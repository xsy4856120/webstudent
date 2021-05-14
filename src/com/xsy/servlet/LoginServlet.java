package com.xsy.servlet;

import com.xsy.dao.AdminDao;
import com.xsy.dao.StudentDao;
import com.xsy.dao.TeacherDao;
import com.xsy.po.Admin;
import com.xsy.po.Student;
import com.xsy.po.Teacher;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        HttpSession httpSession = req.getSession();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(type)) {
            req.setAttribute("error", "输入不能为空!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        else{
        try {
            if ("0".equals(type)) {
                //学生登陆验证
                Student student = new StudentDao().login(username, password);
                if (student != null) {
                    httpSession.setAttribute("username", student);
                    httpSession.setAttribute("type", type);
                    resp.sendRedirect("index.jsp");
                } else {
                    req.setAttribute("error", "用户名或密码错误!");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            }else if ("1".equals(type)) {
                //教师登陆验证
                Teacher teacher = new TeacherDao().login(username, password);
                if (teacher != null) {
                    httpSession.setAttribute("username", teacher);
                    httpSession.setAttribute("type", type);
                    resp.sendRedirect("index.jsp");
                }else {
                    req.setAttribute("error", "用户名或密码错误!");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            } else {
                //管理员登陆验证
                Admin admin = new Admin();
                admin.setUsername(username);
                admin.setPassword(password);
                Admin entity = new AdminDao().login(admin);
                if (entity != null) {
                    //进行跳转
                    httpSession.setAttribute("username", entity);
                    httpSession.setAttribute("type", type);
                    resp.sendRedirect("index.jsp");
                } else {
                    req.setAttribute("error", "用户名或密码错误!");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }}
    }
}
