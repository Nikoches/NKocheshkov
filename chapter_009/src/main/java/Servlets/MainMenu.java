package Servlets;

import Logic.Logic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainMenu extends HttpServlet {
    private final Logic logic = Logic.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("Views/index.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logic.save(logic.createItem(req.getParameter("name"),req.getParameter("desc"), req.getParameter("done")));
        req.getRequestDispatcher("Views/index.html").forward(req,resp);
        super.doPost(req, resp);
    }
}
