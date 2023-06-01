package lesson7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session 預設 30 分鐘，都沒對 server 操作的話就會失效，如果想修改： 
 * apache-tomcat-xxx/conf/web.xml
 * <session-config> <session-timeout>30</session-timeout></session-config>
 * 注意，只要對 server 有操作，就會重新計算 30 分鐘
 */
@WebServlet("/lesson7")
public class MySession1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(); // 自動創建一個 cookie，key 為 JSESSIONID，因為是 cookie，所以瀏覽器關閉就沒了
		System.out.println("JSESSIONID=" + session.getId());
		System.out.println("創建時間=" + session.getCreationTime());
		System.out.println("最後修改時間=" + session.getLastAccessedTime());
		System.out.println("是否是新的=" + session.isNew());

		// session.setMaxInactiveInterval(30); // 30 秒沒對 server 操作的話就會失效
		// session.invalidate(); // 立即將 session 失效，登出用
	}

}
