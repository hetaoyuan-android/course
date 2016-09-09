<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Map"%>  
  
<% 
	Map<String, Object> map = (Map<String, Object>)request.getSession().getAttribute("name");
	String name = (String)map.get("chinese_name");
%>      
    <div id="addCourse">    
     <h2>课程新增</h2>
         <div class="form">
         <!-- class="niceform"用来定位需要被渲染的控件 -->
         <form action="" method="post" class="niceform">
                <fieldset>
                
                	 <dl>
<!--                         <dt><label for="cTeacher">教师:</label></dt> -->
<!--                         <dd> -->
<!--                             <select size="1" id="cTeacher"> -->
<!--                             	<option value="">请选择</option> -->
<!--                                 <option value="姜英利">姜英利</option> -->
<!--                                 <option value="林来军">林来军</option> -->
<!--                                 <option value="韩冰">韩冰</option> -->
<!--                                 <option value="刘文铭">刘文铭</option> -->
<!--                             </select> -->
<!--                         </dd> -->
 							<dt><label for="cTeacherCdt">教师:</label></dt>
	   						<dd><input type="text" id="cTeacher" size="55" value="<%= name%>" /></dd>			
                    </dl>
                	
                    <dl>
                        <dt><label for="cClass">班级:</label></dt>
                        <dd>
                            <select size="1" id="cClass">
                            	<option value="">请选择</option>
                                <option value="祥云1期">祥云1期</option>
                                <option value="祥云2期">祥云2期</option>
                                <option value="祥云3期">祥云3期</option>
                                <option value="祥云4期">祥云4期</option>
                                <option value="祥云5期">祥云5期</option>
                            </select>
                        </dd>
                    </dl>

                    <dl>
                        <dt><label for="cBegin">开课时间:</label></dt>
                        <dd><input type="text" id="cBegin" size="54" /></dd>
                        <font color="red" id="start" style="display: none" >不为空</font>
                    </dl>
                    <dl>
                        <dt><label for="cEnd">结课时间:</label></dt>
                        <dd><input type="text" id="cEnd" size="54" /></dd>
                         <font color="red" id="end" style="display: none" >不为空</font>
                    </dl>
                    <dl>
                        <dt><label for="cPoint">知识点:</label></dt>
                        <dd><input type="text" id="cPoint" size="54" /></dd>
                         <font color="red" id="point" style="display: none" >不为空</font>
                    </dl>
                     <dl class="submit">
                   		 <input type="button" name="submit" id="addSubmit" value="Submit" />
                     </dl>
                </fieldset>
                
         </form>
         </div>  
      </div>     
       <div id="tips_Suc" style="display:none;" class="valid_box"  >恭喜您， 添加成功！</div>
	   <div id="tips_Default" style="display:none;" class="error_box"  >对不起， 添加失败！</div>
	  