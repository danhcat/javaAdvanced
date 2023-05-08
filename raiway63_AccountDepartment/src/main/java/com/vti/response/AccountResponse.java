package com.vti.response;

import java.util.List;

import com.vti.entity.Account;

public class AccountResponse {
	int code;
	String message;
	List<Account> datas;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Account> getDatas() {
		return datas;
	}

	public void setDatas(List<Account> accounts) {
		this.datas = accounts;
	}

}
