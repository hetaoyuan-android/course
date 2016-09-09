package com.yuan.javaweb.teacher.model;

import com.google.gson.Gson;
import com.yuan.javaweb.dbutils.DBUtil;

public class Presence {

	private DBUtil dbUtil = new DBUtil();
	Gson gson = new Gson();
	
	public String query(String id1){
		int id = Integer.parseInt(id1);
//		String sql = "SELECT  course.*,student.* FROM  course,student,course_link_stu cls WHERE course.id = cls.course_id AND student.id = cls.student_id";
		String sql = "SELECT * FROM student where cou_id="+id+"";
		System.out.println(sql);
		return gson.toJson(dbUtil.query(sql));
	}
	
	public String update(String id1,String state){
		int id = Integer.parseInt(id1);
		String sql = "update presence set status='"+state+"' where fk_stu_id="+id+" ";
		System.out.println(sql);
		return gson.toJson(dbUtil.update(sql));
	}
	
	public String count(){
		String sql = "SELECT s.* ,pc.num ,pc.STATUS FROM student s INNER JOIN (SELECT COUNT(*) num ,p.fk_stu_id, p.STATUS  FROM presence p GROUP BY p.fk_stu_id )pc ON s.id = pc.fk_stu_id ORDER BY num DESC";
		return gson.toJson(dbUtil.query(sql));
	}
	
}
