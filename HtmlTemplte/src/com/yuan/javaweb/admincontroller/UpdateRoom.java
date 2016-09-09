package com.yuan.javaweb.admincontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.adminmodel.Room;

/**
 * Servlet implementation class UpdateRoom
 */
public class UpdateRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("roomName");
		String school = request.getParameter("roomSchool");
		String number = request.getParameter("roomNumber");
		String status = request.getParameter("roomStatus");
		
		Room update = new Room();
		update.updateRoom(id, name, school, number, status);
		PrintWriter writer = response.getWriter();
		writer.write(new String("success".getBytes("utf-8")));
		
		writer.flush();
		writer.close();
	}

}
