package com.asmatech.hr.jdbc.springdata.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asmatech.hr.jdbc.springdata.entity.Employee;
import com.asmatech.hr.jdbc.springdata.repository.EmployeeRepository;

@Service
public class EmployeeSrviceImpl implements EmployeeSrvice{

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
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		return employees; 
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
			return 0;
		}
	}

	@Override
	public List<Employee> findBySalaryLessThan(Double salary){
		return employeeRepository.findBySalaryLessThan(salary);
	}

	@Override
	public List<Employee> findByHireDateAfter(Date hireDate) {
		return employeeRepository.findByhierDateAfter(hireDate);
	}

	@Override
	public List<Employee> findEmployee(Date hireDate, Double salary) {
		return employeeRepository.findEmployee(hireDate, salary);
	}

	@Override
	public int updateSalaryById(Double salary, Integer id) {		
		return employeeRepository.updateSalaryById(salary, id);
	}
}
