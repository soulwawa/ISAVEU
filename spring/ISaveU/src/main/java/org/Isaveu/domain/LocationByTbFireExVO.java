package org.Isaveu.domain;

import java.io.Serializable;

public class LocationByTbFireExVO  implements Serializable{

	private static final long serialVersionUID = -8738748657870704357L;
	
	private String location;
	private String fire_ex_status;
	
	public String getFire_ex_status() {
		return fire_ex_status;
	}
	public void setFire_ex_status(String fire_ex_status) {
		this.fire_ex_status = fire_ex_status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "LocationByTbFireExVO [location=" + location + ", fire_ex_status=" + fire_ex_status + "]";
	}
	
	
	
}
