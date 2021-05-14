package com.xsy.util;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	private  String webUrl = "jdbc:mysql://localhost:3306/web_student?useUnicode=true&characterEncoding=utf8"; // ���ݿ����ӵ�ַ
	private String webUserName = "root";
	private String webPassword = "123456";
	private String jdbcName = "com.mysql.cj.jdbc.Driver"; // 驱动名称

	private static Properties properties = new Properties();

	static {
		try {
			InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream("db.properties");
			properties.load(inputStream);
			System.out.println("连接成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource(){
		try {
			System.out.println("连接成功！");
			return 	BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		PropertiesUtils propertiesUtils = new PropertiesUtils();
	}

	//获取数据库数据
//	public Connection getCon() {
//		try {
//			Class.forName(jdbcName);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Connection con = null;
//		try {
//			con = DriverManager.getConnection(webUrl, webUserName, webPassword);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return con;
//	}
//
//	/**
//	 * 关闭数据库
//	 *
//	 * @param con
//	 * @throws Exception
//	 */
//	public void closeCon(Connection con) throws Exception {
//		if (con != null) {
//			con.close();
//		}
//	}
//
//	public static void main(String[] args) {
//		PropertiesUtils dbUtil = new PropertiesUtils();
//		try {
//			dbUtil.getCon();
//			System.out.println("数据库连接成功！");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("数据库连接失败！");
//		}
//	}
}
