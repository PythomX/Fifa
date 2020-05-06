/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.action.view.db.match;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.model.dao.impl.CampeonatoDAO;
import br.edu.vianna.fifa.model.dao.impl.GolDAO;
import br.edu.vianna.fifa.model.dao.impl.PartidaDAO;
import br.edu.vianna.fifa.model.dao.impl.RankDAO;
import br.edu.vianna.fifa.model.dao.impl.TimeDAO;
import br.edu.vianna.fifa.model.domain.Campeonato;
import br.edu.vianna.fifa.model.domain.Gol;
import br.edu.vianna.fifa.model.domain.Partida;
import br.edu.vianna.fifa.model.domain.Rank;
import br.edu.vianna.fifa.model.domain.Time;
import br.edu.vianna.fifa.model.dto.JogadorArtilheiroDTO;
import br.edu.vianna.fifa.model.dto.PartidasRankingDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
public class FinishMatchAction implements ICommanderAction {

    @Override
    public boolean pageReleased() {
        return false;
    }

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Long id = Long.parseLong(request.getParameter("id"));
        Partida partida = new PartidaDAO().findById(id);

        partida.setFinalizado(true);

        new PartidaDAO().update(partida);

        /*-------------------- Criando Ranking --------------------*/
        //List<Campeonato> championships =  new CampeonatoDAO().findAllStarted(partida.getIdCampeonato().getId());
        List<PartidasRankingDTO> matchRanking = new ArrayList<>();

        Campeonato championship = new CampeonatoDAO().findById(partida.getIdCampeonato().getId());

        List<Partida> partidas = championship.getPartidaList();

        Integer rounds = championship.getTimeList().size() - 1;
        Integer teamsByRound = partidas.size() / rounds;

        GolDAO golDAO = new GolDAO();

        for (int i = 0; i < partidas.size(); i++) {
            partida = partidas.get(i);

            Time first = partida.getIdPrimeiroTime();
            Time second = partida.getIdSegundoTime();

            Integer amountGoalsFirstTeam = 0;
            Integer amountGoalsSecondTeam = 0;

            List<Gol> gols = golDAO.findAllByMatch(partida.getId());

            for (Gol gol : gols) {
                if (gol.getIdPartida().getIdPrimeiroTime().equals(first)) {
                    amountGoalsFirstTeam++;

                } else {
                    amountGoalsSecondTeam++;
                }
            }

            PartidasRankingDTO match = new PartidasRankingDTO();

            match.setRound((int) Math.ceil((i + 1.0) / teamsByRound));

            match.setFinalizada(partida.getFinalizado());

            match.setFirstTeamId(first.getId());
            match.setFirstTeamGoals(amountGoalsFirstTeam);

            match.setSecondTeamId(second.getId());
            match.setSecondTeamGoals(amountGoalsSecondTeam);

            matchRanking.add(match);
        }

        CampeonatoDAO champDAO = new CampeonatoDAO();
        JogadorArtilheiroDTO topScorer = champDAO.findTopScorer(championship.getId());
        List<Rank> ranks = calculateRank(championship, matchRanking, topScorer);

        partida.getIdCampeonato().setRankList(ranks);

        response.sendRedirect("fifa?page=editChamp&id=" + partida.getIdCampeonato().getId());

    }

    private List<Rank> calculateRank(Campeonato championship, List<PartidasRankingDTO> matchRanking, JogadorArtilheiroDTO topScorer) throws SQLException {

        List<Rank> rank = new ArrayList<>();
        List<Time> times = new TimeDAO().findAllByChamp(championship.getId());

        Integer vitorias, empates, derrotas, partidas, pontos, gols, golsTomado;

        Integer topScorerPoints = 0;
        if (topScorer.getGols() > 0) {
            topScorerPoints = 5;
        }

        for (Time time : times) {

            pontos = vitorias = empates = derrotas = partidas = gols = golsTomado = 0;

            Long idTime = time.getId();
            for (PartidasRankingDTO match : matchRanking) {

                if (!match.getFirstTeamId().equals(idTime) && !match.getSecondTeamId().equals(idTime)) {
                    continue;
                }

                partidas++;

                Integer first = match.getFirstTeamGoals();
                Integer second = match.getSecondTeamGoals();

                if (match.getFirstTeamId().equals(time.getId())) {

                    gols += first;
                    golsTomado += second;

                    if (first > second) {
                        vitorias++;
                    } else if (second > first) {
                        derrotas++;
                    } else {
                        empates++;
                    }
                } else {

                    golsTomado += first;
                    gols += second;

                    if (second > first) {
                        vitorias++;
                    } else if (first > second) {
                        derrotas++;
                    } else {
                        empates++;
                    }
                }
            }

            Rank rankRow = new RankDAO().findByIdTimeAndChamp(idTime, championship.getId());

            rankRow.setIdTime(time);
            rankRow.setIdChamp(championship);
            rankRow.setVitorias(vitorias);
            rankRow.setEmpates(empates);
            rankRow.setDerrotas(derrotas);
            rankRow.setPartidas(partidas);
            rankRow.setGols(gols);
            rankRow.setGolsTomado(golsTomado);
            rank.add(rankRow);

            Long pontosGolsTomado = Math.round(golsTomado * 0.5);
            pontos = (vitorias * 3) + gols - pontosGolsTomado.intValue();

            if (topScorer.getTimeId().equals(time.getId())) {
                pontos += topScorerPoints;
            }

            rankRow.setPontos(pontos);

            new RankDAO().update(rankRow);

        }

        return rank;

    }

}
