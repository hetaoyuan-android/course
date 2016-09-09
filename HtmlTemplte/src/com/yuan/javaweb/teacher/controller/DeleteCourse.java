package com.yuan.javaweb.teacher.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.teacher.model.Course;
public class DeleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  id = request.getParameter("id");
		Course del = new Course();
		del.delCourse(id);
	}

}
