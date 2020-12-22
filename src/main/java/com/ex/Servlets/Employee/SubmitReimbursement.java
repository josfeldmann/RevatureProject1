package com.ex.Servlets.Employee;

import com.ex.DAO.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Reads user inputs from a form and then creates a new pendiong reimbursement based on those inputs
 */
public class SubmitReimbursement extends HttpServlet {


    private static final long serialVersionUID = 1;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        float amount = Float.parseFloat(req.getParameter("amount"));


        loginDao.ApplyForReimbursement((int)req.getSession().getAttribute("id"),
                                            req.getParameter("purpose"),
                                            amount);


        req.getSession().setAttribute("result", "Reimbursement Added");
        req.getRequestDispatcher("Employee/EmployeeHomePage.jsp").forward(req, resp);
    }
}
