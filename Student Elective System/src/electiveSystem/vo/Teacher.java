package electiveSystem.vo;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
	private String name;
	private String id;
	private List<Course> courses;
	public Teacher(String id, String name) {
		this.id = id;
		this.name = name;
		this.courses = new ArrayList<Course>();
	}
	public Teacher() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Course> getCourses(){
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public void addCourses(Course course) {
		this.courses.add(course);
	}
	public void deleteCourses(Course course) {
		this.courses.remove(course);
	}
	public void printName() {
		System.out.println("教师号码:" + this.id +"\t教师姓名：" + this.name);
		System.out.println("=============================");
	}
	//public void printCourses() {
	//	for(int i = 0; i < courses.size(); i++) {
	//		courses.get(i).printName();
	//		System.out.println("选修这门课程的学生有：");
	//		courses.get(i).printStudents();
	//		System.out.println("=============================");
	//	}
	//}

}
