package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.form.DepartmentForm;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {
	@Autowired
	private IDepartmentRepository departmentRepository;

	@Override
	public List<Department> getAllDepartment() {
		List<Department> listDepartments = departmentRepository.findAll();
		return listDepartments;
	}

	@Override
	public Department getDepartmentbyID(short id) {
		Department department = departmentRepository.findById(id).get();
		return department;

	}

	@Override
	public Department createDepartment(DepartmentForm formforcreating) {
		Department department = new Department();
		department.setName(formforcreating.getName());
		return departmentRepository.save(department);

	}

	@Override
	public void deleteAccount(short id) {
		departmentRepository.deleteById(id);

	}

}
