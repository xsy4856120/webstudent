package com.xsy.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DaoFactory {

	//不用创建对象(参考)
	private static DaoFactory factory = new DaoFactory();
	private Map<String, Object> map = new ConcurrentHashMap<>();
	private DaoFactory() {
	}
	public static DaoFactory getInstance() {
		return factory;
	}
	
	public AdminDao getAdminDao() {
		AdminDao dao = (AdminDao) map.get("AdminDao");
		if(dao != null) {
			return dao;
		}else {
			dao = new AdminDao();
			map.put("AdminDao", dao);
		}
		return dao;
	}
	
	public StudentDao getStudentDao() {
		StudentDao dao = (StudentDao) map.get("StudentDao");
		if(dao != null) {
			return dao;
		}else {
			dao = new StudentDao();
			map.put("StudentDao", dao);
		}
		return dao;
	}
	public CourseDao getClassDao() {
		CourseDao dao = (CourseDao) map.get("CourseDao");
		if(dao != null) {
			return dao;
		}else {
			dao = new CourseDao();
			map.put("ClassDao", dao);
		}
		return dao;
	}
	public SCDao getCourseDao() {
		SCDao dao = (SCDao) map.get("CourseDao");
		if(dao != null) {
			return dao;
		}else {
			dao = new SCDao();
			map.put("ScDao", dao);
		}
		return dao;
	}

	public TeacherDao getTeacherDao() {
		TeacherDao dao = (TeacherDao) map.get("TeacherDao");
		if(dao != null) {
			return dao;
		}else {
			dao = new TeacherDao();
			map.put("TeacherDao", dao);
		}
		return dao;
	}
}
