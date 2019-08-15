package com.atguigu.login.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//演示Cookie
		Cookie cookie = new Cookie("username", "Admin");
		
		//保存到浏览器端
		response.addCookie(cookie);
		
		//cookie的默认时效就是当前浏览器的内存。
		
		//设置cookie的保存时间
		//cookie.setMaxAge("5");
		
		//设置cookie的路径,默认的路径就是web应用名。
		//cookie.setPath(uri);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
