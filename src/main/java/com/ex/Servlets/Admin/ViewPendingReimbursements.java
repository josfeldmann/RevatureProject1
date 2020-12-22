package com.ex.Servlets.Admin;

import com.ex.DAO.UserDao;
import com.ex.Models.Reimbursement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * Builds an HTMl table of all pending reimbursements based on a user list provided by the DAO. Then sends that table to the response
 */
public class ViewPendingReimbursements extends HttpServlet {
    private static final long serialVersionUID = 1;
    private UserDao loginDao;


    public void init() {
        loginDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int id = (int) session.getAttribute("id");
        List<Reimbursement> reimbursements = loginDao.GetAllPendingReimbursements();

        String approveButtonString = "<button class=\"btn btn-primary bg-success\"type=\"submit\">Approve</button>";
        String denyButtonString = "<button class=\"btn btn-primary bg-danger\"type=\"submit\">Deny</button>";
        String pending = "<table class=\"table\"> <thead> <tr> <th scope=\"col\">Reimbursement ID</th> <th scope=\"col\">Amount</th> <th scope=\"col\">Purpose</th> <th>Approve</th> <th>Deny</th> </tr> </thead> <tbody>\n";



        for ( Reimbursement r:
                reimbursements) {

                pending += "<tr> <th scope=\"row\">" + r.getId() +
                           "</th> <td>" + r.getAmount() +
                           "</td> <td>" + r.getPurpose() +
                           "</td> <td>  <form action=\""+ req.getContextPath() +"/approveReimbursement\" method = \"post\"><input type=\"hidden\" id=\"transaction_id\" name=\"transaction_id\" value=\"" + r.getId() +"\">" + approveButtonString +"</form>" +
                           "</td> <td>  <form action=\"" + req.getContextPath() +"/denyReimbursement\" method = \"post\"><input type=\"hidden\" id=\"transaction_id\" name=\"transaction_id\" value=\"" + r.getId() +"\">" + denyButtonString +"</form>" +
                           "</td> </tr>";

        }
        pending += "</tbody> </table>";


        req.setAttribute("pending", pending);

        RequestDispatcher dispatcher = req.getRequestDispatcher("Admin/ViewPendingReimbursements.jsp");
        dispatcher.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
