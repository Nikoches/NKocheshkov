package Servlets;

import Logic.Logic;
import Persistence.ToDoListApp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class Updater extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logic logic = Logic.getInstance();
        Writer writer = resp.getWriter();
        ToDoListApp app = ToDoListApp.getInstance();
        String s = req.getParameter("parametr") == null ? "1" : req.getParameter("parametr");
        int x = Integer.parseInt(s);
        writer.write(logic.getJsonTable(app.getByExcecuted(x)));
        writer.close();
    }
}
