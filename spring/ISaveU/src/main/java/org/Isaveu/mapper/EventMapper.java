package org.Isaveu.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.Isaveu.domain.TbEventVO;
import org.springframework.stereotype.Repository;

@Repository("org.Isaveu.mapper.EventMapper")
public interface EventMapper {
	public void insertEvent(TbEventVO event);
	public ArrayList<TbEventVO> selectRecent(int num);
	public List<TbEventVO> selectRecentToModule(String module_id);
	public ArrayList<TbEventVO> dispatcherPart(int num);
}
