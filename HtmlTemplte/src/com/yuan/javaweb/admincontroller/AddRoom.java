package com.yuan.javaweb.admincontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.adminmodel.Room;

/**
 * Servlet implementation class AddRoom
 */
public class AddRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("room_name");
		String school = request.getParameter("room_school");
		String number = request.getParameter("room_number");
		String status = request.getParameter("room_status");
		
		Room addRoom = new Room();
		addRoom.insertRoom(name, school, number, status);
		
		PrintWriter writer = response.getWriter();
		writer.write(new String("success".getBytes("utf-8")));
		
		//刷新和关闭
		writer.flush();
		writer.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}
	}


