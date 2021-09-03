package com.model;

/**
 * Dormitory entity. @author MyEclipse Persistence Tools
 */

public class Dormitory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer bid;
	private Integer adId;

	// Constructors

	/** default constructor */
	public Dormitory() {
	}

	/** full constructor */
	public Dormitory(Integer bid, Integer adId) {
		this.bid = bid;
		this.adId = adId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getAdId() {
		return this.adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

}