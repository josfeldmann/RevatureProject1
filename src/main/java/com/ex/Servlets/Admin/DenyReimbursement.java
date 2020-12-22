package com.ex.Servlets.Admin;

import com.ex.DAO.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Reads transaction id from the session and denies that reimbursement
 */
public class DenyReimbursement extends HttpServlet {


    private static final long serialVersionUID = 1;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int managerid = (int)req.getSession().getAttribute("id");
        int tid = Integer.parseInt(req.getParameter("transaction_id"));
        loginDao.DenyReimbursement(tid, managerid);
        req.getSession().setAttribute("result", "Reimbursement Denied");
        req.getRequestDispatcher("Admin/AdminHomePage.jsp").forward(req, resp);
    }
}
