package lesson4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lesson4")
public class ReqAttribute1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("a", 1);
//        req.getRequestDispatcher("lesson4/req").forward(req, resp);
//        resp.sendRedirect("lesson4/req");

        req.getRequestDispatcher("forward.jsp").forward(req, resp);
//		resp.sendRedirect(req.getContextPath() + "/forward.jsp"); // 兩次請求，所以 a 會拿不到
	}
}
