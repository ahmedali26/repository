package com.asmatech.hr.springdata.jpa.service.employee;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asmatech.hr.springdata.jpa.entity.Employee;
import com.asmatech.hr.springdata.jpa.projection.HRStatisticsProjection;
import com.asmatech.hr.springdata.jpa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Integer getCount() {
		return (int) employeeRepository.count();
	}

	@Override
	public Optional<Employee> findById(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Integer delete(Integer id) {
		try {
			employeeRepository.deleteById(id);
			return 1;
		}catch (Exception e) {
			e.getMessage();
			return 0;
		}		 
	}

	@Override
	public List<Employee> findByDepartmentId(Integer deptId) {
		return employeeRepository.findByDepartmentId(deptId);
	}

	@Override
	public List<Employee> findByEmpNameAndDeptName(String empName, String deptName) {
		return employeeRepository.findByNameArContainingAndDepartmentNameArContaining(empName, deptName);
	}

	@Override
	public List<Employee> getByHireDate(Date hireDate) {		
		return employeeRepository.findByHireDate(hireDate);
	}

	@Override
	public HRStatisticsProjection getStatistics() {
		return employeeRepository.getStatistics();
	}

	@Override
	public List<Employee> filterNative(String empName) {
		return employeeRepository.filterNative(empName);
	}

}
