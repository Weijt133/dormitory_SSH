package com.action;
import java.util.ArrayList;
import java.util.List;

import com.model.Adminmessage;
import com.model.DormLogin;
import com.model.Dormitory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.AdminmessageService;
import com.service.DormLoginService;
import com.service.DormitoryService;
public class DormitoryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DormLoginService dormloginservice;
	private AdminmessageService adminmessageservice;
	private Adminmessage adminmessag;
	private DormitoryService dormitoryservice;
	public DormitoryService getDormitoryservice() {
		return dormitoryservice;
	}

	public void setDormitoryservice(DormitoryService dormitoryservice) {
		this.dormitoryservice = dormitoryservice;
	}

	public Adminmessage getAdminmessag() {
		return adminmessag;
	}

	public void setAdminmessag(Adminmessage adminmessag) {
		this.adminmessag = adminmessag;
	}

	public AdminmessageService getAdminmessageservice() {
		return adminmessageservice;
	}

	public void setAdminmessageservice(AdminmessageService adminmessageservice) {
		this.adminmessageservice = adminmessageservice;
	}

	private DormLogin dormlogin;

	public DormLogin getDormlogin() {
		return dormlogin;
	}

	public void setDormlogin(DormLogin dormlogin) {
		this.dormlogin = dormlogin;
	}

	public DormLoginService getDormloginservice() {
		return dormloginservice;
	}

	public void setDormloginservice(DormLoginService dormloginservice) {
		this.dormloginservice = dormloginservice;
	}

	private Integer did;
	private Integer adId;
	private String dpassword;
	private Integer bid;
	private String name;
	private Integer userlevel;
	private String call;

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
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

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getDpassword() {
		return dpassword;
	}

	public void setDpassword(String dpassword) {
		this.dpassword = dpassword;
	}

	private String emesg;

	public String getEmesg() {
		return emesg;
	}

	public void setEmesg(String emesg) {
		this.emesg = emesg;
	}

	public String enroll() {
		DormLogin dorm = new DormLogin();
		
		System.out.println("-------------->enroll()adId=" + adId
				+ "\tdpassword=" + dpassword + "\tbid=" + bid + "\tname="
				+ name + "\tuserlevel=" + userlevel + "\tcall=" + call);
		dorm.setAdId(adId);
		dorm.setDpassword(dpassword);
		Adminmessage adadminmessage = new Adminmessage();
		adadminmessage.setAdId(adId);
		adadminmessage.setBid(bid);
		adadminmessage.setName(name);
		adadminmessage.setUserlevel(userlevel);
		adadminmessage.setCall(call);
		Dormitory dormitory=new Dormitory();
		dormitory.setAdId(adId);
		dormitory.setBid(bid);
		if (dormloginservice.findByAdId(adId) != null) {
			emesg = "该用户已经注册！";
			return INPUT;
		} else {
			if (dormloginservice.save(dorm)) {
				if (adminmessageservice.save(adadminmessage)) {
					if(dormitoryservice.save(dormitory)){
						ActionContext.getContext().getSession().put("adId", adId);
						ActionContext.getContext().getSession().put("password",
							dpassword);
						System.out.println("宿管员功能完成！");
						emesg="";
						return SUCCESS;
					}else{
						return INPUT;
					}
				} else {
					return INPUT;
				}
			} else {
				return INPUT;
			}
		}
	}

	// =====================================
	private int type=0;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String query() {
		System.out.println("------------>query() adId=" + adId + "\ttype="
				+ type);
		dormlogin = dormloginservice.findByAdId(adId);
		if (dormlogin != null) {
			adminmessag = adminmessageservice.findByProperty("adId", adId);
			if (adminmessag != null) {
				ActionContext.getContext().getSession().put("dorm", dormlogin);
				ActionContext.getContext().getSession().put("adminmessage",
						adminmessag);
				if (type == 1) {
					type=0;
					return "update";
				}else if(type==2){
					type=0;
					return "delete";
				}else{
					emesg="";
					return SUCCESS;
				}
			} else {
				emesg = "您要查找的宿管员不存在！";
				return INPUT;
			}
		} else {
			emesg = "您要查找的宿管员不存在！";
			return INPUT;
		}
	}

	public String modify() {
		System.out.println("----------------->modify()所需参数 \t adId="
				+ dormlogin.getAdId() + "\tdpassword="
				+ dormlogin.getDpassword() + "\tbid=" + adminmessag.getBid()
				+ "\tname=" + adminmessag.getName() + "\tuserlevel="
				+ adminmessag.getUserlevel() + "\tcall="
				+ adminmessag.getCall());
		boolean flag=false;
		dormlogin.setDpassword(dpassword);
		flag=dormloginservice.update(dormlogin,adminmessag);
		if(flag){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String delete(){
		System.out.println("----------------->modify()所需参数 \t adId="
				+ dormlogin.getAdId() + "\tdpassword="
				+ dormlogin.getDpassword() + "\tbid=" + adminmessag.getBid()
				+ "\tname=" + adminmessag.getName() + "\tuserlevel="
				+ adminmessag.getUserlevel() + "\tcall="
				+ adminmessag.getCall());
		boolean flag=false;
		flag=dormloginservice.delete(dormlogin,adminmessag);
		if(flag){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	//================================================
	List<Adminmessage> admin=new ArrayList<Adminmessage>();
	public String querydormitory(){
		System.out.println("----------------->querydormitory() bid="+bid);
		if(bid!=0&&bid!=null){
			adminmessag=adminmessageservice.findByBid(bid);
			admin.add(adminmessag);
			ActionContext.getContext().getSession().put("dormitory", admin);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
