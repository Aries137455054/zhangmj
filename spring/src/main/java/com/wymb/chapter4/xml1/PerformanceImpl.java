package com.wymb.chapter4.xml1;

import java.util.List;

public class PerformanceImpl implements Performance {
	private String title;
	private List<String> list;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void giveMoney(List<String> list) {
		System.out.println("上交班费。。。。。。。。。。" + title+this.list);
	}

}
