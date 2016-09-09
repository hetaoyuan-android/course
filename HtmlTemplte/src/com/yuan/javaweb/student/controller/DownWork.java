package com.yuan.javaweb.student.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownWork
 */
public class DownWork extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String headName = "" ;//文件名
		String fileUrl = request.getSession().getServletContext().getRealPath("/upload");
//		String fileUrl = "D:/upload/"; //文件路径
		if (headName.endsWith(".jpg") || (headName.endsWith(".gif"))) {
		} else if (headName.endsWith(".txt")) {
		response.setContentType("text;charset=GB2312");
		response.setHeader("Content-disposition", "attachment; filename="
		+ headName);
		} else {
		response.setContentType("application/doc;charset=GB2312");
		response.setHeader("Content-disposition", "attachment; filename="
		+ headName);
		}

		String fileURL = fileUrl;
		if (fileURL == null)
		return;

		try {
		File file = new File(fileUrl);
		FileInputStream bis = new FileInputStream(file);
		OutputStream bos = response.getOutputStream();

		byte[] buff = new byte[1024];
		int readCount = 0;
		int i = 0;
		readCount = bis.read(buff);
		while (readCount != -1) {
		bos.write(buff, 0, readCount);
		readCount = bis.read(buff);
		}
		if (bis != null)
		bis.close();
		if (bos != null)
		bos.close();

		} catch (Exception e) {
		e.printStackTrace();
		}*/
		String path = getServletContext().getRealPath("/upload");
		File obj = new File(path);
		if(!obj.exists()){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("error");
			return;
		}
		
		int index = path.lastIndexOf("\\");
		String fileName = path.substring(index + 1);
		ServletOutputStream out=response.getOutputStream();
		response.setHeader("Content-disposition","attachment;filename="+fileName);
		response.setContentType("application/doc;charset=GB2312");
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try {
			bis = new BufferedInputStream(new FileInputStream(path));
			bos = new BufferedOutputStream(out);

			byte[] buff = new byte[1024];
			int readCount = 0;
			int i = 0;
			readCount = bis.read(buff);
			while (readCount != -1) {
			bos.write(buff, 0, readCount);
			readCount = bis.read(buff);
			}
			if (bis != null)
			bis.close();
			if (bos != null)
			bos.close();

			} catch (Exception e) {
			e.printStackTrace();
			}
	
	}
	
}
