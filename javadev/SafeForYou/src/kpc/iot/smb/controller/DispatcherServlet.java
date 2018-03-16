package kpc.iot.smb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		HandlerMappings mappings = new HandlerMappings();
		Controller controller = mappings.getController(path);
		String returnUrl = "index.jsp";
		try {
			returnUrl = controller.handlerReuquest(request, response);
		} catch (Exception e) {
			System.out.println("DispatcherServlet:" + e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/" + returnUrl);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
