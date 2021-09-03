package com.service;

import java.util.List;

import com.model.Adminmessage;
import com.model.DormLogin;
import com.model.Dormitory;

public interface DormitoryService {

	// property constants
	public static final String BID = "bid";
	public static final String AD_ID = "adId";

	public abstract boolean save(Dormitory transientInstance);

	public abstract void delete(Dormitory persistentInstance);

	public abstract Dormitory findById(java.lang.Integer id);

	public abstract List findByExample(Dormitory instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByBid(Object bid);

	public abstract List findByAdId(Object adId);

	public abstract List findAll();

	public abstract Dormitory merge(Dormitory detachedInstance);

	public abstract void attachDirty(Dormitory instance);

	public abstract void attachClean(Dormitory instance);
	
	public abstract boolean  update(DormLogin dormlogin,Adminmessage adminmessag);

}