package com.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.DormLoginDAO;
import com.model.DormLogin;
import com.model.SuperLogin;


public class DormLoginDAOImpl extends HibernateDaoSupport implements DormLoginDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DormLoginDAOImpl.class);
	List<DormLogin> dormlogin=new ArrayList<DormLogin>();
	protected void initDao() {
		// do nothing
	}

	public boolean save(DormLogin transientInstance) {
		log.debug("saving DormLogin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
			return true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.DormLoginDAO#delete(com.lyjun.entity.DormLogin)
	 */
	public boolean delete(DormLogin persistentInstance) {
		log.debug("deleting DormLogin instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
			System.out.println("宿管员注销功能完成！");
			return true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			System.out.println("宿管员注销出现异常！");
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.DormLoginDAO#findById(java.lang.Integer)
	 */
	public DormLogin findById(java.lang.Integer id) {
		log.debug("getting DormLogin instance with id: " + id);
		try {
			DormLogin instance = (DormLogin) getHibernateTemplate().get(
					"com.lyjun.entity.DormLogin", id);
			if(instance!=null){
				return instance;
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("get failed", re);
			System.out.println("一次查询异常！");
			return null;
		}
	}

	public List findByExample(DormLogin instance) {
		log.debug("finding DormLogin instance by example");
		try {
			List<DormLogin> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public boolean findByExampleExit(DormLogin instance) {
		log.debug("finding DormLogin instance by example");
		try {
			String queryString = "from DormLogin as model where model.adId="
					+instance.getAdId()+" and model.dpassword= '"+instance.getDpassword()+"'";
			List<DormLogin> results=getHibernateTemplate().find(queryString);
			System.out.println("SuperLogin findByExample(SuperLogin instance)listsize="+results.size());
			if(results.size()==1){
				if(results.get(0).getAdId().equals(instance.getAdId())&&results.get(0).getDpassword().equals(instance.getDpassword()))
				{
					System.out.println("dpassword findByExample(dpassword instance)did="+results.get(0).getDid());
					return true;
				}else{
					System.out.println("dpassword findByExample(dpassword instance)登录失败！");
					return false;
				}
			}else{
				System.out.println("dpassword findByExample(dpassword instance)登录失败！");
				return false;
			}
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			return false;
		}
	}

	public DormLogin findByProperty(String propertyName, Object value) {
		log.debug("finding DormLogin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DormLogin as model where model."
					+ propertyName + "= "+Integer.valueOf(value.toString());
			dormlogin=getHibernateTemplate().find(queryString);
			if(dormlogin.size()==1){
				return dormlogin.get(0);
			}else{				
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			return null;
		}
	}
	public DormLogin findByAdId(Object adId) {
		return findByProperty(AD_ID, adId);
	}

	public List findAll() {
		log.debug("finding all DormLogin instances");
		try {
			String queryString = "from DormLogin";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public DormLogin merge(DormLogin detachedInstance) {
		log.debug("merging DormLogin instance");
		try {
			DormLogin result = (DormLogin) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DormLogin instance) {
		log.debug("attaching dirty DormLogin instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DormLogin instance) {
		log.debug("attaching clean DormLogin instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DormLoginDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DormLoginDAO) ctx.getBean("DormLoginDAO");
	}

	public boolean update(DormLogin dormlogin) {
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.update(dormlogin);
		tx.commit();
		session.close();
		System.out.println("dormitory admin update successfully!");
		return true;
	}

}