package com.model;

import java.util.Date;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer stuId;
	private Integer id;
	private String name;
	private String password;

	private String sex;
	private String department;
	private String major;
	private Integer bid;
	private Date time;
	private String cellcall;

	// Constructors


	/** default constructor */
	public Student() {
	}

	public String getCellcall() {
		return cellcall;
	}

	public void setCellcall(String cellcall) {
		this.cellcall = cellcall;
	}

	/** full constructor */
	public Student(Integer id, String name,String password, String sex, String department,
			String major, Integer bid, Date time, String call) {
		this.id = id;
		this.name = name;
		this.password=password;
		this.sex = sex;
		this.department = department;
		this.major = major;
		this.bid=bid;
		this.time = time;
		this.cellcall = call;
	}
	public Student(Integer id, String name,String password) {
		this.id = id;
		this.name = name;
		this.password=password;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid=bid;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}