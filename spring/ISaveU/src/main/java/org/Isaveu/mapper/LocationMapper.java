package org.Isaveu.mapper;

import java.util.ArrayList;

import org.Isaveu.domain.LocationByTbFireExVO;
import org.springframework.stereotype.Repository;

@Repository("org.Isaveu.mapper.LocationMapper")
public interface LocationMapper {
	public ArrayList<LocationByTbFireExVO> locationByFireEx() throws Exception;
}
