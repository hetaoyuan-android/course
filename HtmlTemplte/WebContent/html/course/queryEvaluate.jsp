<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	Map<String, Object> map = (Map<String, Object>)request.getSession().getAttribute("name");
	String name = (String)map.get("chinese_name");
%>

<div id="queryCourse">                
    <h2>课程信息查询</h2> 
    <!-- 查询条件 -->
    <div class="queryForm">
    <form class="niceform">
        <!-- dl表示列表 形式为一行，dt表示列表标题，dd表示列表内容 -->
    	<dl>
<!-- 	   		 <dt><label for="cTeacherCdt">教师:</label></dt> -->
<!--              <dd> -->
<!--              	<select size="1" id="teacherEnv" name="teacherEnv"> -->
<!--                 	<option value="">请选择</option> -->
<!--                 	<option value="姜英利">姜英利</option> -->
<!--                 	<option value="林来军">林来军</option> -->
<!--                 	<option value="韩冰">韩冰</option> -->
<!--                 	<option value="刘文铭">刘文铭</option> -->
<!--              	</select> -->
<!--            	</dd> -->
 				<dt><label for="cTeacherCdt">教师:</label></dt>
	   		 	<dd><input type="text" id="teacherEnv" name="teacherEnv" size="15" value="<%= name%>" /></dd>
      			<dd>
          	 		 <input type="button" id="queryAdv" value="查看建议" />
				</dd>
      			
      	</dl>
    </form>
    </div>
	<table id="rounded-corner">
	    <thead>
	    	<tr>
	            <th class="rounded">评价内容</th>
	            <th class="rounded">优</th>
	            <th class="rounded">良</th>
	            <th class="rounded">中</th>
	            <th class="rounded">差</th>
	        </tr>
	    </thead>
	    <tbody>
	    	
	    </tbody>
	</table>
	<br/>
	<div id="adviceDIV" style="display: none"> 
		<h3>建议：</h3>
		<table border="1" width="500px" height="150px" bordercolor="blue" cellpadding="10" cellspacing="0" >
			<tbody id="advice">
			
			</tbody>
		</table>
	</div>
	<!-- 表格功能按钮 -->
     
		 <!-- 表格结束 --> 
		</div>    
	  

</body>
</html>