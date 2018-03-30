package org.Isaveu.domain;

public class ModuleByLocationVO {
	private int module_id;
	private String type;
	private String ip;
	private int location_id;
	private String location;
	private String dept_name;
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	@Override
	public String toString() {
		return "ModuleByLocation [module_id=" + module_id + ", type=" + type + ", ip=" + ip + ", location_id="
				+ location_id + ", location=" + location + ", dept_name=" + dept_name + "]";
	}
	
}
