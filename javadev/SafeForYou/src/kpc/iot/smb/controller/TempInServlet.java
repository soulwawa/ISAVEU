package kpc.iot.smb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kpc.test.TempDAO;
import kr.or.kpc.test.TempVO;

public class TempInServlet implements Controller {

	@Override
	public String handlerReuquest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		String temp1 = request.getParameter("temp");
		double temp = toConvertTemp(temp1);
		String loc = request.getParameter("loc");
		System.out.println("type : "  + type);
		System.out.println("temp1 : "  + temp1);
		System.out.println("temp : "  + temp);
		System.out.println("loc : "  + loc);
		TempDAO dao = new TempDAO();
		TempVO vo = new TempVO();
		vo.setLoc(loc);
		vo.setType(type);
		vo.setTemperature(temp + "");
		dao.insertTemp(vo);
		out.println("success");
		return null;
	}

	public double toConvertTemp(String reading){
		int readData = Integer.parseInt(reading);
		double voltage = readData * 5.0;
		voltage /= 1024.0;
		double temperatureC = (voltage - 0.5) * 100 ; 
		return Math.round(temperatureC * 100d) / 100d;
	}
}

}
