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
<script type="text/javascript" src="js/studentDemo.js"></script>
</head>
<body>
<% Map<String, Object> map = (Map<String, Object>)request.getSession().getAttribute("name"); %>
<div id="main_container">

	<div class="header">
    <div class="logo"><a href="#"><img src="css/images/logo.gif" alt="" title="" border="0" /></a></div>
    <div class="right_header">Welcome <%=map.get("chinese_name") %>, <a href="#">Visit site</a> | <a href="#" class="messages">(3) Messages</a> | <a href="login.jsp" class="logout">Logout</a></div>
    <div class="jclock"></div>
    </div>
    <div class="main_content">
    <!-- 上导航开始 -->
                    <div class="menu">
                    <ul>
                    <li><a href="javascript:void(0)" name="">签到管理</a>
                    	<ul>
	                        <li><a name="queryPresence" href="javascript:void(0)" title="">查询签到</a></li>
                        </ul>
                    </li>
                    <li><a name="queryWork" href="javascript:void(0)">作业管理(选)</a>
                    </li>
                    <li><a name="teacherEvaluate" href="javascript:void(0)">教师评价(选)</a></li>
                    </ul>
                    </div> 
     <!-- 上导航结束 -->
                    
    <div class="center_content">  
    
    <div class="left_content">
    <!-- 左侧菜单开始 -->
            <div class="sidebarmenu">
                <a class="menuitem submenuheader" href="javascript:void(0)">签到管理</a>
                <a class="menuitem submenuheader" href="javascript:void(0)" >作业管理</a>
                <a class="menuitem_red" href="javascript:void(0)">教师评价</a>
                    
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
    <h2>签到信息查询</h2> 
    <!-- 查询条件 -->
    <div class="queryForm">
    <form class="niceform">
        <!-- dl表示列表 形式为一行，dt表示列表标题，dd表示列表内容 -->
      	<dl>
      		<dt><label for="cNameCdt">请输入学号:</label></dt>
      		<dd><input type="text" name="sNumber" size="23" value="<%=map.get("chinese_name") %>"/></dd>
      		<dt></dt>
			<dd>
          	  <input type="button" name="sNum" value="Submit" />
			</dd>
      	</dl>
    </form>
    </div>
	<table id="rounded-corner">
	    <thead>
	    	<tr>
	            <th class="rounded">学号</th>
	            <th class="rounded">姓名</th>
	            <th class="rounded">知识点</th>
	            <th class="rounded">班级</th>
	            <th class="rounded">状态</th>
	        </tr>
	    </thead>
	        <tfoot>
	    	<tr>
	
	        </tr>
	    </tfoot>
	    <tbody>
	    	<tr>
	            <td>level_2_class_19</td>
	            <td>第一教室</td>
	            <td>祥云168期</td>
	            <td>35/40</td>
	            <td>jQuery_1</td>
	        </tr>
	        
	        
	    	<tr>
	            <td>level_2_class_19</td>
	            <td>第一教室</td>
	            <td>祥云168期</td>
	            <td>35/40</td>
	            <td>jQuery_1</td>
	        </tr>  
	        
	        
	    </tbody>
	</table>
     
		 <!-- 表格结束 --> 
		</div>         
     </div><!-- end right-content -->
  </div>             
    
    <div class="clear"></div>
    </div> <!--end of main content-->
	
    
    <div class="footer">
    
    	<div class="left_footer">IN ADMIN PANEL | Collect from <a href="http://www.cssmoban.com">网页模板</a></div>
    	<div class="right_footer"><a href="http://www.cssmoban.com"><img src="css/images/indeziner_logo.gif" alt="" title="" border="0" /></a></div>
    
    </div>
</div>		
</body>
</html>