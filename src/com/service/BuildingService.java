package com.service;

import java.util.List;

import com.model.Building;
import com.model.Buildinglevel;

public interface BuildingService {

	// property constants
	public static final String SEX = "sex";
	public static final String LID = "lid";

	public abstract void save(Building transientInstance);

	public abstract boolean delete(Building persistentInstance);

	public abstract Building findById(java.lang.Integer id);

	public abstract Building findByExample(Building instance);

	public abstract Building findByProperty(String propertyName, Object value);

	public abstract List<Building> findBySex(Object sex);

	public abstract List<Building> findByLid(Integer pageSize,Integer pageNumber,Object lid);

	public abstract List<Building> findAll();

	public abstract Building merge(Building detachedInstance);

	public abstract void attachDirty(Building instance);

	public abstract void attachClean(Building instance);

	public abstract boolean add(Building building, Buildinglevel buildinglevel);
	
	public abstract List<Building> querybypage(int pageSize,int pageNumber);
	
	public Buildinglevel findbuildinglevel(Integer id);
	
	public abstract List<Building> querybypage(int pageSize,int  pageNumber,String querycontent);
	
	public abstract List<Buildinglevel> findBuildingLevelByNumber(Integer number);
	
	public abstract List<Building> findByLid(Integer  lid);
	
	public abstract List<Buildinglevel> findBuildingLevelByTip(Integer querycontent);
	
	public boolean update(Building tomodifybuilding);

}