package kpc.iot.smb.controller;

import javax.servlet.http.*;


public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
