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
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.AdminmessageDAO;
import com.model.Adminmessage;

public class AdminmessageDAOImpl extends HibernateDaoSupport implements AdminmessageDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AdminmessageDAOImpl.class);
	protected void initDao() {
		// do nothing
	}
	List<Adminmessage> admin=new ArrayList<Adminmessage>();
	public boolean save(Adminmessage transientInstance) {
		log.debug("saving Adminmessage instance");
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		session.save(transientInstance);
		transaction.commit();
		session.close();
		return true;
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.AdminmessageDAO#delete(com.lyjun.entity.Adminmessage)
	 */
	public boolean delete(Adminmessage persistentInstance) {
		log.debug("deleting Adminmessage instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
			System.out.println("dorm admin message delete successfully!");
			return true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			System.out.println("dorm admin message delete failed!");
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.AdminmessageDAO#findById(java.lang.Integer)
	 */
	public Adminmessage findById(java.lang.Integer id) {
		log.debug("getting Adminmessage instance with id: " + id);
		try {
			Adminmessage instance = (Adminmessage) getHibernateTemplate().get(
					"com.lyjun.entity.Adminmessage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.AdminmessageDAO#findByExample(com.lyjun.entity.Adminmessage)
	 */
	public List findByExample(Adminmessage instance) {
		log.debug("finding Adminmessage instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.AdminmessageDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Adminmessage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Adminmessage as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public Adminmessage findByProperty(String propertyName, Object value,String type) {
		log.debug("finding Adminmessage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Adminmessage as model where model."
					+ propertyName + "= "+Integer.valueOf(value.toString());
			admin= getHibernateTemplate().find(queryString);
			if(admin.size()==1){
				return admin.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public Adminmessage findByBid(Object bid) {
		return findByProperty(BID, bid,null);
	}

	
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.AdminmessageDAO#findByUserlevel(java.lang.Object)
	 */
	public List findByUserlevel(Object userlevel) {
		return findByProperty(USERLEVEL, userlevel);
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.AdminmessageDAO#findByCall(java.lang.Object)
	 */
	public List findByCall(Object call) {
		return findByProperty(CALL, call);
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.AdminmessageDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Adminmessage instances");
		try {
			String queryString = "from Adminmessage";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.AdminmessageDAO#merge(com.lyjun.entity.Adminmessage)
	 */
	public Adminmessage merge(Adminmessage detachedInstance) {
		log.debug("merging Adminmessage instance");
		try {
			Adminmessage result = (Adminmessage) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.AdminmessageDAO#attachDirty(com.lyjun.entity.Adminmessage)
	 */
	public void attachDirty(Adminmessage instance) {
		log.debug("attaching dirty Adminmessage instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.AdminmessageDAO#attachClean(com.lyjun.entity.Adminmessage)
	 */
	public void attachClean(Adminmessage instance) {
		log.debug("attaching clean Adminmessage instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdminmessageDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdminmessageDAO) ctx.getBean("AdminmessageDAO");
	}
	
	public Adminmessage findByProperty(String propertyName, Integer value) {
		log.debug("finding Adminmessage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Adminmessage as model where model."
					+ propertyName + "= "+ Integer.valueOf(value.toString());
			System.out.println(queryString);
			admin=getHibernateTemplate().find(queryString);
			if(admin.size()==1){
				return admin.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public boolean update(Adminmessage adminmessag) {
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.update(adminmessag);
		tx.commit();
		session.close();
		System.out.println("恭喜您,adminmessage 信息更新成功！");
		return true;
	}
}