package com.atguigu.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.login.beans.User;
import com.atguigu.login.dao.UserDAO;
import com.atguigu.login.dao.UserDAOIpml;

/**
 * Servlet implementation class CheakUsernameServlet
 */
public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取到用户名
		String username = request.getParameter("username");

		UserDAO userDAO = new UserDAOIpml();
		
		User user = userDAO.getUserByUsername(username);
		
		String msg ="";
		
		if(user ==null ) {
			//用户名可用。
			msg = "0";
			
		}else {
			//用户名不可用。
			msg = "1";
		}
		
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().println(msg);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
