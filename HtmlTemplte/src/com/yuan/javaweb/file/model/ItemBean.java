package com.yuan.javaweb.file.model;

import org.apache.commons.fileupload.FileItem;

public class ItemBean {
	private String id;
	private FileItem item;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public FileItem getItem() {
		return item;
	}
	public void setItem(FileItem item) {
		this.item = item;
	}
	
	
}
