package com.action;
import java.sql.Date;
import java.util.List;
import com.model.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;

public class StudentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentService studentservice;
	private List<Student> students;
	private Student student;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public StudentService getStudentservice() {
		return studentservice;
	}
	public void setStudentservice(StudentService studentservice) {
		this.studentservice = studentservice;
	}
	private Integer id;
	private String name;
	private String password;
	private String sex;
	private String department;
	private String major;
	private Integer bid;
	private String time;
	private String cellcall;
	public String getCellcall() {
		return cellcall;
	}
	public void setCellcall(String cellcall) {
		this.cellcall = cellcall;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid=bid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String enroll(){
		System.out.println("StudentController---->ENROLL()password="+password);
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setSex(sex);
		student.setPassword(password);
		student.setBid(bid);
		student.setDepartment(department);
		student.setMajor(major);
		System.out.println(time);
		Date date=Date.valueOf(time);
		student.setTime(date);
		student.setCellcall(cellcall);
		System.out.println("\t"+student.getId()+"\t"+student.getName()+"\t"+student.getDepartment()
				+"\t"+student.getMajor()+"\t"+student.getBid()+"\t"+student.getTime()
				+"\t"+student.getCellcall());
		studentservice.save(student);
		ActionContext.getContext().getSession().put("student", student);
		return SUCCESS;
	}
	//=========================================
	private String qmesg;
	
	public String getQmesg() {
		return qmesg;
	}
	public void setQmesg(String qmesg) {
		this.qmesg = qmesg;
	}
	public String queryall(){
		System.out.println("studnet queryall()");
		students=studentservice.findAll();
		System.out.println("students size="+students.size());
		if(students!=null&&students.size()!=0){
			ActionContext.getContext().getSession().put("students", students);
			return SUCCESS;
		}else{
			qmesg="没有要找的数据！";
			return INPUT;
		}
		
	}
	//===================================================
	private int querytype;
	private int type;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	private String querycontent;
	public int getQuerytype() {
		return querytype;
	}
	public void setQuerytype(int querytype) {
		this.querytype = querytype;
	}
	public String getQuerycontent() {
		return querycontent;
	}
	public void setQuerycontent(String querycontent) {
		this.querycontent = querycontent;
	}
	//=========================类型查询分页参数=====================
	private int totalPage = 1;
	private int pageNumber = 1;
	private int pageSize = 6;
	private int pageCount;
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public String querybytype(){
		System.out.println("querybytype() querytype="+querytype+"\tquerycontent="+querycontent);
		if(querytype==1){
			ActionContext.getContext().getSession().clear();
			System.out.println("按学号查询 id="+querycontent);
			if(querycontent!=null&&querycontent!=""){
				Student student=new Student();
				student=studentservice.findById(querycontent.toString());
				if(student!=null){
					System.out.println("\tid="+student.getId()+"\tname"+student.getName()+"\tcall="+student.getCellcall());
					ActionContext.getContext().getSession().put("student", student);
					return "querybyid";
				}else{
					qmesg="没有要找的数据！";
					return INPUT;
				}
			}
		}
		if(querytype==2){
			ActionContext.getContext().getSession().clear();
			System.out.println("按姓名查询 name="+querycontent);
			if(querycontent!=null&&querycontent!=""){
				Student student=new Student();
				student=studentservice.findByName(querycontent);
				if(student!=null){
					System.out.println("\tid="+student.getId()+"\tname"+student.getName()+"\tcall="+student.getCellcall());
					ActionContext.getContext().getSession().put("student", student);
					return "querybyname";
				}else{
					qmesg="没有要找的数据！";
					return INPUT;
				}
			}
		}
		if(querytype==3){
			ActionContext.getContext().getSession().clear();
			System.out.println("按性别查询 sex="+querycontent);
			pageCount = studentservice.findBySex(querycontent).size();
			totalPage = pageSize / pageCount + 1;
			if (pageNumber < 1) {
				pageNumber = 1;
			}
			if (pageNumber > totalPage) {
				pageNumber = totalPage;
			}
			students = studentservice.querybypage(pageSize, pageNumber,
					querycontent);
			if (students.size() != 0 && students != null) {
				for (Student i : students) {
					System.out.println("\tbid=" + i.getName() + "\tbsex="
							+ i.getSex() + "\tblid=" + i.getMajor() + "\tnumber="
							+ i.getDepartment());
				}
				ActionContext.getContext().getSession().put("students",
						students);
				return "querybysex";
			} else {
				qmesg = "没有找到您要查找的数据！";
				return "querybysex";
			}
		}
		if(querytype==4){
			ActionContext.getContext().getSession().clear();
			System.out.println("按专业查询major="+querycontent);
			pageCount = studentservice.findByMajor(querycontent).size();
			totalPage = pageSize / pageCount + 1;
			if (pageNumber < 1) {
				pageNumber = 1;
			}
			if (pageNumber > totalPage) {
				pageNumber = totalPage;
			}
			students = studentservice.querybypage(pageSize, pageNumber,
					querycontent,"major");
			if (students.size() != 0 && students != null) {
				for (Student i : students) {
					System.out.println("\tbid=" + i.getName() + "\tbsex="
							+ i.getSex() + "\tblid=" + i.getMajor() + "\tnumber="
							+ i.getDepartment());
				}
				ActionContext.getContext().getSession().put("students",
						students);
				return "querybymajor";
			} else {
				qmesg = "没有找到您要查找的数据！";
				return "querybymajor";
			}
		}
		if(querytype==5){
			ActionContext.getContext().getSession().clear();
			System.out.println("按入学时间查询time="+querycontent);
			pageCount = studentservice.findByTime(querycontent).size();
			totalPage = pageSize / pageCount + 1;
			if (pageNumber < 1) {
				pageNumber = 1;
			}
			if (pageNumber > totalPage) {
				pageNumber = totalPage;
			}
			students = studentservice.querybypage(pageSize, pageNumber,
					querycontent,"time");
			if (students.size() != 0 && students != null) {
				for (Student i : students) {
					System.out.println("\tbid=" + i.getName() + "\tbsex="
							+ i.getSex() + "\tblid=" + i.getMajor() + "\tnumber="
							+ i.getDepartment());
				}
				ActionContext.getContext().getSession().put("students",
						students);
				return "querybymajor";
			} else {
				qmesg = "没有找到您要查找的数据！";
				return "querybymajor";
			}
		}
		qmesg = "没有找到您要查找的数据！";
		return INPUT;
	}
	
	public String updateStudent(){
		System.out.println("\tupdateStudent()   "+id+"\t"+name+"\t"+cellcall+"\t"+time+"\t"+department+"\t"+major);
		Student loadstudent=(Student) ActionContext.getContext().getSession().get("student");
		boolean flag=false;
		Student upstudent=new Student();
		upstudent.setId(id);
		upstudent.setName(name);
		upstudent.setSex(sex);
		upstudent.setDepartment(department);
		upstudent.setMajor(major);
		upstudent.setCellcall(cellcall);
		upstudent.setPassword(password);
		upstudent.setBid(bid);
		Date date=Date.valueOf(time);
		upstudent.setTime(date);
		upstudent.setStuId(loadstudent.getStuId());
		flag=studentservice.update(upstudent);
		if(flag){
			ActionContext.getContext().getSession().put("student", upstudent);
			return SUCCESS;			
		}else{
			return ERROR;
		}
	}
	
	public String updatequery(){
		System.out.println("按学号查询 updatequery()---id="+querycontent+"querytype="+type);
		if(querycontent!=null&&querycontent!=""){
			Student student=new Student();
			student=studentservice.findById(querycontent.toString());
			if(student!=null){
				System.out.println("\tid="+student.getId()+"\tname"+student.getName()+"\tcall="+student.getCellcall());
				ActionContext.getContext().getSession().put("student", student);
				if(type==2){
					type=0;
					return "delete";
				}
				return SUCCESS;
			}else{
				qmesg="没有要找的数据！";
				return INPUT;
			}
		}else{
			return ERROR;
		}
	}
	//====================================
	private Integer stuId;
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String delete(){
		System.out.println("delete() 获取要删除的学生主键 stuId="+stuId);
		student=studentservice.findById(stuId);
		boolean flag=studentservice.delete(student);
		if(flag){
			System.out.println("学生信息注销功能完成！");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
