package org.Isaveu.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.Isaveu.domain.TbHrVO;
import org.Isaveu.dto.LoginDTO;
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
		return hMapper.getHrListId(id);
	}

	@Override
	public ArrayList<TbHrVO> getHrListLevel(String level) throws Exception {
		return hMapper.getHrListLevel(level);
	}

	@Override
	public void hrInsert(TbHrVO hrVo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void fcmUpdate(TbHrVO hrVo) throws Exception {
		hMapper.fcmUpdate(hrVo);
	}

	@Override
	public TbHrVO login(LoginDTO dto) throws Exception {
		return hMapper.login(dto);
	}


}
