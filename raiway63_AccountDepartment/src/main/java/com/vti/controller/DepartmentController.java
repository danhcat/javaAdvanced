package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDto;
import com.vti.entity.Department;
import com.vti.form.DepartmentForm;
import com.vti.form.Departmentforupdate;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/department") // http://localhost:8080/api/v1/department
@CrossOrigin("*")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;

	// http://localhost:8080/api/v1/department/getAllDepartment
	@GetMapping("/getAllDepartment")
	public ResponseEntity<?> getAllDepartment() {
		List<Department> listDepartments = departmentService.getAllDepartment();
//	for (Department department : listDepartments) {
//		System.out.println(department.toString());
//	}

		// trả về API cho Frontend
		// chuyển đổi kiểu dữ liệu
		// khi chỉ cần lấy 1 số trường tỏng bảng thì sử dụng API này, chỉ lấy ra name và
		// dấu ID
		List<DepartmentDto> listdeDepartmentDtos = new ArrayList<DepartmentDto>();
		for (Department department : listDepartments) {
			DepartmentDto departmentDto = new DepartmentDto();
			departmentDto.setId(department.getId());
			departmentDto.setName(department.getName());
			listdeDepartmentDtos.add(departmentDto);
		}

		return new ResponseEntity<>(listdeDepartmentDtos, HttpStatus.OK);
	}

	// phương thức lấy phong ban theo id
	// localhost:8080/api/v1/department/getDepartmentById/idDepartment
	@GetMapping(value = "/getDepartmentById/{idDepartment}")
	public ResponseEntity<?> getDepartmentbyID(@PathVariable(name = "idDepartment") short id) {
		Department department = departmentService.getDepartmentbyID(id);

		// chuyển đổi kiểu dữ liệu

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setName(department.getName());

		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}

	// phường thức tạo mới phòng ban
	@PostMapping("/createDepartment")
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentForm formforcreating) {
		System.out.println(formforcreating.getName());
		Department department = departmentService.createDepartment(formforcreating);

		// chuyển đổi kiểu dữ liệu

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setName(department.getName());

		return new ResponseEntity<>("create susses", HttpStatus.OK);
	}

	// phường thức update phòng ban
	@PutMapping(value = "/{idDepartment}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "idDepartment") short id,
			@RequestBody Departmentforupdate formforupdate) {

//		Department department =  departmentService.updateDepartment(formforupdate);
		System.out.println(id);
		System.out.println(formforupdate.getName());
		// chuyển đổi kiểu dữ liệu

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setName(departmentDto.getName());

		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	// phương thức delete phòng ban
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
		departmentService.deleteAccount(id);
		return new ResponseEntity<>("delete susses", HttpStatus.OK);
	}

}
