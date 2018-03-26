package org.Isaveu.service;

import javax.annotation.Resource;

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

} 
