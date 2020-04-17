/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.fifa.controller.facade;

import br.edu.vianna.fifa.controller.ICommanderAction;
import br.edu.vianna.fifa.controller.action.view.ViewLoginAction;
import br.edu.vianna.fifa.controller.action.view.db.ViewSaveUserAction;
import br.edu.vianna.fifa.controller.action.view.popup.ViewErroPopupAction;
import br.edu.vianna.fifa.controller.action.view.popup.ViewSucessPopupAction;
import java.io.IOException;
import java.io.PrintWriter;
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
    static{
        comandos = new HashMap<>();
        comandos.put(null, new ViewLoginAction());
        comandos.put("login", new ViewLoginAction());
        
        
        /*---------------Views DB------------*/
        comandos.put("saveUser", new ViewSaveUserAction());
        
        
        /* --------------Erro Pop-----------*/
        comandos.put("erroPopup", new ViewErroPopupAction());
        comandos.put("sucessPopup", new ViewSucessPopupAction());
        
        
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        String page = request.getParameter("page");

        try {
            comandos.get(page).openPage(request, response);

        } catch (Exception ex) {
            RequestDispatcher rd = request.getRequestDispatcher("pages/erro.jsp");
            request.setAttribute("err", "Página não encontrada!");
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
