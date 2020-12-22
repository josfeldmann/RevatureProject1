package com.ex.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOut extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("id");
        session.removeAttribute("username");
        session.removeAttribute("account_type");
        session.removeAttribute("first_name");
        session.removeAttribute("last_name");
        session.setAttribute("result", "Logged Out");
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
