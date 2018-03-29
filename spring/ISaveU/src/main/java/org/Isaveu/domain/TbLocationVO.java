package org.Isaveu.domain;

import java.io.Serializable;

import lombok.ToString;

public class TbLocationVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int location_id;
	private String location;
	private String dept_name;
	private String manager;
	private String dept_tel;
	
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

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getDept_tel() {
		return dept_tel;
	}

	public void setDept_tel(String dept_tel) {
		this.dept_tel = dept_tel;
	}

	@Override
	public String toString() {
		return "TbLocationVO [location_id=" + location_id + ", location=" + location + ", dept_name=" + dept_name
				+ ", manager=" + manager + ", dept_tel=" + dept_tel + "]";
	}
	
}

