package ServletExample.Servlets;

import ServletExample.Logic.ValidateService;
import ServletExample.Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidateService validateService = ValidateService.getInstance();
        User user = (User) validateService.process(req,"findbyid").get();
        req.setAttribute("user", user);
        req.getRequestDispatcher("Views/UpdateUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ValidateService validateService = ValidateService.getInstance();
        validateService.process(req,req.getParameter("key"));
        resp.sendRedirect("all");
    }
}
