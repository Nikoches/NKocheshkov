package ServletExample.Servlets;

import ServletExample.Logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AllUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidateService validateService = ValidateService.getInstance();
        ArrayList s2 = (ArrayList) validateService.process(req,"findAll").get();
        req.setAttribute("list", s2);
        req.getRequestDispatcher("Views/AllUsers.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidateService validateService = ValidateService.getInstance();
        ArrayList s2 = (ArrayList) validateService.process(req,"findAll").get();
        req.setAttribute("list", s2);
        req.getRequestDispatcher("Views/AllUsers.jsp").forward(req, resp);
    }
}
