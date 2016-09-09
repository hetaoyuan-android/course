package com.yuan.javaweb.adminmodel;

import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;
import com.yuan.javaweb.dbutils.DBUtil;

public class UserBean {

	private static DBUtil jdbcUtil = new DBUtil();
	private static Gson gson = new Gson();
	private static Page page = new Page();
	public static String getAllUser(String pageNum,String pageSize){
		if(!StringUtils.isNullOrEmpty(pageNum)){
			int beginIdx = (Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize);
			String sql = "SELECT * FROM add_account limit " + beginIdx + "," + pageSize;
			System.out.println(sql);
			page.setList(jdbcUtil.query(sql));
		}
		String countSql = "SELECT count(*) FROM add_account";
		page.setCount(jdbcUtil.execCount(countSql));
		return gson.toJson(page);//{list:[{},{},{}],pageSize:90}
	}
	public static String getAllRoomPage(String pageNum,String pageSize){
		if(!StringUtils.isNullOrEmpty(pageNum)){
			int beginIdx = (Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize);
			String sql = "SELECT * FROM room limit " + beginIdx + "," + pageSize;
			System.out.println(sql);
			page.setList(jdbcUtil.query(sql));
		}
		String countSql = "SELECT count(*) FROM room";
		page.setCount(jdbcUtil.execCount(countSql));
		return gson.toJson(page);//{list:[{},{},{}],pageSize:90}
	}
	
}
