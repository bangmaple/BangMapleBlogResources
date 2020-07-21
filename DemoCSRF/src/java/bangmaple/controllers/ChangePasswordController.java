/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bangmaple.controllers;

import bangmaple.daos.UsersDAO;
import bangmaple.utils.AntiCSRFToken;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bangmaple
 */
@WebServlet(name = "ChangePasswordController", urlPatterns = {"/ChangePasswordController"})
public class ChangePasswordController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "success.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
              String antiCSRFToken;
            if (request.getParameter("btnAction") == null) {
                    antiCSRFToken = AntiCSRFToken.getToken();
                  session.setAttribute("csrfToken", antiCSRFToken);
                request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            } else {
                 antiCSRFToken = String.valueOf(session.getAttribute("csrfToken"));
                if (antiCSRFToken.equals(request.getParameter("csrfToken"))) {
                UsersDAO dao = new UsersDAO();
                if (dao.changePassword(request.getParameter("txtUsername"), request.getParameter("txtPasswordChange"))) {
                    url = SUCCESS;
                }
                } else {
                  request.setAttribute("ERROR", "Invalid CSRF Token! Well done, hacker!");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            log("ERROR at ChangePasswordController: " + e.getMessage());
        } finally {
            if (url.equals(SUCCESS)) {
                request.getSession().invalidate();
                response.sendRedirect("success.jsp");
            } else {
                request.getRequestDispatcher(url).forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
