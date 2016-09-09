<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Map"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IN ADMIN PANEL | Collect from INDEZINER</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/niceforms-default.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.min.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-timepicker-addon.css" />
<script type="text/javascript" src="js/sys/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/sys/ddaccordion.js"></script>
<script type="text/javascript" src="js/sys/jquery.jclock-1.2.0.js.txt"></script>
<script type="text/javascript" src="js/sys/niceforms.js"></script>
<script type="text/javascript" src="js/sys/init.js"></script>
<script type="text/javascript" src="js/sys/jquery-ui-1.10.4.custom.min.js"></script>
<script type="text/javascript" src="js/sys/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="js/courseDemo.js"></script>
</head>
<body>
<% 
	Map<String, Object> map = (Map<String, Object>)request.getSession().getAttribute("name");
	String name = (String)map.get("chinese_name");
%>

<div id="main_container">

	<div class="header">
    <div class="logo"><a href="#"><img src="css/images/logo.gif" alt="" title="" border="0" /></a></div>
    <div class="right_header">Welcome <%=name%> <a href="#">Visit site</a> | <a href="#" class="messages">(3) Messages</a> | <a href="login.jsp" class="logout">Logout</a></div>
    <div class="jclock"></div>
    </div>
    <div class="main_content">
    <!-- 上导航开始 -->
                    <div class="menu">
                    <ul>
                    <li><a class="current" href="teacher_index.jsp">课程管理</a>
                     	<ul>
	                        <li><a name="addCourse" href="javascript:void(0)" title="">新建课程</a></li>
	                        <li><a name="" href="javascript:void(0)" title="">课程修改</a></li>
	                        <li><a name="queryAllCourse" href="javascript:void(0)" title="">课程查询</a></li>
                        </ul>
                    </li>
                    <li><a href="javascript:void(0)">作业管理(选)</a>
                        <ul>
                        <li><a name="addWork" href="javascript:void(0)" title="">新增作业</a></li>
                        <li><a href="javascript:void(0)" title="">作业查询</a></li>
                        </ul>
                    </li>
                    <li><a href="">签到管理</a>
                    	 <ul>
                        <li><a name="count" href="javascript:void(0)" title="">签到统计</a></li>
                        </ul>
                    </li>
                    <li><a name="showEnv" href="javascript:void(0)">评价查看(选)</a></li>
                    </ul>
                    </div> 
     <!-- 上导航结束 -->
                    
    <div class="center_content">  
    
    <div class="left_content">
    <!-- 左侧菜单开始 -->
            <div class="sidebarmenu">
                <a class="menuitem submenuheader" href="">课程管理</a>
                <div class="submenu">
                    <ul>
                    <li><a name="addCourse" href="javascript:void(0)">新建课程</a></li>
                    <li><a name="queryAllCourse" href="javascript:void(0)">课程查询</a></li>
                    <li><a name="" href="javascript:void(0)">课程修改</a></li>
                    </ul>
                </div>
                <a class="menuitem submenuheader" href="" >作业管理</a>
                <div class="submenu">
                    <ul>
                    <li><a href="">新增作业</a></li>
                    <li><a href="">作业查询</a></li>
                    </ul>
                </div>
                <a class="menuitem_green" href="">签到管理</a>
                <a class="menuitem_red" href="">评价查看</a>
                    
            </div>
    <!-- 左侧菜单结束 -->
    <!-- 左侧提示开始 -->        
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h3>系统说明</h3>
                <img src="css/images/info.png" alt="" title="" class="sidebar_icon_right" />
                <p>
					为了达到四海行唐老师和学生的日常工作流程化的目标，搜集教师的日常工作和学生的日常任务需求，形成班级管理系统需求。目的是为了规范和简化学生和老师的日常流程。
                </p>                
                </div>
                <div class="sidebar_box_bottom"></div>
            </div>
            
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h4>重要提示</h4>
                <img src="css/images/notice.png" alt="" title="" class="sidebar_icon_right" />
                <p>
					欢迎祥云30、31、32、33、34期学员加入四海兴唐！
                </p>                
                </div>
                <div class="sidebar_box_bottom"></div>
            </div>
            <!-- 左侧提示结束 -->   
    </div>  
    
    <div class="right_content">          
    <!-- 表格开始 --> 
	<div id="queryCourse">                
    <h2>课程信息查询</h2> 
    <!-- 查询条件 -->
    <div class="queryForm">
    <form class="niceform">
        <!-- dl表示列表 形式为一行，dt表示列表标题，dd表示列表内容 -->
    	<dl>
			<dt><label for="cClassCdt">班级:</label></dt>
			<dd>
				<select size="1" id="cClassCdt">
					<option value="">请选择</option>
                	<option value="祥云1期">祥云1期</option>
                	<option value="祥云2期">祥云2期</option>
                	<option value="祥云3期">祥云3期</option>
                	<option value="祥云4期">祥云4期</option>
                	<option value="祥云5期">祥云5期</option>
	        	</select>
	   		</dd>
	   		 <dt><label for="cTeacherCdt">教师:</label></dt>
	   		 <dd><input type="text" id="cTeacherCdt" size="23" value="<%= name%>" /></dd>
