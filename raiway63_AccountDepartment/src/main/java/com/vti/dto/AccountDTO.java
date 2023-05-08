package com.vti.dto;

import java.util.Date;

public class AccountDTO {

	private short id;
	private String email;
	private String useName;
	private String fullName;

	private String department;

	private String position;

	private Date crateDate;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUseName() {
		return useName;
	}

	public void setUseName(String useName) {
		this.useName = useName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getCrateDate() {
		return crateDate;
	}

	public void setCrateDate(Date crateDate) {
		this.crateDate = crateDate;
	}

	public AccountDTO() {
		super();
	}

	public AccountDTO(short id, String email, String useName, String fullName, String department, String position,
			Date crateDate) {
		super();
		this.id = id;
		this.email = email;
		this.useName = useName;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.crateDate = crateDate;
	}

}
