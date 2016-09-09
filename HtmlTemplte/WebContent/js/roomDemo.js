var pageSize = 3;
var pageCount = 0;



$(function(){
//	initPageRoom();
	initEvts();
	$("#cBeginCdt").datetimepicker();
	$("#cEndCdt").datetimepicker({dateFormat:'yy-mm-dd'});
});

function initEvts(){
//教室管理操作的
$("[name=room]").bind("click",roomIndex);
$("[name=addRoom]").bind("click",addRoomClick);
//添加教室
//$("[name=addRoomServlet]").bind("click",aaddRoomServlet1);
//查询全部教室
//$("[name=queryRoom]").bind("click",queryRoom);
//模糊查询操作
$("#searchRoom").bind("click",searchRoom);
//删除操作
$("#deleteRoom").bind("click",delRoom);
//修改按钮操作
$("[name=updateRoomClick]").bind("click",updateRoomClick);


}

/** 
 * 先查询一个对应的id的信息
 */
function updateRoomClick(){
	var $nodes = $("input:checked");
	$.get('selectRoomOne',{
		"id" : $nodes.val()
	},function(data){
		updateRoom(data);
	},"json");
}

/**
 * 修改教室操作,跳转到显示数据的界面
 */
function updateRoom(datajson){
	$.post('html/admin/alter_room.html', function(data) {
		$(".right_content").empty().append(data);
		//加载页面之后才能完成对于这个事件 的绑定
		$("[name=updateAll]").bind("click",updateAllRoom);
		// 添加 样式
		$("#id").val(datajson[0].id);
		$("#roomName").val(datajson[0].room_name);
		$("#roomSchool").val(datajson[0].room_school);
		$("#roomNumber").val(datajson[0].room_number);
		$("#roomStatus").val(datajson[0].room_status);
		NFInit();
	}, 'text');
}
/**
 * 真正的数据库操作修改的功能,实现全部的修改功能
 */
function updateAllRoom(){
	var $updateRoom = $("form").serializeArray();
	$.post('updateRoom',$updateRoom,function(data){
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
 * 删除教室操作
 */
function delRoom(){
	var flag = confirm("Are you sure ?");
	var $nodes = $("input:checked");
	if(flag){
		$("input:checked").parents("tr").remove();
		$.post('deleteRoom', {
			"id" : $nodes.val()
		}, function(data) {
			
		}, 'json');
	}
}

/**
 * 模糊查询教室
 */
function searchRoom(){
	var name = $("#roomName").val();
	var school = $("#roomSchool").val();
	var number = $("#roomNumber").val();
	var status = $("#roomStatus").val();
	$.post('searchRoom',{
		"room_name" : name,
		"room_school" : school,
		"room_number" : number,
		"room_status" : status
	}, function(data) {
		$("tbody").empty();
		$.each(data,function(){
			$("tbody").append("<tr>" +
					"<td>" + "<input type='checkbox' value='' />" + "</td>"+
					"<td style='display: none;'>"+this.id+"</td>" +
					"<td>"+this.room_name+"</td>" +
					"<td>"+this.room_school+"</td>" +
					"<td>"+this.room_number+"</td>" +
					"<td>"+this.room_status+"</td>" +"</tr>");
		});
	}, 'json');
}

/**
 * 查询全部教室
 */
function queryRoom(){
	$.post('queryRoom',function(data){
		$("tbody").empty();
		$.each(data,function(){
			$("tbody").append("<tr>" +
					"<td>" + "<input type='checkbox' name='' value='"+this.id+"'/>" + "</td>"+
					"<td style='display: none;'>"+this.id+"</td>" +
					"<td>"+this.room_name+"</td>" +
					"<td>"+this.room_school+"</td>" +
					"<td>"+this.room_number+"</td>" +
					"<td>"+this.room_status+"</td>" + "</tr>");
		});
	});
}

/**
 * 教室管理的index界面
 */
function roomIndex(){
	$.post("html/admin/room_index.html",function(data){
		$(".right_content").empty().append(data);
		//表单中内容样式渲染方法，不使用该方法表单无样式，会非常丑！
		NFInit(); 
		$("#cBeginCdt").datetimepicker({dateFormat:'yy-mm-dd'});
		$("#cEndCdt").datetimepicker({dateFormat:'yy-mm-dd'});
		queryRoom();
		bindEvts();
	},"text");
}

/**
 * 添加教室跳转的页面
 */
function addRoomClick(){
	$.post("html/admin/add_room.html",function(data){
		$(".right_content").empty().append(data);
		$("[name=addRoomServlet]").bind("click",aaddRoomServlet1);
		//表单中内容样式渲染方法，不使用该方法表单无样式，会非常丑！ 
		//niceforms插件的初始化方法，用来渲染所有的表单控件样式
		NFInit(); 
		//时间控件初始化
	},"text");
}

/**
 * 添加教室到数据库了
 */
function aaddRoomServlet1(){
	var name = $("#roomName").val();
	var school = $("#roomSchool").val();
	var number = $("#roomNumber").val();
	var status = $("#roomStatus").val();
	
	//判断不能为空
	if (name == "") {
		alert("教室名称不能为空！");
	}
	if (school == "") {
		alert("归属学校不能为空！");
	}
	if (number == "") {
		$("#room_number").show();
	}
	if (status == "") {
		alert("启用状态不能为空！");
	}
	//不为空的时候执行
	if(name != "" && school != "" && number != "" && status != ""){
		$.post('addRoom',{
			"room_name" : name,
			"room_school" : school,
			"room_number" : number,
			"room_status" : status
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
 * 清空Text操作
 */
function clear(){
	var name = $("#roomName").val("");
	var school = $("#roomSchool").val("");
	var number = $("#roomNumber").val("");
	var status = $("#roomStatus").val("");
}

/**
 * 分页的操作
 */

function initPageRoom(){
	$.post("getAllRoomPage",function(data){
		pageCount = Math.ceil(data.count/pageSize);
		$(".tcdPageCodeRoom").createPage({
			pageCount : pageCount,//页数
			current : 1,//当前页
			backFn : function(p){ //点击页码时触发的函数
				showUsersByPageNumRoom(p);
			}
		});
	},"json");
	showUsersByPageNumRoom(1);
	
}
function showUsersByPageNumRoom(pageNum){
	$.post("getAllRoomPage",{pageNum:pageNum,pageSize:pageSize},function(data){
		$("tbody").empty();
		$.each(data,function(){
			$("tbody").append("<tr>" +
					"<td>" + "<input type='checkbox' name='' value='"+this.id+"'/>" + "</td>"+
					"<td style='display: none;'>"+this.id+"</td>" +
					"<td>"+this.room_name+"</td>" +
					"<td>"+this.room_school+"</td>" +
					"<td>"+this.room_number+"</td>" +
					"<td>"+this.room_status+"</td>" + "</tr>");
	});
},"json");
}


