package com.ex.Servlets.Employee;

import com.ex.DAO.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Reads input from a user form and then uses that input to update the database entry for that user
 */
public class UpdateInformation extends HttpServlet {


    private static final long serialVersionUID = 1;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        loginDao.UpdateUser((int)req.getSession().getAttribute("id"),
                            req.getParameter("username"),
                            req.getParameter("password"),
                            req.getParameter("first_name"),
                            req.getParameter("last_name"));


        req.getSession().setAttribute("result", "InformationUpdated");
        req.getRequestDispatcher("Employee/EmployeeHomePage.jsp").forward(req, resp);
    }
}
