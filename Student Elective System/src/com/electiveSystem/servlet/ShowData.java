package com.electiveSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import electiveSystem.vo.*;
import electiveSystem.factory.DAOFactory;

/**
 * Servlet implementation class ShowData
 */
@WebServlet("/ShowData")
public class ShowData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String path = "welPage.jsp";
		String sid = request.getParameter("sid");
		List<Course> courses = new ArrayList<Course>();
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			courses = DAOFactory.getIaccountDAOInstance().findallCourses();
			teachers = DAOFactory.getIaccountDAOInstance().findallTeachers();
		}catch(Exception e) {
			e.printStackTrace();
		}
        request.setAttribute("course", courses);
        request.setAttribute("sid", sid);
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
