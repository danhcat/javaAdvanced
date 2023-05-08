package com.vti.service;

import java.util.List;

import com.vti.entity.Department;
import com.vti.form.DepartmentForm;

public interface IDepartmentService {

	List<Department> getAllDepartment();

	Department getDepartmentbyID(short id);

	Department createDepartment(DepartmentForm formforcreating);

	void deleteAccount(short id);

}
