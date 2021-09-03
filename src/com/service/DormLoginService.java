package com.service;

import java.util.List;

import com.model.Adminmessage;
import com.model.DormLogin;

public interface DormLoginService {

	// property constants
	public static final String AD_ID = "adId";
	public static final String DPASSWORD = "dpassword";

	public abstract boolean save(DormLogin transientInstance);

	public abstract boolean delete(DormLogin persistentInstance);

	public abstract DormLogin findById(java.lang.Integer id);

	public abstract List findByExample(DormLogin instance);

	public abstract DormLogin findByProperty(String propertyName, Object value);

	public abstract DormLogin findByAdId(Object adId);

	public abstract List findByDpassword(Object dpassword);

	public abstract List findAll();

	public abstract DormLogin merge(DormLogin detachedInstance);

	public abstract void attachDirty(DormLogin instance);

	public abstract void attachClean(DormLogin instance);

	public abstract boolean update(DormLogin dormlogin, Adminmessage adminmessag);
	
	public abstract boolean update(DormLogin dormlogin);

	public abstract boolean delete(DormLogin dormlogin, Adminmessage adminmessag);

}