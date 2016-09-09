package com.yuan.javaweb.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;

public class DBUtil {
	
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//加载驱动
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得连接
	 */
	private void getConn(){
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/two_design", "root", "123456");
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**.获得数据库连接*/
	public Connection getConn2(){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/two_design", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public boolean executeSQLNoRelease(String sql){
		System.out.println("执行SQL为："+sql );
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/two_design", "root", "123456");
			stmt = conn.createStatement();
			if(stmt.executeUpdate(sql) > 0){
				return true;
			}else{
				System.out.println("\n更新SQL执行结果为0！");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	/**
	 * 更新
	 * @param sql
	 * @return
	 */
	public int update(String sql){
		int count = 0;
		getConn();
		try {
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return count;
	}
	
	
	/**
	 * 预编译查询
	 */
	
	public List<Map<String,Object>> preparedQuery(String sql,String[] strArr){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		//创建连接
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/two_design", "root", "123456");
		//创建预处理语句对象
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, strArr[0]);
			ps.setString(2, strArr[1]);
			
			rs = ps.executeQuery();
		//结构化数据对象
			ResultSetMetaData rsmt =  rs.getMetaData();
		//获取一共多少列
			int count = rsmt.getColumnCount();
			String[] nameArr = new String[count];
			for(int i = 0;i<nameArr.length;i++){
				nameArr[i] = rsmt.getColumnName(i+1);
			}
			while(rs.next()){
				HashMap<String,Object> map = new HashMap<String,Object>();
				
				for(int i = 0;i<nameArr.length;i++){
					map.put(nameArr[i], rs.getString(nameArr[i]));
				}
				list.add(map);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
	}
	
	//查询记录的条数
	public int execCount(String sql){
		getConn();
		int totalRecords = 0;
	    try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			totalRecords = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return totalRecords;
	}
	
	//查询
	public List<Map<String,Object>> query(String sql){
		//List<List<Object>> list = new ArrayList<List<Object>>();
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		getConn();
		try {
			rs = stmt.executeQuery(sql);
			//结果集对象
			ResultSetMetaData  rsmt = rs.getMetaData();
			//个数
			int count = rsmt.getColumnCount();
			//String columnName = rsmt.getColumnName(1);//��ȡ��i�е������֣������1��ʼ
			
			String[] nameArr = new String[count];
			for(int i = 0;i<nameArr.length;i++){
				nameArr[i] = rsmt.getColumnName(i+1);
			}
			while(rs.next()){
				//rs.getString(columnLabel);���ĳһ�е������֣�ȡ����Ӧ���е�ֵ
				HashMap<String,Object> map = new HashMap<String,Object>();
				
				for(int i = 0;i<nameArr.length;i++){
					map.put(nameArr[i], rs.getString(nameArr[i]));
				}
				list.add(map);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
	}
	
	
	
	/**
	 * 关闭
	 */
	public void close(){
		try {
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Map<String,Object>> query(String sql,int pageIndex,int rows){
		
		String sqlGetPages = "SELECT COUNT(*) sum FROM ("+sql+") s";
		int allRows = Integer.parseInt((String)query(sqlGetPages).get(0).get("sum"));
		//页数
		int pages = allRows%rows == 0 ? allRows/rows : allRows/rows+1;
		
		
		//索引
		//index = (pageIndex-1)*rows;
		sql = sql + " limit " + (pageIndex-1)*rows +","+ rows;
		System.out.println(sql);
		return query(sql);
	}
	
	
	
	public static  int getNumber() {
		int a = 0;
		    try {
		      String s = "t";					
		      a = Integer.parseInt(s);			
		      return a;
		} catch (NumberFormatException e) {
			a = 1;							
		      return a;						
		} finally { 
		      a = 2;							
		      System.out.println("11111");
		}
		}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("22222");
		int i = getNumber();
		System.out.println(i);
		System.out.println("33333");
		
	}
	
	
	
	
	
	
	
	
}
