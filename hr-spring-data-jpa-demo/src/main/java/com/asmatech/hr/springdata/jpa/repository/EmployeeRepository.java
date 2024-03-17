package com.asmatech.hr.springdata.jpa.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asmatech.hr.springdata.jpa.entity.Employee;
import com.asmatech.hr.springdata.jpa.projection.HRStatisticsProjection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByDepartmentId(Integer deptId);
	
	public List<Employee> findByNameArContainingAndDepartmentNameArContaining(String empName, String deptName);
	
	List<Employee> findByHireDate(Date hireDate); 
	
	@Query(value = "select * from hr.employee where name_ar like '%' :empName '%'  or name_en like '%' :empName '%'", 
			nativeQuery = true)
	List<Employee> filterNative(@Param("empName") String empName);
	
	
	@Query(value = "select "
					+ "	(select count(*) from hr.employee) empCount, "
					+ " (select count(*) from hr.departments) deptCount, "
					+ " (select count(*) from hr.users) userCount" ,
					nativeQuery = true)
	HRStatisticsProjection getStatistics();
	
	

}
