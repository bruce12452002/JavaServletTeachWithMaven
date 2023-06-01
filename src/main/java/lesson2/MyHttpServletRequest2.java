package lesson2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/lesson2/encoding")
public class MyHttpServletRequest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tomcat 8 和 9，get 預設正常顯示
        String xxx = req.getParameter("xxx");
        System.out.println(xxx);

        // tomcat 7 可用如下解決，此方法 get、post 都可以用
        String newXxx = new String(xxx.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println(newXxx);

        // 注意，本來如果正常，編碼過後也通常是亂碼，看第一個參數給哪個編碼而定
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tomcat 8 和 9，get 預設會亂碼
//        String xxx = req.getParameter("xxx"); // 必需在 setCharacterEncoding 之後
        System.out.println("CharacterEncoding1=" + req.getCharacterEncoding());
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        System.out.println("CharacterEncoding2=" + req.getCharacterEncoding());

        // 1. setCharacterEncoding 只對 post 有效
        // 2. 必須先 setCharacterEncoding，否則還是亂碼
        // 3. 如果 setCharacterEncoding 之前已先取出資料，就算 setCharacterEncoding 之後再取一次，還是會亂碼，不管是不是同樣的 name
//        System.out.println(xxx);
        System.out.println(req.getParameter("xxx"));
        System.out.println(req.getParameter("ooo"));

        // 還是可用這種方法轉換
//        String newXxx = new String(xxx.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//        System.out.println(newXxx);
    }
}
