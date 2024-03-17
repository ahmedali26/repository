package com.asmatech.hr.springdata.jpa.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FetchType;
import jakarta.persistence.FieldResult;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
@NamedQuery(name = "Employee.findByHireDate", 
			query = "select emp from Employee emp where emp.hireDate <= :hireDate")
@SqlResultSetMapping(name = "empMapping",
					 entities = @EntityResult(entityClass = Employee.class,
				     fields = {
				    		 @FieldResult(name = "id" , column = "id"),
				    		 @FieldResult(name = "nameAr", column = "name_ar"),
				    		 @FieldResult(name="nameEn", column = "name_ar"),
				    		 @FieldResult(name="hireDate", column = "hire_date"),
				    		 @FieldResult(name="salary", column = "salary")
				     }))

@NamedNativeQuery(name = "findByDepartmentId",
				  query = "select id, name_ar, name_en, hire_date, salary from hr.employee where dept_Id=:deptId", 
				  resultSetMapping = "empMapping")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name_ar")
	private String nameAr;
	
	@Column(name = "name_en")
	private String nameEn;
	
	@Column(name = "hire_date")
	private Date hireDate;
	
	@Column(name = "salary")
	private Double salary;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "dept_Id")
	private Department department;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private User user;

	public Employee() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameAr() {
		return nameAr;
	}

	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nameAr=" + nameAr + ", nameEn=" + nameEn + ", hireDate=" + hireDate
				+ ", salary=" + salary + ", department=" + department + "]";
	}
	
	

}
