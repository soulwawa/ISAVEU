package kpc.iot.smb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpc.iot.smb.util.Action;
import kpc.iot.smb.util.ActionFactory;
import kpc.iot.smb.util.ErrorAction;


//@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String path = uri.substring(uri.lastIndexOf("/"));
//		HandlerMappings mappings = new HandlerMappings();
//		Controller controller = mappings.getController(path);
//		String returnUrl = "index.jsp";
//		try {
//			returnUrl = controller.handlerReuquest(request, response);
//		} catch (Exception e) {
//			System.out.println("DispatcherServlet:" + e);
//		}
//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/" + returnUrl);
//		dispatcher.forward(request, response);
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		System.out.println(path);
		
		try{
			ActionFactory factory = ActionFactory.getInstance();
			Action action = factory.getAction(path);
			action.execute(request, response);
		}catch(Exception ex){
			request.setAttribute("error.key", ex);
			Action action = new ErrorAction();
			action.execute(request, response);
		}
	}
	}

