package com.ex.Servlets.Admin;

import com.ex.DAO.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Reads Employee information from the RegisterEmployee.jsp form and
 */
public class RegisterEmployee extends HttpServlet {

    private static final long serialVersionUID = 1;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        boolean result = loginDao.CreateEmployee(username, password, firstName, lastName);
        request.getSession().setAttribute("result", "Employee " + firstName + " " + lastName + " added");


        if (result) {
            response.sendRedirect(request.getContextPath() + "/Admin/AdminHomePage.jsp");
        } else {
            throw new Exception("Registration not successful..");
        }
    }


}
