package kpc.iot.smb.util;

import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // redirect

	public static void redirect(HttpServletResponse response, String path) {
		try {
			response.sendRedirect(path);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // forward

	public static String encoding(String url) {
		try {
			url = URLEncoder.encode(url, "UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return url;
	}

	public static void main(String args[]) {
		String str = "???";
		str = HttpUtil.encoding(str);
		System.out.println(str);
	}
}
