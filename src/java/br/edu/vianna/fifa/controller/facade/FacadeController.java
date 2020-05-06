/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.facade;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.championship.ViewChampionshipAction;
import br.edu.vianna.fifa.controller.action.view.championship.ViewEditChampionshipAction;
import br.edu.vianna.fifa.controller.action.view.match.ViewEditMatchAction;
import br.edu.vianna.fifa.controller.action.view.notfound.ViewPageNotFoundAction;
import br.edu.vianna.fifa.controller.action.view.user.ViewLoginAction;
import br.edu.vianna.fifa.controller.action.view.db.user.CheckLoginAction;
import br.edu.vianna.fifa.controller.action.view.ViewHomeAction;
import br.edu.vianna.fifa.controller.action.view.user.ViewListaUsuariosAction;
import br.edu.vianna.fifa.controller.action.view.championship.ViewShowChampionshipAction;
import br.edu.vianna.fifa.controller.action.view.team.ViewNewTeamAction;
import br.edu.vianna.fifa.controller.action.view.ranking.ViewRankingAction;
import br.edu.vianna.fifa.controller.action.view.ranking.ViewShowRankingAction;
import br.edu.vianna.fifa.controller.action.view.db.championship.PlayChampionshipAction;
import br.edu.vianna.fifa.controller.action.view.team.ViewShowTeamAction;
import br.edu.vianna.fifa.controller.action.view.db.user.DeleteUserAction;
import br.edu.vianna.fifa.controller.action.view.db.match.FinishMatchAction;
import br.edu.vianna.fifa.controller.action.view.db.match.InsertGoalAction;
import br.edu.vianna.fifa.controller.action.view.db.LogoutAction;
import br.edu.vianna.fifa.controller.action.view.db.championship.NewChampAction;
import br.edu.vianna.fifa.controller.action.view.db.team.NewTeamAction;
import br.edu.vianna.fifa.controller.action.view.db.user.SaveUserAction;
import br.edu.vianna.fifa.controller.action.view.db.team.UpdateTeamAction;
import br.edu.vianna.fifa.controller.action.view.db.user.UpdateUserAction;
import br.edu.vianna.fifa.controller.action.view.popup.ViewErroPopupAction;
import br.edu.vianna.fifa.controller.action.view.popup.ViewSucessPopupAction;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateu
 */
@WebServlet(name = "FacadeController", urlPatterns = {"/fifa"})
public class FacadeController extends HttpServlet {

    public static final HashMap<String, ICommanderAction> comandos;

    static {
        comandos = new HashMap<>();
        /*---------------Views------------*/
        comandos.put(null, new ViewLoginAction());
        comandos.put("home", new ViewHomeAction());
        comandos.put("listaUsuarios", new ViewListaUsuariosAction());
        comandos.put("login", new ViewLoginAction());
        comandos.put("newTeam", new ViewNewTeamAction());
        comandos.put("showTeam", new ViewShowTeamAction());
        comandos.put("championship", new ViewChampionshipAction());
        comandos.put("showChamp", new ViewShowChampionshipAction());
        comandos.put("editChamp", new ViewEditChampionshipAction());
        comandos.put("editMatch", new ViewEditMatchAction());
        comandos.put("ranking", new ViewRankingAction());
        comandos.put("showRanking", new ViewShowRankingAction());


        /*---------------Views DB------------*/
        comandos.put("checkLogin", new CheckLoginAction());
        comandos.put("deleteUser", new DeleteUserAction());
        comandos.put("logout", new LogoutAction());
        comandos.put("saveNewTeam", new NewTeamAction());
        comandos.put("saveUser", new SaveUserAction());
        comandos.put("updateTeam", new UpdateTeamAction());
        comandos.put("updateUser", new UpdateUserAction());
        comandos.put("newChamp", new NewChampAction());
        comandos.put("playChamp", new PlayChampionshipAction());
        comandos.put("insertGoal", new InsertGoalAction());
        comandos.put("finishMatch", new FinishMatchAction());
        

        /* --------------Erro Popup-----------*/
        comandos.put("erroPopup", new ViewErroPopupAction());
        comandos.put("sucessPopup", new ViewSucessPopupAction());
        comandos.put("pageNotFound", new ViewPageNotFoundAction());

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String page = request.getParameter("page");

        try {

            if (comandos.get(page).pageReleased()) {
                comandos.get(page).openPage(request, response);
            } else if (request.getSession().getAttribute("user") != null) {
                comandos.get(page).openPage(request, response);
            } else {
                comandos.get("pageNotFound").openPage(request, response);
            }

        } catch (Exception ex) {
            System.out.println(ex.getCause());
            RequestDispatcher rd = request.getRequestDispatcher("pages/pageNotFound.jsp");
            request.setAttribute("erro", ex.toString());
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
