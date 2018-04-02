package org.Isaveu.domain;

import java.io.Serializable;

public class LocationByFireExVO  implements Serializable{

	private static final long serialVersionUID = -8738748657870704357L;
	private int location_id;
	private String location;
	private String dept_name;
	private String manager;
	private String dept_tel;
	private int fire_ex_id;
	private String fire_ex_name;
	private String fire_ex_mac;
	private String fire_ex_status;
	private String fire_ex_make;
	private String next_check;
	private String check_date;
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
	public int getFire_ex_id() {
		return fire_ex_id;
	}
	public void setFire_ex_id(int fire_ex_id) {
		this.fire_ex_id = fire_ex_id;
	}
	public String getFire_ex_name() {
		return fire_ex_name;
	}
	public void setFire_ex_name(String fire_ex_name) {
		this.fire_ex_name = fire_ex_name;
	}
	public String getFire_ex_mac() {
		return fire_ex_mac;
	}
	public void setFire_ex_mac(String fire_ex_mac) {
		this.fire_ex_mac = fire_ex_mac;
	}
	public String getFire_ex_status() {
		return fire_ex_status;
	}
	public void setFire_ex_status(String fire_ex_status) {
		this.fire_ex_status = fire_ex_status;
	}
	public String getFire_ex_make() {
		return fire_ex_make;
	}
	public void setFire_ex_make(String fire_ex_make) {
		this.fire_ex_make = fire_ex_make;
	}
	public String getNext_check() {
		return next_check;
	}
	public void setNext_check(String next_check) {
		this.next_check = next_check;
	}
	public String getCheck_date() {
		return check_date;
	}
	public void setCheck_date(String check_date) {
		this.check_date = check_date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "LocationByFireExVO [location_id=" + location_id + ", location=" + location + ", dept_name=" + dept_name
				+ ", manager=" + manager + ", dept_tel=" + dept_tel + ", fire_ex_id=" + fire_ex_id + ", fire_ex_name="
				+ fire_ex_name + ", fire_ex_mac=" + fire_ex_mac + ", fire_ex_status=" + fire_ex_status
				+ ", fire_ex_make=" + fire_ex_make + ", next_check=" + next_check + ", check_date=" + check_date + "]";
	}
	
	
}
