package com.yuan.javaweb.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.student.model.Student;

/**
 * Servlet implementation class EnvTeacher
 */
public class EnvTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String teacher = request.getParameter("teacher");
		String cbVal1 = request.getParameter("cbVal1");
		String cbVal2 = request.getParameter("cbVal2");
		String cbVal3 = request.getParameter("cbVal3");
		String cbVal4 = request.getParameter("cbVal4");
		String cbVal5 = request.getParameter("cbVal5");
		String advice = request.getParameter("advice");
		
		Student addEnv = new Student();
		addEnv.addEnv(teacher, cbVal1, cbVal2, cbVal3, cbVal4, cbVal5, advice);
		
		PrintWriter writer = response.getWriter();
		writer.write(new String("success".getBytes("utf-8")));
		
		writer.flush();
		writer.close();
	}

}
