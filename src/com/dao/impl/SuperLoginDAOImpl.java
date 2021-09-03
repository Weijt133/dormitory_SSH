package com.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.SuperLoginDAO;
import com.model.SuperLogin;

public class SuperLoginDAOImpl extends HibernateDaoSupport implements SuperLoginDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SuperLoginDAOImpl.class);
	private SuperLogin superLogin=new SuperLogin();
	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.SuperLoginDAO#save(com.lyjun.entity.SuperLogin)
	 */
	public void save(SuperLogin transientInstance) {
		log.debug("saving SuperLogin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.SuperLoginDAO#delete(com.lyjun.entity.SuperLogin)
	 */
	public void delete(SuperLogin persistentInstance) {
		log.debug("deleting SuperLogin instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.SuperLoginDAO#findById(java.lang.Integer)
	 */
	public SuperLogin findById(java.lang.Integer id) {
		log.debug("getting SuperLogin instance with id: " + id);
		try {
			SuperLogin instance = (SuperLogin) getHibernateTemplate().get(
					"com.lyjun.entity.SuperLogin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public SuperLogin findByExample(SuperLogin instance) {
		log.debug("finding SuperLogin instance by example");
		String adId="adId";
		try {
			String queryString = "from SuperLogin as model where model."
					+ adId + "= "+instance.getAdId()+" and model.spassword= '"+instance.getSpassword()+"'";
			List<SuperLogin> results=getHibernateTemplate().find(queryString);
			System.out.println("SuperLogin findByExample(SuperLogin instance)listsize="+results.size());
			if(results.size()==1){
				if(results.get(0).getAdId().equals(instance.getAdId())&&results.get(0).getSpassword().equals(instance.getSpassword()))
				{
					System.out.println("SuperLogin findByExample(SuperLogin instance)sid="+results.get(0).getSid());
					return results.get(0);
				}else{
					System.out.println("SuperLogin findByExample(SuperLogin instance)登录失败！");
					return null;
				}
			}else{
				System.out.println("SuperLogin findByExample(SuperLogin instance)登录失败！");
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			return null;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SuperLogin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SuperLogin as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.SuperLoginDAO#findByAdId(java.lang.Object)
	 */
	public List findByAdId(Object adId) {
		return findByProperty(AD_ID, adId);
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.SuperLoginDAO#findBySpassword(java.lang.Object)
	 */
	public List findBySpassword(Object spassword) {
		return findByProperty(SPASSWORD, spassword);
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.SuperLoginDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all SuperLogin instances");
		try {
			String queryString = "from SuperLogin";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.SuperLoginDAO#merge(com.lyjun.entity.SuperLogin)
	 */
	public SuperLogin merge(SuperLogin detachedInstance) {
		log.debug("merging SuperLogin instance");
		try {
			SuperLogin result = (SuperLogin) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.SuperLoginDAO#attachDirty(com.lyjun.entity.SuperLogin)
	 */
	public void attachDirty(SuperLogin instance) {
		log.debug("attaching dirty SuperLogin instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.SuperLoginDAO#attachClean(com.lyjun.entity.SuperLogin)
	 */
	public void attachClean(SuperLogin instance) {
		log.debug("attaching clean SuperLogin instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SuperLoginDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SuperLoginDAO) ctx.getBean("SuperLoginDAO");
	}

	public boolean find(SuperLogin superman) {
		log.debug("finding SuperLogin instance by example");
		try {
			List<SuperLogin> results = getHibernateTemplate().findByExample(superman);
			log.debug("find by example successful, result size: "
					+ results.size());
			if(results.size()==1){
				System.out.println("superadmin验证通过");
				return true;
			}else{
				System.out.println("superadmin验证未通过");
				return false;
			}
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			System.out.println("admin查询异常");
			return false;
		}

	}
}