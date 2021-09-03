package com.model;

/**
 * SuperLogin entity. @author MyEclipse Persistence Tools
 */

public class SuperLogin implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Integer adId;
	private String spassword;

	// Constructors

	/** default constructor */
	public SuperLogin() {
	}

	/** full constructor */
	public SuperLogin(Integer adId, String spassword) {
		this.adId = adId;
		this.spassword = spassword;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getAdId() {
		return this.adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getSpassword() {
		return this.spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String toString(){
		return "superman";
	}

}