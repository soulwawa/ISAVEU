package org.Isaveu.domain;

public class LocationByIssueVO {
	private String location;
	private String time;
	private String issue;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	@Override
	public String toString() {
		return "LocationByIssueVO [location=" + location + ", time=" + time + ", issue=" + issue + "]";
	}
	
	
}
