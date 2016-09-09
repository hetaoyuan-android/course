package com.yuan.javaweb.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.student.model.Student;

/**
 * Servlet implementation class ShowWork
 */
public class ShowWork extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student show = new Student();
		response.getWriter().append(show.showWork());
	}

}
