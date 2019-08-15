package com.atguigu.login.dao;

import com.atguigu.login.beans.User;

public interface UserDAO {
	public User getUserByUsernameAndPassword(String username,String password);

	public User getUserByUsername(String username);
	//如果注册的信息特别多的话，一定要封装成对象传递。
	public void inserUser(String username,String password);

}
