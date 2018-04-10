package org.Isaveu.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.Isaveu.domain.LocationByFireExVO;
import org.Isaveu.domain.LocationByIssueVO;
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

	@Override
	public ArrayList<LocationByIssueVO> AndroidDisasterCheck(String count) throws Exception {
		return lMapper.AndroidDisasterCheck(count);
	}

	@Override
	public String locationCount(String loc) throws Exception {
		return lMapper.locationCount(loc);
	}

	@Override
	public ArrayList<LocationByFireExVO> locationByFireExName(String fire_ex_name) throws Exception {
		return lMapper.locationByFireExName(fire_ex_name);
	}
	
}
//return lMapper.locationByFireEx();