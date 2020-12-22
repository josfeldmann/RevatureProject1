package com.ex.Servlets.Employee;

import com.ex.DAO.UserDao;
import com.ex.Models.Reimbursement;
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
 * Gets all the reimbursements for this user from the DB and then builds HTMl tables based on those reimbursements
 */
public class ViewReimbursements extends HttpServlet {

    private static final long serialVersionUID = 1;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int id = (int) session.getAttribute("id");
        List<Reimbursement> reimbursements = loginDao.GetReimbursementsForUser(id);



        String pending = "<table class=\"table table-hover table-dark\"> <thead> <tr> <th scope=\"col\">Reimbursement ID</th> <th scope=\"col\">Amount</th> <th scope=\"col\">Purpose</th> </tr> </thead> <tbody>\n";
        String approved = "<table class=\"table table-hover table-dark\"> <thead> <tr> <th scope=\"col\">Reimbursement ID</th> <th scope=\"col\">Amount</th> <th scope=\"col\">Purpose</th> <th scope=\"col\">Approved By</th> </tr> </thead> <tbody>\n";
        String denied = "<table class=\"table table-hover table-dark\"> <thead> <tr> <th scope=\"col\">Reimbursement ID</th> <th scope=\"col\">Amount</th> <th scope=\"col\">Purpose</th> <th scope=\"col\">Approved By</th> </tr> </thead> <tbody>\n";

        for ( Reimbursement r:
                reimbursements) {
            if (r.getStatus().equals(Reimbursement.PENDING)) {
                pending += "<tr> <th scope=\"row\">" + r.getId() + "</th>  <td>" + r.getAmount() + "</td> <td>" + r.getPurpose() + "</td> </tr>";
            } if (r.getStatus().equals(Reimbursement.APPROVED)) {
                approved += "<tr> <th scope=\"row\">" + r.getId() + "</th>  <td>" + r.getAmount() + "</td> <td>" + r.getPurpose() + "</td> <td> Your Manager </td> </tr>";
            } else if (r.getStatus().equals(Reimbursement.DENIED)){
                denied += "<tr> <th scope=\"row\">" + r.getId() + "</th>  <td>" + r.getAmount() + "</td> <td>" + r.getPurpose() + "</td> <td> Your Manager </td> </tr>";
            }
        }
        pending += "</tbody> </table>";
        denied += "</tbody> </table>";
        approved += "</tbody> </table>";


        req.setAttribute("pending", pending);
        req.setAttribute("denied", denied);
        req.setAttribute("approved", approved);

        RequestDispatcher dispatcher = req.getRequestDispatcher("Employee/ViewReimbursementRequests.jsp");
        dispatcher.forward(req, resp);


    }


}
