package com.xsy.dao;

import com.xsy.po.Admin;
import com.xsy.util.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDao {


    public void add(Admin admin) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "insert into s_admin(username,password) values(?,?,?)";
        queryRunner.update(sql, admin.getUsername(), admin.getPassword());
    }

    public void delete(Integer id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "delete from s_admin where id = ?";
        queryRunner.update(sql, id);
    }

    public void update(Admin admin) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "update s_admin set username = ?,password = ? where id = ?";
        queryRunner.update(sql, admin.getUsername(), admin.getPassword());
    }

    public List<Admin> list(Admin admin) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "select * from s_admin";
        List<Admin> list = queryRunner.query(sql, new BeanListHandler<>(Admin.class));
        return list;
    }

    public Admin findById(Integer id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "select * from s_admin where id = ?";
        Admin admin = queryRunner.query(sql, new BeanHandler<>(Admin.class), id.getClass());
        return admin;
    }
//管理员登录
    public Admin login(Admin admin) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "select * from s_admin where username = ? and password =?";
        Admin entity = queryRunner.query(sql, new BeanHandler<>(Admin.class),admin.getUsername(),admin.getPassword());
        return entity;
    }
}