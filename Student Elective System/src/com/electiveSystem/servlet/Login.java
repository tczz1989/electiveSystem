package com.electiveSystem.servlet;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import electiveSystem.factory.DAOFactory;
import electiveSystem.vo.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		List<String> info = new ArrayList<String>();
		List<Course> courses = new ArrayList<Course>();
		List<Teacher> teachers =  new ArrayList<Teacher>();
		Account account = new Account();
	    if(id==null||"".equals(id)){  
	        info.add("�û�������Ϊ��");  
	        System.out.println("�û�������Ϊ��");  
	    }  
	  
	    if(password==null||"".equals(password)){  
	        info.add("���벻��Ϊ��");  
	        System.out.println("���벻��Ϊ��");
	    }
		if (info.size() == 0) {
			account.setId(id);
			account.setPassword(password);
			try {
				if(DAOFactory.getIaccountDAOInstance().findLogin(account)) {
					info.add("ͨ����֤"+account.getId()+"�ѵ�¼");
					path = "welPage.jsp";
					courses = DAOFactory.getIaccountDAOInstance().findallCourses();
					teachers = DAOFactory.getIaccountDAOInstance().findallTeachers();
					System.out.println("ͨ����֤"+account.getId()+"�ѵ�¼");
				}else {
					
					info.add("��¼ʧ��");
					System.out.println("��¼ʧ��");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
        request.setAttribute("info", info);
        request.setAttribute("course", courses);
        request.setAttribute("sid", account.getSid());
        request.setAttribute("teachers", teachers);
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
