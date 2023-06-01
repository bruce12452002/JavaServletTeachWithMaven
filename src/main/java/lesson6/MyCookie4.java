package lesson6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/ls6/getCookie")
public class MyCookie4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/ls6/getCookie 取得 cookie");
		Arrays.stream(request.getCookies()).forEach(c -> {
			System.out.println(c.getName() + " = " + c.getValue());
		});
	}

}
