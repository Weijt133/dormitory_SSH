package com.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.BuildinglevelDAO;
import com.model.Buildinglevel;
public class BuildinglevelDAOImpl extends HibernateDaoSupport implements BuildinglevelDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BuildinglevelDAOImpl.class);
	protected void initDao() {
		// do nothing
	}
	public boolean save(Buildinglevel transientInstance) {
		log.debug("saving Buildinglevel instance");
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
	 * @see com.lyjun.dao.impl.BuildinglevelDAO#delete(com.lyjun.entity.Buildinglevel)
	 */
	public void delete(Buildinglevel persistentInstance) {
		log.debug("deleting Buildinglevel instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.BuildinglevelDAO#findById(java.lang.Integer)
	 */
	public Buildinglevel findById(java.lang.Integer id) {
		log.debug("getting Buildinglevel instance with id: " + id);
		try {
			Buildinglevel instance = (Buildinglevel) getHibernateTemplate()
					.get("com.model.Buildinglevel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.BuildinglevelDAO#findByExample(com.lyjun.entity.Buildinglevel)
	 */
	public List findByExample(Buildinglevel instance) {
		log.debug("finding Buildinglevel instance by example");
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
	public List<Buildinglevel> findByProperty(String propertyName, Object value) {
		log.debug("finding Buildinglevel instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Buildinglevel as model where model."
					+ propertyName + "="+Integer.valueOf(value.toString());
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			return null;
		}
	}

	public List<Buildinglevel> findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}
	
	public List<Buildinglevel> findByTip(Object tip) {
		return findByProperty(TIP, tip);
	}

	public List findAll() {
		log.debug("finding all Buildinglevel instances");
		try {
			String queryString = "from Buildinglevel";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.BuildinglevelDAO#merge(com.lyjun.entity.Buildinglevel)
	 */
	public Buildinglevel merge(Buildinglevel detachedInstance) {
		log.debug("merging Buildinglevel instance");
		try {
			Buildinglevel result = (Buildinglevel) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.BuildinglevelDAO#attachDirty(com.lyjun.entity.Buildinglevel)
	 */
	public void attachDirty(Buildinglevel instance) {
		log.debug("attaching dirty Buildinglevel instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.lyjun.dao.impl.BuildinglevelDAO#attachClean(com.lyjun.entity.Buildinglevel)
	 */
	public void attachClean(Buildinglevel instance) {
		log.debug("attaching clean Buildinglevel instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BuildinglevelDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (BuildinglevelDAO) ctx.getBean("BuildinglevelDAO");
	}
}