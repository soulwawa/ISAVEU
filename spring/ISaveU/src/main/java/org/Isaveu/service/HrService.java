package org.Isaveu.service;

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
	public List<TbHrVO> getHrAllList() throws Exception {
		return hMapper.getHrAllList();
	}

	@Override
	public List<TbHrVO> getHrListId(String id) throws Exception {
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
