package com.atguigu.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.atguigu.login.beans.User;
import com.atguigu.login.utls.connectionUtls;


public class UserDAOIpml implements UserDAO{
	 
	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		User u = null;
		
		// 获取连接，编写SQL语句，预编译SQL，设置参数，执行SQL，封装结果，关闭连接。
				try {
					/*Class.forName("com.mysql.jdbc.Driver");
					String url ="jdbc:mysql://localhost:3306/";
					String user="root";
					String pawd="123456";
					Connection conn = DriverManager.getConnection(url, user, pawd);*/
					Connection conn = connectionUtls.getconn();
					String sql ="select id,username,password from tbl_user where username=? and password=?";
					PreparedStatement ps =  conn.prepareStatement(sql);
					ps.setString(1, username);
					ps.setString(2, password);
					
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {//因为rs.next()返回的是true 和false 如果集合中有数据返回的就是true
						u = new User();
						u.setId(rs.getInt("id"));
						u.setUsername(rs.getString("username"));
						u.setPassword(rs.getString("password"));
					}
					return u;
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						connectionUtls.closeconn();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
	            return null;
            }
	@Override
	public User getUserByUsername(String username) {
        User u = null;
		try {
			Connection conn = connectionUtls.getconn();
			String sql ="select id,username,password from tbl_user where username=?";
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {//因为rs.next()返回的是true 和false 如果集合中有数据返回的就是true
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connectionUtls.closeconn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
        return null;
	}
	
	@Override
	public void inserUser(String username, String password) {
		try {
			Connection conn = connectionUtls.getconn();
			
			String sql = "insert into tbl_user (username,password) value(?,?)";
			
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2, password);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connectionUtls.closeconn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }

	
}
