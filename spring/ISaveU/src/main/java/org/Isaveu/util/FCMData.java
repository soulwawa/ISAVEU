package org.Isaveu.util;


import com.google.gson.JsonElement;

public class FCMData {
	
	
	Data data;
//	String to;
	JsonElement registration_ids;
	String collapse_key = "type_a";
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public JsonElement getRegistration_ids() {
		return registration_ids;
	}
	public void setRegistration_ids(JsonElement registration_ids) {
		this.registration_ids = registration_ids;
	}
//	public String getTo() {
//		return to;
//	}
//	public void setTo(String to) {
//		this.to = to;
//	}
	
}
