package kpc.iot.smb.chart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/Dispatcher")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Dispatcher() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//이번에는 이전 예제와는 다르게 Ajax요청이 오면 응답해줄꺼다.
		//이전에는 그냥 내가 원하는 페이지로 json을 가져가는 거였다면?
		//지금은 요청한 놈한테 return만 해주면 되기 때문에
		//PrintWriter out = resp.getWriter();
		//이걸 사용하면 된다.
		
		//주소요청 http://localhost:8000/JsonAjax/Dispatcher
		//Get방식
		//process()함수 호출
		//JSON만들기
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("temp", "200");
		jsonObj.put("smoke", "150");
		jsonObj.put("fire", "120");
		jsonObj.put("gyro", "100");
		jsonObj.put("msg", "success");
		
		PrintWriter out = resp.getWriter();
		out.print(jsonObj);
		System.out.println(out);
	}

}

