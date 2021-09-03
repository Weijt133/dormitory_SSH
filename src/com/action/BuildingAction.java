package com.action;

import java.util.ArrayList;
import java.util.List;

import com.model.Building;
import com.model.Buildinglevel;
import com.model.SuperLogin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BuildingService;
import com.tool.Build;

public class BuildingAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BuildingService buildingservice;
	private Building building;
	private Buildinglevel buildinglevel;
	private SuperLogin superman;
	private String loginmesg;

	public String getLoginmesg() {
		return loginmesg;
	}

	public void setLoginmesg(String loginmesg) {
		this.loginmesg = loginmesg;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Buildinglevel getBuildinglevel() {
		return buildinglevel;
	}

	public void setBuildinglevel(Buildinglevel buildinglevel) {
		this.buildinglevel = buildinglevel;
	}

	public BuildingService getBuildingservice() {
		return buildingservice;
	}

	public void setBuildingservice(BuildingService buildingservice) {
		this.buildingservice = buildingservice;
	}

	// ========================================================
	public String addmesg;
	public String bmesg;
	public String smesg;
	public String nmesg;
	public String tmesg;

	public String getBmesg() {
		return bmesg;
	}

	public void setBmesg(String bmesg) {
		this.bmesg = bmesg;
	}

	public String getSmesg() {
		return smesg;
	}

	public void setSmesg(String smesg) {
		this.smesg = smesg;
	}

	public String getNmesg() {
		return nmesg;
	}

	public void setNmesg(String nmesg) {
		this.nmesg = nmesg;
	}

	public String getTmesg() {
		return tmesg;
	}

	public void setTmesg(String tmesg) {
		this.tmesg = tmesg;
	}

	public String getAddmesg() {
		return addmesg;
	}

	public void setAddmesg(String addmesg) {
		this.addmesg = addmesg;
	}

	public String add() {
		superman = (SuperLogin) ActionContext.getContext().getSession().get(
				"loginuser");
		if (building.getBid() == 0) {
			bmesg = "楼号不能为空！";
			return INPUT;
		}
		if (building.getSex() == null || building.getSex() == "") {
			smesg = "楼宇性别标识不能为空！";
			return INPUT;
		}
		if (buildinglevel.getNumber() == 0) {
			nmesg = "楼宇容纳人数不能为空！";
			return INPUT;
		}
		if (buildinglevel.getTip() == 0) {
			tmesg = "楼宇收费标准不能为空！";
			return INPUT;
		}
		if (superman != null) {
			boolean flag = false;
			System.out.println(building.getLid()+" "+buildinglevel.getLid());

			if (!building.getLid().equals(buildinglevel.getLid())) {
				addmesg = "您输入的楼宇标准与标准信息中的标准号不一致！";
				return INPUT;
			}
			flag = buildingservice.add(building, buildinglevel);
			if (flag) {
				ActionContext.getContext().getSession().put("building",
						building);
				ActionContext.getContext().getSession().put("buildinglevel",
						buildinglevel);
				System.out.println("楼宇功能实现！");
				return SUCCESS;
			} else {
				return INPUT;
			}
		} else {
			loginmesg = "请登录后进行操作！";
			return LOGIN;
		}
	}

	// ==================================================
	private int totalPage = 1;
	private int pageNumber = 1;
	private int pageSize = 6;
	private int pageCount;
	private List<Building> build = new ArrayList<Building>();
	private List<Buildinglevel> buildlevel = new ArrayList<Buildinglevel>();
	private List<Build> buildings = new ArrayList<Build>();

	public List<Build> getBuilds() {
		return buildings;
	}

	public void setBuilds(List<Build> builds) {
		this.buildings = builds;
	}

	public List<Buildinglevel> getBuildlevel() {
		return buildlevel;
	}

	public void setBuildlevel(List<Buildinglevel> buildlevel) {
		this.buildlevel = buildlevel;
	}

	public List<Building> getBuild() {
		return build;
	}

	public void setBuild(List<Building> build) {
		this.build = build;
	}

	public SuperLogin getSuperman() {
		return superman;
	}

	public void setSuperman(SuperLogin superman) {
		this.superman = superman;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String querybypage() {
		buildings.clear();
		System.out.println("---------------->querybypage()");
		pageCount = buildingservice.findAll().size();
		totalPage = pageSize / pageCount + 1;
		if(pageSize>pageCount){
			totalPage=1;
		}
		if (pageNumber < 1) {
			pageNumber = 1;
		}
		if (pageNumber > totalPage) {
			pageNumber = totalPage;
		}
		build = buildingservice.querybypage(pageSize, pageNumber);
		if (build.size() != 0 && build != null) {
			for (int i = 0; i < build.size(); i++) {
				Buildinglevel bl = new Buildinglevel();
				bl = buildingservice.findbuildinglevel(build.get(i).getLid());
				if (bl != null) {
					Build builds = new Build();
					builds.setBid(build.get(i).getBid());
					builds.setLid(build.get(i).getLid());
					builds.setNumber(bl.getNumber());
					builds.setSex(build.get(i).getSex());
					builds.setTip(bl.getTip());
					System.out.println("builds id=" + builds.getBid() + "\t"
							+ builds.getLid() + "\tnumber="
							+ builds.getNumber() + "\ttip=" + builds.getTip());
					buildings.add(builds);
				}
			}
			System.out.println("builds构造完毕！其中的数目是：" + buildings.size());
			for (Build i : buildings) {
				System.out.println("\tbid=" + i.getBid() + "\tbsex="
						+ i.getSex() + "\tblid=" + i.getLid() + "\tnumber="
						+ i.getNumber());
			}
			ActionContext.getContext().getSession().put("buildings", buildings);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	// ==========================================================
	private int querytype;
	private String querycontent;
	private int target;
	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public String getQuerycontent() {
		return querycontent;
	}

	public void setQuerycontent(String querycontent) {
		this.querycontent = querycontent;
	}

	public int getQuerytype() {
		return querytype;
	}

	public void setQuerytype(int querytype) {
		this.querytype = querytype;
	}

	public String querymesg;

	public String getQuerymesg() {
		return querymesg;
	}

	public void setQuerymesg(String querymesg) {
		this.querymesg = querymesg;
	}

	public String querybytype() {
		buildings.clear();
		System.out.println("----------->querybytype() querytype=" + querytype
				+ "\tquerycontent=" + querycontent);
		if (querytype == 1) {
			building = buildingservice.findById(Integer.valueOf(querycontent));
			if (building != null) {
				buildinglevel = buildingservice.findbuildinglevel(building
						.getLid());
				if (buildinglevel != null) {
					Build builds = new Build();
					builds.setBid(building.getBid());
					builds.setLid(building.getLid());
					builds.setNumber(buildinglevel.getNumber());
					builds.setSex(building.getSex());
					builds.setTip(buildinglevel.getTip());
					buildings.add(builds);
					ActionContext.getContext().getSession().put("buildings",
							buildings);
					return "querybybid";
				} else {
					return ERROR;
				}
			} else {
				querymesg = "没有找到您要查找的数据！";
				return "querybybid";
			}
		}

		if (querytype == 2) {
			System.out.println("---------------->querybypage()");
			pageCount = buildingservice.findBySex(querycontent).size();
			totalPage = pageSize / pageCount + 1;
			if(pageSize>pageCount){
				totalPage=1;
			}
			if (pageNumber < 1) {
				pageNumber = 1;
			}
			if (pageNumber > totalPage) {
				pageNumber = totalPage;
			}
			build = buildingservice.querybypage(pageSize, pageNumber,
					querycontent);
			if (build.size() != 0 && build != null) {
				for (int i = 0; i < build.size(); i++) {
					Buildinglevel bl = new Buildinglevel();
					bl = buildingservice.findbuildinglevel(build.get(i)
							.getLid());
					if (bl != null) {
						Build builds = new Build();
						builds.setBid(build.get(i).getBid());
						builds.setLid(build.get(i).getLid());
						builds.setNumber(bl.getNumber());
						builds.setSex(build.get(i).getSex());
						builds.setTip(bl.getTip());
						System.out.println("builds id=" + builds.getBid()
								+ "\t" + builds.getLid() + "\tnumber="
								+ builds.getNumber() + "\ttip="
								+ builds.getTip());
						buildings.add(builds);
					}
				}
				System.out.println("builds构造完毕！其中的数目是：" + buildings.size());
				for (Build i : buildings) {
					System.out.println("\tbid=" + i.getBid() + "\tbsex="
							+ i.getSex() + "\tblid=" + i.getLid() + "\tnumber="
							+ i.getNumber());
				}
				ActionContext.getContext().getSession().put("buildings",
						buildings);
				return "querybysex";
			} else {
				querymesg = "没有找到您要查找的数据！";
				return "querybysex";
			}
		}
		if (querytype == 3) {
			build = buildingservice.findByLid(pageSize, pageNumber, Integer
					.valueOf(querycontent));
			if (build != null && build.size() != 0) {
				for (int i = 0; i < build.size(); i++) {
					Buildinglevel bl = new Buildinglevel();
					bl = buildingservice.findbuildinglevel(build.get(i)
							.getLid());
					if (bl != null) {
						Build builds = new Build();
						builds.setBid(build.get(i).getBid());
						builds.setLid(build.get(i).getLid());
						builds.setNumber(bl.getNumber());
						builds.setSex(build.get(i).getSex());
						builds.setTip(bl.getTip());
						System.out.println("builds id=" + builds.getBid()
								+ "\t" + builds.getLid() + "\tnumber="
								+ builds.getNumber() + "\ttip="
								+ builds.getTip());
						buildings.add(builds);
					}
				}
				System.out.println("builds构造完毕！其中的数目是：" + buildings.size());
				for (Build i : buildings) {
					System.out.println("\tbid=" + i.getBid() + "\tbsex="
							+ i.getSex() + "\tblid=" + i.getLid() + "\tnumber="
							+ i.getNumber());
				}
				ActionContext.getContext().getSession().put("buildings",
						buildings);
				return "querybylid";
			}
		}
		if (querytype == 4) {
			System.out.println("---------------------------------->querytype="
					+ querytype);
			buildlevel = buildingservice.findBuildingLevelByNumber(Integer
					.valueOf(querycontent));
			if (buildlevel != null && buildlevel.size() != 0) {
				System.out.println("------------->buildlevelsize="+buildlevel.size());
				for (int i = 0; i < buildlevel.size(); i++) {
					build.clear();
					System.out.println("----------->buildlevellid="+buildlevel.get(i).getLid());
					build = buildingservice.findByLid(buildlevel.get(i).getLid());
					System.out.println("------------->buildsize="+build.size());
					for(Buildinglevel n:buildlevel){
						System.out.println("buildlvelid="+n.getLid()+"\tbuildlevelnumber="+n.getNumber()+"\tbuildleveltip="+n.getTip());
					}
					for(Building m:build){
						System.out.println("bid="+m.getBid()+"\tbsex="+m.getSex()+"\tblid="+m.getLid());
					}
					for (int j = 0; j < build.size(); j++) {
						if (buildlevel.get(i).getLid() .equals(build.get(j).getLid()) ) {
							Build builds = new Build();
							builds.setBid(build.get(j).getBid());
							builds.setLid(build.get(j).getLid());
							builds.setNumber(buildlevel.get(i).getNumber());
							builds.setSex(build.get(j).getSex());
							builds.setTip(buildlevel.get(i).getTip());
							System.out.println("builds id=" + builds.getBid()
									+ "\t" + builds.getLid() + "\tnumber="
									+ builds.getNumber() + "\ttip="
									+ builds.getTip());
							buildings.add(builds);
						}
					}
				}
			}
			System.out.println("builds构造完毕！其中的数目是：" + buildings.size());
			for (Build i : buildings) {
				System.out.println("\tbid=" + i.getBid() + "\tbsex="
						+ i.getSex() + "\tblid=" + i.getLid() + "\tnumber="
						+ i.getNumber());
			}
			ActionContext.getContext().getSession().put("buildings", buildings);
			return "querybynumber";
		}
		if (querytype == 5) {
			System.out.println("---------------------------------->querytype="
					+ querytype);
			buildlevel = buildingservice.findBuildingLevelByTip(Integer
					.valueOf(querycontent)); 
			if (buildlevel != null && buildlevel.size() != 0) {
				System.out.println("------------->buildlevelsize="+buildlevel.size());
				for (int i = 0; i < buildlevel.size(); i++) {
					build.clear();
					System.out.println("----------->buildlevellid="+buildlevel.get(i).getLid());
					build = buildingservice.findByLid(buildlevel.get(i).getLid());
					System.out.println("------------->buildsize="+build.size());
					for(Buildinglevel n:buildlevel){
						System.out.println("buildlvelid="+n.getLid()+"\tbuildlevelnumber="+n.getNumber()+"\tbuildleveltip="+n.getTip());
					}
					for(Building m:build){
						System.out.println("bid="+m.getBid()+"\tbsex="+m.getSex()+"\tblid="+m.getLid());
					}
					for (int j = 0; j < build.size(); j++) {
						if (buildlevel.get(i).getLid() .equals(build.get(j).getLid()) ) {
							Build builds = new Build();
							builds.setBid(build.get(j).getBid());
							builds.setLid(build.get(j).getLid());
							builds.setNumber(buildlevel.get(i).getNumber());
							builds.setSex(build.get(j).getSex());
							builds.setTip(buildlevel.get(i).getTip());
							System.out.println("builds id=" + builds.getBid()
									+ "\t" + builds.getLid() + "\tnumber="
									+ builds.getNumber() + "\ttip="
									+ builds.getTip());
							buildings.add(builds);
						}
					}
				}
			}
			System.out.println("builds构造完毕！其中的数目是：" + buildings.size());
			for (Build i : buildings) {
				System.out.println("\tbid=" + i.getBid() + "\tbsex="
						+ i.getSex() + "\tblid=" + i.getLid() + "\tnumber="
						+ i.getNumber());
			}
			ActionContext.getContext().getSession().put("buildings", buildings);
			return "querybynumber";
		}
		return INPUT;
	}
	
	public String querybybidnumber(){
		System.out.println("--------->querybybidnumber()");
		building = buildingservice.findById(Integer.valueOf(querycontent));
		if (building != null) {
			buildinglevel = buildingservice.findbuildinglevel(building
					.getLid());
			ActionContext.getContext().getSession().put("building",
					building);
			ActionContext.getContext().getSession().put("buildinglevel",
					buildinglevel);
				return SUCCESS;
		} else{
			return INPUT;
		}
	}
	//===========================================
	private String sex;
	private Integer lid;
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String modify(){
		System.out.println("----------->modify()要修改的楼号为："+building.getBid()+"\tbuildinglevleid="+building.getLid());
		Building tomodifybuilding=new Building();
		Buildinglevel newBuildinglevel=new Buildinglevel();
		tomodifybuilding.setBid(building.getBid());
		tomodifybuilding.setLid(lid);
		tomodifybuilding.setSex(sex);
		buildingservice.update(tomodifybuilding);
		newBuildinglevel=buildingservice.findbuildinglevel(tomodifybuilding.getLid());
		ActionContext.getContext().getSession().put("building",
				tomodifybuilding);
		ActionContext.getContext().getSession().put("buildinglevel",
				newBuildinglevel);
		return SUCCESS;
	}
	//===================================================
	private Integer bid;
	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String delete(){
		System.out.println("得到要删除的楼号为："+bid);
		building=buildingservice.findById(bid);
		if(building.getSex()!=null){
			if(buildingservice.delete(building)){
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			return INPUT;
		}
	}
}
