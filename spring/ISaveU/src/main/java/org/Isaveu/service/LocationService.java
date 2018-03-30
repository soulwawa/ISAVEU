package org.Isaveu.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.Isaveu.domain.LocationByFireExVO;
import org.Isaveu.domain.ModuleByLocationVO;
import org.Isaveu.mapper.LocationMapper;
import org.springframework.stereotype.Service;

@Service("org.Isaveu.service.LocationService")
public class LocationService implements LocationMapper{

	@Resource(name = "org.Isaveu.mapper.LocationMapper")
	LocationMapper lMapper;

	@Override
	public ArrayList<LocationByFireExVO> locationByFireEx() throws Exception {
		return lMapper.locationByFireEx();
	}

	@Override
	public ArrayList<ModuleByLocationVO> moduleByLocation(String module_id) throws Exception {
		return lMapper.moduleByLocation(module_id);
	}
	
}
//return lMapper.locationByFireEx();