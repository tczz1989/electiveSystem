package electiveSystem.dao.proxy;

import java.util.List;
import electiveSystem.dbc.Dbconnection;
import electiveSystem.dao.impl.AccountDAOImpl;
import electiveSystem.dao.IaccountDAO;
import electiveSystem.vo.Account;
import electiveSystem.vo.Course;
import electiveSystem.vo.Student;
import electiveSystem.vo.Teacher;

public class AccountDAOProxy implements IaccountDAO {
	private Dbconnection dbc = null;
	private IaccountDAO dao = null;

	public AccountDAOProxy() {
		try {
			this.dbc = new Dbconnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.dao = new AccountDAOImpl(this.dbc.getConn());
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean findLogin(Account account) throws Exception {
		
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.findLogin(account);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean createAccount(Account account) throws Exception {
		
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.createAccount(account);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}
	
	@Override
	public List<Course> findallCourses() throws Exception {
		try {
			return this.dao.findallCourses();
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}
	
	@Override
	public boolean selectCourse(String sid, String[] cid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.selectCourse(sid, cid);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<Teacher> findallTeachers() throws Exception {
		// TODO Auto-generated method stub
		try {
			return this.dao.findallTeachers();
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Course> findCourses(String tid) throws Exception {
		// TODO Auto-generated method stub
		try {
			return this.dao.findCourses(tid);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public Student findStudent(String sid) throws Exception {
		// TODO Auto-generated method stub
		try {
			return this.dao.findStudent(sid);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean deleteCourse(String sid, String[] cid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.dao.deleteCourse(sid, cid);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}

}
