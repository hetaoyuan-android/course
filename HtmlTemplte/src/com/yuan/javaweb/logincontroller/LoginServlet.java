package com.yuan.javaweb.logincontroller;

import java.io.IOException;
import java.util.List;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yuan.javaweb.loginbean.LoginBean;
import com.yuan.javaweb.logindao.LoginDao;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String chinese_name = request.getParameter("chinese_name");
		request.setAttribute("chinses_name", chinese_name);
		//当在地址栏中直接输入http://.....loginServle
		if(username == null || password == null){
			request.setAttribute("message", "不合法");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		
		List<Map<String, Object>> list = LoginDao.login(username, password);
		if(list != null && list.size()>0){
			LoginBean  userLogin = new  LoginBean();
			Map<String, Object> map = list.get(0);
			
			userLogin.setId(Integer.parseInt((String)map.get("id")));
			userLogin.setPassword(map.get("password").toString());
			userLogin.setRole((String) map.get("role"));
			userLogin.setUsername(map.get("account").toString());
			
			if(userLogin.getRole().equals("管理员")){
				request.getSession().setAttribute("name",map);
				response.sendRedirect(request.getContextPath()+"/admin_index.jsp");
				return;
			}
			if(userLogin.getRole().equals("老师")){
				request.getSession().setAttribute("name",map);
				response.sendRedirect(request.getContextPath()+"/teacher_index.jsp");
				return;
			}
			if(userLogin.getRole().equals("学生")){
				request.getSession().setAttribute("name",map);
				response.sendRedirect(request.getContextPath()+"/student_index.jsp");
				return;
			}
		}else{
			request.setAttribute("message", "用户名或者密码错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
