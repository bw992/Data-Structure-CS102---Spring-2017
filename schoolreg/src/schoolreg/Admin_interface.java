package schoolreg;

import java.io.IOException;
import java.util.ArrayList;

public interface Admin_interface {
	
	 //Course Management
	 //1.Create a new course 
	 public void add_new_course(String Course_Name,String Course_id,int Maximum_Students
				,int Current_Students, ArrayList<String> List_Of_Names,String Course_Instructor, int Course_Section_Number, String Course_Location);
	 //5.Register a student 
	 public  void enrollStudentInCourse(String username, Course course );
	 //2. Delete a course 
	 public void Delete_a_course(String delete_course_name,int sec_number);
	 //3 Edit a course 
	 public  void Edit_course(String course_id,int sec);
	 //4 Display information for a given course 
	 public void Display_info(String course_id,int sec);
	 //5:registrate a student from admin
	 public void add_student(String student_name,String id);
	 
	//Reports
	//1. view all courses 
	public void view_all_class();
	//2. view all courses that are full;
	public void view_all_full_class();
	//3 Write a file the list of course that are full
	public void write_file_of_list() throws IOException ;
	//4 view the names of the students that being registered in a specific  class
	public void view_names_in_class(String id);
	//5 view the list of student class 
	public void student_class(String fullname);
	//6 Sort courses based on current number of student 
	public void sort_courses();
	//1 
	








}
