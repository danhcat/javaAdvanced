package com.vti.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Account;

public class AccountSpecification implements Specification<Account> {

	private String field;
	private String operater;
	private Object value; // where username like '%aa%'
	// field operator value

	public AccountSpecification(String field, String operater, Object value) {
		super();
		this.field = field;
		this.operater = operater;
		this.value = value;
	}

	public AccountSpecification() {
		super();
	}
	// sql
	// hql
	// criteria

	@Override
	public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (operater == "LIKE" && value != null) {
			if (field == "department") {
				return criteriaBuilder.like(root.get(field).get("name"), "%" + value.toString() + "%");// departmentName
																										// like %value%
			} else {
				return criteriaBuilder.like(root.get(field), "%" + value.toString() + "%");
			}
		} else {
			return null;
		}
	}

}
