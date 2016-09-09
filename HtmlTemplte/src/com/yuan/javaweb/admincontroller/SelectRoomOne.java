package com.yuan.javaweb.admincontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.adminmodel.Room;

/**
 * Servlet implementation class SelectRoomOne
 */
public class SelectRoomOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		String id = request.getParameter("id");
		Room selectOneId = new Room();
		response.getWriter().append(selectOneId.selectOneId(id));
	}

}
