package com.dao;

import java.util.List;

import com.model.DormLogin;

public interface DormLoginDAO {

	// property constants
	public static final String AD_ID = "adId";
	public static final String DPASSWORD = "dpassword";

	public abstract boolean save(DormLogin transientInstance);

	public abstract boolean delete(DormLogin persistentInstance);

	public abstract DormLogin findById(java.lang.Integer id);

	public abstract List findByExample(DormLogin instance);
	
	public abstract boolean findByExampleExit(DormLogin instance);

	public abstract DormLogin findByProperty(String propertyName, Object value);

	public abstract DormLogin findByAdId(Object adId);

	public abstract List findAll();

	public abstract DormLogin merge(DormLogin detachedInstance);

	public abstract void attachDirty(DormLogin instance);

	public abstract void attachClean(DormLogin instance);

	public abstract boolean update(DormLogin dormlogin);

}