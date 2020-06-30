package ServletExample.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            session.invalidate();
            for (Cookie x :cookies){
                x.setMaxAge(0);
                response.addCookie(x);
            }
        }
        request.getRequestDispatcher("Views/login.jsp").forward(request, response);
    }

}