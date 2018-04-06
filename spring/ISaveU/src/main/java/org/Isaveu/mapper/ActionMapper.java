package org.Isaveu.mapper;

import java.util.ArrayList;

import org.Isaveu.domain.TbActionVO;
import org.springframework.stereotype.Repository;

@Repository("org.Isaveu.mapper.ActionMapper")
public interface ActionMapper {
	public void insertAction(TbActionVO action) throws Exception;
	public ArrayList<TbActionVO> selectAllList() throws Exception;
}
