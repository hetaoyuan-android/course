<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Map"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IN ADMIN PANEL | Collect from INDEZINER</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/jQpage.css" />
<link rel="stylesheet" type="text/css" href="css/niceforms-default.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.min.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-timepicker-addon.css" />
<script type="text/javascript" src="js/sys/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/sys/ddaccordion.js"></script>
<script type="text/javascript" src="js/sys/init.js"></script>
<script type="text/javascript" src="js/sys/jquery.jclock-1.2.0.js.txt"></script>
<script type="text/javascript" src="js/sys/niceforms.js"></script>
<script type="text/javascript" src="js/sys/jquery-ui-1.10.4.custom.min.js"></script>
<script type="text/javascript" src="js/sys/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="js/adminDemo.js "></script>
<script type="text/javascript" src="js/roomDemo.js "></script>
<script type="text/javascript" src="js/classDemo.js "></script>
<script type="text/javascript" src="js/jquery.page.js "></script>
</head>
<body>
<% Map<String, Object> map = (Map<String, Object>)request.getSession().getAttribute("name"); %>
<div id="main_container">

	<div class="header">
    <div class="logo"><a href="#"><img src="css/images/logo.gif" alt="" title="" border="0" /></a></div>
    <div class="right_header"><%=map.get("chinese_name") %>, <a href="#">Visit site</a> | <a href="#" class="messages">(3) Messages</a> | <a href="login.jsp" class="logout">Logout</a></div>
    <div class="jclock"></div>
    </div>
    <div class="main_content">
    <!-- 上导航开始 -->
                    <div class="menu">
                    <ul>
                    <li><a class="current" href="">账号管理</a>
                     	<ul>
	                        <li><a name="addCourse" href="javascript:void(0)" title="">账号新增</a></li>
	                        <li><a name="queryCourse" href="javascript:void(0)" title="">修改账号</a></li>
	                        <li><a name="queryAll" href="javascript:void(0)" title="">账号查询</a></li>
                        </ul>
                    </li>
                    <li><a name="room" href="javascript:void(0)">教室管理</a>
                        <ul>
                        <li><a name="addRoom" href="javascript:void(0)" title="">教室新增</a></li>
                        <li><a name="updateRoomClick" href="javascript:void(0)" title="">教室修改</a></li>
                        <li><a name="queryRoom" href="javascript:void(0)" title="">教室查询</a></li>
                        </ul>
                    </li>
                    <li><a href="javascript:void(0)" name="Class">班级管理</a>
                    	<ul>
                        <li><a name="addClass" href="javascript:void(0)" title="">班级新增</a></li>
                        <li><a name="alterClassOne" href="javascript:void(0)" title="">班级修改</a></li>
                        <li><a name="queryAllClass" href="javascript:void(0)" title="">班级查询</a></li>
                        </ul>
                    </li>
                    </div> 
     <!-- 上导航结束 -->
                    
    <div class="center_content">  
    <!-- 左侧菜单开始 -->
    <div class="left_content">
    	<div class="sidebarmenu">
                <a class="menuitem submenuheader" href="javascript:void(0)">账号管理</a>
                <div class="submenu">
                    <ul>
                    <li><a name="addCourse" href="javascript:void(0)">账号新增</a></li>
                    <li><a name="queryCourse" href="javascript:void(0)">账号修改</a></li>
                    <li><a name="queryAll" href="javascript:void(0)">账号查询</a></li>
                    </ul>
                </div>
                <a class="menuitem submenuheader" href="javascript:void(0)" >教室管理</a>
                <div class="submenu">
                    <ul>
                    <li><a name="addRoom" href="javascript:void(0)">教室新增</a></li>
                    <li><a name="updateRoomClick" href="javascript:void(0)">教室修改</a></li>
                    <li><a name="queryRoom" href="javascript:void(0)">教室查询</a></li>
                    </ul>
                </div>
                <a class="menuitem submenuheader" href="javascript:void(0)">班级管理</a>
                 <div class="submenu">
                    <ul>
                    <li><a name="addClass" href="javascript:void(0)">班级新增</a></li>
                    <li><a name="alterClassOne" href="javascript:void(0)">班级修改</a></li>
                    <li><a name="queryAllClass" href="javascript:void(0)">班级查询</a></li>
                    </ul>
                </div>
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
    
    <div class="right_content" id="right_show">          
    <!-- 表格开始 --> 
	<div id="queryCourse">                
    <h2>账号信息查询</h2> 
    <!-- 查询条件 -->
    <div class="queryForm">
    <!-- 想要表单控件有样式，必须把要渲染的控件放到form标签里，而且form标签必须使用class="niceform" -->
    <form class="niceform">
        <!-- dl表示列表 形式为一行，dt表示列表标题，dd表示列表内容 -->
    	<dl>
			<dt><label for="cClassCdt">入学年级:</label></dt>
			<dd><input type="text" id="cClassCdt" size="23" /></dd>
	   		 <dt><label for="cTeacherCdt">籍贯:</label></dt>
             <dd>
             	<select size="1" id="cProvCdt">
             		<option value="">请选择</option>
                		<option value="河北省">河北省</option>
							<option value="山西省">山西省</option>
							<option value="辽宁省">辽宁省</option>
							<option value="吉林省">吉林省</option>
							<option value="黑龙江省">黑龙江省</option>
							<option value="江苏省">江苏省</option>
							<option value="浙江省">浙江省</option>
							<option value="安徽省">安徽省</option>
							<option value="福建省">福建省</option>
							<option value="江西省">江西省</option>
							<option value="山东省">山东省</option>
							<option value="河南省">河南省</option>
							<option value="湖北省">湖北省</option>
							<option value="湖南省">湖南省</option>
							<option value="广东省">广东省</option>
							<option value="海南省">海南省</option>
							<option value="四川省">四川省</option>
							<option value="贵州省">贵州省</option>
							<option value="云南省">云南省</option>
							<option value="陕西省">陕西省</option>
							<option value="甘肃省">甘肃省</option>
							<option value="青海省">青海省</option>
							<option value="台湾省">台湾省</option>
							<option value="内蒙古自治区">内蒙古自治区</option>
							<option value="广西壮族自治区">广西壮族自治区</option>
							<option value="西藏自治区">西藏自治区</option>
							<option value="宁夏回族自治区">宁夏回族自治区</option>
							<option value="新疆维吾尔自治区">新疆维吾尔自治区</option>
							<option value="香港特别行政区">香港特别行政区</option>
							<option value="澳门特别行政区">澳门特别行政区</option>
             	</select>
           	</dd>
      	</dl>
      	<dl>
      		<dt><label for="cSchoolCdt">学校:</label></dt>
      		<dd><input type="text" id="cSchoolCdt" size="23" /></dd>
      		<dt><label for="cProCdt">专业:</label></dt>
      		<dd><input type="text" id="cProCdt" size="23" /></dd>
			<dd>
      	</dl>
      	<dl>
      		<dt><label for="cNameCdt">中文姓名:</label></dt>
      		<dd><input type="text" id="cNameCdt" size="23" /></dd>
      		<dt></dt>
			<dd>
          	  <input type="button" value="Submit" onclick="searchAdminsclick()"/>
			</dd>
      	</dl>
    </form>
    </div>
	<table id="rounded-corner">
	    <thead>
	    	<tr>
	        	<th class="rounded-company"></th>
	            <th class="rounded">账号</th>
	            <th class="rounded">密码</th>
	            <th class="rounded">性别</th>
	            <th class="rounded">学校</th>
	            <th class="rounded">专业</th>
	            <th class="rounded">角色</th>
	            <th class="rounded">QQ</th>
	            <th class="rounded">电话</th>
	            <th class="rounded">中文姓名</th>
	            <th class="rounded">年级</th>
	            <th class="rounded">省份</th>
	            <th class="rounded">启用</th>
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
	        	<td>1</td>
	            <td>第一教室</td>
	            <td>祥云1期</td>
	            <td>35/40</td>
	            <td>jQuery_1</td>
	            <td>java</td>
	            <td>java</td>
	            <td>java</td>
	            <td>java</td>
	            <td>java</td>
	            <td>java</td>
	            <td><a href="javascript:void(0)"><img src="css/images/info.png" name="courseInfo" alt="" title="" border="0" /></a></a></td>
	        </tr> 
	        
	    	<tr>
	    		<td><input type="checkbox" name="" /></td>
	        	<td>2</td>
	            <td>第二教室</td>
	            <td>祥云2期</td>
	            <td>35/40</td>
	            <td>jQuery_1</td>
	            <td>java</td>
	            <td>java</td>
	            <td>java</td>
	            <td>java</td>
	            <td>java</td>
	            <td>java</td>
	            <td><a href="javascript:void(0)"><img src="css/images/info.png" name="courseInfo" alt="" title="" border="0" /></a></td>
	        </tr>
	        
	    
	    	
	        
	    </tbody>
	</table>
	<!-- 表格功能按钮 -->
	 <a href="javascript:void(0)" class="bt_green" name="addCourse" ><span class="bt_green_lft"></span><strong>新增账号</strong><span class="bt_green_r"></span></a>
<!--      <a href="javascript:void(0)" class="bt_blue" id="alterCourse"><span class="bt_blue_lft"></span><strong>修改账号</strong><span class="bt_blue_r"></span></a> -->
     <a href="javascript:void(0)" class="bt_red" id="delCourse"><span class="bt_red_lft"></span><strong>删除账号</strong><span class="bt_red_r"></span></a> 
     
     <!-- 表格分页控件，用我发的替换 -->
		 <div class="tcdPageCode"></div>     
			
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