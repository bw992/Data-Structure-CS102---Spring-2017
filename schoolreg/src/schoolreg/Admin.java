package schoolreg;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Admin extends user {
	ArrayList<Course> admin_course = new ArrayList<Course>();
	//Default Constructor
	 public Admin(String username, String password, String first_name, String last_name){
		 super(username, password, first_name, last_name);
	 }
	 //Req 03 .5 Register a studnet 
	 public void enrollStudentInCourse(String username, Course course ){
		 if(course.get_Current_Students()<course.get_Max_Students()){
			  course.get_List_of_name().add(username);
			  int new_course_current_student = course.get_Current_Students() +1;
			  course.set_Course_current_students(new_course_current_student);}
		 
	 }
	 
	 //1
	 public void add_new_course(String Course_Name,String Course_id,int Maximum_Students
				,int Current_Students, ArrayList<String> List_Of_Names,String Course_Instructor, int Course_Section_Number, String Course_Location){
		 
		 Course temp = new Course(Course_Name,Course_id,Maximum_Students
					,Current_Students, List_Of_Names,Course_Instructor,Course_Section_Number,Course_Location);
		 admin_course.add(temp);
		 Course.All_course.add(temp);
		 
	 }
	
	 //2. Delete a course by using course id 
	 public void Delete_a_course(String delete_course_name){
		if (Course.get_Course(delete_course_name) != null){
			admin_course.remove(delete_course_name);
			Course.All_course.remove(delete_course_name);
			}
			else {
				System.out.println("The course is not in the list");
			}
		}
	 // loop through the course string to find the same course name 
	 // if not return false 
		
		//3.edit a course 
		public void Edit_course(){
			
		}
		//4.Display information for a giver course (String course id )
		public void Display_info(String course_id){
			if (Course.get_Course(course_id) != null){
				System.out.println(Course.get_Course(course_id));
				}
				else {
					System.out.println("There is nothing about the specific course in the system");
				}
			}
		//5:registrate a student override 
		public void add_student(String student_name,String id){
			if (Course.get_Course(id) != null){
				Course.add_student(id, student_name);
			}
		}
		
		//1. view all courses 
		public void view_all_class(){
			System.out.print(Course.All_course);
		}
		
		//2. view all courses that are full
		public void view_all_full_class(){
			System.out.println(Course.check_if_class_full());
		}
		
		//3 Write a file the list of course that are full
		public void write_file_of_list() throws IOException{
			FileWriter writer = new FileWriter("output.txt"); 
			String str = Course.check_if_class_full().toString();
			writer.write(str);
			writer.close();
			}
			
		
		//4 view the names of the students that being registered in a specific  class
		public void view_names_in_class(String id){
			
			 System.out.println(Course.find_studentnames_inclass(id));
		}
	
			
		//5 view the list of student class 
		public void student_class(String first_name,String last_name){
			String full_name = first_name+last_name;
			System.out.println(Course.find_student_all_class(full_name));
		}
		//6 Sort courses based on current number of student 
		public void sort_courses(){
			Course.sort_list();
			System.out.println(Course.sort_list());
		}
	
	 
	
		
	}

