package com.model;

/**
 * Adminmessage entity. @author MyEclipse Persistence Tools
 */

public class Adminmessage implements java.io.Serializable {

	// Fields

	private Integer adId;
	private Integer bid;
	private String name;
	private Integer userlevel;
	private String call;

	// Constructors

	/** default constructor */
	public Adminmessage() {
	}

	/** full constructor */
	public Adminmessage(Integer bid, String name, Integer userlevel, String call) {
		this.bid = bid;
		this.name = name;
		this.userlevel = userlevel;
		this.call = call;
	}

	// Property accessors

	public Integer getAdId() {
		return this.adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserlevel() {
		return this.userlevel;
	}

	public void setUserlevel(Integer userlevel) {
		this.userlevel = userlevel;
	}

	public String getCall() {
		return this.call;
	}

	public void setCall(String call) {
		this.call = call;
	}

}