package com.service.impl;

import java.util.List;

import com.dao.AdminmessageDAO;
import com.model.Adminmessage;
import com.service.AdminmessageService;

public class AdminmessageServiceImpl implements AdminmessageService {
	private AdminmessageDAO adminmessagedao;
	public AdminmessageDAO getAdminmessagedao() {
		return adminmessagedao;
	}

	public void setAdminmessagedao(AdminmessageDAO adminmessagedao) {
		System.out.println("setAdminmessagedao");
		this.adminmessagedao = adminmessagedao;
	}

	public void attachClean(Adminmessage instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Adminmessage instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Adminmessage persistentInstance) {
		// TODO Auto-generated method stub

	}

	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Adminmessage findByBid(Object bid) {
		return adminmessagedao.findByBid(bid);
	}

	public List findByCall(Object call) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByExample(Adminmessage instance) {
		// TODO Auto-generated method stub
		return null;
	}

	public Adminmessage findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByName(Object name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Adminmessage findByProperty(String propertyName, Integer value) {
		
		return adminmessagedao.findByProperty(propertyName, value);
	}

	public List findByUserlevel(Object userlevel) {
		// TODO Auto-generated method stub
		return null;
	}

	public Adminmessage merge(Adminmessage detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(Adminmessage transientInstance) {
		System.out.println(" AdminmessageServiceImp.save(Adminmessage transientInstance) id= "+transientInstance.getBid());
		if(adminmessagedao.save(transientInstance)){
			return true;
		}else{
			return false;
		}
	}

	public Adminmessage findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
