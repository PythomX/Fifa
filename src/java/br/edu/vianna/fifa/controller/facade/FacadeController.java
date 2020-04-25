/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.facade;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.ViewAcessoNegado;
import br.edu.vianna.fifa.controller.action.view.ViewLoginAction;
import br.edu.vianna.fifa.controller.action.view.db.CheckLoginAction;
import br.edu.vianna.fifa.controller.action.view.ViewHomeAction;
import br.edu.vianna.fifa.controller.action.view.ViewListaJogadoresAction;
import br.edu.vianna.fifa.controller.action.view.ViewNewTeamAction;
import br.edu.vianna.fifa.controller.action.view.db.LogoutAction;
import br.edu.vianna.fifa.controller.action.view.db.NewTeamAction;
import br.edu.vianna.fifa.controller.action.view.db.SaveUserAction;
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
        comandos.put(null, new ViewLoginAction());
        comandos.put("login", new ViewLoginAction());
        comandos.put("home", new ViewHomeAction());
        comandos.put("newTeam", new ViewNewTeamAction());
        comandos.put("listaUsuarios", new ViewListaJogadoresAction());

        /*---------------Views DB------------*/
        comandos.put("saveUser", new SaveUserAction());
        comandos.put("checkLogin", new CheckLoginAction());
        comandos.put("logout", new LogoutAction());
        comandos.put("saveNewTeam", new NewTeamAction());

        /* --------------Erro Pop-----------*/
        comandos.put("erroPopup", new ViewErroPopupAction());
        comandos.put("sucessPopup", new ViewSucessPopupAction());
        comandos.put("acessoNegado", new ViewAcessoNegado());

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
                comandos.get("acessoNegado").openPage(request, response);
            }

        } catch (Exception ex) {
            System.out.println(ex.getCause());
            RequestDispatcher rd = request.getRequestDispatcher("pages/erro.jsp");
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
