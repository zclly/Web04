<!-- JSP声明 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 文档类型 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1 align="center">我是html代码</h1>
    <!-- 
    java代码：
    java片段：
        .表达式
     -->
     <!-- java片段 -->
     <%
     String str ="abc";
     System.out.println("abc");
     %>	
     <!--表达式 -->
     <%= 5>3?"大于":"小于" %> 
     <!-- JSP页面执行原理 ：
         JSP本质上就是一个servlet，执行的时候就会转化为一个.java文件，在编译成.class文件。
         如何转化：
         java代码照搬
         html,css,js,表达式等通过输出流out.write()方法往外写。
      作用：
                 可以自动的将HTML相关的代码通过流的方式写给浏览器。
                 支持写java代码，可以灵活的做一些处理。 
     -->
</body>
</html>