package lesson2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/lesson2/*")
public class MyHttpServletRequest1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----Request-----");
        System.out.println("RequestURL=" + req.getRequestURL());
        System.out.println("RequestURI=" + req.getRequestURI());
        System.out.println("Scheme=" + req.getScheme());
        System.out.println("ServerName=" + req.getServerName());
        System.out.println("ServerPort=" + req.getServerPort());
        System.out.println("ContextPath=" + req.getContextPath());
        System.out.println("ServletPath=" + req.getServletPath());
        System.out.println("pathInfo=" + req.getPathInfo()); // 非完全對應才有作用

        System.out.println("QueryString=" + req.getQueryString());
        System.out.println("\r\nParameterNames Start");
        Enumeration<String> name = req.getParameterNames();
        while (name.hasMoreElements()) {
            String n = name.nextElement();
            System.out.println(n);
            System.out.println(req.getParameter(n) + "\r\n");
        }
        System.out.println("ParameterNames End");

        String[] sArray = req.getParameterValues("xxx");
        if (sArray != null) {
            for (String s : sArray) {
                System.out.println(s);
            }
        }

        System.out.println("remoteAddr=" + req.getRemoteAddr());
        System.out.println("protocol=" + req.getProtocol());
    }
}
