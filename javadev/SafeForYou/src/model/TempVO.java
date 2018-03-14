package model;

import java.io.Serializable;

public class TempVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String num;
	private String loc;
	private String type;
	private String temperature;
	private String idate;

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getNum() {
		return num;
	}
}