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
 * Servlet implementation class WelPage
 */
@WebServlet("/SelectCourse")
public class SelectCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCourse() {
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
		String[] cid = request.getParameterValues("cid");
		List<Course> courses = new ArrayList<Course>();
		List<String> info = new ArrayList<String>();
		List<Course> course = new ArrayList<Course>();
		List<Teacher> teachers =  new ArrayList<Teacher>();
		try {
			course = DAOFactory.getIaccountDAOInstance().findallCourses();
			teachers = DAOFactory.getIaccountDAOInstance().findallTeachers();
			courses = DAOFactory.getIaccountDAOInstance().findStudent(sid).getCourses();
			List<String> cid_new = new ArrayList<String>();
			for(int i = 0; i < cid.length; i++) {
				boolean flag = false;
				for(int j = 0; j < courses.size(); j++) {
					if(Integer.parseInt(cid[i]) == Integer.parseInt(courses.get(j).getId())) {
						flag = true;
						info.add("你已经选择了"+courses.get(j).getName());
						System.out.println("你已经选择了"+courses.get(j).getName());
					}
				}
				if(!flag) {
					cid_new.add(cid[i]);
				}
			}
			if(cid_new.size() > 0) {
				String[] cid_finnal = cid_new.toArray(new String[0]);
				if(DAOFactory.getIaccountDAOInstance().selectCourse(sid, cid_finnal)) {
					info.add("选课成功！");
				}else {
					info.add("选课失败");
				}
			}else {
				System.out.println("不可以重复选课！");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	    request.setAttribute("course", course);
	    request.setAttribute("sid", sid);
	    request.setAttribute("teachers", teachers);
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
