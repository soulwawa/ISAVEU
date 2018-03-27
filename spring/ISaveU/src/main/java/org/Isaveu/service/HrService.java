package org.Isaveu.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.Isaveu.domain.TbHrVO;
import org.Isaveu.mapper.HrMapper;
import org.springframework.stereotype.Service;

@Service("org.Isaveu.service.HrService")
public class HrService implements HrMapper{
	@Resource(name = "org.Isaveu.mapper.HrMapper")
	HrMapper hMapper;
	

	@Override
	public ArrayList<TbHrVO> getHrAllList() throws Exception {
		return hMapper.getHrAllList();
	}

	@Override
	public ArrayList<TbHrVO> getHrListId(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hrInsert(TbHrVO hrVo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fcmUpdate(TbHrVO hrVo) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
