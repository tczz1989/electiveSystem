package electiveSystem.dao.impl;

import java.sql.*;
import electiveSystem.dao.IaccountDAO;
import electiveSystem.vo.*;

import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements IaccountDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public AccountDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean findLogin(Account account) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			String sql = "SELECT sid FROM login WHERE id = ? AND password = ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1,account.getId());
			this.pstmt.setString(2, account.getPassword());
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()) {
				account.setSid(rs.getString(1));
				flag = true;
			}
		}catch(Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public boolean createAccount(Account account) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			String sql = "INSERT INTO login(id,password,sid) VALUES(?,?,?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1,account.getId());
			this.pstmt.setString(2,account.getPassword());
			this.pstmt.setString(3,account.getSid());
			if(this.pstmt.executeUpdate() > 0) {
				flag = true;
			}
		}catch(Exception e) {
			throw e;
		}
		return flag;
	}
	@Override
	public List<Course> findallCourses() throws Exception {
		List<Course> courseTable = new ArrayList<Course>();
		try {
			String sql = "SELECT * FROM courses";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			//System.out.println(rs.getMetaData().getColumnCount());
			while(rs.next()) {
				Course course = new Course();
				String id = rs.getString("cid");
				String name = rs.getString("cname");
				course.setId(id);
				course.setName(name);
				courseTable.add(course);
			}
		}catch(Exception e) {
			throw e;
		}
		return courseTable;
	}


	@Override
	public boolean selectCourse(String sid, String[] cid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			String sql = "INSERT INTO take(sid, cid) VALUES(?,?)";
			this.pstmt = this.conn.prepareStatement(sql);
			for(int i = 0; i < cid.length; i++) {
				this.pstmt.setString(1,sid);
				this.pstmt.setString(2,cid[i]);
				if(this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			}
		}catch(Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public List<Teacher> findallTeachers() throws Exception {
		// TODO Auto-generated method stub
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			String sql = "SELECT * FROM teachers";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()) {
				Teacher teacher = new Teacher();
				String tid = rs.getString("tid");
				String name = rs.getString("tname");
				teacher.setId(tid);
				teacher.setName(name);
				teacher.setCourses(findCourses(tid));
				teachers.add(teacher);
			}
		}catch(Exception e) {
			throw e;
		}
		return teachers;
	}

	@Override
	public List<Course> findCourses(String tid) throws Exception {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<Course>();
		try {
			String sql = "SELECT cid, cname FROM courses NATURAL JOIN teach WHERE tid = ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, tid);
			ResultSet rs = this.pstmt.executeQuery();
			while(rs.next()) {
				Course course = new Course();
				String cid = rs.getString("cid");
				String cname = rs.getString("cname");
				course.setId(cid);
				course.setName(cname);
				courses.add(course);
			}
		}catch(Exception e) {
			throw e;
		}
		return courses;
	}

	@Override
	public Student findStudent(String sid) throws Exception {
		// TODO Auto-generated method stub
		Student student = new Student();
		try {
			String sql = "SELECT sname, cid, cname FROM take NATURAL JOIN courses NATURAL JOIN students WHERE sid = ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, sid);
			ResultSet rs = this.pstmt.executeQuery();
			List<Course> courses = new ArrayList<Course>();
			String sname = new String();
			while(rs.next()) {
				Course course = new Course();
				sname = rs.getString("sname");
				String cid = rs.getString("cid");
				String cname = rs.getString("cname");
				course.setId(cid);
				course.setName(cname);
				courses.add(course);
			}
			student.setCourses(courses);
			student.setId(sid);
			student.setName(sname);
		}catch(Exception e) {
			throw e;
		}
		return student;
	}

	@Override
	public boolean deleteCourse(String sid, String[] cid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			String sql = "DELETE FROM take WHERE sid = ? AND cid = ?";
			this.pstmt = this.conn.prepareStatement(sql);
			for(int i = 0; i < cid.length; i++) {
				this.pstmt.setString(1,sid);
				this.pstmt.setString(2,cid[i]);
				if(this.pstmt.executeUpdate() > 0) {
					flag = true;
				}
			}
		}catch(Exception e) {
			throw e;
		}
		return flag;
	}
	
	
	

}
