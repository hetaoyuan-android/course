package com.yuan.javaweb.admincontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.adminmodel.SysClass;

public class SearchClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("class_name");
		String stage = request.getParameter("class_stage");
		String startTime = request.getParameter("class_startTime");
		String endTime = request.getParameter("class_endTime");
		SysClass search = new SysClass();
		response.getWriter().append(search.searchClass(name, stage, startTime, endTime));
	}

}
