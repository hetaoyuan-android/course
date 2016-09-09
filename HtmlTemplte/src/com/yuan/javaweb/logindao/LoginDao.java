package com.yuan.javaweb.logindao;

import java.util.List;
import java.util.Map;



import com.yuan.javaweb.dbutils.DBUtil;

public class LoginDao {

	
	private static DBUtil jdbcUtil = new DBUtil();
	
	public static List<Map<String,Object>>  login(String username,String password){
		String sql = "select * from add_account where account= ? and password=?";
		String[] strArr = {username,password};
		List<Map<String,Object>> list = jdbcUtil.preparedQuery(sql, strArr);
		return list;
	}
}
