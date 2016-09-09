package com.yuan.javaweb.admincontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.adminmodel.AAdmin;

/**
 * Servlet implementation class UpdateAdmin
 */
public class UpdateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String school = request.getParameter("school");
		String profession = request.getParameter("profession");
		String role = request.getParameter("role");
		String qq = request.getParameter("qq");
		String phone = request.getParameter("phone");
		String chinese_name = request.getParameter("chinese_name");
		String grade = request.getParameter("grade");
		String province = request.getParameter("province");
		String status = request.getParameter("status");
		
		AAdmin update = new AAdmin();
		update.updateAdmin(id, account, password, sex, school, profession, role, qq, phone, chinese_name, grade, province, status);
		PrintWriter writer = response.getWriter();
		writer.write(new String("success".getBytes("utf-8")));
		
		writer.flush();
		writer.close();
	}

}
