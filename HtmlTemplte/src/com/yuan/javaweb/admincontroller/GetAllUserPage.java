package com.yuan.javaweb.admincontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.adminmodel.UserBean;

public class GetAllUserPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		response.getWriter().append(UserBean.getAllUser(pageNum, pageSize));
	}

}
