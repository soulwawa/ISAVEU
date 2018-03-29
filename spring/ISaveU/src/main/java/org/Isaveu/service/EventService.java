package org.Isaveu.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.Isaveu.domain.TbEventVO;
import org.Isaveu.mapper.EventMapper;
import org.springframework.stereotype.Service;

@Service("org.Isaveu.service.EventService")
public class EventService implements EventMapper{

	@Resource(name = "org.Isaveu.mapper.EventMapper")
	EventMapper eMapper;
	
	@Override
	public void insertEvent(TbEventVO event) {
		eMapper.insertEvent(event);
		
	}

	@Override
	public ArrayList<TbEventVO> selectRecent(int num) {
		return eMapper.selectRecent(num);
	}
	
}
