package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.StudentDAO;
import com.model.Student;
import com.service.StudentService;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentdao;
	public StudentDAO getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDAO studentdao) {
		this.studentdao = studentdao;
	}

	public void attachClean(Student instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(Student instance) {
		// TODO Auto-generated method stub

	}

	public boolean delete(Student persistentInstance) {
		return studentdao.delete(persistentInstance);

	}

	public List<Student> findAll() {
		return studentdao.findAll();
	}

	public List findByCall(Object call) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByDepartment(Object department) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByExample(Student instance) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student findById(Integer id) {
		
		return studentdao.findById(id);
	}

	public Student findById(Object id) {
		return studentdao.findById(id);
	}

	public List<Student> findByMajor(Object major) {
		return studentdao.findByMajor(major);
	}

	public Student findByName(Object name) {
		return studentdao.findByName(name);
	}

	public List findByPalce(Object palce) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> findBySex(Object sex) {
		return studentdao.findBySex(sex);
	}

	public Student merge(Student detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(Student transientInstance) {
		boolean flag=false;
		flag=studentdao.save(transientInstance);
		if(flag){
			return true;
		}else{
			return false;
		}

	}

	public List<Student> querybypage(int pageSize, int pageNumber,
			String querycontent) {
		return studentdao.querybypage(pageSize, pageNumber,
				querycontent);
	}

	public List<Student> querybypage(int pageSize, int pageNumber,
			String querycontent, String major) {
		return studentdao.querybypage(pageSize, pageNumber,
				querycontent,major);
	}

	public List<Student> findByTime(String querycontent) {
		return studentdao.findByTime(querycontent);
	}

	public boolean update(Student student) {
		return studentdao.update(student);
	}

}
