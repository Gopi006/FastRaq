package com.securecloud.bean;

import java.io.Serializable;

// Setters and getters for Bean

public class Example implements Serializable {

	private static final long serialVersionUID = 1L;

	private String string;

	private int fileid;

	private int sid;

	private String keyword;

	private int count;
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private String fileIds;

	public int getFileid() {
		return fileid;
	}

	public void setFileid(int fileid) {
		this.fileid = fileid;
	}

	public String getString() {
		return string;
	}

	public void setString(String a) {
		this.string = a;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getFileIds() {
		return fileIds;
	}

	public void setFileIds(String fileIds) {
		this.fileIds = fileIds;
	}

	public String getAc2() {
		return ac2;
	}

	public void setAc2(String ac2) {
		this.ac2 = ac2;
	}

	public String getAc3() {
		return ac3;
	}

	public void setAc3(String ac3) {
		this.ac3 = ac3;
	}

	public String getAc4() {
		return ac4;
	}

	public void setAc4(String ac4) {
		this.ac4 = ac4;
	}

	public String getAc5() {
		return ac5;
	}

	public void setAc5(String ac5) {
		this.ac5 = ac5;
	}

	public String getTc1() {
		return tc1;
	}

	public void setTc1(String tc1) {
		this.tc1 = tc1;
	}

	public String getTc2() {
		return tc2;
	}

	public void setTc2(String tc2) {
		this.tc2 = tc2;
	}

	public String getTc3() {
		return tc3;
	}

	public void setTc3(String tc3) {
		this.tc3 = tc3;
	}

	public String getTc4() {
		return tc4;
	}

	public void setTc4(String tc4) {
		this.tc4 = tc4;
	}

	public String getTc5() {
		return tc5;
	}

	public void setTc5(String tc5) {
		this.tc5 = tc5;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String ac2;
	private String ac3;
	private String ac4;
	private String ac5;

	private String tc1;
	private String tc2;
	private String tc3;
	private String tc4;
	private String tc5;

}
