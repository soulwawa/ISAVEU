package kpc.iot.smb.fcm;

public class Data {
	String title;
	String content_1;
	String content_2;
	String content_3;
	String key1 = "key1";
	String key2 = "key2";
	public String getTitle() {
		return title;
	}
	public String getContent_3() {
		return content_3;
	}
	public void setContent_3(String content_3) {
		this.content_3 = content_3;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent_1() {
		return content_1;
	}
	public void setContent_1(String content_1) {
		this.content_1 = content_1;
	}
	public String getContent_2() {
		return content_2;
	}
	public void setContent_2(String content_2) {
		this.content_2 = content_2;
	}

	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	@Override
	public String toString() {
		return "Data [title=" + title + ", content_1=" + content_1 + ", content_2=" + content_2 + ", content_3="
				+ content_3 + ", key1=" + key1 + ", key2=" + key2 + "]";
	}
	
}
