package com.yuan.javaweb.admincontroller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.adminmodel.SysClass;

public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("class_name");
		String stage = request.getParameter("class_stage");
		String startTime = request.getParameter("class_startTime");
		String endTime = request.getParameter("class_endTime");
		String courseAll = request.getParameter("class_courseAll");
		String room = request.getParameter("class_room");
		String status =  request.getParameter("class_status");
		String teacher = request.getParameter("class_teacher");
		
		SysClass add = new SysClass();
		add.addClass(name, stage, startTime, endTime, courseAll, room, status, teacher);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(new String("success".getBytes("utf-8")));
		
		printWriter.flush();
		printWriter.close();
	
	}

}
