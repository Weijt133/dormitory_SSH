package com.service.impl;

import java.util.List;

import com.dao.StudentDAO;
import com.dao.SuperLoginDAO;
import com.dao.DormLoginDAO;
import com.model.DormLogin;
import com.model.Student;
import com.model.SuperLogin;
import com.service.SuperLoginService;

public class SuperLoginServiceImpl implements SuperLoginService {
	private SuperLoginDAO superlogindao;
	private StudentDAO studentdao;
	private DormLoginDAO daomlogindao;
	
	public StudentDAO getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDAO studentdao) {
		this.studentdao = studentdao;
	}

	private SuperLogin superLogin=new SuperLogin();

	public SuperLoginDAO getSuperlogindao() {
		return superlogindao;
	}

	public void setSuperlogindao(SuperLoginDAO superlogindao) {
		this.superlogindao = superlogindao;
	}

	public void attachClean(SuperLogin instance) {
		// TODO Auto-generated method stub

	}

	public void attachDirty(SuperLogin instance) {
		// TODO Auto-generated method stub

	}

	public void delete(SuperLogin persistentInstance) {
		// TODO Auto-generated method stub

	}

	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByAdId(Object adId) {
		// TODO Auto-generated method stub
		return null;
	}

	public SuperLogin findByExample(SuperLogin instance) {
		superLogin=superlogindao.findByExample(instance);
		if(superLogin!=null){
			return instance;
		}else{
			return null;
		}
	}

	public SuperLogin findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findBySpassword(Object spassword) {
		// TODO Auto-generated method stub
		return null;
	}

	public SuperLogin merge(SuperLogin detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(SuperLogin transientInstance) {
		// TODO Auto-generated method stub

	}
	public boolean findDormLoginByIdAndPassword(DormLogin instance) {
		if(daomlogindao.findByExampleExit(instance)){
			return true;
		}else{
			return false;
		}
	}

	public boolean findStudentByIdAndPassword(Student student) {
		if(studentdao.findByExample(student)){
			return true;
		}else{
			return false;
		}
	}

	public boolean find(SuperLogin superman) {
		return superlogindao.find(superman);
	}

}
