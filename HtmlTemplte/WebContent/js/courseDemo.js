/*
 * 课程相关方法(自己根据实际情况复用或修改)
 *
 * Date: 2015-12-10 create by dym
 */
$(function(){
	bindEvts();
	queryAllCourse();
	$("[name=count]").bind("click",count);
	$("#cBeginCdt").datetimepicker({dateFormat:'yy-mm-dd'});
	$("#cEndCdt").datetimepicker({dateFormat:'yy-mm-dd'});
});
function bindEvts(){
	//删除按钮绑定click事件
	$("#delCourse").bind("click",delCourse);
	//课程新增按钮绑定click事件
	$("[name=addCourse]").bind("click",addCourse);
	//$("[name=queryAllCourse]").bind("click",queryAllCourse);
	//查询一个按钮
	$("[name=queryOneCourse]").bind("click",queryOneCourse);
	//出席情况
	$("[name=presence]").bind("click",presence);
	//模糊查询
	$("#querySubmit").bind("click",search);
	//新增作业
	$("[name=addWork]").bind("click",addWork);
	//老师查看评价
	$("[name=showEnv]").bind("click",showEnv);
	
}

/**
 * 查看界面
 */
function showEnv(){
	$.post('html/course/queryEvaluate.jsp',function(data){
		$(".right_content").empty().append(data);
		NFInit(); 
		$("#queryAdv").bind("click",queryAdv);
		queryEnv();
	});
}
/**
 * 查看建议
 */
function queryAdv(){
	alert("ss");
	var teacher = $("#teacherEnv").val();
	$("#adviceDIV").show();
	$.post('queryEnvAdv',{
		"teacher" : teacher
	},function(data){
		$("#advice").empty();
		$.each(data,function(){
		$("#advice").append(
				"<tr>"+"<td>"+this.advice+"</td>"+"</tr>");
	});
},"json");
}

/**
 * 老师查看自己的评价
 */
function queryEnv(){
	var teacher = $("#teacherEnv").val();
	$.post('queryEnv',{
		"teacher" : teacher
	},function(data){
		$("tbody").empty();
		$.each(data,function(){
		$("tbody").append("<tr>" +
				"<td>"+this.countType+"</td>" +
				"<td>"+this.Y+"</td>" +
				"<td>"+this.l+"</td>" +
				"<td>"+this.z+"</td>" +
				"<td>"+this.c+"</td>" +
				"</tr>");
	});
},"json");
}
/**
 * 新增作业
 */
function addWork(){
	alert("d");
	$.post("html/course/addWork.jsp",function(data){
		$(".right_content").empty().append(data);
		//表单中内容样式渲染方法，不使用该方法表单无样式，会非常丑！ 
		//niceforms插件的初始化方法，用来渲染所有的表单控件样式
		NFInit(); 
		//时间控件初始化
		$("#cBegin").datetimepicker({dateFormat:'yy-mm-dd'});
		$("#cEnd").datetimepicker({dateFormat:'yy-mm-dd'});
	},"text");
}

/**
 * 删除课程方法
 */
function delCourse(){
	var flag = confirm("Are you sure ?");
	var $nodes = $("input:checked");
	if(flag){
		//AJAX后台数据库删除自己写
		$("input:checked").parents("tr").remove();
		$.post('deleteCourse', {
			"id" : $nodes.val()
		}, function(data) {
			
		}, 'json');
	}
}
//新增课程方法
function addCourse(){
	$.post("html/course/addCourse.jsp",function(data){
		$(".right_content").empty().append(data);
		$("#addSubmit").bind("click",addCousrseServlet);
		//表单中内容样式渲染方法，不使用该方法表单无样式，会非常丑！ 
		//niceforms插件的初始化方法，用来渲染所有的表单控件样式
		NFInit(); 
		//时间控件初始化
		$("#cBegin").datetimepicker({dateFormat:'yy-mm-dd'});
		$("#cEnd").datetimepicker({dateFormat:'yy-mm-dd'});
	},"text");
}
/**
 * 新增课程到数据库添加操作
 */
