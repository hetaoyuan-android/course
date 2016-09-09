package com.yuan.javaweb.adminmodel;

import com.google.gson.Gson;
import com.yuan.javaweb.dbutils.DBUtil;

public class SysClass {
	
	private DBUtil dbUtil = new DBUtil();
	Gson gson = new Gson();
	
	/**
	 * 新增班级
	 */
	public void addClass(String name,String stage,String startTime,String endTime,String courseAll,String room,String status,String teacher){
		String sql = "insert into s_class (class_name,class_stage,class_startTime,class_endTime,class_courseAll,class_room,class_status,class_teacher) values ('"+ name
				+"','"+ stage +"','"+ startTime +"','"+ endTime +"','"+ courseAll +"','" + room + "','"+ status +"','"+ teacher +"')";
	System.out.println(sql);
	dbUtil.update(sql);
	}
	
	/**
	 * 查询全部的班级
	 */
	public String queryAll(){
		String sql = "select * from s_class";
		System.out.println(dbUtil.query(sql));
		return gson.toJson(dbUtil.query(sql));
	}
	/**
	 * 删除班级操作
	 */
	public void delClass(String id1){
		int id = Integer.parseInt(id1);
		String sql = "delete from s_class where id="+ id +"";
		System.out.println(sql);
		dbUtil.update(sql);
	}
	/**
	 * 查询一个班级
	 */
	public String selectOne(String id1){
		int id = Integer.parseInt(id1);
		String sql = "select * from s_class where id="+ id +"";
		System.out.println(dbUtil.query(sql));
		return gson.toJson(dbUtil.query(sql));
		
	}
	/**
	 * 修改一个班级
	 */
	public	void updateAll(String id1,String name,String stage,String startTime,String endTime,String courseAll,String room,String status,String teacher){
		int id = Integer.parseInt(id1);
		String sql = "update s_class set class_name='"+name+"',class_stage='"+stage+"',class_startTime='"+ startTime +"',class_endTime='"+ endTime 
				+"', class_courseAll='"+ courseAll +"',class_room='"+ room +"',class_status='" + status + "',class_teacher='"+teacher+"' where id="+id+"";
		System.out.println(dbUtil.update(sql));
		dbUtil.update(sql);
	}
	/**
	 * 模糊查询
	 */
	public String searchClass(String name,String stage,String startTime,String endTime){
	//	String sql = "select * from s_class where class_name like '%"+ name +"%' or class_stage like '%"+stage+"%' or class_startTime like '%"+ startTime +"%' or class_endTime like '%"+endTime+"%'";
	//	String sql = "select * from s_class where class_name='"+ name +"' or class_stage='"+stage+"' or class_startTime='"+ startTime +"' or class_endTime='"+endTime+"'";
		String sql = "";
		if(name != "" && stage != "" && startTime != "" && endTime != ""){
			sql += "select * from s_class where class_name like '%"+ name +"%' and class_stage like '%"+stage+"%' and class_startTime like '%"+ startTime +"%' and class_endTime like '%"+endTime+"%'";
		}
		if(name != ""){
			sql += "select * from s_class where class_name like '%"+ name +"%'";
			
			if(stage != ""){
				sql += "and class_stage like '%"+stage+"%'";
			}
			if(startTime != ""){
				sql += "and class_startTime like '%"+ startTime +"%'";
			}
			if(endTime != ""){
				sql += "and class_endTime like '%"+endTime+"%'";
			}
		}
		
		System.out.println(sql);
		return gson.toJson(dbUtil.query(sql));
		
	}
}
