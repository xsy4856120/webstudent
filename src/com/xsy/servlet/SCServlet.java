package com.xsy.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xsy.dao.DaoFactory;
import com.xsy.po.Class;
import com.xsy.po.Course;
import com.xsy.po.Student;
import com.xsy.po.Teacher;
import com.xsy.util.PageInfo;
import org.apache.commons.lang3.StringUtils;

@WebServlet("/sc")
public class SCServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String method = request.getParameter("method");
//		if("select".equals(method)) {
//			this.select(request, response);
//		}else if("submit".equals(method)) {
//			this.submit(request, response);
//		}else if("tc".equals(method)) {
//			this.teacher_course(request, response);
//		}else if("cs".equals(method)) {
//			this.course_student(request, response);
//		}else if("score_submit".equals(method)) {
//			this.score_submit(request, response);
//		}
//
//	}
	//评分提交
//	private void score_submit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Integer cId = getIntParameter(request, "cId");
//		String[] stuIdArr = request.getParameterValues("stuId");
//		String[] scoreArr = request.getParameterValues("score");
//		try {
//			DaoFactory.getInstance().getScDao().update(stuIdArr, scoreArr, cId);
//			response.sendRedirect(PathUtils.getBasePath(request)+"sc?method=cs&cId="+cId+"&msg=1");
//		} catch (SQLException e) {
//			response.sendRedirect(PathUtils.getBasePath(request)+"sc?method=cs&cId="+cId+"&msg=0");
//			e.printStackTrace();
//		}
//	}
//	//选课的学生查询
//	private void course_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//1、获取cid的参数
//		Integer cId = getIntParameter(request, "cId");
//		//2、获取学生列表
//		try {
//			List<Student> list = DaoFactory.getInstance().getScDao().listStudentByCId(cId);
//			request.setAttribute("list", list);
//			request.setAttribute("cId", cId);
//			request.getRequestDispatcher("page/sc/course_student.jsp").forward(request, response);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		//3、return页面
//
//	}
//
//	private void teacher_course(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		//1、获取老师的session中对象tId
//		Teacher teacher =(Teacher)request.getSession().getAttribute("user");
//		Integer pageNo = getIntParameter(request, "pageNo");
//		Course course = new Course();
//		course.setTeacher(teacher);
//		PageInfo<Course> pageInfo = new PageInfo<>(pageNo);
//		//2、查询所教课程列表
//		try {
//			pageInfo = DaoFactory.getInstance().getClassDao().list(Class, pageInfo);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		//3、将信息返回到jsp页面
//		request.setAttribute("pageInfo", pageInfo);
//		request.getRequestDispatcher("page/sc/teacher_course.jsp").forward(request, response);
//	}
//
//
//	//保存选课
//	private void submit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String[] cIds = request.getParameterValues("cId");
//		List<Integer> cIdArray = new ArrayList<Integer>();
//		for (String string : cIds) {
//			cIdArray.add(Integer.parseInt(string));
//		}
//		Student student = (Student)request.getSession().getAttribute("user");
//		try {
//			int[] arr = DaoFactory.getInstance().getCourseDao().add(cIdArray, student.getStuId());
//			if(arr.length == 0) {
//				response.sendRedirect(PathUtils.getBasePath(request)+"sc?method=select&msg=0");
//			}else {
//				response.sendRedirect(PathUtils.getBasePath(request)+"sc?method=select&msg=1");
//			}
//		} catch (SQLException e) {
//			response.sendRedirect(PathUtils.getBasePath(request)+"sc?method=select&msg=0");
//		}
//	}
//	//选课跳转
//	private void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PageInfo<Class> info = new PageInfo<>(1);
//		info.setPageSize(1000);
//		try {
//			info = (PageInfo<Class>) DaoFactory.getInstance().getClassDao().list(new Class(), info);
//			//获取登录的学生信息
//			Student student = (Student)request.getSession().getAttribute("user");
//			//获取已选课的课程ID(cId)
//			List<Course> list = DaoFactory.getInstance().getCourseDao().listByStuId(student.getStuId());
//			request.setAttribute("scs",list);
//			request.setAttribute("courses", info.getList());
//			request.getRequestDispatcher("page/sc/select.jsp").forward(request, response);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public Integer getIntParameter(HttpServletRequest request,String name) {
//		if(StringUtils.isNoneBlank(request.getParameter(name))) {
//			return Integer.parseInt(request.getParameter(name));
//		}else {
//			return null;
//		}
//	}
//
//
}
