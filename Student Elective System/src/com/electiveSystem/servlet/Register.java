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
	        info.add("�û�������Ϊ��");  
	        System.out.println("�û�������Ϊ��");  
	    }  
	  
	    if(password==null||"".equals(password)){  
	        info.add("���벻��Ϊ��");  
	        System.out.println("���벻��Ϊ��");  
	    }
		if (info.size() == 0) {
			Account account = new Account();
			account.setId(id);
			account.setPassword(password);
			account.setSid(sid);
			try {
				Student student = DAOFactory.getIaccountDAOInstance().findStudent(sid);
				if(student.getName() == null || "".equals(student.getName())) {
					System.out.println("��ѧ�Ų����ڣ�");
					info.add("��ѧ�Ų����ڣ�");
				}else {
					if(DAOFactory.getIaccountDAOInstance().createAccount(account)) {
						info.add("ע��ɹ����ʺ�"+account.getId()+"�Ѵ���");
						System.out.println("�ʺ�"+account.getId()+"�Ѵ���");
					}else {
						info.add("���û��ѱ�ע��");
						System.out.println("�û����ѱ�ע��");
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
