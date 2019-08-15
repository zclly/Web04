package com.atguigu.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.login.beans.User;
import com.atguigu.login.dao.UserDAO;
import com.atguigu.login.dao.UserDAOIpml;
import com.sun.prism.paint.Color;

/**
 * 处理登录请求的servlet
 * 
 * Servlet是sun公司制定的标准。Tomcat(web应用服务器、Servlet服务器）实现了这些标准。
 * 
 * HttpServlet: 
 */
public class LoginServlet extends HttpServlet {
/**
 * 常用方法：
 *   doget:处理客户端get方式的请求 
 *   dopost：处理客户端post方式的请求
 *   server:根据具体的请求方式去调用对应的doGet、doPost方法
 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//登录功能的实现。
		    System.out.println("登录请求过来啦。。。");
		    
		       //验证用户名输入的用户名和密码，进行登录验证
		    /**
		     * HttpServletRequest:请求对象。Servlet容器会在请求到达后，创建一个reques对象，
		        *                 将Http请求到的相关信息全部封装到该对象
		     */
		     
		    resp.setCharacterEncoding("utf-8");
		    //获取用户名
		    String username=req.getParameter("username");
		    //获取用户密码
		    String password=req.getParameter("password");
		    
		    System.out.println(username+","+password);
		    
		    //验证用户名和密码是否正确。
		    //通过响应对象HttpServletResponse,给客户端响应数据。
		    
		    resp.setContentType("text/html;charset=utf-8");
		    PrintWriter out = resp.getWriter();
		    //获取DAO对象
		    UserDAO userDAO = new UserDAOIpml();	
	
		    User user = userDAO.getUserByUsernameAndPassword(username, password);
		    
		    if(user == null) {
		    	//通过重定向的方式去往登录页面
		    	
		    	/*
		    	 * 服务器会给浏览器发送一个302的状态码以及一个新的地址。
		    	 */
		    	//resp.sendRedirect("login.jsp");
		    	
		    	/**
		    	 * 转发
		    	 */
		    	//转发之前，绑定数据，就是将想要交给下一个组件（jsp）处理的数据，绑定到request对象。
		    	req.setAttribute("login_msg", "用户名或密码错误！！！");
		    	//获取转发器
		    	RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		    	//开始转发
		    	rd.forward(req, resp);
		    	
		    	
		    	
		    	//登录成功
		    	//out.println("<h1><font color='green'>Login success!    登录成功<font><h1>");
		    }else {
		    	//登录失败
		    	//out.println("<h1><font color='green'>Login success!    登录成功<font><h1>");
		    	resp.sendRedirect("main.jsp");
		    	
		    }
		    
		    
		   
		}
		}