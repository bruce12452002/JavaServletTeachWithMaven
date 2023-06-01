package lesson7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/lesson7/attr")
public class MySession2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("sessionKey1", "v1");
		session.setAttribute("sessionKey2", "v2");
		session.removeAttribute("sessionKey2");

		req.setAttribute("reqKey", "v3");

//		req.getRequestDispatcher("/attribute.jsp").forward(req, resp);
		resp.sendRedirect(req.getContextPath() + "/attribute.jsp"); // 兩次請求，所以 reqKey 會拿不到
	}

}
