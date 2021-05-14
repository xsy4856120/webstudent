package com.xsy.dao;

import com.xsy.po.Class;
import com.xsy.po.Course;
import com.xsy.po.Teacher;
import com.xsy.util.PageInfo;
import com.xsy.util.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CourseDao {
//    public void add(Class Class) throws SQLException {
//        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
//        String sql = "insert into class(classname,tid) values(?,?)";
//        queryRunner.update(sql,Class.getUsername(),Class.getTid());
//    }

    public void delete(Integer id) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "delete from class where cid = ?";
        queryRunner.update(sql,id);
    }

    public void update(Class Class) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String sql = "update class set classname = ? where cid = ?";
        queryRunner.update(sql,Class.getTeacher().getUsername());
    }

    public List<Class> list(Class course, PageInfo<Class> pageInfo) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
        String _sql = "";
        List<Object> _list = new ArrayList<Object>();
        if(course != null && course.getCid() != null) {
            _sql += " and cid = ?";
            _list.add(course.getCid());
        }
        if(course != null && StringUtils.isNoneBlank(course.getcName())) {
            _sql += " and classname like ?";
            _list.add("%"+course.getcName()+"%");
        }
        if(course != null && StringUtils.isNoneBlank(course.getTeacher().getUsername())) {
            _sql += " and username like ?";
            _list.add("%"+course.getTeacher().getUsername()+"%");
        }
        if(course != null && course.getTeacher().getTid() != null) {
            _sql += " and course.tid  = ?";
            _list.add(course.getTeacher().getTid());
        }
        //_list转数组
        Object[] arr = new Object[_list.size()];
        for (int i=0;i<_list.size();i++) {
            arr[i] = _list.get(i);
        }
        //TODO
        String sql = "select class.*,s_teacher.username from class,s_teacher where class.tid = s_teacher.tid "+_sql+" limit  "+(pageInfo.getPageNo()-1)*pageInfo.getPageSize()+" , "+pageInfo.getPageSize();
        System.out.println(sql);
        System.out.println(Arrays.toString(arr));
        //List<Course> list = queryRunner.query(sql, new BeanListHandler<>(Course.class),arr);
        List<Map<String, Object>> Maplist = queryRunner.query(sql, new MapListHandler(),arr);
        //设置list集合
        List<Course> list = new ArrayList<>();
        //list<Map> -->list<Course>转换过程
//        for (Map map :Maplist) {
//            Class entity = new Class();
//            entity.setCid(Integer.parseInt(map.get("cId")+""));
//            entity.setcName(map.get("cName")+"");
//            Teacher teacher = new Teacher();
//            teacher.setTid(Integer.parseInt(map.get("tId")+""));
//            teacher.setUsername(map.get("userName")+"");
//            list.add(entity);
//        }
//        pageInfo.setList(list);
//        pageInfo.setTotalCount(this.count(course));
        return null;
    }

//    public Class findById(Integer cid) throws SQLException{
//        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSource());
//        String sql = "select * from class where cid = ?";
//        Class Class = queryRunner.query(sql, new BeanHandler<>(Class.class),cid);
//        return Class;
//    }
}
