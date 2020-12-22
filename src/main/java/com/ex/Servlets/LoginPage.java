package com.ex.Servlets;

import com.ex.DAO.UserDao;
import com.ex.Models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginPage extends HttpServlet {

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

        User result = loginDao.validate(username, password);

        if (result == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("error", "Username or password was incorrect");
            dispatcher.forward(request, response);
        } else if (result.getAccountType() == 1) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Employee/EmployeeHomePage.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("id", result.getId());
            session.setAttribute("username", username);
            session.setAttribute("account_type", 1);
            session.setAttribute("first_name", result.getFirstName());
            session.setAttribute("last_name", result.getLastName());
            session.setAttribute("result", "Employee Logged In");
            dispatcher.forward(request, response);


        } else if (result.getAccountType() == 2) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/AdminHomePage.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("id", result.getId());
            session.setAttribute("username", username);
            session.setAttribute("account_type", 2);
            session.setAttribute("first_name", result.getFirstName());
            session.setAttribute("last_name", result.getLastName());
            session.setAttribute("result", "Admin Logged In");
            dispatcher.forward(request, response);
        }

    }

}
