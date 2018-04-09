package org.Isaveu.domain;

import java.io.Serializable;

public class TbActionVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private int action_id;
	private String module_id;
	private String url;
	private String time;

	public int getAction_id() {
		return action_id;
	}

	public void setAction_id(int action_id) {
		this.action_id = action_id;
	}

	public String getModule_id() {
		return module_id;
	}

	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String gettime() {
		return time;
	}

	public void settime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "TbActionVO [action_id=" + action_id + ", module_id=" + module_id + ", url=" + url + ", time="
				+ time + "]";
	}
}
