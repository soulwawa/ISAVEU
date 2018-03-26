package org.Isaveu.mapper;

import org.Isaveu.domain.TbEventVO;
import org.springframework.stereotype.Repository;

@Repository("org.Isaveu.mapper.EventMapper")
public interface EventMapper {
	public void insertEvent(TbEventVO event);
}
