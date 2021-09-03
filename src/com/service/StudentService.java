package com.service;

import java.util.List;

import com.model.Student;

public interface StudentService {

	// property constants
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String DEPARTMENT = "department";
	public static final String MAJOR = "major";
	public static final String BID = "bid";
	public static final String CALL = "call";

	public abstract boolean save(Student transientInstance);

	public abstract boolean delete(Student persistentInstance);

	public abstract Student findById(java.lang.Integer id);

	public abstract List findByExample(Student instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract Student findById(Object id);

	public abstract Student findByName(Object name);

	public abstract List<Student> findBySex(Object sex);

	public abstract List findByDepartment(Object department);

	public abstract List<Student> findByMajor(Object major);

	public abstract List findByPalce(Object palce);

	public abstract List findByCall(Object call);

	public abstract List<Student> findAll();

	public abstract Student merge(Student detachedInstance);

	public abstract void attachDirty(Student instance);

	public abstract void attachClean(Student instance);

	public abstract List<Student> querybypage(int pageSize, int pageNumber,String querycontent);

	public abstract List<Student> querybypage(int pageSize, int pageNumber,
			String querycontent, String major2);

	public abstract List<Student> findByTime(String querycontent);

	public abstract boolean update(Student student);

}