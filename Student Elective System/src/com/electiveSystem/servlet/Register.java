package com.electiveSystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import electiveSystem.factory.DAOFactory;
import electiveSystem.vo.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String path = "Index.jsp";
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String sid = request.getParameter("sid");
		List<String> info = new ArrayList<String>();
	    if(id==null||"".equals(id)){  
	        info.add("用户名不能为空");  
	        System.out.println("用户名不能为空");  
	    }  
	  
	    if(password==null||"".equals(password)){  
	        info.add("密码不能为空");  
	        System.out.println("密码不能为空");  
	    }
		if (info.size() == 0) {
			Account account = new Account();
			account.setId(id);
			account.setPassword(password);
			account.setSid(sid);
			try {
				Student student = DAOFactory.getIaccountDAOInstance().findStudent(sid);
				if(student.getName() == null || "".equals(student.getName())) {
					System.out.println("该学号不存在！");
					info.add("该学号不存在！");
				}else {
					if(DAOFactory.getIaccountDAOInstance().createAccount(account)) {
						info.add("注册成功，帐号"+account.getId()+"已创建");
						System.out.println("帐号"+account.getId()+"已创建");
					}else {
						info.add("该用户已被注册");
						System.out.println("该户用已被注册");
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
        request.setAttribute("info", info);     
        request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
