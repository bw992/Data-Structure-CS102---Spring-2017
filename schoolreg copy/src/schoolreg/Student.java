package schoolreg;

import java.util.ArrayList;

public class Student extends user {
	private String id ;
	private ArrayList<String> courses= new ArrayList<String>(); 

	public Student(String username, String password, String first_name, String last_name,String id, ArrayList courses) {
		super(username, password, first_name, last_name);
		// Inherit the parent class
		this.id = id;
		this.courses =courses;
	}
	
	
	public String getStudentId(){
		return id;
	}
	
	public void view_all_class(){
		System.out.print(Course.All_course);
	}
	
	public void view_not_full_calss(){
		System.out.print(Course.check_if_class_not_full());
	}
	
	//3. Register on a cours
	public void register_on_a_course(String course_name,int section_number,){
		courses.add(course_name,section_number);
		Course  add_student_studentside();
	}
			
}
	// Req 4.5 
	//public ArrayList getStudentCourses(){
	//	return courses;
	//}
	// Req 4.3
	
	//public course addCourses(String Course_Name, String Course_id, int Course_Section_Number, String first_name, String last_name){
		//course student_course = new course(Course_Name,Course_id);
		//if (course.get_Course_Section_Number() == Course_Section_Number){
			
		//}

