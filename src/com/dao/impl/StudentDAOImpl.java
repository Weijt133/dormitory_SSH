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

import com.dao.StudentDAO;
import com.model.Student;


public class StudentDAOImpl extends HibernateDaoSupport implements StudentDAO {
	private static final Logger log = LoggerFactory.getLogger(StudentDAOImpl.class);
	private List<Student> students=new ArrayList<Student>();
	protected void initDao() {
		// do nothing
	}
	public boolean save(Student transientInstance) {
		log.debug("saving Student instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
			System.out.println("学生信息注册功能完成");
			return true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		
	}
	public boolean delete(Student persistentInstance) {
		log.debug("deleting Student instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
			System.out.println("学生信息成功注销");
			return true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			System.out.println("学生注销出现异常");
			return false;
		}
	}


	public Student findById(java.lang.Integer id) {
		log.debug("getting Student instance with id: " + id);
		try {
			Student instance = (Student) getHibernateTemplate().get(
					"com.model.Student", id);
			System.out.println("student find by stuid="+instance.getStuId());
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	
	public boolean findByExample(Student instance) {
		log.debug("finding Student instance by example");
		try {
			List<Student> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			if(results.size()==1){
				return true;
			}else{
				return false;
			}
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			System.out.println("登录出现异常！");
			return false;
		}
	}

	public List<Student> findByProperty(String propertyName, Object value) {
		log.debug("finding Student instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Student as model where model."
					+ propertyName + "= '"+value.toString()+"'";
			students=getHibernateTemplate().find(queryString);
			if(students!=null&&students.size()!=0){
				return students;
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			System.out.println("查询异常");
			return null;
		}
	}

	public Student findByProperty(String propertyName, Object value,String type) {
		log.debug("finding Student instance with property: " + propertyName
				+ ", value: " + value);
		if(type.equals("1")){
		try {
			String queryString = "from Student as model where model."
					+ propertyName + "= "+Integer.valueOf(value.toString());
			System.out.println("查询语句是："+queryString);
			students=getHibernateTemplate().find(queryString);
			if(students.size()==1){
				System.out.println("list 列表不空！");
				return students.get(0);
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			System.out.println("22222登录出现异常！");
			return null;
		}
		}else{
			try {
				String queryString = "from Student as model where model."
						+ propertyName + "= '"+value.toString()+"'";
				System.out.println("查询语句是："+queryString);
				students=getHibernateTemplate().find(queryString);
				if(students.size()==1){
					System.out.println("list 列表不空！");
					return students.get(0);
				}else{
					return null;
				}
			} catch (RuntimeException re) {
				log.error("find by property name failed", re);
				System.out.println("11111登录出现异常！");
				return null;
			}
		}
	}
	public Student findById(Object id) {
		return findByProperty(ID, id,"1");
	}

	public Student findByName(Object name) {
		return findByProperty(NAME, name,"2");
	}

	public List<Student> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByDepartment(Object department) {
		return findByProperty(DEPARTMENT, department);
	}

	
	public List<Student> findByMajor(Object major) {
		return findByProperty(MAJOR, major);
	}

	
	public List findByPalce(Object bid) {
		return findByProperty(BID, bid);
	}

	
	public List findByCall(Object call) {
		return findByProperty(CALL, call);
	}
	
	public List<Student> findAll() {
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
			students=getHibernateTemplate().find(queryString);
			if(students!=null){
				return students;
			}else{
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			System.out.println("studnet findall failed!");
			throw re;
		}
	}

	
	public Student merge(Student detachedInstance) {
		log.debug("merging Student instance");
		try {
			Student result = (Student) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	
	public void attachDirty(Student instance) {
		log.debug("attaching dirty Student instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	
	public void attachClean(Student instance) {
		log.debug("attaching clean Student instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StudentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StudentDAO) ctx.getBean("StudentDAO");
	}
	public List<Student> querybypage(final int pageSize, final int pageNumber,
			final String querycontent) {
		System.out.println(" StudentDAOImpl-->querybypage(final int pageSize, final int pageNumber)获得的分页查询参数是：pageSize="+pageSize+"\tpageNo="+pageNumber);
		List<Student> students=getHibernateTemplate().executeFind(new  HibernateCallback(){
					public Object doInHibernate(Session session){
						String hql="from Student as b where b.sex='"+querycontent+"' order by b.sex desc";
						Query query=session.createQuery(hql);
						query.setFirstResult((pageNumber-1)*pageSize);
						query.setMaxResults(pageSize);
						List<Student> st=query.list();
						System.out.println("building 数目："+st.size());
						return st;
					}
				}
		);
		if(students!=null){
			return students;
		}else{
			return null;
		}
	}
	public List<Student> querybypage(final int pageSize, final int pageNumber,
			final String querycontent, final String major2) {
		System.out.println(" StudentDAOImpl-->querybypage(final int pageSize, final int pageNumber)获得的分页查询参数是：pageSize="+pageSize+"\tpageNo="+pageNumber);
		List<Student> students=getHibernateTemplate().executeFind(new  HibernateCallback(){
					public Object doInHibernate(Session session){
						String hql="from Student as b where b."+major2+"='"+querycontent+"' order by b."+major2+"  desc";
						Query query=session.createQuery(hql);
						query.setFirstResult((pageNumber-1)*pageSize);
						query.setMaxResults(pageSize);
						List<Student> st=query.list();
						System.out.println("building 数目："+st.size());
						return st;
					}
				}
		);
		if(students!=null){
			return students;
		}else{
			return null;
		}
	}
	public List<Student> findByTime(String querycontent) {
		return findByProperty("time", querycontent);
	}
	public boolean update(Student student) {
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();
		session.close();
		System.out.println("学生信息更新功能完成！");
		return true;
	}
}