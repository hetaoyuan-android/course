$(function(){
	ClassInit();
});

function ClassInit(){
	$("[name=Class]").bind("click",classIndex);
}

/**
 * 班级管理index界面
 */
function classIndex(){
	$.post('html/admin/class_index.html',function(data){
		$(".right_content").empty().append(data);
		$("[name=addClass]").bind("click",addClassClick);
		$("[name=delClass]").bind("click",delClass);
		$("[name=alterClassOne]").bind("click",queryClassOne);
		$("[name=searchSubmit]").bind("click",searchOne);
		queryAllClass();
		//表单中内容样式渲染方法，不使用该方法表单无样式，会非常丑！
		NFInit(); 
		$("#cBeginCdt").datetimepicker({dateFormat:'yy-mm-dd'});
		$("#cEndCdt").datetimepicker({dateFormat:'yy-mm-dd'});
		bindEvts();
	},"text");
}
/**
 * 模糊查询
 */
function searchOne(){
	var name = $("#cClassName").val();
	var stage = $("#cClassStage").val();
	var startTime = $("#cClassBegin").val();
	var endTime = $("#cClassEnd").val();
	
	$.post('searchClass',{
		"class_name" : name,
		"class_stage" : stage,
		"class_startTime" : startTime,
		"class_endTime" : endTime
	},function(data){
		$("tbody").empty();
		$.each(data,function(){
			$("tbody").append("<tr>" +
					"<td>" + "<input type='checkbox' name='' value='"+this.id+"'/>" + "</td>"+
					"<td style='display: none;'>"+this.id+"</td>" +
					"<td>"+this.class_name+"</td>" +
					"<td>"+this.class_stage+"</td>" +
					"<td>"+this.class_startTime+"</td>" +
					"<td>"+this.class_endTime+"</td>" +
					"<td>"+this.class_courseAll+"</td>" +
					"<td>"+this.class_room+"</td>" +
					"<td>"+this.class_status+"</td>" +
					"<td>"+this.class_teacher+"</td>" + "</tr>");
	});
	},"json");
}
/**
 * 查找一个班级
 */
function queryClassOne(){
	var $nodes = $("input:checked");
	alert($nodes.val());
	$.get('selectClassOne',{
		"id" : $nodes.val()
	},function(data){
		updateClass(data);
	},"json");
}
/**
 * 修改班级操作,跳转到显示数据的界面
 */

function updateClass(datajson){
	$.post('html/admin/alter_class.html', function(data) {
		$(".right_content").empty().append(data);
		$("#updateClassAll").bind("click",updateClassAll);
		//加载页面之后才能完成对于这个事件 的绑定
		// 添加 样式
		$("#id").val(datajson[0].id);
		$("#class_name").val(datajson[0].class_name);
		$("#class_stage").val(datajson[0].class_stage);
		$("#class_startTime").val(datajson[0].class_startTime);
		$("#class_endTime").val(datajson[0].class_endTime);
		$("#class_timeAll").val(datajson[0].class_courseAll);
		$("#class_room").val(datajson[0].class_room);
		$("#class_status").val(datajson[0].class_status);
		$("#class_teacher").val(datajson[0].class_teacher);
		NFInit();
	}, 'text');
}

/**
 * 修改之后的提交操作
 */
function updateClassAll(){
	var $updateRoom = $("form").serializeArray();
	$.post('updateClass',$updateRoom,function(data){
		if (data != null && data != undefined) {
			if(data == "success"){//成功
				$("#tips_Suc").show();
				setTimeout(function() {
							$("#tips_Suc").
							fadeOut(2000);
						}, 400);
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
 * 删除班级信息
 */
function delClass(){
	var flag = confirm("Are you sure ?");
	var $nodes = $("input:checked");
	if(flag){
		$("input:checked").parents("tr").remove();
		$.post('deleteClass', {
			"id" : $nodes.val()
		}, function(data) {
			
		}, 'json');
	}
}


/**
 * 查看全部的班级信息
 */
function queryAllClass(){
	$.post('queryClass',function(data){
		$("tbody").empty();
		$.each(data,function(){
			$("tbody").append("<tr>" +
					"<td>" + "<input type='checkbox' name='' value='"+this.id+"'/>" + "</td>"+
					"<td style='display: none;'>"+this.id+"</td>" +
					"<td>"+this.class_name+"</td>" +
					"<td>"+this.class_stage+"</td>" +
					"<td>"+this.class_startTime+"</td>" +
					"<td>"+this.class_endTime+"</td>" +
					"<td>"+this.class_courseAll+"</td>" +
					"<td>"+this.class_room+"</td>" +
					"<td>"+this.class_status+"</td>" +
					"<td>"+this.class_teacher+"</td>" + "</tr>");
		});
		
	});
}

/**
 * 添加班级管理信息按钮
 */
function addClassClick(){
	$.post('html/admin/add_class.html',function(data){
	$(".right_content").empty().append(data);
		NFInit(); 
		$("#addClassServlet").bind("click",addClassServlet);
	},"text");
}
/**
 * 把数据添加到数据库中
 */
function addClassServlet(){
	var name = $("#class_name").val();
	var stage = $("#class_stage").val();
	var startTime = $("#class_startTime").val();
	var endTime = $("#class_endTime").val();
	var courseAll = $("#class_timeAll").val();
	var room = $("#class_room").val();
	var status = $("#class_status").val();
	var teacher = $("#class_teacher").val();
	
	//判断不为空
	if(name == ""){
		alert("班级名称不能为空");
	}
	if(stage == ""){
		alert("当前阶段不能为空");
	}
	if(startTime == ""){
		$("#start_time").show();
	}
	if(endTime == ""){
		$("#end_time").show();
	}
	if(courseAll == ""){
		$("#time_all").show();
	}
	if(room == ""){
		alert("班级教室不能为空");
	}
	if(status == ""){
		alert("启用状态不能为空");
	}
	if(teacher == ""){
		alert("授课教师不能为空");
	}
	//都不为空的时候执行操作
	if(name != "" && stage != "" && startTime != "" && endTime != "" && courseAll != "" && room != ""  && status != "" && teacher != ""){
		$.post('addClass',{
			"class_name" : name,
			"class_stage" : stage,
			"class_startTime" : startTime,
			"class_endTime" : endTime,
			"class_courseAll" : courseAll,
			"class_room" : room,
			"class_status" : status,
			"class_teacher" : teacher
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
	var name = $("#class_name").val("");
	var stage = $("#class_stage").val("");
	var startTime = $("#class_startTime").val("");
	var endTime = $("#class_endTime").val("");
	var courseAll = $("#class_timeAll").val("");
	var room = $("#class_room").val("");
	var status = $("#class_status").val("");
	var teacher = $("#class_teacher").val("");
}
