package com.yuan.javaweb.adminmodel;

import com.google.gson.Gson;
import com.yuan.javaweb.dbutils.DBUtil;

public class AAdmin {

	private DBUtil dbUtil = new DBUtil();
	Gson gson = new Gson();
	
	/**
	 * 插入操作
	 */
	public void addAdmin(String account,String password,String sex,String school,String profession,String role,
			String qq1,String phone1,String chinese_name,String grade,String province,String status){
		int qq = Integer.parseInt(qq1);
		int phone = Integer.parseInt(phone1);
		
		String sql = "INSERT INTO add_account (account,PASSWORD,sex,school,profession,role,qq,phone,chinese_name,grade,province,STATUS) VALUES ('"+ 
			account+"','"+ password +"','"+ sex +"','"+ school +"','"+ profession +"','"+ role +"'," + qq + ","+ phone +",'"+ chinese_name +"','"+ grade
			+"','"+ province +"','"+ status +"')";
		System.out.println(sql);
		dbUtil.update(sql);
	}
	
	/**
	 * 查询全部的操作
	 * @return
	 */
	public String queryAdmin(){
		String sql = "SELECT * FROM add_account";
		System.out.println(dbUtil.query(sql));
		return gson.toJson(dbUtil.query(sql));
	}
	
	/**
	 * 模糊查询
	 */
	public String searchAdmin(String grade,String prov,String school,String pro,String cname){
		String sql = "";
		if(grade != "" && prov != "" && school != "" && pro != "" && cname != ""){
			sql += "SELECT * FROM add_account WHERE grade like '%" + grade + "%' and province like '%" + prov + "%' and school like '%"+ school
					+"%' and profession like '%"+ pro +"%' and chinese_name like '%" + cname + "%' ";
		}
		if(grade != ""){
			sql += "SELECT * FROM add_account WHERE grade like '%" + grade + "%' ";
			if(prov != ""){
				sql += " and province like '%" + prov + "%' ";
			}
			if(school != ""){
				sql += "and school like '%"+ school +"%'";
			}
			if(pro != ""){
				sql += "and profession like '%"+ pro +"%' ";
			}
			if(cname != ""){
				sql += "and chinese_name like '%" + cname + "%'";
			}
		}
		
		
		System.out.println(dbUtil.query(sql));
		return gson.toJson(dbUtil.query(sql));
	}
	/**
	 * 查询一个id
	 * @param id1
	 * @return
	 */
	public String selectOneId(String id1){
		int id = Integer.parseInt(id1);
		String sql = "select * from add_account where id="+ id +"";
		System.out.println(dbUtil.query(sql));
		return gson.toJson(dbUtil.query(sql));
	}
	/**
	 * 更新
	 */
	public String updateAdmin(String id1,String account,String password,String sex,String school,String profession,String role,
			String qq1,String phone1,String chinese_name,String grade,String province,String status){
		int id = Integer.parseInt(id1);
		int qq = Integer.parseInt(qq1);
		int phone = Integer.parseInt(phone1);
		
		String sql ="update add_account set account='" + account + "',password='"+ password +"',sex='"+ sex +"',school='"+ school +"',profession='"+ profession 
				+"',role='"+ role +"',qq='"+ qq +"',phone='"+ phone +"',chinese_name='"+ chinese_name +"',grade='"+ grade +"',province='"+ province +"',status='"
				+ status +"' where id="+ id +"";
		System.out.println(dbUtil.update(sql));
		return gson.toJson(dbUtil.update(sql));
		
	}
	/**
	 * 删除
	 * @param id1
	 */
	public void deleteAdmin(String id1){
		int id = Integer.parseInt(id1);
		String sql = "DELETE FROM add_account WHERE id=" + id + "";
		System.out.println(sql);
		dbUtil.update(sql);
	}
}
