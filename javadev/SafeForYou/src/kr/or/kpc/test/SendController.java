package kr.or.kpc.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kpc.iot.smb.util.Action;
import kpc.iot.smb.util.HttpUtil;

public class SendController extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpUtil.forward(request, response, "WEB-INF/fcmtest.jsp");
	}

	
}
