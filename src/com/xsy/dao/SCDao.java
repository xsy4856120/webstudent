package com.xsy.dao;

import com.xsy.po.Course;
import com.xsy.po.Class;
import com.xsy.util.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class SCDao {
    public void add(Course course) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "insert into s_course(score,cid,stuid) values(?,?,?)";
        queryRunner.update(sql,course.getScore(),course.getCid(),course.getStuid());
    }

    public void delete(Integer id) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "delete from s_course where scid = ?";
        queryRunner.update(sql,id);
    }

    public void update(Course course) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "update s_course set score = ? where scid = ?";
        queryRunner.update(sql,course.getScore(),course.getScid());
    }

    public List<Course> list(Course course) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "select * from s_course";
        List<Course> list = queryRunner.query(sql, new BeanListHandler<>(Course.class));
        return list;
    }

    public Course findById(Integer scid) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "select * from s_course where scid = ?";
        Course course = queryRunner.query(sql, new BeanHandler<>(Course.class),scid);
        return course;
    }
}
