package com.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.DormitoryDAO;
import com.model.DormLogin;
import com.model.Dormitory;

public class DormitoryDAOImpl extends HibernateDaoSupport implements DormitoryDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DormitoryDAOImpl.class);
	protected void initDao() {
		// do nothing
	}

	public boolean save(Dormitory transientInstance) {
		log.debug("saving Dormitory instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
			System.out.println("dormitory init successfully!!!!");
			return true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			System.out.println("dormitory init unsuccessfully!!!!");
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.DormitoryDAO#delete(com.lyjun.entity.Dormitory)
	 */
	public boolean delete(Dormitory persistentInstance) {
		log.debug("deleting Dormitory instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
			return true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			System.out.println("dormitory delete failed!");
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.DormitoryDAO#findById(java.lang.Integer)
	 */
	public Dormitory findById(java.lang.Integer id) {
		log.debug("getting Dormitory instance with id: " + id);
		try {
			Dormitory instance = (Dormitory) getHibernateTemplate().get(
					"com.lyjun.entity.Dormitory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.DormitoryDAO#findByExample(com.lyjun.entity.Dormitory)
	 */
	public Dormitory findByExample(Dormitory instance) {
		log.debug("finding Dormitory instance by example");
		try {
			List<Dormitory> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			if(results.size()==1){
				return results.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			System.out.println("dormitory query failed!");
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.DormitoryDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Dormitory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Dormitory as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.DormitoryDAO#findByBid(java.lang.Object)
	 */
	public Dormitory findByProperty(String propertyName, Object value,Integer i) {
		log.debug("finding Dormitory instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Dormitory as model where model."
					+ propertyName + "= "+Integer.valueOf(value.toString());
			System.out.println("dormitory 查询语句："+queryString);
			List<Dormitory> results= getHibernateTemplate().find(queryString);
			if(results.size()==1){
				return results.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			System.out.println("dormitory query failed!");
			return null;
		}
	}
	public Dormitory findByBid(Object bid) {
		return findByProperty(BID, bid,null);
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.DormitoryDAO#findByAdId(java.lang.Object)
	 */
	public Dormitory findByAdId(Object adId) {
		return findByProperty(AD_ID, adId,2);
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.DormitoryDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Dormitory instances");
		try {
			String queryString = "from Dormitory";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.DormitoryDAO#merge(com.lyjun.entity.Dormitory)
	 */
	public Dormitory merge(Dormitory detachedInstance) {
		log.debug("merging Dormitory instance");
		try {
			Dormitory result = (Dormitory) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.DormitoryDAO#attachDirty(com.lyjun.entity.Dormitory)
	 */
	public void attachDirty(Dormitory instance) {
		log.debug("attaching dirty Dormitory instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.DormitoryDAO#attachClean(com.lyjun.entity.Dormitory)
	 */
	public void attachClean(Dormitory instance) {
		log.debug("attaching clean Dormitory instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DormitoryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DormitoryDAO) ctx.getBean("DormitoryDAO");
	}

	public boolean update(DormLogin dormlogin) {
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(dormlogin);
		tx.commit();
		session.close();
		System.out.println("dormitoryadmin信息更新功能完成！");
		return true;
	}

	public boolean update(Dormitory dormitory) {
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(dormitory);
		tx.commit();
		session.close();
		System.out.println("dormitory信息更新功能完成！");
		return true;
	}
}