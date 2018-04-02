package org.Isaveu.domain;

import java.io.Serializable;

import lombok.ToString;

@ToString
public class TbModuleVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String module_id;
	private String type;
	private String ip;
	int location_id;

	public String getModule_id() {
		return module_id;
	}

	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	@Override
	public String toString() {
		return "TbModuleVO [module_id=" + module_id + ", type=" + type + ", ip=" + ip + ", location_id=" + location_id + "]";
	}
	
}
