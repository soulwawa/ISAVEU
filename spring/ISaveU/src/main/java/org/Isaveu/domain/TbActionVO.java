package org.Isaveu.domain;

import java.io.Serializable;

import lombok.ToString;

@ToString
public class TbActionVO implements Serializable {
	private static final long serialVersionUID = 1L;
	int action_id;
	String module_id;
	String url;
	String datetime;

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

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
