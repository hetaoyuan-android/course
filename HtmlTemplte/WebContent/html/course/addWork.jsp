<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Map"%> 
<% 
	Map<String, Object> map = (Map<String, Object>)request.getSession().getAttribute("name");
	String name = (String)map.get("chinese_name");
%>
    <div id="addCourse">    
     <h2>新增作业</h2>
         <div class="form">
         <!-- class="niceform"用来定位需要被渲染的控件 -->
         <form action="FileUploadServlet" method="post" class="niceform" enctype="multipart/form-data">
                <fieldset >
                
                	 <dl >
                        <dt><label for="cTeacherCdt">教师:</label></dt>
	   					<dd><input type="text" name="teacher" id="cTeacherCdt" size="55" value="<%= name%>" /></dd>
                    </dl>
                	
                    <dl>
                        <dt><label for="cClass">班级:</label></dt>
                        <dd>
                            <select size="1" id="wClass" name="wclass">
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
                        <dt><label for="cEnd">完成时间:</label></dt>
                        <dd><input type="text" id="wEnd" size="54" name="wtime" /></dd>
                         <font color="red" id="end" style="display: none" >不为空</font>
                    </dl>
                    <dl>
                        <dt><label for="cPoint">作业内容:</label></dt>
                        <dd><input type="file" id="wContent" name="filename" size="54" /></dd>
                         <font color="red" id="point" style="display: none" >不为空</font>
                    </dl>
                     <dl class="submit">
                   		 <input type="submit" value="Submit" />
                     </dl>
                </fieldset>
                
         </form>
         </div>  
      </div>     
	  