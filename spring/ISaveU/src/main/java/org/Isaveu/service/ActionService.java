package org.Isaveu.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.Isaveu.domain.ActionBoardVO;
import org.Isaveu.domain.TbActionVO;
import org.Isaveu.mapper.ActionMapper;
import org.springframework.stereotype.Service;

@Service("org.Isaveu.service.ActionService")
public class ActionService implements ActionMapper{
	
	@Resource(name = "org.Isaveu.mapper.ActionMapper")
	ActionMapper aMapper;
	
	@Override
	public void insertAction(TbActionVO action) throws Exception {
		aMapper.insertAction(action);
	}

	@Override
	public ArrayList<ActionBoardVO> selectAllList() throws Exception {
		return aMapper.selectAllList();
	}
	
} 
