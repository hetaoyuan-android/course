package com.yuan.javaweb.admincontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.adminmodel.SysClass;

public class UpdateClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("class_name");
		String stage = request.getParameter("class_stage");
		String startTime = request.getParameter("class_startTime");
		String endTime = request.getParameter("class_endTime");
		String courseAll = request.getParameter("class_timeAll");
		String room = request.getParameter("class_room");
		String status =  request.getParameter("class_status");
		String teacher = request.getParameter("class_teacher");
		
		SysClass updateClass = new SysClass();
		updateClass.updateAll(id, name, stage, startTime, endTime, courseAll, room, status, teacher);
		PrintWriter writer = response.getWriter();
		writer.write(new String("success".getBytes("utf-8")));
		
		writer.flush();
		writer.close();
		
	}

}
