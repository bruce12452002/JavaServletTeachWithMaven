package lesson5;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/lesson5")
public class MyHttpServletResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getWriter getOutputStream 只能擇其一

		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setContentType("text/html");

//		response.setHeader("content-type", "text/html;charset=utf-8"); // 以上兩個可變一行
//		response.setContentType("text/html;charset=utf-8"); // 更短的寫法

//		response.getWriter().append("嘻嘻").append(request.getContextPath());

		ServletOutputStream out = response.getOutputStream();
		out.write("haha 哈哈".getBytes());
	}

}
