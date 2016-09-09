package com.yuan.javaweb.teacher.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.teacher.model.Envlaute;

/**
 * Servlet implementation class QueryEnvAdv
 */
public class QueryEnvAdv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teacher = request.getParameter("teacher");
		Envlaute advice = new Envlaute();
		response.getWriter().append(advice.queryAdvice(teacher));
	}

}
