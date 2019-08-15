package com.atguigu.login.utls;
/**
 * @author admin
 *链接的工具类
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
//import com.sun.xml.internal.fastinfoset.sax.Properties;

import com.sun.media.jfxmedia.control.VideoDataBuffer;

public class connectionUtls {
	
	public static String driver =null;
	public static String url =null;
	public static String username =null;
	public static String password =null;
	public static Properties props = new Properties();
	
	//ThreadLocal:保证一个线程中只有一个连接。
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	
	/**
	 * 静态代码块读取db.properties
	 */
	
	static {
		
		//类加载器读取文件
		
		
			try {
				InputStream in = connectionUtls.class.getClassLoader().getResourceAsStream("db.properties");
				props.load(in);
				
				driver = props.getProperty("jdbc.driver");
				url = props.getProperty("jdbc.url");
				username = props.getProperty("jdbc.username");
				password = props.getProperty("jdbc.password");
				
				Class.forName(driver);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}
    /**
     * 获取连接的方法
     */
	public static Connection getconn() throws Exception{
		Connection conn = tl.get();
		if(conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			tl.set(conn);
		}
		return conn;
	}
	/*
	 * 关闭连接
	 */
	public static void closeconn() throws Exception {
		//尝试从tl中获取连接
		Connection conn = tl.get();
		if(conn != null) {
			conn.close();
		}
		tl.set(null);
	}
	public static void main(String[] args) throws Exception{
		Connection conn =  getconn();
		closeconn();
		Connection conn2 = getconn();
		System.out.println(conn == conn2);
	}
}
