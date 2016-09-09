package com.yuan.javaweb.adminmodel;

import java.util.List;
import java.util.Map;

public class Page {

	private List<Map<String,Object>> list;
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
}
