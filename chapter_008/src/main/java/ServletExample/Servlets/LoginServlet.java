package ServletExample.Servlets;

import ServletExample.Logic.DbStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      resp.sendRedirect("Views/login.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get request parameters for userID and password
        DbStore dbStore = DbStore.getInstance();
        int role = dbStore.getCredentials(request.getParameter("user"),request.getParameter("pwd"));
        if(role > 0) {
            Cookie userName = new Cookie("user",role + "");
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            response.sendRedirect("all");
        } else {
            request.setAttribute("red","Either user name or password is wrong.");
            request.getRequestDispatcher("Views/login.jsp").forward(request,response);
        }
    }

}