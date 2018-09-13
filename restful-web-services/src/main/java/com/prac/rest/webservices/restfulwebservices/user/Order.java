package com.prac.rest.webservices.restfulwebservices.user;

public class Order {
	private int id;
	private String detail;

	public Order(int i, String string) {
		this.detail=string;
		this.id = i;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
