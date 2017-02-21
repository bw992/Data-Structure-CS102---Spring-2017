package schoolreg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends user implements java.io.Serializable{
	private String id ;
	public static ArrayList <String> courses = new ArrayList<String>(); 

	
	public Student(String username, String password, String first_name, String last_name,String id, ArrayList courses) {
		super(username, password, first_name, last_name);
		// Inherit the parent class
		this.id = id;
		this.courses =new ArrayList<String>();
	}
	
	
	public String getStudentId(){
		return id;
	}
	
	public static ArrayList<String> getCourses(){
		return courses;
	}
	//1.view all class
	public static void view_all_class(){
			for (int i = 0; i < Course.All_course.size(); i++) {
				 System.out.println("Course Name:" + Course.All_course.get(i).get_Course_Name());
			     System.out.println("Course id:" +Course.All_course.get(i).get_Course_id());
			     System.out.println("Course cur-stu:" +Course.All_course.get(i).get_Current_Students());
			     System.out.println("Course max-stu:" +Course.All_course.get(i).get_Max_Students());
			     System.out.println("Course list of names:" +Course.All_course.get(i).get_List_of_name());
			     System.out.println("Course instructor:" +Course.All_course.get(i).get_Course_Instructor());
			     System.out.println("Course sec num:" +Course.All_course.get(i).get_Course_Section_Number());
			     System.out.println("Course location:" +Course.All_course.get(i).get_Course_Locations());
			     System.out.println("-----------------------------------------");}
		}
	
	
	//2. view all classes that are not full 
	public static void view_not_full_calss(){
		Course.check_if_class_not_full();
	}
	
	//3. Register on a course
	public static void register_on_a_course(String course_name,String id, int sec_number,String full_name){
		System.out.println(Course.get_Course(id,sec_number));
		//To check if the id is in the existing id list 
		System.out.println(Course.get_Course(id,sec_number) != null);
		//System.out.println(Course.All_course.size());	
		for(Course temp: Database.All_course){
			if (Course.get_Course(id,sec_number) != null){
				//System.out.println("ongoing  - plz wait - check course id ing ");
				
				//System.out.println("above is the course_name2");
				//problem starts here 				
				//System.out.println(sec_number);
				Course.add_student_studentside(id, sec_number,full_name);
				System.out.println("Registration success XD");
				System.out.println("The course id which is added in the student class temp list is "+id);
				getCourses().add(course_name);
				System.out.println(getCourses().get(0));
				//Student.getCourses().add(id);
				view_all_class();
				
			return;
			
		}
		else{
			System.out.println("Course not found - Register denied");
			return;
		}}
	}
	
	//4. withdraw from a course: full name , the course 
	public static void withdraw_a_course(String full_name, String id , int sec_number, String course_name){
				if (Course.get_Course(course_name) != null){
					System.out.println("The course is in the list");
					Course.withdraw_student(full_name,id,sec_number,course_name);
					System.out.println("Withdraw success XD");
					getCourses().remove(course_name);
					view_all_class();
					}
					else {
						System.out.println("The course is not in the list,student can't withdraw");
					}
				}
	
	//5 view all courses that studnet is being registered in
	public static void student_class_list(){
		for(int i =0;i<getCourses().size();i++){
		System.out.println(getCourses().get(i));}
	}

	/*	
 * 	
	
	public void display(){
		System.out.println("1. view all class");
		System.out.println("2. view all classes that are not full ");
		System.out.println("3. Register on a course");
		System.out.println("4. withdraw from a course: full name , the course");
		System.out.println("5. view all courses that studnet is being registered in");
		System.out.println("6. Exit");
		Choice = input.nextInt();
		input.nextLine();
		switch (Choice){
		case 6: System.exit(0);
		case 1: 
				view_all_class();
				return;
		case 2: 
				view_not_full_calss();
				return;
		case 3: 
			System.out.println("Enter course id");
			String cos = input.nextLine(); 
			System.out.println(Course.get_Course(cos));
			System.out.println("----");
			System.out.println("Enter section number"); 
			int secnumber = input.nextInt(); 
			input.nextLine();
			System.out.println("----");
			System.out.println("Enter student's full name");
			String name = input.nextLine(); 
			System.out.println("You are looking for course" + cos + "  secton #" +secnumber+ "  your name is "+ name);
			
			register_on_a_course(cos,secnumber,name);
			break;
		case 4: 
			System.out.println("Enter course name");
			String cos1 = input.nextLine(); 
			System.out.println("Enter student's full name");
			String name1 = input.nextLine(); 
			withdraw_a_course(name1, cos1);
			break;
		case 5: 
			System.out.println("Below is all the courses that student is on");
			student_class_list();
			break;
		
		default:
				System.out.println("Invalid input, exit system");
				System.exit(0);	
	

	
		}
	

}*/}


