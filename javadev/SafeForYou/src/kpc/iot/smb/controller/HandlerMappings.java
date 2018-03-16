package kpc.iot.smb.controller;

import java.util.HashMap;

public class HandlerMappings {
	private HashMap<String, Controller> lists =  new HashMap<String, Controller>(); 
	public HandlerMappings() {
		initConfig();
	}
	
	void initConfig() {
		lists.put("/sendaction.do", new SendController());
	}
	
	public Controller getController(String path) {
		return lists.get(path);
	}
}
