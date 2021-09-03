package com.service;

import java.util.List;

import com.model.DormLogin;
import com.model.Student;
import com.model.SuperLogin;

public interface SuperLoginService {

	// property constants
	public static final String AD_ID = "adId";
	public static final String SPASSWORD = "spassword";

	public abstract void save(SuperLogin transientInstance);

	public abstract void delete(SuperLogin persistentInstance);

	public abstract SuperLogin findById(java.lang.Integer id);

	public abstract SuperLogin findByExample(SuperLogin instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByAdId(Object adId);

	public abstract List findBySpassword(Object spassword);

	public abstract List findAll();

	public abstract SuperLogin merge(SuperLogin detachedInstance);

	public abstract void attachDirty(SuperLogin instance);

	public abstract void attachClean(SuperLogin instance);

	public abstract boolean findStudentByIdAndPassword(Student student);
	
	public abstract boolean findDormLoginByIdAndPassword(DormLogin instance);

	public abstract boolean find(SuperLogin superman);

}