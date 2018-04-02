package org.Isaveu.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.Isaveu.domain.TbFireExVO;
import org.Isaveu.mapper.FireExMapper;
import org.springframework.stereotype.Service;

@Service("org.Isave.service.FireExService")
public class FireExService implements FireExMapper{
	
	@Resource(name = "org.Isaveu.mapper.FireExMapper")
	FireExMapper fMapper;
	

	@Override
	public ArrayList<TbFireExVO> getFireEx(String fire_ex_name) throws Exception {
		return fMapper.getFireEx(fire_ex_name);
	}

	@Override
	public void fireExStatusUpdate(TbFireExVO fire) throws Exception {
		fMapper.fireExStatusUpdate(fire);
		
	}

	@Override
	public void updatefireExStatus(String location) throws Exception {
		fMapper.updatefireExStatus(location);
	}


	
}
