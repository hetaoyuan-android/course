package com.yuan.javaweb.teacher.model;

import com.google.gson.Gson;
import com.yuan.javaweb.dbutils.DBUtil;

public class Course {

	private DBUtil dbUtil = new DBUtil();
	Gson gson = new Gson();
	/**
	 * 添加操作
	 */
	public void addCourse(String teacher,String cclass,String start,String end,String point){
		String sql = "insert into course (course_teacher,course_class,course_startTime,course_endTime,course_content) values ('"+teacher+
				"','"+cclass+"','"+start+"','"+end+"','"+point+"')";
		System.out.println(sql);
		dbUtil.update(sql);
	}
	/**
	 * 查询全部的操作
	 */
	public String queryAll(){
		String sql = "select * from course";
		System.out.println(sql);
		return gson.toJson(dbUtil.query(sql));
	}
	/**
	 * 查询一个的操作
	 */
	public String queryOne(String id1){
		int id = Integer.parseInt(id1);
		String sql = "select * from course where id = "+ id +"";
		System.out.println(sql);
		return gson.toJson(dbUtil.query(sql));
	}
	/**
	 * 修改操作
	 */
	public String updateCourse(String id1,String teacher,String cclass,String start,String end,String point){
		int id = Integer.parseInt(id1);
		String sql = "update course set course_teacher='"+teacher+"',course_class='"+cclass+"',course_startTime='"+start
				+"',course_endTime='"+end+"',course_content='"+point+"' where id="+id+"";
		System.out.println(dbUtil.update(sql));
		return gson.toJson(dbUtil.update(sql));
		
	}
	/**
	 * 删除操作
	 */
	public void delCourse(String id1){
		int id = Integer.parseInt(id1);
		String sql = "delete from course where id = "+id+"";
		dbUtil.update(sql);
	}
	
	/**
	 * 模糊查询
	 */
	public String search(String c_class,String teacher,String start,String end){
		String sql = "";
		if(c_class != "" && teacher != "" && start != "" && end != "" ){
			sql += "select * from course where course_class like '%"+c_class+"%' and course_teacher like '%"+ teacher 
					+"%' and course_startTime like '%"+start+"%' and course_endTime like '%"+end+"%'";
		}
		if(c_class != ""){
			sql += "select * from course where course_class like '%"+c_class+"%'";
			
			if(teacher != "" ){
				sql += "and course_teacher like '%"+ teacher +"%'";
			}
			if(start != ""){
				sql += "and course_startTime like '%"+start+"%'";
			}
			if(end != ""){
				sql += "and course_endTime like '%"+end+"%'";
			}
		}
		System.out.println(sql);
		return gson.toJson(dbUtil.query(sql));
	}
}
