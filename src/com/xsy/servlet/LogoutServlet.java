package com.xsy.servlet;

import com.xsy.dao.AdminDao;
import com.xsy.dao.StudentDao;
import com.xsy.dao.TeacherDao;
import com.xsy.po.Admin;
import com.xsy.po.Student;
import com.xsy.po.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("login.jsp");
    }
}
