package com.dao;

import java.util.List;

import com.model.Buildinglevel;

public interface BuildinglevelDAO {

	// property constants
	public static final String NUMBER = "number";
	public static final String TIP = "tip";

	public abstract boolean save(Buildinglevel transientInstance);

	public abstract void delete(Buildinglevel persistentInstance);

	public abstract Buildinglevel findById(java.lang.Integer id);

	public abstract List findByExample(Buildinglevel instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<Buildinglevel> findByNumber(Object number);

	public abstract List<Buildinglevel> findByTip(Object tip);

	public abstract List findAll();

	public abstract Buildinglevel merge(Buildinglevel detachedInstance);

	public abstract void attachDirty(Buildinglevel instance);

	public abstract void attachClean(Buildinglevel instance);

}