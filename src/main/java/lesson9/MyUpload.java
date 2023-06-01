package lesson9;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/lesson9/upload")
@MultipartConfig
public class MyUpload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(StandardCharsets.UTF_8.name());
		String author = req.getParameter("author");
		System.out.println("author=" + author);
		Part part = req.getPart("data");
		String fileName = part.getSubmittedFileName();
		System.out.println("fileName=" + fileName);
		String path = getServletContext().getRealPath("/");
		System.out.println("path=" + path); // C:\Users/user\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\JavaServlet\
		part.write(path + "/" + fileName);
	}

}
