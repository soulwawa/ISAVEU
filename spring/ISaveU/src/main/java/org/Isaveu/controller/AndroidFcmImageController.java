package org.Isaveu.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AndroidFcmImageController {
	
	@ResponseBody
	@RequestMapping(value = "/AndoridIamgeGet.do", method = RequestMethod.GET)
	private void AndoridIamgeGet(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ImageId = request.getParameter("imageID");
		String path = "C:\\workspace\\SaveForYou\\spring\\ISaveU\\src\\main\\resources\\eventImage\\" + ImageId;
		System.out.println(path);
		response.setContentType("image/png");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		File file = new File(path);
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
		}
}
