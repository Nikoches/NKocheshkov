package ServletExample.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter2")
public class AuthorityFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("AuthorityFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        Cookie[] cookies =req.getCookies();
        int role = 0;
        if (cookies != null) {
            for (Cookie x : cookies) {
                if (x.getName().equals("user")) {
                    role = Integer.parseInt(x.getValue());
                    break;
                }
            }
        }
        if (role == 1) {
            filterChain.doFilter(req, res);
        } else  {
            this.context.log("Unauthorized access rights request");
            req.getRequestDispatcher("Views/Unable.jsp").forward(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
