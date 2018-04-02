package org.Isaveu.domain;

import java.io.Serializable;

import lombok.ToString;

@ToString
public class TbEventVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int event_id;
	private String module_id;
	private String time;
	private float temp;
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private float smoke;
	private float gyro;
	private float fire;
	private String issue;

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getModule_id() {
		return module_id;
	}

	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}


	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getSmoke() {
		return smoke;
	}

	public void setSmoke(float smoke) {
		this.smoke = smoke;
	}

	public float getGyro() {
		return gyro;
	}

	public void setGyro(float gyro) {
		this.gyro = gyro;
	}

	public float getFire() {
		return fire;
	}

	public void setFire(float fire) {
		this.fire = fire;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	@Override
	public String toString() {
		return "TbEventVO [event_id=" + event_id + ", module_id=" + module_id + ", time=" + time + ", temp=" + temp
				+ ", smoke=" + smoke + ", gyro=" + gyro + ", fire=" + fire + ", issue=" + issue + "]";
	}

	
	
}
