package org.Isaveu.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.Isaveu.domain.TbEventVO;
import org.springframework.stereotype.Repository;

@Repository("org.Isaveu.mapper.EventMapper")
public interface EventMapper {
	public void insertEvent(TbEventVO event);
	public ArrayList<TbEventVO> selectRecent(int num);
	public ArrayList<TbEventVO> dispatcherPart(int num);
}
