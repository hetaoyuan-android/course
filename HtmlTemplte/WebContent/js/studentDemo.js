/*
 * 课程相关方法(自己根据实际情况复用或修改)
 *
 * Date: 2015-12-10 create by dym
 */
$(function(){
	bindEvts();
	$("#cBeginCdt").datetimepicker({dateFormat:'yy-mm-dd'});
	$("#cEndCdt").datetimepicker({dateFormat:'yy-mm-dd'});
});

function bindEvts(){

	//查询签到历史
	$("[name=sNum]").bind("click",show);
	//评价
	$("[name=teacherEvaluate]").bind("click",teacherEvaluate);
	//学生查看作业
	$("[name=queryWork]").bind("click",queryWork);
}

/**
 * 查询签到历史
 */

function show(){
	var num = $("[name=sNumber]").val();
	$.post('queryShow',{"num" : num},function(data){
		$("tbody").empty();
		$.each(data,function(){
			$("tbody").append("<tr>" +
					"<td>"+this.stu_num+"</td>" +
					"<td>"+this.stu_name+"</td>" +
					"<td>"+this.course_content+"</td>" +
					"<td>"+this.course_class+"</td>" +
					"<td>"+this.STATUS+"</td>" + "</tr>");
		});
	});
}

/**
 * 对于教师的评价
 */
function teacherEvaluate(){
	$.post("html/student/teacherEvaluate.html",function(data){
		$(".right_content").empty().append(data);
		$("[name=envSubmit]").bind("click",submitTableEnv);
//		submitTableEnv();
		NFInit(); 
	},"text");
}

/**
 * 显示正常的评价表格
 */
function submitTableEnv(){
	var teacher = $("#teacherEnv").val();
	var cbVal1 = $("table tr input:checked").eq(0).val();
	var cbVal2 = $("table tr input:checked").eq(1).val();
	var cbVal3 = $("table tr input:checked").eq(2).val();
	var cbVal4 = $("table tr input:checked").eq(3).val();
	var cbVal5 = $("table tr input:checked").eq(4).val();
	var advice = $("[name=advice]").val();
	if(teacher == ""){
		alert("请选择需要评价的老师");
		return true;
	}
	if(advice == ""){
		alert("对老师的建议必须写");
	}
	if(teacher != "" && advice != ""){
		$.post('envTeacher',{
			"teacher" : teacher,
			"cbVal1" : cbVal1,
			"cbVal2" : cbVal2,
			"cbVal3" : cbVal3,
			"cbVal4" : cbVal4,
			"cbVal5" : cbVal5,
			"advice" :advice
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
	var teacher = $("#teacherEnv").val("");
	var cbVal1 = $("table tr input:checked").eq(0).val("");
	var cbVal2 = $("table tr input:checked").eq(1).val("");
	var cbVal3 = $("table tr input:checked").eq(2).val("");
	var cbVal4 = $("table tr input:checked").eq(3).val("");
	var cbVal5 = $("table tr input:checked").eq(4).val("");
	var advice = $("[name=advice]").val("");
}

/**
 * 查看作业
 */
function queryWork(){
	alert("ss");
	$.post('html/student/queryWork.html',function(data){
		$(".right_content").empty().append(data);
		NFInit(); 
		showWork();
	});
}

function showWork(){
	$.post('showWork',function(data){
		$("tbody").empty();
		$.each(data,function(){
		$("tbody").append("<tr>" +
				"<td>"+this.w_teacher+"</td>" +
				"<td>"+this.w_class+"</td>" +
				"<td>"+this.finish_time+"</td>" +
				"<td>"+this.w_content+"</td>" +
				"<td>"+
				"<a href='javascript:downSubmit()'>download</a>"+
				"</td>"+
				"</tr>");
	});
},"json");
}

function downSubmit(){
	$.post('downWork',function(data){
		
	});
}