<!--              <dd> -->
<!--              	<select size="1" id="cTeacherCdt"> -->
<!--              		<option value="">请选择</option> -->
<!--                 	<option value="姜英利">姜英利</option> -->
<!--                 	<option value="林来军">林来军</option> -->
<!--                 	<option value="韩冰">韩冰</option> -->
<!--                 	 <option value="刘文铭">刘文铭</option> -->
<!--              	</select> -->
<!--            	</dd> -->
	   	</dl>
	   	<dl>
      	
      		<dt><label for="cBeginCdt">开课开始时间:</label></dt>
      		<dd><input type="text" id="cBeginCdt" size="23" /></dd>
    	
      		<dt><label for="cEndCdt">开课结束时间:</label></dt>
      		<dd><input type="text" id="cEndCdt" size="23" /></dd>
			<dd>
          	  <input type="button" id="querySubmit" value="Submit" />
			</dd>
      	</dl>
      
    </form>
    </div>
	<table id="rounded-corner">
	    <thead>
	    	<tr>
	        	<th class="rounded-company"></th>
	            <th class="rounded">教师</th>
	            <th class="rounded">班级</th>
	            <th class="rounded">上课时间</th>
	            <th class="rounded">下课时间</th>
	            <th class="rounded">知识点</th>
	        </tr>
	    </thead>
	        <tfoot>
	    	<tr>
	        	<td colspan="6" class="rounded-foot-left"><em>想查看更详细的信息，请点击详情。详情中可以对学生签到信息进行查看和修改。</em></td>
	        	<td class="rounded-foot-right">&nbsp;</td>
	
	        </tr>
	    </tfoot>
	    <tbody>
	    	<tr>
	        	<td><input type="checkbox" name="" /></td>
	            <td>王老师</td>
	            <td>祥云168期</td>
	            <td>2016-4-30 16:00</td>
	            <td>2016-4-30 16:00</td>
	            <td>jQuery_1</td>
	        </tr>
	    	<tr>
	        	<td><input type="checkbox" name="" /></td>
	            <td>成老师</td>
	            <td>祥云168期</td>
	            <td>2016-4-30 16:00</td>
	            <td>2016-4-30 16:00</td>
	            <td>jQuery_1</td>
	        </tr>    
	        
	    </tbody>
	</table>
	<!-- 表格功能按钮 -->
<!-- 	 <a href="javascript:void(0)" class="bt_green" name="queryAllCourse" ><span class="bt_green_lft"></span><strong>查看课程</strong><span class="bt_green_r"></span></a> -->
	<div id="div">
	 <a href="javascript:void(0)" class="bt_green" name="presence" ><span class="bt_green_lft"></span><strong>出席情况</strong><span class="bt_green_r"></span></a>
	 <a href="javascript:void(0)" class="bt_green" name="addCourse" ><span class="bt_green_lft"></span><strong>新增课程</strong><span class="bt_green_r"></span></a>
     <a href="javascript:void(0)" class="bt_blue" name="queryOneCourse"><span class="bt_blue_lft"></span><strong>修改课程</strong><span class="bt_blue_r"></span></a>
     <a href="javascript:void(0)" class="bt_red" id="delCourse"><span class="bt_red_lft"></span><strong>删除课程</strong><span class="bt_red_r"></span></a> 
    </div>
     <!-- 表格分页控件，用我发的替换 -->
<!--         <div class="pagination"> -->
<!--         <span class="disabled"><< prev</span><span class="current">1</span><a href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>…<a href="">10</a><a href="">11</a><a href="">12</a>...<a href="">100</a><a href="">101</a><a href="">next >></a> -->
<!--         </div>  -->
		 <!-- 表格结束 --> 
		</div>         
     </div><!-- end right-content -->
  </div>             
    
    <div class="clear"></div>
    </div> <!--end of main content-->
	
    
    <div class="footer">
    
    	<div class="left_footer">IN ADMIN PANEL | Collect from <a href="http://www.cssmoban.com">四海兴唐</a></div>
    	<div class="right_footer"><a href="http://www.cssmoban.com"><img src="css/images/indeziner_logo.gif" alt="" title="" border="0" /></a></div>
    
    </div>
</div>		
</body>
</html>