package com.model;

/**
 * Building entity. @author MyEclipse Persistence Tools
 */

public class Building implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer bid;
	private String sex;
	private Integer lid;
	
	// Constructors

	/** default constructor */
	public Building() {
	}

	/** full constructor */
	public Building(String sex, Integer lid) {
		this.sex = sex;
		this.lid = lid;
	}

	// Property accessors

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

}