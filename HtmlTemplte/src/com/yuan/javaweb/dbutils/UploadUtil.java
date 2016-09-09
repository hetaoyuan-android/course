package com.yuan.javaweb.dbutils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import com.yuan.javaweb.file.model.ItemBean;



public class UploadUtil {
	private static final String TEMP_PATH = "/tmp";
	private static final  String UPLOAD_PATH = "D:/upload/";
	private static final  int FILE_MAX_SIZE = 1024*500;
	public static ItemBean getFileItems(HttpServletRequest request) {
		List<FileItem> items = new ArrayList<FileItem>();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		ItemBean itemBean = new ItemBean();
		upload.setHeaderEncoding("utf-8");
		//upload.setFileSizeMax(1024*500);
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		for(FileItem item:items){
			if(item.isFormField()){
				itemBean.setId(item.getString());
			}else{
				itemBean.setItem(item);
			}
		}
		return itemBean;
	}
	public static boolean uploadFile(ItemBean itemBean,String realFileName){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		File uploadDir = new File(UPLOAD_PATH);
		if(!uploadDir.exists()){
			uploadDir.mkdirs();
		}
		try {
			bis = new BufferedInputStream(itemBean.getItem().getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(new File(UPLOAD_PATH+realFileName)));
			byte[] tmp = new byte[1024];
			while(bis.read(tmp) != -1){
				bos.write(tmp);
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public String getExtension(FileItem item){
		return item.getFieldName().split(".")[1];
	}
	
	
	public static Map<String,Object> getFileUpload(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		InputStream is = null;
		
		OutputStream os = null;
		
		try {
			
			if(ServletFileUpload.isMultipartContent(request)){//是否为上传请求
				String realpath = request.getSession().getServletContext().getRealPath("/upload");
//				String realpath = "D:/upload/";
				File f = new File(realpath);
				if(!f.isDirectory()){
					f.mkdirs();
				}
				
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				List<FileItem> fileItems = upload.parseRequest(request);
				//进行迭代
				Iterator<FileItem> iter = fileItems.iterator();
				
				
				
				while(iter.hasNext()){
					FileItem fileItem = iter.next();
					String filedName = fileItem.getFieldName();//表单中 name=""对应的名字
					
					is =  new BufferedInputStream(fileItem.getInputStream());
					//判断是否为普通表单
					if(fileItem.isFormField()){
						//除type="file"外都是普通表单控件
						map.put(filedName, Streams.asString(is, "UTF-8"));
					}else{//处理文件域
						String fileName = fileItem.getName();
						
						String ext = FilenameUtils.getExtension(fileName);//获取后缀名
						
						String newFileName = UUID.randomUUID().toString()+"."+ext;//新的名字
						
						os =  new BufferedOutputStream(new FileOutputStream(new File(realpath+File.separator+newFileName)));
						
						//上传
						IOUtils.copy(is, os);
						map.put(filedName, newFileName);
					}
				}
				
				
			}else{
				map.put("error", "不是上传请求");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("error", "上传出错了"+e.getMessage());
		}
		
		return map;
	}
	
	
	
	
}
