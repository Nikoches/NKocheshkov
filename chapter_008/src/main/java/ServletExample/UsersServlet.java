package ServletExample;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UsersServlet extends HttpServlet {
    //private final ValidateService usersProcess = ValidateService.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter writer = new PrintWriter(res.getOutputStream());
        writer.append("YYYYYYYYYYYYYYYYYY");
        //writer.append(usersProcess.findAll().toString());
        writer.flush();
    }
//    @Override
//    public void doPost(HttpServletRequest req, HttpServletResponse res) {
//        res.setContentType("text/html");
//        //usersProcess.process(req);
//
//    }
}
