package kpc.iot.smb.data.vo;

import java.io.Serializable;

public class TbFireExVO implements Serializable {

	private static final long serialVersionUID = 1L;
	int fire_ex_id;
	int location_id;
	String ex_date;
	String datetime;

	public int getFire_ex_id() {
		return fire_ex_id;
	}

	public void setFire_ex_id(int fire_ex_id) {
		this.fire_ex_id = fire_ex_id;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getEx_date() {
		return ex_date;
	}

	public void setEx_date(String ex_date) {
		this.ex_date = ex_date;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
