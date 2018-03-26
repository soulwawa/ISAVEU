package org.Isaveu.mapper;

import org.Isaveu.domain.TbActionVO;
import org.springframework.stereotype.Repository;

@Repository("org.Isaveu.mapper.ActionMapper")
public interface ActionMapper {
	public void insertAction(TbActionVO action) throws Exception;
}
