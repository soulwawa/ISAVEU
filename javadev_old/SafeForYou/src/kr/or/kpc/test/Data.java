package kr.or.kpc.test;

public class Data {
	String title;
	String content;
	String key1 = "key1";
	String key2 = "key2";
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
		return "Message [title=" + title + ", content=" + content + ", key1=" + key1 + ", key2=" + key2 + "]";
	}
}
