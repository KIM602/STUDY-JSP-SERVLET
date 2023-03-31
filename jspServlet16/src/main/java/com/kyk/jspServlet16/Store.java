package com.kyk.jspServlet16;

public class Store {
	private String id;
	private String code;
	private int cost;
	private boolean flag;
	
	public Store() {
		super();
	}

	public Store(String id, String code, int cost, boolean flag) {
		super();
		this.id = id;
		this.code = code;
		this.cost = cost;
		this.flag = flag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
