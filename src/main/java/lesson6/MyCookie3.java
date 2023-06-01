package lesson6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 設定路徑是指設定的 cookie 在什麼路徑才可以訪問
 *
 */
@WebServlet("/lesson6/path")
public class MyCookie3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c1 = new Cookie("key1", "value1");
		// 預設為當前 ServletContext 路徑+@WebServlet第一個路徑，也就是這行可以不寫
		// c1.setPath("/JavaServlet/lesson6");

		// c1.setPath("/JavaServlet/lesson6/path");

		Cookie c2 = new Cookie("key2", "value2");
		c2.setPath("/JavaServlet/lesson6");

		Cookie c3 = new Cookie("key3", "value3");
		c3.setPath("/JavaServlet/ls6");

		Cookie c4 = new Cookie("key4", "value4");
		c4.setPath("/");

		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		response.addCookie(c4);

		if (request.getCookies() != null) {
			System.out.println("/lesson6/path 取得 cookie");
			Arrays.stream(request.getCookies()).forEach(c -> {
				System.out.println(c.getName() + " = " + c.getValue());
			});
		}
	}

}
