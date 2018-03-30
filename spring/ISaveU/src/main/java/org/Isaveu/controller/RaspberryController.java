package org.Isaveu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaspberryController {

	@RequestMapping(value = "/raspstream")
	private void raspStreaming() throws Exception{
		
		
		// 192.168.0.13:5001/stream/
		// http://192.168.0.13:5000
		
		
	}
}
