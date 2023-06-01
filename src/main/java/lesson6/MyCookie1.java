package lesson6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

@WebServlet("/lesson6/setCookie")
public class MyCookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 訪問網頁後，在 F12 Application/Cookies 查看
	 * 每個瀏覽器都有自己的 cookie
	 * 不可存非 ascii code，但可用 URLEncoder
	 * cookie 有大小限制，每個瀏覽器不同，但大約是 4k
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c = new Cookie("key", "value");
		c.setValue("xxx"); // 修改 value

		// cookie 存活時間
		// 預設 -1，表示瀏覽器關閉就失效了
		// 0 表示刪除這個 cookie
		// 正整數是存活幾秒，只要時間還沒到，關閉瀏覽器也不會刪除
		c.setMaxAge(5);

		response.addCookie(c);
		response.addCookie(new Cookie("key2", "value2"));
		response.addCookie(new Cookie(URLEncoder.encode("哇哈哈", Charset.forName("UTF-8")), "value3"));
	}

}
