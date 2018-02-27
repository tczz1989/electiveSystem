package com.electiveSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import electiveSystem.vo.*;
import electiveSystem.factory.DAOFactory;

/**
 * Servlet implementation class TeacherCourse
 */
@WebServlet("/SelectedCourse")
public class SelectedCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectedCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String path = "selectedCourse.jsp";
		String sid = request.getParameter("sid");
		Student student = new Student();
		try {
			student = DAOFactory.getIaccountDAOInstance().findStudent(sid);
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("sid", sid);
		request.setAttribute("selectedCourse", student.getCourses());
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
