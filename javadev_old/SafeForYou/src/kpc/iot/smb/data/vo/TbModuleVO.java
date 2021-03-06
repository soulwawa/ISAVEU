package kpc.iot.smb.data.vo;

import java.io.Serializable;

public class TbModuleVO implements Serializable {

	private static final long serialVersionUID = 1L;
	String module;
	String type;
	String ip;
	int location_id;

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
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

}
