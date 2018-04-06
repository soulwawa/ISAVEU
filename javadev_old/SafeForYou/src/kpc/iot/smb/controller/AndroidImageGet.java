package kpc.iot.smb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import kpc.iot.smb.util.Action;

public class AndroidImageGet extends Action {
	private static final long serialVersionUID = 1L;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		ServletContext appplication = request.getSession().getServletContext();
//		ServletContext appplication = request.getServletContext();
		String ImageId = request.getParameter("imageID");
//		String path = appplication.getRealPath("c:\\down\\img\\" + ImageId);
		String path = "C:\\workspace\\SaveForYou\\javadev\\SafeForYou\\WebContent\\img\\Event\\" + ImageId;
		System.out.println(path);
		response.setContentType("image/png");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		File file = new File(path);
		
//		response.setContentLength((int)file.length());
		FileInputStream input = new FileInputStream(file);
		OutputStream output = response.getOutputStream();
		byte[] buffer = new byte[8 * 1024];
		try {
			int bytesRead;
			while ((bytesRead = input.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}
			output.flush();
			System.out.println("Response 완료!");
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
				input.close();
				output.close();
			}
//		request.setAttribute("image", output);
//		request.getRequestDispatcher("WEB-INF/andoridevent.jsp").forward(request, response);
		}}
