package com.yuan.javaweb.admincontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.adminmodel.AAdmin;

/**
 * Servlet implementation class SearchAdmin
 */
public class SearchAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String cClassCdt = request.getParameter("cClassCdt");
		String cProvCdt = request.getParameter("cProvCdt");
		String cSchoolCdt = request.getParameter("cSchoolCdt");
		String cProCdt = request.getParameter("cProCdt");
		String cNameCdt = request.getParameter("cNameCdt");
		
		AAdmin seacrch = new AAdmin();
		response.getWriter().append(seacrch.searchAdmin(cClassCdt, cProvCdt, cSchoolCdt, cProCdt, cNameCdt));
	}

}
