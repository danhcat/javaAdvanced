package com.vti.form;

public class DepartmentForm {
	int so;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentForm() {
		super();
	}

	@Override
	public String toString() {
		return "DepartmentForm [name=" + name + "]";
	}

}
