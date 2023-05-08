package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Account;
import com.vti.form.AccountFormforUpdate;
import com.vti.form.AccountFormforcreate;

public interface IAccountService extends UserDetailsService {

	public Page<Account> getlistAccount(Pageable pageable, String search);

	public Account getAccountbyID(short id);

	public Account createAccount(AccountFormforcreate accountcrating);

	public Account updateAccount(Short id, AccountFormforUpdate acccountUpdate);

	public void deleteAccount(short id);

	Account getAccountByUserName(String username);

}
