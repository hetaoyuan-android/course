
var pageSize = 3;
var pageCount = 0;

$(function(){
	initPage();
	bindEvts();
	$("#cBeginCdt").datetimepicker();
	$("#cEndCdt").datetimepicker({dateFormat:'yy-mm-dd'});
});
function bindEvts(){
	//删除按钮绑定click事件
	$("#delCourse").bind("click",delAdmin);
	//课程详情按钮绑定click事件
	$("[name=courseInfo]").bind("click",addAdmin);
	//课程新增按钮绑定click事件
	$("[name=addCourse]").bind("click",addAdmin);
	$("[name=queryCourse]").bind("click",queryAdmin);
	//改变一个
	$("#alterAdmin").bind("click",updateAdminClick);	
	//改变的是全部的提交
	$("#updateSubmit").bind("click",updateAddAdmin);
	//查询全部
	$("[name=queryAll]").bind("click",queryAll);
	
}


/**
 * 删除账号方法
 */
function delAdmin(){
	var flag = confirm("Are you sure ?");
	var $nodes = $("input:checked");
	if(flag){
		//AJAX后台数据库删除自己写
		$("input:checked").parents("tr").remove();
		$.post('deleteAdmin', {
			"id" : $nodes.val()
		}, function(data) {
			
		}, 'json');
	}
}
/**
 * 新增账号方法
 */
