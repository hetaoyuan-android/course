package com.yuan.javaweb.teacher.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.teacher.model.Course;

public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teacher = request.getParameter("teacher");
		String cclass = request.getParameter("cclass");
		String cBegin = request.getParameter("cBegin");
		String cEnd = request.getParameter("cEnd");
		String cPoint = request.getParameter("cPoint");
		Course add = new Course();
		add.addCourse(teacher, cclass, cBegin, cEnd, cPoint);
		PrintWriter writer = response.getWriter();
		writer.write(new String("success".getBytes("utf-8")));
		
		writer.flush();
		writer.close();
	}

}
