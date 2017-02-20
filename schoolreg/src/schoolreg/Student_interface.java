package schoolreg;

import java.util.ArrayList;

public interface Student_interface {
	public static ArrayList<String> courses = new ArrayList<String>(); 
	//Course Mangement 
	//1. View all courses
	public void view_all_class();
	//2. View all course that are not full
	public void view_not_full_calss();
	//3. Register on a course 
	public void register_on_a_course(String course_name,int section_number,String full_name);
	//4. Withdraw from a course 
	public void withdraw_a_course(String full_name, String course_name);
	//5. View all courses that the current student is being registered in 
	public void student_class_list();
	public ArrayList<String> getCourses ();
}
