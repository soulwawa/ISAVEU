package kpc.iot.smb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendController implements Controller {

	@Override
	public String handlerReuquest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "fcmtest.jsp";
	}

}
