package org.Isaveu.mapper;

import java.util.List;

import org.Isaveu.domain.TbModuleVO;
import org.springframework.stereotype.Repository;

@Repository("org.Isaveu.mapper.ModuleMapper")
public interface ModuleMapper {
	public List<TbModuleVO> getModuleList(String type) throws Exception;
}
