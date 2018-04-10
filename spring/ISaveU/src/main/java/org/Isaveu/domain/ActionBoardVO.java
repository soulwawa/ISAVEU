package org.Isaveu.domain;

public class ActionBoardVO {
	private int action_id;
	private int module_id;
	private String time;
	private String url;
	private String issue;
	private String dept_name;
	public int getAction_id() {
		return action_id;
	}
	public void setAction_id(int action_id) {
		this.action_id = action_id;
	}
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	@Override
	public String toString() {
		return "ActionBoardVO [action_id=" + action_id + ", module_id=" + module_id + ", time=" + time + ", url=" + url
				+ ", issue=" + issue + ", dept_name=" + dept_name + "]";
	}
	
}
