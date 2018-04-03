package org.Isaveu.mapper;

import java.util.ArrayList;

import org.Isaveu.domain.LocationByFireExVO;
import org.Isaveu.domain.LocationByIssueVO;
import org.Isaveu.domain.ModuleByLocationVO;
import org.springframework.stereotype.Repository;

@Repository("org.Isaveu.mapper.LocationMapper")
public interface LocationMapper {
	public ArrayList<LocationByFireExVO> locationByFireEx() throws Exception;
	public ArrayList<ModuleByLocationVO> moduleByLocation(String module_id) throws Exception;
	public ArrayList<LocationByIssueVO> AndroidDisasterCheck(int count) throws Exception;
	public String locationCount(String loc) throws Exception;
}
