<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="electiveSystem.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html">
<style>
    body{
        text-align: left;
        padding: 40px;
    }
    table, th , td  {
        border: 1px solid grey;
        border-collapse: collapse;
        padding: 15px;
    }
    table tr:nth-child(odd) {
        background-color: #f1f1f1;
    }
    table tr:nth-child(even) {
        background-color: #ffffff;
    }
    .form-control {padding: 3px 1px; outline: none; border: 1px solid #abcdef;}
    .form-control:focus {border-color: #000000;}
</style>
<script type="text/javascript">
	function validate(f){  
	    if(!$("input[type='checkbox']").is(':checked')){
	        alert("请选中一门课程！");
	        return false;
	    }
	    return true;  
	}
	$(function(){
		$("tr#dataT").hide();
		$("#search").click(function(){
			var $keywords = $("#keywords").val();
			//alert($keywords);
			$('.data').hide().filter(':contains('+$keywords+')').show();
		});
		$("#resetSearch").click(function(){
			$('.data').show();
		});
		$("#searchTeacher").click(function(){
			var $index = $("#teacher").val();
			$('.data').hide();
			$("tr#dataT").hide();
			$('.'+$index).show();
		});
	});
</script>
<title>Student Elective System</title>
</head>
<body>
<%  
request.setCharacterEncoding("UTF-8");
%> 
<p>欢迎登录</p>

<p>按照教师搜索：<select id="teacher" name="teacher">
<option></option>
<%
List<Teacher> teachers = (List<Teacher>)request.getAttribute("teachers");
Iterator<Teacher> iterT = teachers.iterator();
int i = 0;
while(iterT.hasNext()){
	Teacher tdata = iterT.next();
%>
<option value = "<%= i%>"><%= tdata.getName()%></option>
<%
	i++;
}
%>
</select><input type="button" id="searchTeacher" value="搜索"/>
</p>

<p>课程名搜索：
<input type="text" name="keywords" id="keywords"/><input type="button" id="search" value="搜索"/><input type="button" id="resetSearch" value="重置"/>
</p>
<form action = "SelectCourse" method = "get" onSubmit = "return validate(this)" >
<input type="hidden" name="sid" value= "<%=  (String)request.getAttribute("sid")%>"/>
<table id="all">
	<tr>
		<th>Course ID</th>
		<th>Course Name</th>
		<th>Selected</th>
	</tr>
	<%
	List<Course> course = (List<Course>)request.getAttribute("course");
	Iterator<Course> iter = course.iterator();
    while(iter.hasNext()){
	    Course cdata = iter.next();
	%>
	<tr class="data">
		<td><%= cdata.getId() %></td>
		<td><%= cdata.getName() %></td>
		<td><input type = "checkbox"  name ="cid" value = "<%= cdata.getId()%>" /></td>
	</tr>
	<%
    }
	for(int j = 0; j < teachers.size(); j++){
		course = teachers.get(j).getCourses();
		iter = course.iterator();
	    while(iter.hasNext()){
		    Course cdata = iter.next();
	%>
	<tr class="<%= j%>" id="dataT">
		<td><%= cdata.getId() %></td>
		<td><%= cdata.getName() %></td>
		<td><input type = "checkbox"  name ="cid" value = "<%= cdata.getId()%>" /></td>
	</tr>
	<%
    	}
    }
	%>
</table>
<input type = "submit" value = "提交"/>
</form>
<form action="SelectedCourse" method="get">
<input type="hidden" name="sid" value= "<%=  (String)request.getAttribute("sid")%>"/>
<input type = "submit" value = "已选课程"/>
</form>

</body>
</html>