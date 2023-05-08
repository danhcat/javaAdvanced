package com.vti.dto;

public class DepartmentDto {
	private short id;

	public DepartmentDto() {
		super();
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentDto(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "DepartmentDto [name=" + name + "]";
	}

}
