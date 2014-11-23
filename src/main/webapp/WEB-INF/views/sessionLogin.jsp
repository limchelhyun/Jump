<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("jumpId", (String)request.getParameter("username"));
	response.sendRedirect("/list");
%>