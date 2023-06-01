package lesson3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lesson3")
public class MyForward1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xxx = req.getParameter("xxx");
        if (xxx == null) {
            // server 端跳轉，網址不變
            // 只有一次 request
            req.getRequestDispatcher("lesson3/s2").forward(req, resp);
//            req.getRequestDispatcher("forward.html").forward(req, resp);
        } else {
            // client 端跳轉，網址會變
            // 兩次 request
//            resp.sendRedirect("lesson3/s2");
            resp.sendRedirect("forward.html");
        }
    }
}
