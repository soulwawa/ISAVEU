package kpc.iot.smb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpc.iot.smb.data.dao.EventDAO;
import kpc.iot.smb.data.vo.TbEventVO;
import kpc.iot.smb.util.Action;

public class EventInServlet extends Action{
//  url = "POST /SafeForYou/tempIn.do?module_id=1";
//    url += "&temp=" + String(reading, DEC);
//    url += "&smoke=0&gyro=0&fire=0&issue=0";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/plain;charset=utf-8");
		String issue = request.getParameter("issue");
		String module_id = request.getParameter("module_id");
		String temp = request.getParameter("temp");
		String smoke = request.getParameter("smoke");
		String gyro = request.getParameter("gyro");
		String fire = request.getParameter("fire");
		
		//ISSUE Process
		// 0 -> DB, 1 -> Rasp,DB, 2->Rasp,DB, 3->Rasp,DB,
		
		switch (issue) {
		case "1":
			System.out.println("화재경보");
			break;
		case "2":
			System.out.println("지진경보");
			break;
		case "3":
			System.out.println("지진 + 화재경보");
			break;
		default:
			EventDAO dao = new EventDAO();
			TbEventVO vo = new TbEventVO();
			
			vo.setModule_id(module_id);
			vo.setTemp(Float.parseFloat(temp));
			vo.setSmoke(Float.parseFloat(smoke));
			vo.setGyro(Float.parseFloat(gyro));
			vo.setFire(Float.parseFloat(fire));
			vo.setIssue(issue);
			dao.insertEvent(vo);
			System.out.println("InsertEvent Succes");
			break;
		}
		
		
//		if(issue.equals("0")) {
//			EventDAO dao = new EventDAO();
//			TbEventVO vo = new TbEventVO();
//			vo.setModule_id(module_id);
//			vo.setTemp(Float.parseFloat(temp));
//			vo.setSmoke(Float.parseFloat(smoke));
//			vo.setGyro(Float.parseFloat(gyro));
//			vo.setFire(Float.parseFloat(fire));
//			vo.setIssue(issue);
//			dao.insertEvent(vo);
//			System.out.println("InsertEvent Succes");
//		}else if (issue.equals("1")) {
//			System.out.println("화재경보");
//		}else if (issue.equals("2")) {
//			System.out.println("지진경보");
//		}else if (issue.equals("3")) {
//			System.out.println("지진 + 화재 경보");
//		}		
	}
	

}
