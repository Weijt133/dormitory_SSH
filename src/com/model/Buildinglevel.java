package com.model;

/**
 * Buildinglevel entity. @author MyEclipse Persistence Tools
 */

public class Buildinglevel implements java.io.Serializable {

	private Integer lid;
	private Integer number;
	private Integer tip;

	public Buildinglevel() {
	}

	/** full constructor */
	public Buildinglevel(Integer number, Integer tip) {
		this.number = number;
		this.tip = tip;
	}

	// Property accessors

	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getTip() {
		return this.tip;
	}

	public void setTip(Integer tip) {
		this.tip = tip;
	}

}