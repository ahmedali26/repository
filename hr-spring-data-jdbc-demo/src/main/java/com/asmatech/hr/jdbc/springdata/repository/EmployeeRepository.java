package com.asmatech.hr.jdbc.springdata.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asmatech.hr.jdbc.springdata.entity.Employee;

@Repository
@EnableJdbcRepositories
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	/**
	 * findBySalaryLessThanEqual, findBySalaryGreaterThan, findBySalaryGreaterThanEqual
	 * 
	 * @param salary
	 * @return
	 */
	public List<Employee> findBySalaryLessThan(Double salary);

	
	/**
	 * findByHireDateBefore
	 * 
	 * @param hireDate
	 * @return
	 */
	public List<Employee> findByhierDateAfter(Date hierDate);
	
	
	@Query(value = "SELECT id, name_ar, name_en, hire_date, salary FROM HR.EMPLOYEE WHERE hire_date >= :hireDate and Salary >= :salary")
	public List<Employee> findEmployee(@Param("hireDate") Date hireDate, @Param("salary") Double salary);
	
	@Modifying
	@Query(value = "UPDATE HR.EMPLOYEE SET salary=:salary WHERE id=:id")
	public int updateSalaryById(@Param("salary") Double salary, @Param("id") Integer id);
}
