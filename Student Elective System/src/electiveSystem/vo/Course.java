package electiveSystem.vo;

//import java.util.ArrayList;

public class Course {
	private String id;
	private String name;
	//private ArrayList<Student> students;
	public Course(String id, String name) {
		this.id = id;
		this.name =  name;
	//	this.students = new ArrayList<Student>();
	}
	public Course() {
		
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
	//public void addStudent(Student student) {
	//	this.students.add(student);
	//}
	//public void deleteStudent(Student student) {
	//	this.students.remove(student);
	//}
	public void printName() {
		System.out.println("¿Î³ÌºÅÂë:" + this.id +"\t¿Î³ÌÃû³Æ£º" + this.name);
		System.out.println("=============================");
	}
	//public void printStudents() {
	//	for(int i = 0; i < students.size(); i++) {
	//		students.get(i).printName();
	//	}
	//}

}
