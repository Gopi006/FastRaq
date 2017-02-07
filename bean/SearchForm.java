package com.securecloud.bean;

import java.io.Serializable;

public class SearchForm implements Serializable {

	private String keyword;
	private String wordindex;
	private String indexdescription;
	private String key;
	private String username;
	private String purpose;

	private String worddocument;
	private String worddocumenttype;
	private String urls;
	private String datatitle;
	private String imagepath;

	private int interfaceid;
	private int keyref;
	private String title;
	private String titledata;
	private String datadescription;
	private String filename;
	private String keywords[];

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	private int dataindexid;
	private int interfacerefid;
	private String othermetadata;
	private String datadate;
	private String titlehead;
	private int recordscount;

	private String filedescription;
	private String inputfile;
	private String filetype;
	private int fileid;
	private int filedownloadcount;
	private int securitycode;
	private int fsize;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getSecuritycode() {
		return securitycode;
	}

	public void setSecuritycode(int securitycode) {
		this.securitycode = securitycode;
	}

	public int getFsize() {
		return fsize;
	}

	public void setFsize(int fsize) {
		this.fsize = fsize;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWordindex() {
		return wordindex;
	}

	public void setWordindex(String wordindex) {
		this.wordindex = wordindex;
	}

	public String getIndexdescription() {
		return indexdescription;
	}

	public void setIndexdescription(String indexdescription) {
		this.indexdescription = indexdescription;
	}

	public String getWorddocument() {
		return worddocument;
	}

	public void setWorddocument(String worddocument) {
		this.worddocument = worddocument;
	}

	public String getDatatitle() {
		return datatitle;
	}

	public void setDatatitle(String datatitle) {
		this.datatitle = datatitle;
	}

	public String getWorddocumenttype() {
		return worddocumenttype;
	}

	public void setWorddocumenttype(String worddocumenttype) {
		this.worddocumenttype = worddocumenttype;
	}

	public String getUrls() {
		return urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public int getInterfaceid() {
		return interfaceid;
	}

	public void setInterfaceid(int interfaceid) {
		this.interfaceid = interfaceid;
	}

	public int getKeyref() {
		return keyref;
	}

	public void setKeyref(int keyref) {
		this.keyref = keyref;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitledata() {
		return titledata;
	}

	public void setTitledata(String titledata) {
		this.titledata = titledata;
	}

	public String getDatadescription() {
		return datadescription;
	}

	public void setDatadescription(String datadescription) {
		this.datadescription = datadescription;
	}

	public int getDataindexid() {
		return dataindexid;
	}

	public void setDataindexid(int dataindexid) {
		this.dataindexid = dataindexid;
	}

	public int getInterfacerefid() {
		return interfacerefid;
	}

	public void setInterfacerefid(int interfacerefid) {
		this.interfacerefid = interfacerefid;
	}

	public String getOthermetadata() {
		return othermetadata;
	}

	public void setOthermetadata(String othermetadata) {
		this.othermetadata = othermetadata;
	}

	public String getDatadate() {
		return datadate;
	}

	public void setDatadate(String datadate) {
		this.datadate = datadate;
	}

	public String getTitlehead() {
		return titlehead;
	}

	public void setTitlehead(String titlehead) {
		this.titlehead = titlehead;
	}

	public int getRecordscount() {
		return recordscount;
	}

	public void setRecordscount(int recordscount) {
		this.recordscount = recordscount;
	}

	public String getFiledescription() {
		return filedescription;
	}

	public void setFiledescription(String filedescription) {
		this.filedescription = filedescription;
	}

	public String getInputfile() {
		return inputfile;
	}

	public void setInputfile(String inputfile) {
		this.inputfile = inputfile;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public int getFileid() {
		return fileid;
	}

	public void setFileid(int fileid) {
		this.fileid = fileid;
	}

	public int getFiledownloadcount() {
		return filedownloadcount;
	}

	public void setFiledownloadcount(int filedownloadcount) {
		this.filedownloadcount = filedownloadcount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

}
