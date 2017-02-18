package schoolreg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.List;
import java.io.FileWriter;
import java.io.IOException;

public class Admin extends user implements Admin_interface  {
	public static ArrayList<Course> admin_course = new ArrayList<Course>();
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
		 System.out.print("Successfully added a course");
		 
	 }
	
	 //2. Delete a course by using course id 
	 public void Delete_a_course(String delete_course_name,int sec_number){
		System.out.println(Course.get_Course(delete_course_name,sec_number) ); 
		if (Course.get_Course(delete_course_name, sec_number) != null){
			//System.out.println("The course if exists: "+Course.get_Course(delete_course_name) );
			Course.delete_course(delete_course_name,sec_number);
			System.out.println("Delete course successfully.");
			System.out.println("Retrun to the Admin menu.");
			//System.out.println("The course ######");
			
			}
			else {
				System.out.println("The course is not in the list");
				System.out.println("Retrun to the Admin menu.");
			}
		}
	 // loop through the course string to find the same course name 
	 // if not return false 
		
		//3.edit a course 
		public  void Edit_course(){
			
		}
		//4.Display information for a giver course (String course id )
		public void Display_info(String course_id,int sec){
			if (Course.get_Course(course_id,sec) != null){
				System.out.println(Course.get_Course(course_id,sec));
				}
				else {
					System.out.println("There is nothing about the specific course in the system");
				}
			}
		//5:registrate a student override 
		public void add_student(String student_name,String id,int sec){
			System.out.println("in admin class");
			if (Course.get_Course(id,sec) != null){
				Course.add_student(id, student_name);
			}
			else {
				System.out.println("Wrong course id");
			}
		}
		
		//1. view all courses 
		public void view_all_class(){
			for (int i = 0; i < Course.All_course.size(); i++) {
			     System.out.println(Course.All_course.get(i).get_Course_Name()+" "+ Course.All_course.get(i).get_Course_id()+" "+Course.All_course.get(i).get_Current_Students()+" "+Course.All_course.get(i).get_Max_Students()+" "+Course.All_course.get(i).get_List_of_name()+" "+Course.All_course.get(i).get_Course_Instructor()+" "+Course.All_course.get(i).get_Course_Section_Number()+" "+Course.All_course.get(i).get_Course_Locations());
			}
		}
		
		//2. view all courses that are full
		public void view_all_full_class(){
			
			Course.check_if_class_full();
		}
		
		//3 Write a file the list of course that are full
		public void write_file_of_list() throws IOException{
			FileWriter writer = new FileWriter("output.txt"); 
			String str = Course.list_if_class_full();
			writer.write(str);
			writer.close();
			System.out.println("The list is written in output.txt");
			
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
	/*
		public void display(){
			
			System.out.println("1. create a new course");
			System.out.println("2. Delete a course ");
			System.out.println("3. Edit a course ");
			System.out.println("4. Display information for a given course( by id)");
			System.out.println("5. Register a student");
			System.out.println("6. Exit");
			System.out.println("7. View all course ");
			System.out.println("8. View all courses that are FULL");
			System.out.println("9. Write to file that list of course that are full");
			System.out.println("10. View the names of the students being registered in a specific course");
			System.out.println("11. View the list of courses that a given student is being registered on");
			System.out.println("12.  Sort courses based on the current number of student registers");
			Choice = input.nextInt();
			input.nextLine();
			switch (Choice){
			case 6: System.exit(0);
			case 1: 
				System.out.println("Enter course name");
				String cos = input.nextLine(); 
				System.out.println("Enter course id "); 
				String id= input.nextLine(); 
				System.out.println("Enter Maximum Students"); 
				int max_num= input.nextInt();
				System.out.println("Enter current Students"); 
				int cur_num= input.nextInt(); 
				System.out.println("Enter lists of names"); 
				String lists= input.nextLine(); 
				ArrayList<String> myList = new ArrayList<String>(Arrays.asList(lists));
				System.out.println("Enter course instructor");
				String teacher = input.nextLine(); 
				System.out.println("Enter section number"); 
				int sec_num= input.nextInt(); 
				System.out.println("Enter course location");
				String loc = input.nextLine(); 
				add_new_course(cos,id,max_num,cur_num, myList,teacher, sec_num,loc);
				break;
			case 2: 
				System.out.println("Enter course name which you want to delete ");
				String cos1 = input.nextLine(); 
				Delete_a_course(cos1);;
				break;
			case 3: 
				Edit_course();
				break;
			case 4: 
				System.out.println("Enter the course id , so we can display info");
				String id3 = input.nextLine(); 
				Display_info(id3);
				break;
			case 5: 
				System.out.println("Enter course name");
				String cos2 = input.nextLine(); 
				System.out.println("Enter student's full name");
				String name1 = input.nextLine(); 
				add_student(name1,cos2);;
				break;
			case 7: 
				view_all_class();
				break;
			case 8: 
				view_all_full_class();
				break;
			case 9: 
				try {
					write_file_of_list() ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 10:
				System.out.println("Enter the course id , so we can display names");
				String id4 = input.nextLine(); 
				view_names_in_class(id4);
				break;
			case 11:
				System.out.println("Enter first name ");
				String fn = input.nextLine(); 
				System.out.println("Enter first name ");
				String ln = input.nextLine();
				student_class(fn,ln);
				break;	
			case 12: 
				sort_courses();
				break;
				
			default:
					System.out.println("Invalid input, exit system");
					System.exit(0);	
		
			}
			}	*/
		@Override
		public void add_student(String student_name, String id) {
			// TODO Auto-generated method stub
			
		}
	}

