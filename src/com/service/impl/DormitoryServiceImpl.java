package com.service.impl;

import java.util.List;

import com.dao.AdminmessageDAO;
import com.dao.DormitoryDAO;
import com.model.Adminmessage;
import com.model.DormLogin;
import com.model.Dormitory;

public class DormitoryServiceImpl implements com.service.DormitoryService {
	private DormitoryDAO dormitorydao;
	private AdminmessageDAO  adminmessagedao;
	
	public AdminmessageDAO getAdminmessagedao() {
		return adminmessagedao;
	}

	public void setAdminmessagedao(AdminmessageDAO adminmessagedao) {
		this.adminmessagedao = adminmessagedao;
	}

	public DormitoryDAO getDormitorydao() {
		return dormitorydao;
	}

	public void setDormitorydao(DormitoryDAO dormitorydao) {
		this.dormitorydao = dormitorydao;
	}

	public void attachClean(Dormitory instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Dormitory instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Dormitory persistentInstance) {
		// TODO Auto-generated method stub

	}

	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByAdId(Object adId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByBid(Object bid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByExample(Dormitory instance) {
		// TODO Auto-generated method stub
		return null;
	}

	public Dormitory findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public Dormitory merge(Dormitory detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(Dormitory transientInstance) {
		return dormitorydao.save(transientInstance);

	}

	public boolean update(DormLogin dormlogin, Adminmessage adminmessag) {
		boolean flag=false;
		flag=adminmessagedao.update(adminmessag);
		if(flag){
			return dormitorydao.update(dormlogin);
		}else{			
			return false;
		}
	}

}
