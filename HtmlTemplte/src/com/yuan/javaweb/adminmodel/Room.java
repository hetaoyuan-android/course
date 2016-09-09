package com.yuan.javaweb.adminmodel;

import com.google.gson.Gson;
import com.yuan.javaweb.dbutils.DBUtil;

public class Room {

	private DBUtil dbUtil = new DBUtil();
	Gson gson = new Gson();
	
	/**
	 * 查询全部教室
	 */
	public String queryRoom(){
		String sql = "select * from room";
		System.out.println(dbUtil.query(sql));
		return gson.toJson(dbUtil.query(sql));
	}
	
	/**
	 * 插入教室
	 */
	public void insertRoom(String name,String school,String number1,String status){
		int number = Integer.parseInt(number1);
		String sql = "insert into room (room_name,room_school,room_number,room_status) values ('"+ name 
				+"','"+ school +"',"+ number +",'"+ status +"')";
		System.out.println(sql);
		dbUtil.update(sql);
	}
	
	/**
	 * 模糊查询
	 */
	public String searchRoom(String name,String school,String number,String status){
//		String sql = "select * from room where room_name='"+ name +"' or room_school='" + school 
//				+ "'or room_number='"+ number +"' or room_status='" + status + "'";
		String sql = "";
		if(name != "" && school != "" && number != "" && status != ""){
			sql += "select * from room where room_name like '%"+name+"%' and room_school like '%"+school
					+"%' and room_number like '%"+number+"%' and room_status like '%"+status+"%' "; 
		}
		if(name != ""){
			sql += "select * from room where room_name like '%"+name+"%' ";
			
			if(school != ""){
				sql += "and room_school like '%"+school+"%' ";
			}
			if(number !=  ""){
				sql += "and room_number like '%"+number+"%'";
			}
			if(status != ""){
				sql += "and room_status like '%"+status+"%' ";
			}
		}
		System.out.println(sql);
		System.out.println(dbUtil.query(sql));
		return gson.toJson(dbUtil.query(sql));
	}
	
	/**
	 * 根据id查询一个教室的信息
	 */
	public String selectOneId(String id1){
		int id = Integer.parseInt(id1);
		String sql = "select * from room where id="+ id +"";
		System.out.println(dbUtil.query(sql));
		return gson.toJson(dbUtil.query(sql));
	}
	
	/**
	 * 修改教室信息
	 */
	public String updateRoom(String id1,String name,String school,String number1,String status){
		int id = Integer.parseInt(id1);
		int number = Integer.parseInt(number1);
		String sql = "update room set room_name='"+ name +"',room_school='"+ school 
				+"',room_number="+ number +",room_status='"+ status +"' where id="+id+"";
		System.out.println(dbUtil.update(sql));
		return gson.toJson(dbUtil.update(sql));
		
	}
	
	/**
	 * 删除教室
	 */
	public void delRoom(String id1){
		int id = Integer.parseInt(id1);
		String sql = "delete from room where id="+ id +"";
		System.out.println(sql);
		dbUtil.update(sql);
	}
}
