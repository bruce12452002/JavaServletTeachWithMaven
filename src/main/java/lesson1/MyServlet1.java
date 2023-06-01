package lesson1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * value 和 urlPatterns 只能擇其一，否則啟動時報錯
 * 匹配時，每個 servlet 請求路徑也只能唯一，否則啟動時也會報錯
 * 必需是「/」或「*」開頭，如「*.do」
 */
@WebServlet(value = {"/s01", "/servlet1"})
public class MyServlet1 extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service1");
        super.service(req, res);
        res.getWriter().write("hello servlet");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service2");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init1");
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init2");
        super.init();
    }
}
