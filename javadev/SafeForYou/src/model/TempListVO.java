package model;

import java.util.ArrayList;

public class TempListVO {
	private String status;
	private int cnt;
	private ArrayList<TempVO> list;



	public int getCnt() {
		return cnt;
	}



	public void setCnt(int cnt) {
		this.cnt = cnt;
	}



	public ArrayList<TempVO> getList() {
		return list;
	}



	public void setList(ArrayList<TempVO> list) {
		this.list = list;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getStatus() {
		return status;
	}
}
