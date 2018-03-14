package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.TempDAO;
import model.TempListVO;
import model.TempVO;

public class TempListServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String loc = request.getParameter("loc");
	TempVO vo = new TempVO();
	TempDAO dao = new TempDAO();

	vo.setLoc(loc);
	ArrayList<TempVO> list = dao.getTempList(vo);
	TempListVO tList = new TempListVO();
	tList.setCnt(list.size());
	tList.setStatus("success");
	tList.setList(list);
	Gson gson = new Gson();
	String result = gson.toJson(tList);
	tList = gson.fromJson(result, TempListVO.class);
	response.setContentType("application/json;charset=utf-8");
	PrintWriter out = response.getWriter();
	out.println(result);
	}
}
