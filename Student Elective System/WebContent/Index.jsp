<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>Student Login</title>
<script language = "JavaScript">
      function validate(f){  
          if(!(/^\w{1,15}$/.test(f.id.value))){  
              alert("用户ID必须是1~15位");  
              f.id.focus();  
              return false;  
          }  
          if(!(/^\w{1,15}$/.test(f.password.value))){  
              alert("密码必须是1~15位");  
              f.password.focus();  
              return false;  
          }
          return true;  
      }
</script>  
</head>
<body>
<h2>用户登录</h2>  
     <%  
        request.setCharacterEncoding("UTF-8");  
     %>
     <%
        List<String> info=(List<String>)request.getAttribute("info");
        if(info != null){
            Iterator<String> iter = info.iterator();
            while(iter.hasNext()){
     %>
                <h4><%= iter.next() %></h4>  
     <%
            }
        }
     %>
     <form name = "form1" action="" method="POST" onSubmit = "return validate(this)">  
       
        用户ID: <input type = "text" name = "id"><br>  
        密  码:<input type = "password" name="password"><br>  
        <input type = "submit" value = "登录" onclick = "form1.action = 'Login'" >
        <input type = "button" value = "注册" onclick = "location.href='Register.jsp'"> 
        <input type = "reset" value = "重置">  
     </form>  
</body>
</html>