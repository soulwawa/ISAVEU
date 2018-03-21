package kpc.iot.smb.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.ForwardingJavaFileManager;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kpc.iot.smb.util.Action;
import kpc.iot.smb.util.HttpUtil;

public class RaspIn extends Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("완료");
		String savePath = "/SafeForYou/WebContent/img/Event";
		
		HttpUtil.forward(request, response, "WEB-INF/eventupload.jsp");
	}

}
