package com.yuan.javaweb.file.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.yuan.javaweb.dbutils.DBUtil;
import com.yuan.javaweb.dbutils.UploadUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class FileBean {
	private DBUtil jdbcUtil = new DBUtil();
	private String realFileName = "";
	public boolean fileUpload(HttpServletRequest request){
		ItemBean itemBean = UploadUtil.getFileItems(request);
		String sql = this.getFileAddSql(itemBean);
		Connection conn = jdbcUtil.getConn2();
		try {
			conn.setAutoCommit(false);
			jdbcUtil.executeSQLNoRelease(sql);
			if(UploadUtil.uploadFile(itemBean, realFileName)){
				conn.commit();
			}else{
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.close();
		}
		return true;
	}
	private String getFileAddSql(ItemBean itemBean){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String displayFileName = itemBean.getItem().getName();
		String[] names = displayFileName.split("\\.");
		String extension = displayFileName.split("\\.")[1];
		realFileName = UUID.randomUUID().toString() + "."+extension;
//		String sql = "INSERT INTO upload_files(real_name,display_name,user_id,extension,upload_time) values('"+realFileName
//				+"','" + displayFileName
//				+"','" + itemBean.getId()
//				+"','" + extension
//				+"','" + sdf.format(new Date())+"')";
		String sql = "INSERT INTO work (real_name,display_name,user_id,extension,upload_time) values('"+realFileName
				+"','" + displayFileName
				+"','" + itemBean.getId()
				+"','" + extension
				+"','" + sdf.format(new Date())+"')";
		return sql;
	}
}
