package com.xsy.servlet;

import com.xsy.dao.DaoFactory;
import com.xsy.dao.StudentDao;
import com.xsy.po.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
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
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        System.out.println("我来添加了");
        try {
            DaoFactory.getInstance().getStudentDao().add(student);
            //直接重定向到列表页面
            response.sendRedirect("student?method=list");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response){
        try {
            System.out.println("学生列表");
            List<Student> list = null;
            try {
                list = DaoFactory.getInstance().getStudentDao().list(null);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("list",list);
            request.getRequestDispatcher("page/student/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StudentDao studentDao = new StudentDao();
        List<Student> list = null;
        try {
            list = studentDao.list(null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("list",list);
        try {
            request.getRequestDispatcher("page/student/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
