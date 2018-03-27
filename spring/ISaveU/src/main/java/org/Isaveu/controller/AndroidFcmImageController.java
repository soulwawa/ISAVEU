package org.Isaveu.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AndroidFcmImageController {
	
	@ResponseBody
	@RequestMapping(value = "/AndoridIamgeGet.do", method = RequestMethod.GET)
	private void AndoridIamgeGet(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		ServletContext appplication = request.getSession().getServletContext();
//		ServletContext appplication = request.getServletContext();
		String ImageId = request.getParameter("imageID");
		String path = "C:\\workspace\\SaveForYou\\spring\\ISaveU\\src\\main\\resources\\eventImage\\" + ImageId;
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
		}
		
		
//		String imageId = request.getParameter("imageID");
//		System.out.println(imageId);
//		ServletContext application = request.getServletContext();
//		System.out.println(application.getContextPath());
//		InputStream in = application.getResourceAsStream("/ISaveU/src/main/resources/eventImage" + imageId);
//		response.setContentType(MediaType.IMAGE_PNG_VALUE);
//		IOUtils.copy(in, response.getOutputStream());
		
//		String imageId = request.getParameter("imageID");
//		String path = "C:\\workspace\\SaveForYou\\spring\\ISaveU\\src\\main\\resources\\eventImage" + imageId;
//		File file = new File(path);
//		FileInputStream input = new FileInputStream(file);
//		return null;
//	}	
	
}
