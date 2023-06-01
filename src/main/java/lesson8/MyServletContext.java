package lesson8;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lesson8")
public class MyServletContext extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得 ServletContext，JSP 裡是 application，兩個指的都是 ServletContext
		ServletContext s1 = req.getServletContext();
		ServletContext s2 = req.getSession().getServletContext();
		ServletContext s3 = getServletContext();
		ServletContext s4 = getServletConfig().getServletContext();
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		System.out.println(s1 == s4);
		System.out.println(s1.getServerInfo()); // Apache Tomcat/9.0.68
		System.out.println(s4.getRealPath("/")); // C:\Users/user\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\JavaServlet\

		s1.setAttribute("applicationKey", "value"); // servletContext 作用域為伺服器執行期間都會有
	}

}
