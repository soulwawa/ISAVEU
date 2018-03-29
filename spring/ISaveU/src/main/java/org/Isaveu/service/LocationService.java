package org.Isaveu.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.Isaveu.domain.LocationByTbFireExVO;
import org.Isaveu.mapper.LocationMapper;
import org.springframework.stereotype.Service;

@Service("org.Isaveu.service.LocationService")
public class LocationService implements LocationMapper{

	@Resource(name = "org.Isaveu.mapper.LocationMapper")
	LocationMapper lMapper;

	@Override
	public ArrayList<LocationByTbFireExVO> locationByFireEx() throws Exception {
		return lMapper.locationByFireEx();
	}
	
}
//return lMapper.locationByFireEx();