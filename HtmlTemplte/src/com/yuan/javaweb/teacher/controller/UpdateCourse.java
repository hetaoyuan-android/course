package com.yuan.javaweb.teacher.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.teacher.model.Course;

public class UpdateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String id = request.getParameter("id");
		String teacher = request.getParameter("cTeacher");
		String cclass = request.getParameter("cClass");
		String start = request.getParameter("cBegin");
		String end = request.getParameter("cEnd");
		String point = request.getParameter("cPoint");
		Course update = new Course();
		update.updateCourse(id, teacher, cclass, start, end, point);
		
		PrintWriter writer = response.getWriter();
		writer.write(new String("success".getBytes("utf-8")));
		
		writer.flush();
		writer.close();
	}

}
