package com.xsy.dao;

import com.xsy.po.Teacher;
import com.xsy.util.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TeacherDao {
    public void add(Teacher teacher) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "insert into s_teacher(username,password) values(?,?)";
        queryRunner.update(sql,teacher.getUsername(),teacher.getPassword());
    }

    public void delete(Integer id) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "delete from s_teacher where tid = ?";
        queryRunner.update(sql,id);
    }

    public void update(Teacher teacher) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "update s_teacher set username = ?,password = ? where tid = ?";
        queryRunner.update(sql,teacher.getUsername(),teacher.getPassword());
    }

    public List<Teacher> list(Teacher teacher) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
//        String sql = "select s_teacher.*,class.classname from s_teacher,class where class.tid = s_teacher.tid";
        String sql = "select * from s_teacher";
        List<Teacher> list = queryRunner.query(sql, new BeanListHandler<>(Teacher.class));
        return list;
    }

    public Teacher findById(Integer tid) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "select * from s_teacher where tid = ?";
        Teacher teacher = queryRunner.query(sql, new BeanHandler<>(Teacher.class),tid);
        return teacher;
    }
    //教师登录
    public Teacher login(String username,String password) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "select * from s_teacher where username = ? and password = ?";
        Teacher teacher = queryRunner.query(sql, new BeanHandler<>(Teacher.class),username,password);
        return teacher;
    }
}
