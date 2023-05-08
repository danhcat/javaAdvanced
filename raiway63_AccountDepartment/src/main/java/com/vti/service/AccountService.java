package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.Specification.AccountSpecification;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.form.AccountFormforUpdate;
import com.vti.form.AccountFormforcreate;
import com.vti.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public Page<Account> getlistAccount(Pageable pageable, String search) {
// tạo ra 1 điều kiện where để tìm kiếm Specification

		Specification<Account> where = null;
		// xây dựng điều kiện where theo mong muốn
		if (!StringUtils.isEmpty(search)) {
			AccountSpecification fullNameSpecification = new AccountSpecification("fullName", "LIKE", search);
			AccountSpecification emailSpecification = new AccountSpecification("email", "LIKE", search);
			AccountSpecification departmentSpecification = new AccountSpecification("department", "LIKE", search);
			where = Specification.where(fullNameSpecification).or(emailSpecification).or(departmentSpecification);

		}
		Page<Account> pageAccounts = accountRepository.findAll(where, pageable);
		return pageAccounts;

	}

	@Override
	public Account getAccountbyID(short id) {
		Account account = accountRepository.findById(id).get();

		return account;
	}

	@Override
	public Account createAccount(AccountFormforcreate accountcrating) {

		Account account = new Account();
		account.setEmail(accountcrating.getEmail());
		account.setUseName(accountcrating.getUsename());
		account.setFullName(accountcrating.getFullname());
		account.setDepartment(new Department(accountcrating.getDepartmentId()));
		Position position = new Position(accountcrating.getPositionId());
		account.setPosition(position);

		return accountRepository.save(account);
	}

	@Override
	public Account updateAccount(Short id, AccountFormforUpdate acccountUpdate) {
		Account account = getAccountbyID(id);
		account.setEmail(acccountUpdate.getEmail());
		account.setUseName(acccountUpdate.getUsename());
		account.setFullName(acccountUpdate.getFullname());
		Department department = new Department();
		department.setId(acccountUpdate.getDepartmentId());
		account.setDepartment(department);
		Position position = new Position();
		position.setId(acccountUpdate.getPositionId());
		account.setPosition(position);

		return accountRepository.save(account);

	}

	@Override
	public void deleteAccount(short id) {
		accountRepository.deleteById(id);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// từ thông tin username ==> tạo ra được userDetails
		// b1 tư usename ==> account tương ứng với username
		Account account = accountRepository.finđByUseName(username);
		// từ thông tin accounr ==> Userdetails
		UserDetails userDetails = new User(account.getUseName(), account.getPassWord(),
				AuthorityUtils.createAuthorityList("user"));
		return userDetails;
	}

	@Override
	public Account getAccountByUserName(String username) {

		return accountRepository.finđByUseName(username);
	}

}
