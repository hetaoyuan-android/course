package com.yuan.javaweb.student.model;

import com.google.gson.Gson;
import com.yuan.javaweb.dbutils.DBUtil;

public class Student {

	private DBUtil dbUtil = new DBUtil();
	Gson gson = new Gson();
	/**
	 * 查询出席情况
	 * @param num
	 * @return
	 */
	public String query(String num){
		int number = Integer.parseInt(num);
		String sql = "SELECT s.*,c_s_p.course_content,c_s_p.STATUS,c_s_p.course_class FROM student s ,(SELECT c.*,p.fk_stu_id,p.STATUS FROM presence p,course c WHERE p.fk_course_id = c.id) c_s_p WHERE c_s_p.fk_stu_id = s.id AND stu_num = "+number+"";
		System.out.println(dbUtil.query(sql));
		return gson.toJson(dbUtil.query(sql));
	}
	
	/**
	 * 添加评论
	 */
	public void addEnv(String teacher,String teach,String wear,String time,String technique,String lessons,String advice){
		String sql = "insert into envluate (env_teacher,teach,wear,time,technique,lessons,advice) values ('"+teacher+"','"+
				teach+"','"+wear+"','"+time+"','"+technique+"','"+lessons+"','"+advice+"')";
		System.out.println(sql);
		gson.toJson(dbUtil.update(sql));
	}
	
	/**
	 * 查看老师布置的作业
	 */
	public String showWork(){
		String sql = "SELECT * FROM WORK";
		System.out.println(dbUtil.query(sql));
		return gson.toJson(dbUtil.query(sql));
	}
}