function addAdmin(){
	$.post("html/admin/add_admin.html",function(data){
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
 * 
 * 查询一个
 */
function updateAdminClick(obj){
	var $nodes = $("input:checked");
	$.get('selectAdminOne', {
		"id" : $nodes.val()
	}, function(data) {
		updateAdmin(data);
	}, 'json');
}

/**
 * 跳转到更新
 */
function updateAdmin(datajson){
	$.post('html/admin/alter_Admin.html', function(data) {
		$(".right_content").empty().append(data);
		// 添加 样式
		$("#id").val(datajson[0].id);
		$("#account").val(datajson[0].account);
		$("#password").val(datajson[0].password);
		$("#sex").val(datajson[0].sex);
		$("#school").val(datajson[0].school);
		$("#profession").val(datajson[0].profession);
		$("#qq").val(datajson[0].qq);
		$("#phone").val(datajson[0].phone);
		$("#chinese_name").val(datajson[0].chinese_name);
		$("#grade").val(datajson[0].grade);
		$("#role").val(datajson[0].role);
		$("#province").val(datajson[0].province);
		$("#status").val(datajson[0].status);
		NFInit();
	}, 'text');
}

/**
 * 全部修改操作
 */
function updateAddAdmin(){
	var updateInfo = $("#alertAdminForm").serializeArray();
	$.post('updateAdmin',updateInfo,function(data){
		if (data != null && data != undefined) {
			if(data == "success"){//成功
				$("#tips").show();
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

//显示课程查询方法
function queryAdmin(){
		$.post("html/admin/query_Admine.html",function(data){
		$(".right_content").empty().append(data);
		//表单中内容样式渲染方法，不使用该方法表单无样式，会非常丑！
		NFInit(); 
		$("#cBeginCdt").datetimepicker({dateFormat:'yy-mm-dd'});
		$("#cEndCdt").datetimepicker({dateFormat:'yy-mm-dd'});
		bindEvts();
		queryAll();
	},"text");
}

//js

/**
 * 按条件的模糊查询
 */
function searchAdminsclick(){

	var cClassCdt = $("#cClassCdt").val(); 
	var cProvCdt = $("#cProvCdt").val();
	var cProCdt = $("#cProCdt").val();
	var cNameCdt = $("#cNameCdt").val();
	var cSchoolCdt = $("#cSchoolCdt").val();
	$.post("searchAdmin", {
				"cClassCdt" : cClassCdt,
				"cProvCdt" : cProvCdt,
				"cSchoolCdt" : cSchoolCdt,
				"cProCdt":cProCdt,
				"cNameCdt":cNameCdt,
			}, function(data) {
				$("tbody").empty();
				$.each(data,function(){
					$("tbody").append("<tr>" +
							"<td>" + "<input type='checkbox' value='' />" + "</td>"+
							"<td style='display: none;'>"+this.id+"</td>" +
							"<td>"+this.account+"</td>" +
							"<td>"+this.password+"</td>" +
							"<td>"+this.sex+"</td>" +
							"<td>"+this.school+"</td>" +
							"<td>"+this.profession+"</td>" +
							"<td>"+this.role+"</td>" +
							"<td>"+this.qq+"</td>" +
							"<td>"+this.phone+"</td>" +
							"<td>"+this.chinese_name+"</td>" +
							"<td>"+this.grade+"</td>" +
							"<td>"+this.province+"</td>" +
							"<td>"+this.status+"</td>" +
							"</tr>");
				});
			}, 'json');
}

/**
 * 查询全部
 */
function queryAll(){
	$.post("queryAdmin",function(data){
		$("tbody").empty();
		$.each(data,function(){
		$("tbody").append("<tr>" +
				"<td>" + "<input type='checkbox' name='' value='"+this.id+"'/>" + "</td>"+
				"<td style='display: none;'>"+this.id+"</td>" +
				"<td>"+this.account+"</td>" +
				"<td>"+this.password+"</td>" +
				"<td>"+this.sex+"</td>" +
				"<td>"+this.school+"</td>" +
				"<td>"+this.profession+"</td>" +
				"<td>"+this.role+"</td>" +
				"<td>"+this.qq+"</td>" +
				"<td>"+this.phone+"</td>" +
				"<td>"+this.chinese_name+"</td>" +
				"<td>"+this.grade+"</td>" +
				"<td>"+this.province+"</td>" +
				"<td>"+this.status+"</td>" +
				"</tr>");
	});
},"json");
}



/**
 * 添加 先 校验 校验：1 空校验 2 位数校验（没写）3.空格输入
 */
function addusersclick() {
	var account = $("#account").val();
	var password = $("#password").val();
	var sex = $("#sex").val();
	var school = $("#school").val();
	var profession = $("#profession").val(); 
	var role = $("#role").val();
	var qq = $("#qq").val();
	var phone = $("#phone").val();
	var chinese_name = $("#chinese_name").val();
	var grade = $("#grade").val();
	var province = $("#province").val();
	var status =  $("#status").val();
	// 判断不能为空 ==========================================（可以化简 用循环）

	if (account == "") {
		$("#account_Unkong").show();
	}
	if (password == "") {
		$("#password_Unkong").show();
	}
	if (sex == "") {
		$("#sex_Unkong").show();
	}
	if (school == "") {
		$("#school_Unkong").show();
	}
	if (profession == "") {
		$("#pro_Unkong").show();
	}
	if (role == "") {
		$("#role_Unkong").show();
	}
	if (qq == "") {
		$("#qq_Unkong").show();
	}
	if (phone == "") {
		$("#phone_Unkong").show();
	}
	if (chinese_name == "") {
		$("#cn_Unkong").show();
	}
	if (grade == "") {
		$("#grade_Unkong").show();
	}
	if (province == "") {
		$("#prov_Unkong").show();
	}
	if (status == "") {
		$("#status_Unkong").show();
	}

	
	// 不为空的时候执行
	if (account != "" && password != "" && sex != "" && school != "" && profession != "" && role != "" && qq != "" && phone != "" && chinese_name != "" && grade != "" && province != "" && status != "") {
		$.post('addAdmin', {// 传递的参数
			"account" : account,
			"password" : password,
			"sex" : sex,
			"school": school,
			"profession":profession,
			"role":role,
			"qq":qq,
			"phone":phone,
			"chinese_name":chinese_name,
			"grade":grade,
			"province":province,
			"status":status,
		}, function(data) {
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
	var account = $("#account").val("");
	var password = $("#password").val("");
	var sex = $("#sex").val("");
	var school = $("#school").val("");
	var profession = $("#profession").val(""); // 0 or 1
	var role = $("#role").val("");
	var qq = $("#qq").val("");
	var phone = $("#phone").val(""); // 0 or 1
	var chinese_name = $("#chinese_name").val("");
	var grade = $("#grade").val("");
	var province = $("#province").val("");
	var status =  $("#status").val("");
	var confirmpswd =  $("#addupswd_confirm").val("");
}

/**
 * 分页的操作
 */
function initPage(){
	$.post("getAllUserPage",function(data){
		pageCount = Math.ceil(data.count/pageSize);
		$(".tcdPageCode").createPage({
			pageCount : pageCount,//页数
			current : 1,//当前页
			backFn : function(p){ //点击页码时触发的函数
				showUsersByPageNum(p);
			}
		});
	},"json");
	showUsersByPageNum(1);
	
}
function showUsersByPageNum(pageNum){
	$.post("getAllUserPage",{pageNum:pageNum,pageSize:pageSize},function(data){
		$("tbody").empty();
		$.each(data.list,function(){
		$("tbody").append("<tr>" +
				"<td>" + "<input type='checkbox' name='' value='"+this.id+"'/>" + "</td>"+
				"<td style='display: none;'>"+this.id+"</td>" +
				"<td>"+this.account+"</td>" +
				"<td>"+this.password+"</td>" +
				"<td>"+this.sex+"</td>" +
				"<td>"+this.school+"</td>" +
				"<td>"+this.profession+"</td>" +
				"<td>"+this.role+"</td>" +
				"<td>"+this.qq+"</td>" +
				"<td>"+this.phone+"</td>" +
				"<td>"+this.chinese_name+"</td>" +
				"<td>"+this.grade+"</td>" +
				"<td>"+this.province+"</td>" +
				"<td>"+this.status+"</td>" +
				"</tr>");
	});
},"json");
}

