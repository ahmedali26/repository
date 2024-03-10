package com.asmatech.hr.jdbc.springdata.entity;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")
public class Employee {

	@Id
	@Column("id")
	private Integer id;
	
	@Column("name_ar")
	private String nameAr;
	
	@Column("name_en")
	private String nameEn;
	
	@Column("hire_date")
	private Date hierDate;
	
	@Column("salary")
	private Double salary;

	public Employee() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public Employee(Integer id, String nameAr, String nameEn, Date hierDate, Double salary) {
		this.id = id;
		this.nameAr = nameAr;
		this.nameEn = nameEn;
		this.hierDate = hierDate;
		this.salary = salary;
	}

	public Employee(String nameAr, String nameEn, Date hierDate, Double salary) {
		this.nameAr = nameAr;
		this.nameEn = nameEn;
		this.hierDate = hierDate;
		this.salary = salary;
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

	public Date getHierDate() {
		return hierDate;
	}

	public void setHierDate(Date hierDate) {
		this.hierDate = hierDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nameAr=" + nameAr + ", nameEn=" + nameEn + ", hierDate=" + hierDate
				+ ", salary=" + salary + "]";
	}
	
	
	
	

}
