package com.xsy.dao;

import com.xsy.po.Student;
import com.xsy.util.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    public void add(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "insert into s_student(username,password) values(?,?)";
        queryRunner.update(sql,student.getUsername(),student.getPassword());
    }

    public void delete(Integer id) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "delete from s_student where stuid = ?";
        queryRunner.update(sql,id);
    }

    public void update(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "update s_student set username = ?,password = ? where stuid = ?";
        queryRunner.update(sql,student.getUsername(),student.getPassword());
    }

    public List<Student> list(Student student) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "select * from s_student";

        List<Student> list = queryRunner.query(sql, new BeanListHandler<>(Student.class));
        return list;
    }

    public Student findById(Integer stuid) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "select * from s_student where stuid = ?";
        Student student = queryRunner.query(sql, new BeanHandler<>(Student.class),stuid);
        return student;
    }

    //学生登陆
    public Student login(String username,String password) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "select * from s_student where username = ? and password = ?";
        Student student = queryRunner.query(sql, new BeanHandler<>(Student.class),username,password);
        return student;
    }
}
