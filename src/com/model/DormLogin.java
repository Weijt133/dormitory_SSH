package com.model;

/**
 * DormLogin entity. @author MyEclipse Persistence Tools
 */

public class DormLogin implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer did;
	private Integer adId;
	private String dpassword;

	// Constructors

	/** default constructor */
	public DormLogin() {
	}

	/** full constructor */
	public DormLogin(Integer adId, String dpassword) {
		this.adId = adId;
		this.dpassword = dpassword;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getAdId() {
		return this.adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getDpassword() {
		return this.dpassword;
	}

	public void setDpassword(String dpassword) {
		this.dpassword = dpassword;
	}
	public String toString(){
		return "dormadmin";
	}

}