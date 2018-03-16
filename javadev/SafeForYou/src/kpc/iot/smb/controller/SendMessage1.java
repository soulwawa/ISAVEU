package kpc.iot.smb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

@WebServlet("/SendMessage")
public class SendMessage1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	ArrayList<String> token = new ArrayList<String>(); // token값을 ArrayList에 저장
//	String MESSAGE_ID = String.valueOf(Math.random() % 100 +1); //메시지 고유 ID
	String MESSAGE_ID = "AAAA91-0IQE:APA91bEvPIXCvITxVpcVaxysasJzU4wjuTNT29zkgmRv6ayxLe0U1iIgO0zIvImluA4_5AczoDfZrlFZluTuVBqFM_JBvyjqkH6R9k2bBoMSQaNOPlTOVnjHYTFwjSjMuVt0-nusaVRJ"; //메시지 고유 ID
	
	boolean SHOW_ON_IDLE = false;
	int LIVE_TIME = 1;
	int RETRY = 2;
	
//	String simpleApikey = "dpLbZuQqfWI:APA91bGk_AXJK3q6Kx4_k9sil7hJQ1CzfqFvTPzonsQpl3OwOpCYVeHrcJdcBpvgY6XaazHcQLkSfHtho2cVdv6G9hkMZUELAPruewDjlffQ5sNCPyIQL71PNtQPVfPlPHOusLBnN6pJ";
	String simpleApikey = "AAAA91-0IQE:APA91bEvPIXCvITxVpcVaxysasJzU4wjuTNT29zkgmRv6ayxLe0U1iIgO0zIvImluA4_5AczoDfZrlFZluTuVBqFM_JBvyjqkH6R9k2bBoMSQaNOPlTOVnjHYTFwjSjMuVt0-nusaVRJ";
	String gcmURL = "https://fcm.googleapis.com/fcm/send";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("message");
		if(msg == null || msg.equals("")) {
			msg = "";
		}
		msg = new String(msg.getBytes("UTF-8"), "UTF-8");  //메세지 한글깨짐 처리
		Sender sender = new Sender(simpleApikey);
		Message message = new Message.Builder().
				collapseKey(MESSAGE_ID).
				delayWhileIdle(SHOW_ON_IDLE).
				timeToLive(LIVE_TIME).
				addData("message", msg).
				build();
		MulticastResult result1 = sender.send(message, token, RETRY);
		if(result1 != null) {
			List<Result> resultList = result1.getResults();
			for (Result result : resultList) {
				System.out.println(result.getErrorCodeName());
			}
		}
	}

}
