<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML><HEAD><TITLE></TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2800.1611" name=GENERATOR>
<LINK href="images/css1.css" type=text/css rel=stylesheet><LINK 
href="images/newhead.css" type=text/css rel=stylesheet></HEAD>
<BODY leftMargin=0 topMargin=0 MARGINWIDTH="0" MARGINHEIGHT="0" >
<%String error = (String)request.getAttribute("message"); %>

<FORM action="LoginServlet" method="post" onsubmit="return submittest()">
<TABLE cellSpacing=0 cellPadding=0 width=1004 border=0>
  <TBODY>
  <TR>
    <TD colSpan=6><IMG height=92 alt="" src="images/crm_1.gif" 
    width=345></TD>
    <TD colSpan=4><IMG height=92 alt="" src="images/crm_2.gif" 
    width=452></TD>
    <TD><IMG height=92 alt="" src="images/crm_3.gif" width=207></TD></TR>
  <TR>
    <TD colSpan=6><IMG height=98 alt="" src="images/crm_4.gif" 
    width=345></TD>
    <TD colSpan=4><IMG height=98 alt="" src="images/crm_5.gif" 
    width=452></TD>
    <TD><IMG height=98 alt="" src="images/crm_6.gif" width=207></TD></TR>
  <TR>
    <TD rowSpan=5><IMG height=370 alt="" src="images/crm_7.gif" 
    width=59></TD>
    <TD colSpan=5><IMG height=80 alt="" src="images/crm_8.gif" 
    width=286></TD>
    <TD colSpan=4><IMG height=80 alt="" src="images/crm_9.gif" 
    width=452></TD>
    <TD><IMG height=80 alt="" src="images/crm_10.gif" width=207></TD></TR>
  <TR>
    <TD><IMG height=110 alt="" src="images/crm_11.gif" width=127></TD>
    <TD background=images/crm_12.gif colSpan=6>
      <TABLE id=table1 cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
          <TD>
            <TABLE id=table2 cellSpacing=1 cellPadding=0 width="100%" 
              border=0><TBODY>
              <TR>
               <TR><TD><font color="red"><%=error == null ? "" :error %></font></TD></TR>
                <TD align=center width=81><FONT color=#ffffff>用户名：</FONT></TD>
               
                <TD><INPUT class=regtxt title=请填写用户名 maxLength=16 size=16 
                   name="username" id="username">
                   <TD> <font color="red" id="test_name"></font> </TD>
                   </TR>
              <TR>
                <TD align=center width=81><FONT color=#ffffff>密&nbsp; 
                码：</FONT></TD>
                <TD><INPUT class=regtxt title=请填写密码 type=password maxLength=16 
                  size=16  name="password" id="password">
                    <TD> <font color="red" id="test_password"></font>
                  </TD></TR>
              <TR>
                </TBODY></TABLE></TD></TR></TBODY></TABLE></TD>
    <TD colSpan=2 rowSpan=2><IMG height=158 alt="" 
      src="images/crm_13.gif" width=295></TD>
    <TD rowSpan=2><IMG height=158 alt="" src="images/crm_14.gif" 
      width=207></TD></TR>
     
    
  
  <TR>
    <TD rowSpan=3><IMG height=180 alt="" src="images/crm_15.gif" 
      width=127></TD>
    <TD rowSpan=3><IMG height=180 alt="" src="images/crm_16.gif" 
    width=24></TD>
    <TD><INPUT title=登录后台 type=image height=48 alt="" width=86 
      src="images/crm_17.gif" name=image></TD>
    <TD><IMG height=48 alt="" src="images/crm_18.gif" width=21></TD>
    <TD colSpan=2><A href=""><IMG 
      title=返回首页 height=48 alt="" src="images/crm_19.gif" width=84 
      border=0></A></TD>
    <TD><IMG height=48 alt="" src="images/crm_20.gif" width=101></TD></TR>
  <TR>
    <TD colSpan=5 rowSpan=2><IMG height=132 alt="" 
      src="images/crm_21.gif" width=292></TD>
    <TD rowSpan=2><IMG height=132 alt="" src="images/crm_22.gif" 
      width=170></TD>
    <TD colSpan=2><IMG height=75 alt="" src="images/crm_23.gif" 
    width=332></TD></TR>
  <TR>
    <TD colSpan=2><IMG height=57 alt="" src="images/crm_24.gif" 
    width=332></TD></TR>
  
  <TR>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=59></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=127></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=24></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=86></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=21></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=28></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=56></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=101></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=170></TD>
    <TD><IMG height=1 alt="" src="images/spacer.gif" width=125></TD>
<!--     <TD><IMG height=1 alt="" src="images/spacer.gif" width=207></TD> -->
	
 	 </TR></TBODY></TABLE></FORM>
 
  	<script type="text/javascript" src="jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript">
  		function submittest(){
  			
  			var nameValue = document.getElementById("username").value;
  			if(nameValue == null || nameValue == ""){
  				document.getElementById("test_name").innerHTML = "不为空！";
  				return false;
  			}
  			
  			
  			var passwordValue = document.getElementById("password").value;
  			if(passwordValue == null || passwordValue == ""){
  				document.getElementById("test_password").innerHTML = "不能为空！";
  				return false;
  			}
  			
  		}
  	
  	</script>
  </BODY></HTML>
