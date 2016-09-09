package com.yuan.javaweb.admincontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.adminmodel.Room;

/**
 * Servlet implementation class SearchRoom
 */
public class SearchRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String name = request.getParameter("room_name");
		String school = request.getParameter("room_school");
		String number = request.getParameter("room_number");
		String status = request.getParameter("room_status");
		
		Room search = new Room();
		response.getWriter().append(search.searchRoom(name, school, number, status));
	}

}