function addCousrseServlet(){
	var teacher = $("#cTeacher").val();
	var cclass = $("#cClass").val();
	var cBegin = $("#cBegin").val();
	var cEnd = $("#cEnd").val();
	var cPoint = $("#cPoint").val();
	
	//判断是否为空
	if(teacher == ""){
		alert("教师不能为空");
	}
	if(cclass == ""){
		alert("班级不能为空");
	}
	if(cBegin == ""){
		$("#start").show();
	}
	if(cEnd == ""){
		$("#end").show();
	}
	if(cPoint == ""){
		$("#point").show();
	}
	if(teacher != "" && cclass != "" && cBegin != "" && cEnd!= "" && cPoint!= ""){
		$.post('addCourse',{
			"teacher" : teacher,
			"cclass" : cclass,
			"cBegin" : cBegin,
			"cEnd" : cEnd,
			"cPoint" : cPoint
		},function(data){
			// 添加成功
			if (data != null && data != undefined) {
				if(data == "success"){//成功
					$("#tips_Suc").show();
					setTimeout(function() {
								$("#tips_Suc").
								fadeOut(2000);
							}, 400);
					// 成功之后 清空操作
					clear();
				}else{//失败
					$("#tips_Default").show();
					setTimeout(function() {
								$("#tips_Default").fadeOut(1000);
							}, 400);
				}
			
			}
		}, 'text');
	}
}

/**
 * 清空操作
 */		
function clear(){
	var teacher = $("#cTeacher").val("");
	var cclass = $("#cClass").val("");
	var cBegin = $("#cBegin").val("");
	var cEnd = $("#cEnd").val("");
	var cPoint = $("#cPoint").val("");
}

	
//显示提示
function showTips(){
	$("#tips").show();
	setTimeout(function(){$("#tips").fadeOut(1000)},400)
}

//显示课程查询方法
function queryAllCourse(){
	$.post('queryAllCourse',function(data){
		$("tbody").empty();
		$.each(data,function(){
		$("tbody").append("<tr>" +
				"<td>" + "<input type='checkbox' name='' value='"+this.id+"'/>" + "</td>"+
				"<td style='display: none;'>"+this.id+"</td>" +
				"<td>"+this.course_teacher+"</td>" +
				"<td>"+this.course_class+"</td>" +
				"<td>"+this.course_startTime+"</td>" +
				"<td>"+this.course_endTime+"</td>" +
				"<td>"+this.course_content+"</td>" +
				"</tr>");
	});
},"json");
}
/**
 * 查询一个
 */
function queryOneCourse(obj){
	var $nodes = $("input:checked");
	$.post('selectCourseOne', {
		"id" : $nodes.val()
	}, function(data) {
		updateCourse(data);
	}, 'json');
}
/**
 * 跳转到更新页面
 */
function updateCourse(datajson){
	$.post("html/course/alterCourse.html",function(data){
		$(".right_content").empty().append(data);
		$("#updateAll").bind("click",updateAllCourse);
		//表单中内容样式渲染方法，不使用该方法表单无样式，会非常丑！
		//时间控件初始化
		$("#cBegin").datetimepicker({dateFormat:'yy-mm-dd'});
		$("#cEnd").datetimepicker({dateFormat:'yy-mm-dd'});
		$("#id").val(datajson[0].id);
		$("#cTeacher").val(datajson[0].course_teacher);
		$("#cClass").val(datajson[0].course_class);
		$("#cBegin").val(datajson[0].course_startTime);
		$("#cEnd").val(datajson[0].course_endTime);
		$("#cPoint").val(datajson[0].course_content);
		NFInit();
	}, 'text');
}
/**
 * 修改数据到数据库
 */
function updateAllCourse(){
	var updateCourse = $("form").serializeArray();
	$.post('updateCourse',updateCourse,function(data){
		if (data != null && data != undefined) {
			if(data == "success"){//成功
				$("#tips_Suc").show();
				setTimeout(function() {
							$("#tips_Suc").
							fadeOut(2000);
						}, 400);
				// 成功之后 清空操作
				clear();
			}else{//失败
				$("#tips_Default").show();
				setTimeout(function() {
							$("#tips_Default").fadeOut(1000);
						}, 400);
			}
		
		}
	}, 'text');
}
/**
 * 出席情况的统计
 */
