package com.dao;

import java.util.List;

import com.model.Adminmessage;

public interface AdminmessageDAO {

	// property constants
	public static final String BID = "bid";
	public static final String NAME = "name";
	public static final String USERLEVEL = "userlevel";
	public static final String CALL = "call";

	public abstract boolean save(Adminmessage transientInstance);

	public abstract boolean delete(Adminmessage persistentInstance);

	public abstract Adminmessage findById(java.lang.Integer id);

	public abstract List findByExample(Adminmessage instance);

	public abstract Adminmessage findByProperty(String propertyName, Integer value);

	public abstract Adminmessage findByBid(Object bid);

	public abstract List findByName(Object name);

	public abstract List findByUserlevel(Object userlevel);

	public abstract List findByCall(Object call);

	public abstract List findAll();

	public abstract Adminmessage merge(Adminmessage detachedInstance);

	public abstract void attachDirty(Adminmessage instance);

	public abstract void attachClean(Adminmessage instance);

	public abstract boolean update(Adminmessage adminmessag);

}