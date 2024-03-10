package com.asmatech.hr.jdbc.springdata.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.asmatech.hr.jdbc.springdata.entity.Employee;

public interface EmployeeSrvice{

	public Integer getCount();
	
	public Optional<Employee> findById(Integer id);
	
	public List<Employee> findAll();
	
	public Employee save(Employee employee);
	
	public Integer delete(Integer id);
	
	public List<Employee> findBySalaryLessThan(Double salary);
	
	public List<Employee> findByHireDateAfter(Date hireDate);
	
	public List<Employee> findEmployee(Date hireDate, Double salary);
	
	public int updateSalaryById(Double salary, Integer id);
	
}
