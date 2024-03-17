package com.asmatech.hr.springdata.jpa.service.department;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asmatech.hr.springdata.jpa.entity.Department;
import com.asmatech.hr.springdata.jpa.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public Integer getCount() {
		return (int) departmentRepository.count();
	}

	@Override
	public Optional<Department> findById(Integer id) {
		return departmentRepository.findById(id);
	}

	@Override
	public List<Department> findAll() {
		return (List<Department>) departmentRepository.findAll();
	}

	@Override
	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Integer delete(Integer id) {
		try {
			departmentRepository.deleteById(id);
			return 1;
		}catch (Exception e) {
			e.getMessage();
			return 0;
		}		 
	}

}
