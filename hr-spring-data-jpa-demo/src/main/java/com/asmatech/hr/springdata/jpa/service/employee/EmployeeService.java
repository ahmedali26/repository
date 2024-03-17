package com.asmatech.hr.springdata.jpa.service.employee;

import java.sql.Date;
import java.util.List;

import com.asmatech.hr.springdata.jpa.entity.Employee;
import com.asmatech.hr.springdata.jpa.projection.HRStatisticsProjection;
import com.asmatech.hr.springdata.jpa.service.HrService;


public interface EmployeeService extends HrService<Employee>{

	public List<Employee> findByDepartmentId(Integer deptId);
	
	public List<Employee> findByEmpNameAndDeptName(String empName, String deptName);
	
	public List<Employee> getByHireDate(Date hireDate);
	
	public List<Employee> filterNative(String empName);
	
	public HRStatisticsProjection getStatistics();
	
	
	
}
