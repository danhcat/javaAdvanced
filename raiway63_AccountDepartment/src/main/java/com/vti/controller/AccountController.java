package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountFormforUpdate;
import com.vti.form.AccountFormforcreate;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/account")
@CrossOrigin("*")

public class AccountController {
	@Autowired
	private IAccountService accountService;

// lấy ra tất cả account
	@GetMapping("/getAllAccount")
	public ResponseEntity<?> getlistAccount(Pageable pageable, @RequestParam(required = false) String search) {

		Page<Account> accountPage = accountService.getlistAccount(pageable, search);

		Page<AccountDTO> pageDto = accountPage.map(new java.util.function.Function<Account, AccountDTO>() {

			@Override
			public AccountDTO apply(Account account) {
				AccountDTO accountDTO = new AccountDTO();
				accountDTO.setId(account.getId());
				accountDTO.setEmail(account.getEmail());
				accountDTO.setUseName(account.getUseName());
				accountDTO.setFullName(account.getFullName());
				accountDTO.setDepartment(account.getDepartment().getName());
				accountDTO.setPosition(account.getPositionID().getName().toString());
				accountDTO.setCrateDate(account.getCrateDate());

				return accountDTO;
			}

		});

		return new ResponseEntity<>(pageDto, HttpStatus.OK);
//		Page<AccountDTO> lisAccountDTOs = new ArrayList<AccountDTO>();
//		for (Account account : accounts) {
//			AccountDTO accountDTO = new AccountDTO();
//			accountDTO.setId(account.getId());
//			accountDTO.setEmail(account.getEmail());
//			accountDTO.setUseName(account.getUseName());
//			accountDTO.setFullName(account.getFullName());
//			accountDTO.setDepartment(account.getDepartment().getName());
//			accountDTO.setPosition(account.getPositionID().getName().toString());
//			accountDTO.setCrateDate(account.getCrateDate());
//			lisAccountDTOs.add(accountDTO);
//		}
//
//		return new ResponseEntity<>(lisAccountDTOs, HttpStatus.OK);

	}

// lấy ra account theo id
//	http://localhost:8080/api/v1/account/getaccountbyID/5
	@GetMapping(value = "/getaccountbyID/{idaccount}")
	public ResponseEntity<?> getAccountbyID(@PathVariable(name = "idaccount") short id) {
		Account account = accountService.getAccountbyID(id);

		return new ResponseEntity<>(account, HttpStatus.OK);
	}

// tạo mới account

//	http://localhost:8080/api/v1/account/createAccount
	@PostMapping("/createAccount")
	public Account createAccount(@RequestBody AccountFormforcreate accountcrating) {
		Account account = accountService.createAccount(accountcrating);
		return account;

	}

	// phương thức update phòng ban
	// 1. truyền vào đối tượng muốn update (id) -Controller
	// 2. Lấy đối tượng theo id dưới DB lên - Service
	// 3. Set lại giá trị cho đối tượng vừa get lên, ví dụ old name A, new name B ->
	// old name B
	// 4. Lưu lại vào db - Repository

//	http://localhost:8080/api/v1/account/updateAccountById/5
	@PutMapping("/updateAccountById/{id}")
	public void updateAccount(@PathVariable(name = "id") Short id, @RequestBody AccountFormforUpdate acccountUpdate) {

		Account account = accountService.updateAccount(id, acccountUpdate);

	}

	// phương thức delete account
	@DeleteMapping(value = "/deleteAccount/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
		accountService.deleteAccount(id);
		return new ResponseEntity<>("delete Susses", HttpStatus.OK);
	}
}