package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.BuildingDAO;
import com.dao.BuildinglevelDAO;
import com.model.Building;
import com.model.Buildinglevel;

public class BuildingServiceImpl implements com.service.BuildingService {
	private BuildingDAO buildingdao;
	private BuildinglevelDAO buildingleveldao;
	private Buildinglevel buildinglevel;
	private Building buildings;
	List<Buildinglevel> buildinglevels=new ArrayList<Buildinglevel>();
	public Building getBuildings() {
		return buildings;
	}

	public void setBuildings(Building buildings) {
		this.buildings = buildings;
	}

	List<Building> building=new ArrayList<Building>();
	public Buildinglevel getBuildinglevel() {
		return buildinglevel;
	}

	public void setBuildinglevel(Buildinglevel buildinglevel) {
		this.buildinglevel = buildinglevel;
	}

	private List<Building> build=new ArrayList<Building>();
	public BuildinglevelDAO getBuildingleveldao() {
		return buildingleveldao;
	}

	public void setBuildingleveldao(BuildinglevelDAO buildingleveldao) {
		this.buildingleveldao = buildingleveldao;
	}

	public BuildingDAO getBuildingdao() {
		return buildingdao;
	}

	public void setBuildingdao(BuildingDAO buildingdao) {
		this.buildingdao = buildingdao;
	}

	public void attachClean(Building instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Building instance) {
		// TODO Auto-generated method stub

	}

	public boolean delete(Building persistentInstance) {
		if(buildingdao.delete(persistentInstance)){
			return true;
		}else{
			return false;
		}

	}

	public List<Building> findAll() {
		building=buildingdao.findAll();
		if(building.size()!=0){
			System.out.println();
			return building;
		}else{
			return null;
		}
	}

	public Building findByExample(Building instance) {
		System.out.println("***********BuildingServiceImpl********findByExample************");
		buildings=buildingdao.findByExample(instance);
		if(buildings!=null){
			return buildings;
		}else{
			return null;
		}
	}

	public Building findById(Integer id) {
		buildings=buildingdao.findById(id);
		if(buildings!=null){
			return buildings;
		}else{
			return null;
		}
	}

	public List<Building> findByLid(Integer pageSize,Integer pageNumber,Object lid) {
		building=buildingdao.findByLid(pageSize,pageNumber,Integer.valueOf(lid.toString()));
		if(building!=null){
			return building;
		}else{
			return null;
		}
	}

	public Building findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Building> findBySex(Object sex) {
		build=buildingdao.findBySex(sex);
		if(build!=null){
			System.out.println("BuildingServiceImpl build数目是："+build.size());
			return build;
		}else{
			return null;
		}
	}

	public Building merge(Building detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Building transientInstance) {
		// TODO Auto-generated method stub

	}

	public boolean add(Building building, Buildinglevel buildinglevel) {
		boolean flag=false;
		Buildinglevel findbuildinglevel=new Buildinglevel();
		findbuildinglevel=buildingleveldao.findById(buildinglevel.getLid());
		if(findbuildinglevel!=null){
			System.out.println(buildinglevel.getLid()+"楼标准已经存在");
			flag=true;
		}else{
			flag=buildingleveldao.save(buildinglevel);
		}
		if(flag){
			Building findbuilding=new Building();
			findbuilding=buildingdao.findById(building.getBid());
			if(findbuilding!=null){
				System.out.println(building.getLid()+"楼房已经存在");
				return true;
			}else{
				return buildingdao.save(building);
			}
		}else{
			return false;
		}
	}

	public List<Building> querybypage(int pageSize, int pageNumber) {
		build=buildingdao.querybypage(pageSize, pageNumber);
		if(build!=null){
			System.out.println("BuildingServiceImpl build数目是："+build.size());
			return build;
		}else{
			return null;
		}
	}

	public Buildinglevel findbuildinglevel(Integer id) {
		buildinglevel=buildingleveldao.findById(id);
		if(buildinglevel!=null){
			return buildinglevel;
		}else{
			return null;
		}
	}

	public List<Building> querybypage(int pageSize, int pageNumber,
			String querycontent) {
		build=buildingdao.querybypage(pageSize, pageNumber ,querycontent);
		if(build!=null){
			System.out.println("BuildingServiceImpl build数目是："+build.size());
			return build;
		}else{
			return null;
		}
	}

	public List<Buildinglevel> findBuildingLevelByNumber(Integer querycontent) {
		buildinglevels=buildingleveldao.findByNumber(querycontent);
		if(buildinglevels!=null&&buildinglevels.size()!=0){
			return buildinglevels;
		}else{
			return null;
		}
	}

	public List<Building> findByLid(Integer lid) {
		building=buildingdao.findByLid(lid);
		if(building!=null){
			return building;
		}else{
			return null;
		}
	}

	public List<Buildinglevel> findBuildingLevelByTip(Integer querycontent) {
		buildinglevels=buildingleveldao.findByTip(querycontent);
		if(buildinglevels!=null&&buildinglevels.size()!=0){
			return buildinglevels;
		}else{
			return null;
		}
	}

	public boolean update(Building tomodifybuilding) {
		boolean flag=false;
		flag=buildingdao.update(tomodifybuilding);
		if(flag){
			return true;
		}else{			
			return false;
		}
	}

}
