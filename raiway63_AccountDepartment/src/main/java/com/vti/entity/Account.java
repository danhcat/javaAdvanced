package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "account")
public class Account implements Serializable {
	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	@Column(name = "Email", length = 50, nullable = false, unique = true)
	private String email;
	@Column(name = "Username", length = 50, nullable = false)
	private String useName;
	@Column(name = "FullName", length = 50, nullable = false)
	private String fullName;
	@ManyToOne
	@JoinColumn(name = "DepartmentID", nullable = false)
	private Department department;
	@ManyToOne
	@JoinColumn(name = "PositionID", nullable = false)
	private Position position;
	@Column(name = "CreateDate")
	@CreationTimestamp
	private Date crateDate;
	@Column(name = "PassWord", length = 800)
	private String passWord;

	public short getId() {
		return id;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPositionID() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getCrateDate() {
		return crateDate;
	}

	public void setCrateDate(Date crateDate) {
		this.crateDate = crateDate;
	}

	public Account() {
		super();
	}

	public Account(short id, String email, String useName, String fullName, Department department, Position position,
			Date crateDate, String passWord) {
		super();
		this.id = id;
		this.email = email;
		this.useName = useName;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.crateDate = crateDate;
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", useName=" + useName + ", fullName=" + fullName
				+ ", departmentID=" + department + ", position=" + position.toString() + ", crateDate=" + crateDate
				+ "]";
	}

}