function presence(){
	var $nodes = $("input:checked");
//	{"id" : $nodes.val()},
	$.post('html/course/queryPresence.html',function(data){
		$(".right_content").empty().append(data);
		$("#presenceTbody").empty();
		queryPresence($nodes);
		$("[name=sub]").bind("click",presenceSubmit);
	});
}
function queryPresence($nodes){
	$.post('queryPresence',{"id" : $nodes.val()},function(data){
		$.each(data,function(){
			$("#presenceTbody").append("<tr>" +
				
				"<td>" + "<input type='checkbox' name='sid' value='"+this.id+"'/>" + "</td>"+
				"<td style='display: none;'>"+this.id+"</td>" +
				"<td>"+this.stu_num+"</td>" +
				"<td>"+this.stu_name+"</td>" +
//				"<td>" + "<select size='1' id='cTeacherCdt'>"+
//         		"<option value=''>请选择</option>"+
//            	"<option value='迟到'>迟到</option>"+
//            	"<option value='请假'>请假</option>"+
//            	"<option value='正常'>正常</option>"+
//            	"<option value='旷课'>旷课</option>"+
//            	"</select>"
//				+"</td>" + "</tr>");
				"<td>"
				+"<input name='state'  type='checkbox' value='正常' />" +'正常'
				+"<input name='state' type='checkbox' value='迟到' />" +'迟到'
				+"<input name='state' type='checkbox' value='请假' />" +'请假'
				+"<input name='state' type='checkbox' value='旷课' />" +'旷课'
				+"</td>" + 
				"<td>"+
				"<a href='javascript:doSubmit()'>确定</a>"+
				"</td>"+
				"</tr>" );
	});
},"json");
}

/**
 * 提交出席情况
 */
function doSubmit(){
   var url = "updatePresence";
   //sid=""
   //state=""
   $.ajax({
	  url:url,
      data:$("#ff").serialize(),
      type:"POST",
      success:function(msg){
    	 alert("操作成功"); 
    	 clearAll();
      },
      error:function(){
    	 alert("操作失败");
    	 
      }
   });
   
//   document.getElementById("ff").action="";
//   $("#ff").submit();
}
/**
 * 清除所选择的checkbox选项
 */
function clearAll() {    
	var el = document.getElementsByTagName('input');     
	var len = el.length;     
	for(var i=0; i<len; i++) {         
		if((el[i].type=="checkbox"))  {             
			el[i].checked = false;        
		}     
	} 
}
/**
 * 签到统计
 */
function count(){
	$.post('html/course/count.html',function(data){
		$(".right_content").empty().append(data);
		$("#countForm").empty();
		showCount();
	});
}
function showCount(){
	$.post('count',function(data){
		$("tbody").empty();
		$.each(data,function(){
		$("tbody").append("<tr>" +
				"<td>"+this.stu_num+"</td>" +
				"<td>"+this.stu_name+"</td>" +
				"<td>"+this.STATUS+"</td>" +
				"</tr>");
	});
},"json");
}


/**
 * 模糊查询
*/
function search(){
	var cClassCdt = $("#cClassCdt").val();
	var cTeacherCdt = $("#cTeacherCdt").val();
	var cBeginCdt = $("#cBeginCdt").val();
	var cEndCdt = $("#cEndCdt").val();
	$.post('search',{
		"cClassCdt" : cClassCdt,
		"cTeacherCdt" : cTeacherCdt,
		"cBeginCdt" : cBeginCdt,
		"cEndCdt" : cEndCdt
		
	},function(data){
		$("tbody").empty();
		$.each(data,function(){
		$("tbody").append("<tr>" +
				"<td>" + "<input type='checkbox' name='' value='"+this.id+"'/>" + "</td>"+
				"<td style='display: none;'>"+this.id+"</td>" +
				"<td>"+this.course_teacher+"</td>" +
				"<td>"+this.course_class+"</td>" +
				"<td>"+this.course_startTime+"</td>" +
				"<td>"+this.course_endTime+"</td>" +
				"<td>"+this.course_content+"</td>" +
				"</tr>");
	});
},"json");
}

