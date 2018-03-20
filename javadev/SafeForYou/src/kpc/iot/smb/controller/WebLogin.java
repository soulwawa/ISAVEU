package kpc.iot.smb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kpc.iot.smb.data.dao.HrDAO;
import kpc.iot.smb.data.vo.TbHrVO;
import kpc.iot.smb.util.Action;

public class WebLogin extends Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/plain;charset=utf-8");
		String andId = request.getParameter("id");
		String andPw = request.getParameter("password");
		
		System.out.println(andId);
		System.out.println(andPw);
		
		TbHrVO vo = new TbHrVO();
		HrDAO dao = new HrDAO();
		
		vo.setId(andId);
		ArrayList<TbHrVO> list = dao.getHrList(vo);
		String msg = null;
		
		if(list.size() == 0) { 
			System.out.println("Query FAIL");
			msg = "Query FAIL";
			request.setAttribute("result", msg);
			request.getRequestDispatcher("WEB-INF/WebLoginTest.jsp").forward(request, response);
		}else {
			TbHrVO result = list.get(0);
			System.out.println("0");
			if(andId.equals(result.getId()) && andPw.equals(result.getPw())) {
				msg = "1";
				request.setAttribute("result", msg);
				request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
			}else {
				msg = "2";
				request.setAttribute("result", msg);
				request.getRequestDispatcher("WEB-INF/resultJson.jsp").forward(request, response);
			}
		}
	}


}