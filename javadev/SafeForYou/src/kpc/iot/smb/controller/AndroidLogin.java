package kpc.iot.smb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpc.iot.smb.data.DAO.HrDAO;
import kpc.iot.smb.data.VO.TbHrVO;
import kpc.iot.smb.util.Action;

public class AndroidLogin extends Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/plain;charset=utf-8");
		String andId = request.getParameter("u_id");
		String andPw = request.getParameter("u_pw");
		String fcmValue = request.getParameter("u_instancekey");
		
		System.out.println(andId);
		System.out.println(andPw);
		System.out.println(fcmValue);
		
		TbHrVO vo = new TbHrVO();
		HrDAO dao = new HrDAO();
		
		vo.setId(andId);
		ArrayList<TbHrVO> list = dao.getHrList(vo);
		System.out.println(list.size());
		if(list.size() == 0) {
			System.out.println("F");
		}else {
			System.out.println("T");
		}
		
		
		
		
		
		
		
	}

}
