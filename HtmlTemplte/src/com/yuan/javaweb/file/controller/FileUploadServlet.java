package com.yuan.javaweb.file.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuan.javaweb.dbutils.DBUtil;
import com.yuan.javaweb.dbutils.UploadUtil;
import com.yuan.javaweb.file.model.FileBean;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FileUploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		DBUtil dbutil = new DBUtil();
		Map<String,Object> map = UploadUtil.getFileUpload(request);
		
		String teac = (String) map.get("teacher");
		String wtime = (String) map.get("wtime");
		String wclass = (String) map.get("wclass");
		String filename = (String) map.get("filename");
		
		String sql = "insert into work (w_teacher,w_class,finish_time,w_content) values ('"+teac+"','"+wclass+"','"+wtime+"','"+filename+"')";
		System.out.println(sql);
		dbutil.update(sql);
//		System.out.println(map.size());
//		System.out.println(teac);
//		request.getRequestDispatcher("/teacher_index.jsp").forward(request, response);
		response.sendRedirect("teacher_index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
