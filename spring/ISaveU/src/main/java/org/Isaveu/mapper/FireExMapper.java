package org.Isaveu.mapper;

import java.util.ArrayList;

import org.Isaveu.domain.TbFireExVO;
import org.springframework.stereotype.Repository;

@Repository("org.Isaveu.mapper.FireExMapper")
public interface FireExMapper {
	public ArrayList<TbFireExVO> getFireEx(String fire_ex_name) throws Exception;
	public void fireExStatusUpdate(TbFireExVO fire) throws Exception;
	public void updatefireExStatus(String location) throws Exception;
}
