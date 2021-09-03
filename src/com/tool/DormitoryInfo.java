package com.tool;

public class DormitoryInfo {
	private Integer bid;
	private Integer adId;
	private String name;
	private Integer userlevel;
	private String call;
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getAdId() {
		return adId;
	}
	public void setAdId(Integer adId) {
		this.adId = adId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(Integer userlevel) {
		this.userlevel = userlevel;
	}
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public DormitoryInfo(Integer bid, Integer adId, String name,
			Integer userlevel, String call) {
		super();
		this.bid = bid;
		this.adId = adId;
		this.name = name;
		this.userlevel = userlevel;
		this.call = call;
	}
	public DormitoryInfo() {
		super();
	}
	
}
