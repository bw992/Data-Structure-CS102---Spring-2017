package schoolreg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.Serializable;


public class Database implements java.io.Serializable{
	public static ArrayList<Course> All_course = new ArrayList<>();
	public static ArrayList<Student> student_list= new ArrayList<>();
	
	public Admin admin = new Admin("Admin","Admin001","first_name","last_name");
	
	public Database(){
		
	}
	
	public ArrayList<Course> getCourses_list(){
		return All_course;
	}
	public ArrayList<Student> getStudent_list(){
		return student_list;
	}
	
	public void display(){
		Scanner input = new Scanner (System.in);
		int Choice;
		System.out.println("Choose the option below");
		System.out.println("1-Admin, 2-Student, 3-exit");
		Choice = input.nextInt();
		input.nextLine();
		switch (Choice){
		case 3: System.exit(0);
		case 1: 
			System.out.println("Enter Admin Menu");
			String username = input.nextLine(); 
			System.out.println("Enter password"); 
			String password = input.nextLine(); 
			if (username.equals("Admin")& password.equals("Admin001")){
					System.out.println("Login successfully");
					admin_display();
			}
			else{
				System.out.println("Username or password not right");
				display();
			}
			
			
				
	    case 2: 
	    	
			System.out.println("Enter username");
			String stud_username = input.nextLine(); 
			//System.out.println(stud_username);		
			System.out.println("Enter password"); 
			String stud_password = input.nextLine(); 
			//System.out.println(stud_password);
			System.out.println("Enter first name");
			String stud_firstname = input.nextLine(); 
			System.out.println("Enter last name"); 
			String stud_lastname = input.nextLine(); 
			System.out.println("Enter id"); 
			String id = input.nextLine(); 
			Student st1 =new Student(stud_username,stud_password,stud_firstname,stud_lastname,id,null);
			Stu_display(st1);
			break;
		
	    default:
				System.out.println("Invalid input, exit system");
				System.exit(0);
				
				
	}

	
}
	
	public void Stu_display(Student st1){
		Scanner input = new Scanner (System.in);
		System.out.println("HI"+st1.getFirstname()+st1.getlastname());
		int Choice;
		
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
				st1.view_all_class();
				Stu_display(st1);
				return ;
		case 2: 
				st1.view_not_full_calss();
				Stu_display(st1);
				return;
		case 3: 
			System.out.println("Enter course name");
			String cos1 = input.nextLine(); 
			System.out.println("Enter course id");
			String cos = input.nextLine(); 
			System.out.println("Enter section number"); 
			int sec2 = input.nextInt(); 
			input.nextLine();
			System.out.println(Course.get_Course(cos,sec2));
			System.out.println("----");
			System.out.println("Enter section number"); 
			int secnumber = input.nextInt(); 
			input.nextLine();
			System.out.println("----");
			System.out.println("Enter student's full name");
			String name = input.nextLine(); 
			System.out.println("You are looking for course" + cos + "  secton #" +secnumber+ "  your name is "+ name);
			st1.register_on_a_course(cos1,cos,secnumber,name);
			Stu_display(st1);
			break;
		case 4: 
			System.out.println("Enter course name");
			String cos2 = input.nextLine(); 
			System.out.println("Enter course id");
			String cosid = input.nextLine(); 
			System.out.println("Enter student's full name");
			String name1 = input.nextLine(); 
			System.out.println("Enter section number"); 
			int sec1 = input.nextInt(); 
			input.nextLine();
			st1.withdraw_a_course(name1, cosid,sec1,cos2);
			Stu_display(st1);
			break;
		case 5: 
			System.out.println("Below is all the courses that student is on");
			st1.student_class_list();
			Stu_display(st1);
			break;
		
		default:
				System.out.println("Invalid input, exit system");
				System.exit(0);	
	

	
		}
	

}
	public void admin_display(){
		Scanner input = new Scanner (System.in);
		int Choice;
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
		System.out.println("you are in the admind menu");
		switch (Choice){
		case 6: System.exit(0);
		case 1: 
			System.out.println("Enter course name");
			String cos = input.nextLine(); 
			System.out.println("Enter course id "); 
			String id= input.nextLine(); 
			System.out.println("Enter Maximum Students"); 
			int max_num= input.nextInt();
			input.nextLine();
			System.out.println("Enter current Students"); 
			int cur_num= input.nextInt(); 
			input.nextLine();
			System.out.println("Enter lists of names"); 
			String lists= input.nextLine(); 
			ArrayList<String> myList = new ArrayList<String>(Arrays.asList(lists));
			System.out.println("Enter course instructor");
			String teacher = input.nextLine(); 
			System.out.println("Enter section number"); 
			int sec_num= input.nextInt(); 
			input.nextLine();
			System.out.println("Enter course location");
			String loc = input.nextLine(); 
			admin.add_new_course(cos,id,max_num,cur_num, myList,teacher, sec_num,loc);
			admin_display();
			break;
		case 2: 
			System.out.println("Enter course id which you want to delete ");
			String cos1 = input.nextLine(); 
			System.out.println("Enter section number"); 
			int sec_num1= input.nextInt(); 
			input.nextLine();
			admin.Delete_a_course(cos1,sec_num1);
			admin_display();
			break;
		case 3: 
			admin.Edit_course();
			admin_display();
			break;
		case 4: 
			System.out.println("Enter the course id , so we can display info");
			String id3 = input.nextLine(); 
			System.out.println("Enter section number"); 
			int sec_num2= input.nextInt(); 
			input.nextLine();
			admin.Display_info(id3,sec_num2);
			admin_display();
			break;
		case 5: 
			System.out.println("Enter course ID");
			String cos2 = input.nextLine(); 
			System.out.println("Enter student's full name");
			String name1 = input.nextLine(); 
			admin.add_student(name1,cos2);
			admin_display();
			break;
		case 7: 
			System.out.println("viewing all class now");
			admin.view_all_class();
			admin_display();
			break;
		case 8: 
			admin.view_all_full_class();
			admin_display();
			break;
		case 9: 
			try {
				admin.write_file_of_list();
				admin_display();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 10:
			System.out.println("Enter the course id , so we can display names");
			String id4 = input.nextLine(); 
			admin.view_names_in_class(id4);
			admin_display();
			break;
		case 11:
			System.out.println("Enter first name ");
			String fn = input.nextLine(); 
			System.out.println("Enter first name ");
			String ln = input.nextLine();
			admin.student_class(fn,ln);
			admin_display();
			break;	
		case 12: 
			admin.sort_courses();
			admin_display();
			break;
			
		default:
				System.out.println("Invalid input, exit system");
				System.exit(0);	
	
		}
		}	
	
}
