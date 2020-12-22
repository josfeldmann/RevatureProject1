package com.ex.Servlets.Admin;

import com.ex.DAO.UserDao;
import com.ex.Models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Builds an HTMl table of employees based on a user list provided by the DAO. Then sends that table to the response
 */
public class ViewEmployees extends HttpServlet {

    private static final long serialVersionUID = 1;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = loginDao.GetEmployees();
        PrintWriter out = resp.getWriter();

        String output = "<table class=\"table\"> <thead> <tr> <th scope=\"col\">EmployeeID</th> <th scope=\"col\">First</th> <th scope=\"col\">Last</th> <th scope=\"col\">Email</th> </tr> </thead> <tbody>\n";
        for ( User u:
             users) {
            output += "<tr> <th scope=\"row\">" + u.getId() + "</th>  <td>"+ u.getFirstName() +"</td> <td>" + u.getLastName() +"</td> <td>" + u.getUsername() +"</td> </tr>";
        }
        output += "</tbody> </table>";


        req.setAttribute("employees", output);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Admin/ViewEmployees.jsp");
        dispatcher.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
