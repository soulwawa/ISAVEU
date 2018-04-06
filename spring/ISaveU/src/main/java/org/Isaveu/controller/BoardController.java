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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/admin/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name = "org.Isaveu.service.BoardService")
	BoardService bService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(TbBoardVO board, Model model) throws Exception{
		logger.info("register get .....");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(TbBoardVO board, RedirectAttributes rttr) throws Exception{
		logger.info("register POST .....");
		logger.info(board.toString());
		
		bService.create(board);
		
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/admin/listAll", method = RequestMethod.GET)
	public String listAll(Model model) throws Exception{
		logger.info("show all List...");
		return "board/listAll";
	}
}
