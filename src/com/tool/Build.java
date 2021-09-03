package com.tool;

import java.io.Serializable;

public class Build implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer bid;
	private String sex;
	private Integer lid;
	private Integer number;
	private Integer tip;
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getTip() {
		return tip;
	}
	public void setTip(Integer tip) {
		this.tip = tip;
	}
	public Build(Integer bid, String sex, Integer lid, Integer number,
			Integer tip) {
		super();
		this.bid = bid;
		this.sex = sex;
		this.lid = lid;
		this.number = number;
		this.tip = tip;
	}
	public Build() {
		super();
	}
}
