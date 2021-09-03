package com.action;

import com.model.DormLogin;
import com.model.Student;
import com.model.SuperLogin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.AdminmessageService;
import com.service.SuperLoginService;

public class AdimanAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminmessageService adminmessageservice;
	private SuperLoginService superloginservice;
	private int account;
	private String password;
	private int logintype;
	private SuperLogin superman;
	private DormLogin dormman;
	private Student student;
	
	public SuperLoginService getSuperloginservice() {
		return superloginservice;
	}
	public void setSuperloginservice(SuperLoginService superloginservice) {
		this.superloginservice = superloginservice;
	}
	public AdminmessageService getAdminmessageservice() {
		return adminmessageservice;
	}
	public void setAdminmessageservice(AdminmessageService adminmessageservice) {
		System.out.println("setAdminmessageservice");
		this.adminmessageservice = adminmessageservice;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLogintype() {
		return logintype;
	}
	public void setLogintype(int logintype) {
		this.logintype = logintype;
	}
	//==========================================
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String login(){
		System.out.println("------->login()account="+account+"\tpassword="+password+"\tlogintype="+logintype);
		if(logintype==1){
			if(account==0||password==null){
				msg="请输入用户名和密码！";
				return INPUT;
			}
			superman=new SuperLogin(account, password);
			superman=superloginservice.findByExample(superman);
			if(superman==null){
				msg="用户账号或密码有误！";
				return INPUT;
			}
			ActionContext.getContext().getSession().put("loginuser", superman);
			return SUCCESS;
		}else if(logintype==2){
			if(account==0||password==null){
				msg="请输入用户名和密码！";
				return INPUT;
			}
			dormman=new DormLogin(account, password);
			/*boolean flag0=false;
			flag0=superloginservice.findDormLoginByIdAndPassword(dormman);
			if(flag0==false){
				msg="用户账号或密码有误！";
				return INPUT;
			}*/
			ActionContext.getContext().getSession().put("loginuser", dormman);
			ActionContext.getContext().getSession().put("dorman", dormman);
			return SUCCESS;
		}else if(logintype==3)
		{
			if(account==0||password==null){
				msg="请输入用户名和密码！";
				return INPUT;
			}
			student=new Student(account, null, password);
			boolean flag=false;
			flag=superloginservice.findStudentByIdAndPassword(student);
			if(flag==false){
				msg="用户账号或密码有误！";
				return INPUT;
			}
			ActionContext.getContext().getSession().put("loginusername", student.getId());
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	public String exit(){
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
}
