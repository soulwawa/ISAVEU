package kpc.iot.smb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kpc.iot.smb.data.vo.TbHrVO;
import svc.LoginService;


@WebServlet("/login.do")
public class webLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public webLogin() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("password");
    	LoginService loginService = new LoginService();
    	TbHrVO loginMember = loginService.getLoginMeber(id, pwd);
    	//성공시 Member 객체가  넘어오고 실패하면 null 넘어옴
    	
    	if(loginMember != null) {
    		HttpSession session = request.getSession();
    		session.setAttribute("id", id);
    		response.sendRedirect("index.jsp");
    	}else {
    		response.setContentType("text/html;charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		out.println("<script>");
    		out.println("alert('로그인 실패')");
    		out.println("history.back()");
    		out.println("</script>");
    	}
    }

}
