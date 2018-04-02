package org.Isaveu.service;

import java.util.List;

import javax.annotation.Resource;

import org.Isaveu.domain.TbModuleVO;
import org.Isaveu.mapper.ModuleMapper;
import org.springframework.stereotype.Service;

@Service("org.Isaveu.service.ModuleService")
public class ModuleService implements ModuleMapper {

	@Resource(name = "org.Isaveu.mapper.ModuleMapper")
	ModuleMapper mMapper;

	@Override
	public List<TbModuleVO> getModuleList(String type) throws Exception {
		return mMapper.getModuleList(type);
	}

}
