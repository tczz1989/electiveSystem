package electiveSystem.vo;

import java.util.*;
import electiveSystem.factory.DAOFactory;

public class Index {
	public static Course[] courseList = {new Course("001","C�������"),new Course("002","Java�γ����"),new Course("003","���ݽṹ"),new Course("004","���������"),new Course("005","����ԭ��"),new Course("006","�ߵ���ѧ")};
	public static Student[] studentList = {new Student("001","����"),new Student("002","����"),new Student("003","��С��"),new Student("004","С����")};
	public static Teacher[] teacherList = {new Teacher("001","�Ա�ɽ"),new Teacher("002","��ΰ")};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "admin";
		String password = "admin";
		Account account = new Account();
		account.setId(id);
		account.setPassword(password);
		try {
			if(DAOFactory.getIaccountDAOInstance().findLogin(account)) {
				System.out.println("ͨ����֤"+account.getId()+"�ѵ�¼");
			}else {
				System.out.println("��¼ʧ��");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

/*		for(int i = 0; i < studentList.length; i++) {
			Set<Integer> set = randomSet(0, courseList.length, 3);
			Iterator <Integer> it = set.iterator();
			while(it.hasNext()) {
				int c = it.next();
				studentList[i].addCourses(courseList[c]);
				//courseList[c].addStudent(studentList[i]);
			}
		}
		int[] a1 = {0,2,3};
		int[] a2 = {1,4,5};
		for(int i = 0; i < 3; i++ ) {
			teacherList[0].addCourses(courseList[a1[i]]);
			teacherList[1].addCourses(courseList[a2[i]]);
		}
		//getCourses(teacherList[1]);
		Scanner in = new Scanner(System.in);
		System.out.println("��ѡ�� 1.ѧ�� �� 2.��ʦ");
		String x = in.next();
		switch (Integer.parseInt(x)) {
		case 1 : 
			System.out.println("������ѧ���ĺ��룺");
			String i1 = in.next();
			for(int i = 0; i < studentList.length; i++) {
				int id = Integer.parseInt(studentList[i].getId());
				if(id == Integer.parseInt(i1)) {
					getCourses(studentList[i]);
				}
			}
			break; 
		case 2 : 
			System.out.println("�������ʦ�ĺ��룺");
			String i2 = in.next();
			for(int i = 0; i < teacherList.length; i++) {
				int id = Integer.parseInt(teacherList[i].getId());
				if(id == Integer.parseInt(i2)) {
					getCourses(teacherList[i]);
				}
			}
			break;
		}
		in.close();*/
	}
	public static Set<Integer> randomSet(int min, int max, int size) {
		Random r = new Random();
		Set<Integer> set = new HashSet<Integer>();
		while(true) {
			int a = r.nextInt(max-min)+min;
			set.add(a);
			if (set.size()>size) {
				return set;
			}
		}
	}
	public static void getCourses(Student student) {
		student.printName();
		System.out.println("��ѡ�޵Ŀγ��У�");
		student.printCourses();
	}
	public static void getCourses(Teacher teacher) {
		teacher.printName();
		System.out.println("�����ڵĿγ��У�");
		for(int i = 0; i < teacher.getCourses().size(); i++) {
			teacher.getCourses().get(i).printName();
			System.out.println("ѡ�����ſγ̵�ѧ���У�");
			printStudents(teacher.getCourses().get(i));
			System.out.println("=============================\n");
		}
	}
	public static void printStudents(Course course) {
		for(int i = 0; i < studentList.length; i++) {
			if(studentList[i].getCourses().contains(course)) {
				studentList[i].printName();
			}
		}	
	}

}
