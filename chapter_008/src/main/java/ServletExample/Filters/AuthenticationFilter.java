package ServletExample.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter1", urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
        FilterRegistration registration = context.getFilterRegistration("Filter2");
        registration.addMappingForUrlPatterns(null, true, "/update", "/remove", "/add");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        Cookie[] cookies = req.getCookies();
        this.context.log("Requested Resource::" + uri);
        int role = 0;
        if (cookies != null) {
            for (Cookie x : cookies) {
                if (x.getName().equals("user")) {
                    role = Integer.parseInt(x.getValue());
                    break;
                }
            }
        }
        if (role != 0 || uri.endsWith("login.jsp") || uri.endsWith("LoginServlet")) {
            chain.doFilter(request, response);
        } else {
            this.context.log("Unauthorized access request");
            req.getRequestDispatcher("Views/login.jsp").forward(req, res);
        }
    }

    public void destroy() {
        //close any resources here
    }

}