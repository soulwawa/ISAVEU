package org.Isaveu.controller;

import javax.annotation.Resource;

import org.Isaveu.domain.TbBoardVO;
import org.Isaveu.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name = "org.Isaveu.service.BoardService")
	BoardService bService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(TbBoardVO board, Model model) throws Exception{
		logger.info("register get .....");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(TbBoardVO board, Model model) throws Exception{
		logger.info("register POST .....");
		logger.info(board.toString());
		
		bService.create(board);
		
		model.addAttribute("result", "success");
		return "/board/success";
	}
}
