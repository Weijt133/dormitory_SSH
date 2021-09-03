package com.service.impl;

import java.util.List;

import com.dao.AdminmessageDAO;
import com.dao.DormLoginDAO;
import com.dao.DormitoryDAO;
import com.model.Adminmessage;
import com.model.DormLogin;
import com.model.Dormitory;

public class DormLoginServiceImpl implements com.service.DormLoginService {
	private DormLoginDAO dormlogindao;
	private DormLogin dormlogin=new DormLogin();
	private DormitoryDAO dormitorydao;
	Dormitory	dormitorys=new Dormitory();
	public DormitoryDAO getDormitorydao() {
		return dormitorydao;
	}

	public void setDormitorydao(DormitoryDAO dormitorydao) {
		this.dormitorydao = dormitorydao;
	}

	private AdminmessageDAO adminmessagedao;
	private Dormitory dormitory;
	public AdminmessageDAO getAdminmessagedao() {
		return adminmessagedao;
	}

	public void setAdminmessagedao(AdminmessageDAO adminmessagedao) {
		this.adminmessagedao = adminmessagedao;
	}

	public DormLoginDAO getDormlogindao() {
		return dormlogindao;
	}

	public void setDormlogindao(DormLoginDAO dormlogindao) {
		this.dormlogindao = dormlogindao;
	}

	public void attachClean(DormLogin instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(DormLogin instance) {
		// TODO Auto-generated method stub

	}

	

	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public DormLogin findByAdId(Object adId) {
		
		return dormlogindao.findByAdId(adId);
	}

	public List findByDpassword(Object dpassword) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByExample(DormLogin instance) {
		// TODO Auto-generated method stub
		return null;
	}

	public DormLogin findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public DormLogin findByProperty(String propertyName, Object value) {
		dormlogin=dormlogindao.findByProperty(propertyName, value);
		if(dormlogin!=null){
			return dormlogin;
		}else{
			return null;
		}
	}

	public DormLogin merge(DormLogin detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(DormLogin transientInstance) {
		if(dormlogindao.save(transientInstance)){
			return true;			
		}else{
			return false;
		}

	}

	public boolean update(DormLogin dormlogin, Adminmessage adminmessag) {
		if(adminmessagedao.update(adminmessag)){
			dormitory=new Dormitory();
			dormitorys=new Dormitory();
			dormitory.setBid(adminmessag.getBid());
			dormitory.setAdId(adminmessag.getAdId());
			System.out.println("()()()()(=="+adminmessag.getAdId());
			dormitorys= dormitorydao.findByAdId(adminmessag.getAdId());
			dormitory.setId(dormitorys.getId());
			if(dormitorydao.update(dormitory)){
				return	dormlogindao.update(dormlogin);
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public boolean update(DormLogin dormlogin) {
		return dormlogindao.update(dormlogin);
	}

	public boolean delete(DormLogin dormlogin, Adminmessage adminmessag) {
		
		if(adminmessagedao.delete(adminmessag)){
			dormitory=new Dormitory();
			dormitorys=new Dormitory();
			dormitory.setBid(adminmessag.getBid());
			dormitory.setAdId(adminmessag.getAdId());
			dormitorys= dormitorydao.findByAdId(adminmessag.getAdId());
			dormitory.setId(dormitorys.getId());
			if(dormitorydao.delete(dormitory)){
				return	dormlogindao.delete(dormlogin);
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public boolean delete(DormLogin persistentInstance) {
		
		return dormlogindao.delete(dormlogin);
	}

}
