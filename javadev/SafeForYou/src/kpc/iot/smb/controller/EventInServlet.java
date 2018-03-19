package kpc.iot.smb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpc.iot.smb.data.DAO.EventDAO;
import kpc.iot.smb.data.VO.TbEventVO;
import kpc.iot.smb.util.Action;

public class EventInServlet extends Action{
//  url = "POST /SafeForYou/tempIn.do?module_id=1";
//    url += "&temp=" + String(reading, DEC);
//    url += "&smoke=0&gyro=0&fire=0&issue=0";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		String module_id = request.getParameter("module_id");
		String temp1 = request.getParameter("temp");
		float temp = toConvertTemp(temp1);
		String smoke = request.getParameter("smoke");
		String gyro = request.getParameter("gyro");
		String fire = request.getParameter("fire");
		String issue = request.getParameter("issue");
		
		EventDAO dao = new EventDAO();
		TbEventVO vo = new TbEventVO();
		
		vo.setModule_id(module_id);
		vo.setTemp(temp);
		vo.setSmoke(Float.parseFloat(smoke));
		vo.setGyro(Float.parseFloat(gyro));
		vo.setFire(Float.parseFloat(fire));
		vo.setIssue(issue);
		dao.insertEvent(vo);
		System.out.println("InsertEvent Succes");
		
	}
	//온도 변화
	public float toConvertTemp(String reading){
		 float readData = Float.parseFloat(reading);
		 float voltage = (float) (readData * 5.0);
		 voltage /= 1024.0;
		 float temperatureC = (float) ((voltage - 0.5) * 100) ; 
		 return (float) (Math.round(temperatureC * 100d) / 100d);
	}

}
