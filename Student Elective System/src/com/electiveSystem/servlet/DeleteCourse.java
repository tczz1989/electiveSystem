package com.electiveSystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import electiveSystem.vo.*;
import electiveSystem.factory.DAOFactory;

/**
 * Servlet implementation class DeleteCourse
 */
@WebServlet("/DeleteCourse")
public class DeleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCourse() {
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
		System.out.println(sid);
		String[] cid = request.getParameterValues("cid");
		List<String> info = new ArrayList<String>();
		Student student = new Student();
		if(cid.length > 0) {
			try {
				if(DAOFactory.getIaccountDAOInstance().deleteCourse(sid, cid)) {
					info.add("ÍË¿Î³É¹¦£¡");
					System.out.println("ÍË¿Î³É¹¦");
					student = DAOFactory.getIaccountDAOInstance().findStudent(sid);
				}else {
					info.add("ÍË¿ÎÊ§°Ü");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
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
