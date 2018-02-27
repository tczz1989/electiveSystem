<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8" import="java.util.*" import ="electiveSystem.vo.*"%>
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
<script language = "JavaScript">
      function validate(f){  
          if(!$("input[type='checkbox']").is(':checked')){
              alert("请选中一门课程！");
              return false;
          }
          return true;  
      }
</script>  
<title>Selected Courses</title>
</head>
<body>
<h3>已选课程：</h3>
<form action ="DeleteCourse" method="get" name= "form1" onSubmit = "return validate()">
<table>
	<tr>
		<th>Course ID</th>
		<th>Course Name</th>
		<th>Drop the Courses</th>
	</tr>
	<%
	List<Course> course = (List<Course>)request.getAttribute("selectedCourse");
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
    %>
</table>
<input type="hidden" name="sid" value= "<%=  (String)request.getAttribute("sid")%>"/>
<input type="submit" value="提交"/>
</form>
<form action="ShowData" method="get">
<input type="hidden" name="sid" value= "<%=  (String)request.getAttribute("sid")%>"/>
<input type="submit"  value="返回课程列表"/>
</form>
</body>
</html>