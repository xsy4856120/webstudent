package com.xsy.servlet;

import com.xsy.dao.DaoFactory;
import com.xsy.dao.StudentDao;
import com.xsy.dao.TeacherDao;
import com.xsy.po.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
        System.out.println("正常");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if ("list".equals(method)){
            this.list(request,response);
        }else if ("add".equals(method)){
            this.add(request,response);
        }
    }


    private void list(HttpServletRequest request, HttpServletResponse response){
        try {
            System.out.println("我来过");
            List<Teacher> list = null;
            try {
                list = DaoFactory.getInstance().getTeacherDao().list(null);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("list",list);
            request.getRequestDispatcher("page/teacher/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TeacherDao teacherDao = new TeacherDao();
        List<Teacher> list = null;
        try {
            list = teacherDao.list(null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("list",list);
        try {
            request.getRequestDispatcher("page/teacher/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        Teacher teacher = new Teacher();
        teacher.setUsername(userName);
        teacher.setPassword(password);
        try {
            DaoFactory.getInstance().getTeacherDao().add(teacher);
            //直接重定向到列表页面
            try {
                request.getRequestDispatcher("page/teacher/add.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
