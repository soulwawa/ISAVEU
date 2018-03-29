package org.Isaveu.domain;
import java.io.Serializable;

import lombok.ToString;

@ToString
public class TbHrVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int hr_id;
	private	String id;
	private String pw;
	private String name;
	private int location_id;
	private String tel;
	private String email;
	private String sex;
	private String birthday;
	private String level;
	private String fcm;
	private String profile;

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getHr_id() {
		return hr_id;
	}

	public void setHr_id(int hr_id) {
		this.hr_id = hr_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getFcm() {
		return fcm;
	}

	public void setFcm(String fcm) {
		this.fcm = fcm;
	}

	@Override
	public String toString() {
		return "TbHrVO [hr_id=" + hr_id + ", id=" + id + ", pw=" + pw + ", name=" + name + ", location_id="
				+ location_id + ", tel=" + tel + ", email=" + email + ", sex=" + sex + ", birthday=" + birthday
				+ ", level=" + level + ", fcm=" + fcm + ", profile=" + profile + "]";
	}


}
