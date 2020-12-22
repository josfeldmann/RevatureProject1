package com.ex.Servlets.Employee;

import com.ex.DAO.UserDao;
import com.ex.Models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Gets the user information from the DB and puts it into attributes so the jsp can access them.
 */
public class ViewEmployeeInformation extends HttpServlet {

    private static final long serialVersionUID = 1;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        User user = loginDao.GetUser(username);
        req.setAttribute("username", user.getUsername());
        req.setAttribute("first_name", user.getFirstName());
        req.setAttribute("last_name", user.getLastName());
        RequestDispatcher dispatcher = req.getRequestDispatcher("Employee/ViewInformation.jsp");
        dispatcher.forward(req, resp);

    }


}
