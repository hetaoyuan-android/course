package com.yuan.javaweb.teacher.model;

import com.google.gson.Gson;
import com.yuan.javaweb.dbutils.DBUtil;

public class Envlaute {
	private DBUtil dbUtil = new DBUtil();
	Gson gson = new Gson();
	
	public String queryEnv(String teacher){
		System.out.println("----->"+teacher);
		//(SELECT env_teacher,wear,COUNT(*) counts FROM envluate GROUP BY env_teacher,wear
		String sql ="SELECT * FROM (SELECT env_teacher,'串课、代课方面' countType," +
				"SUM(CASE teach WHEN '优' THEN 1 ELSE 0 END) Y," +
				"SUM(CASE teach WHEN '良' THEN 1 ELSE 0 END) l," +
				"SUM(CASE teach WHEN '中' THEN 1 ELSE 0 END) z," +
				"SUM(CASE teach WHEN '差' THEN 1 ELSE 0 END) c "+
				" FROM (SELECT env_teacher,teach,COUNT(*) counts FROM envluate GROUP BY env_teacher,teach) teach GROUP BY env_teacher UNION SELECT env_teacher,'穿着得体方面' countType," +
				"SUM(CASE wear WHEN '优' THEN 1 ELSE 0 END) Y," +
				"SUM(CASE wear WHEN '良' THEN 1 ELSE 0 END) l," +
				"SUM(CASE wear WHEN '中' THEN 1 ELSE 0 END) z," +
				"SUM(CASE wear WHEN '差' THEN 1 ELSE 0 END) c" +
				" FROM (SELECT env_teacher,wear,COUNT(*) counts FROM envluate GROUP BY env_teacher,wear) wear GROUP BY env_teacher UNION SELECT env_teacher,'迟到早退方面' countType," +
				"SUM(CASE TIME WHEN '优' THEN 1 ELSE 0 END) Y," +
				"SUM(CASE TIME WHEN '良' THEN 1 ELSE 0 END) l," +
				"SUM(CASE TIME WHEN '中' THEN 1 ELSE 0 END) z," +
				"SUM(CASE TIME WHEN '差' THEN 1 ELSE 0 END) c" +
				" FROM (SELECT env_teacher,TIME,COUNT(*) counts FROM envluate GROUP BY env_teacher,technique) TIME GROUP BY env_teacher UNION " +
				" SELECT env_teacher,'技术高度是否满意' countType," +
				"SUM(CASE technique WHEN '优' THEN 1 ELSE 0 END) Y," +
				"SUM(CASE technique WHEN '良' THEN 1 ELSE 0 END) l," +
				"SUM(CASE technique WHEN '中' THEN 1 ELSE 0 END) z," +
				"SUM(CASE technique WHEN '差' THEN 1 ELSE 0 END) c" +
				" FROM (SELECT env_teacher,technique,COUNT(*) counts FROM envluate GROUP BY env_teacher,technique) technique GROUP BY env_teacher UNION" +
				" SELECT env_teacher,'备课充分' countType," +
				"SUM(CASE lessons WHEN '优' THEN 1 ELSE 0 END) Y," +
				"SUM(CASE lessons WHEN '良' THEN 1 ELSE 0 END) l," +
				"SUM(CASE lessons WHEN '中' THEN 1 ELSE 0 END) z," +
				"SUM(CASE lessons WHEN '差' THEN 1 ELSE 0 END) c" +
				" FROM (SELECT env_teacher,lessons,COUNT(*) counts FROM envluate GROUP BY env_teacher,lessons) lessons GROUP BY env_teacher" +
				" ) env_sum WHERE env_teacher='"+teacher+"'";
		System.out.println(sql);
		System.out.println(dbUtil.query(sql));	
		return gson.toJson(dbUtil.query(sql));
	}
	
	public String queryAdvice(String teacher){
		String sql = "SELECT advice FROM envluate WHERE env_teacher='"+teacher+"'";
		System.out.println(dbUtil.query(sql));
		return gson.toJson(dbUtil.query(sql));
	}
	
}
