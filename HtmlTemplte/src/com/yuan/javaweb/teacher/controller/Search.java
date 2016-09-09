package com.yuan.javaweb.teacher.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.teacher.model.Course;

/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String c_class = request.getParameter("cClassCdt");
		String teacher = request.getParameter("cTeacherCdt");
		String start = request.getParameter("cBeginCdt");
		String end = request.getParameter("cEndCdt");
		Course search = new Course();
		response.getWriter().append(search.search(c_class, teacher, start, end));
	}

}
