package lesson9;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * res.setContextType 設定兩個其中一個 application/octet-stream、application/x-msdownload
 * 
 * res.setHeader Content-Disposition/attachment;filename=檔案名稱
 *
 */
@WebServlet("/lesson9/download")
public class MyDownload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("text/html;charset=UTF-8");

		String fileName = req.getParameter("fileName");
		if (Objects.isNull(fileName) || fileName.strip().length() == 0) {
			PrintWriter w = resp.getWriter();
			w.write("請輸入下載的檔名");
			w.flush();
			w.close();
			return;
		}

		// System.out.println(new File(".").getAbsolutePath());
		File file = new File("C:/Users/user/eclipse-workspace/JavaServlet/src/main/webapp/data/" + fileName);
		if (!file.exists() || !file.isFile()) {
			PrintWriter w = resp.getWriter();
			w.write("檔案不存在");
			w.flush();
			w.close();
			return;
		}

		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), StandardCharsets.ISO_8859_1));

		InputStream in = new FileInputStream(file);
		OutputStream out = resp.getOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
			out.flush();
		}
		out.close();
		in.close();
	}

}
