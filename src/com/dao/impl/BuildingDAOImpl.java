package com.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.BuildingDAO;
import com.model.Building;


public class BuildingDAOImpl extends HibernateDaoSupport implements BuildingDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BuildingDAOImpl.class);
	List<Building> building=new ArrayList<Building>();
	public List<Building> getBuilding() {
		return building;
	}
	public void setBuilding(List<Building> building) {
		this.building = building;
	}
	protected void initDao() {
		// do nothing
	}
	public boolean save(Building transientInstance) {
		log.debug("saving Building instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
			System.out.println("BuildingDAOImpl楼宇添加功能成功实现！");
			return true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			return false;
		}
	}

	public boolean delete(Building persistentInstance) {
		log.debug("deleting Building instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			return true;
		} catch (RuntimeException re) {
			return false;
		}
	}

	public Building findById(java.lang.Integer id) {
		log.debug("getting Building instance with id: " + id);
		try {
			Building instance = (Building) getHibernateTemplate().get(
					"com.model.Building", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Building findByExample(Building instance) {
		log.debug("finding Building instance by example");
		try {
			System.out.println("***********BuildingdaoImpl********findByExample************"+instance.getSex());
			List<Building> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			if(results.size()==1){
				System.out.println("***********BuildingdaoImpl-------------------findByExample************");
				return  results.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			return null;
		}
	}

	public List<Building> findByProperty(String propertyName, Object value) {
		log.debug("finding Building instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Building as model where model."
					+ propertyName + "= '"+value.toString()+"'";
			System.out.println("查询语句是："+queryString);
			building=getHibernateTemplate().find(queryString);
			if(building.size()!=0){
				return building;
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			return null;
		}
	}

	public List<Building> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}
	public List<Building> findByLid(final Integer pageSize,final Integer pageNumber,final Object lid) {
		System.out.println(" BuildingDAOImpl-->querybypage(final int pageSize, final int pageNumber)获得的分页查询参数是：pageSize="+pageSize+"\tpageNo="+pageNumber);
		List<Building> buildings=getHibernateTemplate().executeFind(new  HibernateCallback(){
					public Object doInHibernate(Session session){
						String hql="from Building as b where b.lid="+Integer.valueOf(lid.toString())+" order by b.lid desc";
						Query query=session.createQuery(hql);
						query.setFirstResult((pageNumber-1)*pageSize);
						query.setMaxResults(pageSize);
						List<Building> building=query.list();
						System.out.println("building 数目："+building.size());
						return building;
					}
				}
		);
		if(buildings!=null){
			return buildings;
		}else{
			return null;
		}
	}

	public List<Building> findAll() {
		log.debug("finding all Building instances");
		try {
			String queryString = "from Building";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.BuildingDAO#merge(com.lyjun.entity.Building)
	 */
	public Building merge(Building detachedInstance) {
		log.debug("merging Building instance");
		try {
			Building result = (Building) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	public void attachDirty(Building instance) {
		log.debug("attaching dirty Building instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public void attachClean(Building instance) {
		log.debug("attaching clean Building instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BuildingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BuildingDAO) ctx.getBean("BuildingDAO");
	}

	public List<Building> querybypage(final int pageSize, final int pageNumber) {
		System.out.println(" BuildingDAOImpl-->querybypage(final int pageSize, final int pageNumber)获得的分页查询参数是：pageSize="+pageSize+"\tpageNo="+pageNumber);
		List<Building> buildings=getHibernateTemplate().executeFind(new  HibernateCallback(){
					public Object doInHibernate(Session session){
						String hql="from Building order by bid desc";
						Query query=session.createQuery(hql);
						query.setFirstResult((pageNumber-1)*pageSize);
						query.setMaxResults(pageSize);
						List<Building> building=query.list();
						System.out.println("building 数目："+building.size());
						return building;
					}
				}
		);
		if(buildings!=null){
			return buildings;
		}else{
			return null;
		}
	}
	public List<Building> querybypage(final int pageSize, final int pageNumber,
			final String querycontent) {
		System.out.println(" BuildingDAOImpl-->querybypage(final int pageSize, final int pageNumber)获得的分页查询参数是：pageSize="+pageSize+"\tpageNo="+pageNumber);
		List<Building> buildings=getHibernateTemplate().executeFind(new  HibernateCallback(){
					public Object doInHibernate(Session session){
						String hql="from Building as b where b.sex='"+querycontent+"' order by b.bid desc";
						Query query=session.createQuery(hql);
						query.setFirstResult((pageNumber-1)*pageSize);
						query.setMaxResults(pageSize);
						List<Building> building=query.list();
						System.out.println("building 数目："+building.size());
						return building;
					}
				}
		);
		if(buildings!=null){
			return buildings;
		}else{
			return null;
		}
	}
	public List<Building> findByLid(Integer lid) {
		try {
			String queryString = "from Building as model where model.lid"
					 + "= "+lid;
			System.out.println("查询语句是："+queryString);
			building=getHibernateTemplate().find(queryString);
			if(building.size()!=0){
				return building;
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			return null;
		}
	}
	public boolean update(Building tomodifybuilding) {
		try {
		 	System.out.println("buildingdao--------------->update(********)");
		 	Session session = getHibernateTemplate().getSessionFactory().openSession();
		 	Transaction	transaction = session.beginTransaction();
			session.saveOrUpdate(tomodifybuilding);
			transaction.commit();
			session.close();
			System.out.println("恭喜您，信息更新成功！");
            return true;
        } catch (RuntimeException re) {
        	return false;
         }
	}
}