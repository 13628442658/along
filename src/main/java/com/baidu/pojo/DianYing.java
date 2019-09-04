package com.baidu.pojo;

public class DianYing {

	private int did;
	private String dname;
	private String content;
	private String dao;
	private String day;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDao() {
		return dao;
	}
	public void setDao(String dao) {
		this.dao = dao;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "DianYing [did=" + did + ", dname=" + dname + ", content=" + content + ", dao=" + dao + ", day=" + day
				+ "]";
	}
	
	
}
