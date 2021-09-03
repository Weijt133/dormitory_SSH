package com.service.impl;

import java.util.List;

import com.dao.BuildinglevelDAO;
import com.model.Buildinglevel;
import com.service.BuildinglevelService;

public class BuildinglevelServiceImpl implements BuildinglevelService {
	private BuildinglevelDAO buildingleveldao;
	public BuildinglevelDAO getBuildingleveldao() {
		return buildingleveldao;
	}

	public void setBuildingleveldao(BuildinglevelDAO buildingleveldao) {
		this.buildingleveldao = buildingleveldao;
	}

	public void attachClean(Buildinglevel instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Buildinglevel instance) {
		// TODO Auto-generated method stub

	}

	public void delete(Buildinglevel persistentInstance) {
		// TODO Auto-generated method stub

	}

	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByExample(Buildinglevel instance) {
		// TODO Auto-generated method stub
		return null;
	}

	public Buildinglevel findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByNumber(Object number) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByTip(Object tip) {
		// TODO Auto-generated method stub
		return null;
	}

	public Buildinglevel merge(Buildinglevel detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Buildinglevel transientInstance) {
		// TODO Auto-generated method stub

	}

}
