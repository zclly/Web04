package com.atguigu.login.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.login.beans.User;
import com.atguigu.login.dao.UserDAO;
import com.atguigu.login.dao.UserDAOIpml;

public class RegistServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//注册业务处理：
		//1.获取到用户提交的信息。
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//2.判断用户名是否可用。
		UserDAO userDAO = new UserDAOIpml();
		
		User user = userDAO.getUserByUsername(username);
		if(user != null) {
			//注册失败,回到注册页面，并进行相应的提示。
			//转发
			req.setAttribute("regist_msg", "用户名已存在！");
			req.getRequestDispatcher("regist.jsp").forward(req, resp);
		}else {
			//可以注册
			//3.将获取到的信息写入到数据库中。
			userDAO.inserUser(username, password);
		    //注册成功去往登录页面。
			resp.sendRedirect("login.jsp");
		}
	} 
}
