package electiveSystem.dao;

import electiveSystem.vo.*;
import java.util.List;

public interface IaccountDAO {
	public boolean createAccount(Account account) throws Exception;
	public boolean findLogin(Account account) throws Exception;
	public List<Course> findallCourses() throws Exception;
	public List<Course> findCourses(String tid) throws Exception;
	public boolean selectCourse(String sid, String[] cid) throws Exception;
	public List<Teacher> findallTeachers() throws Exception;
	public Student findStudent(String sid) throws Exception;
	public boolean deleteCourse(String sid, String[] cid) throws Exception;
}
