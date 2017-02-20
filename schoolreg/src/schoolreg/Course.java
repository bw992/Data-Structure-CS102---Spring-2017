package schoolreg;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Course implements Serializable {
	private String Course_Name;
	private String Course_id;
	private int Maximum_Students;
	private int Current_Students;
	ArrayList<String> List_Of_Names = new ArrayList<String>(); 
	private String Course_Instructor;
	private int Course_Section_Number;
	private String Course_Location;
	public static ArrayList<Course> All_course = new ArrayList<Course>();
	
	public Course(String Course_Name,String Course_id,int Maximum_Students
		,int Current_Students, ArrayList<String> List_Of_Names,String Course_Instructor, int Course_Section_Number, String Course_Location){
	//Prvent over enrollment and max student < 1
		if (Current_Students > Maximum_Students)
			throw new IllegalArgumentException("Numebr of current student should not over the max student limit");
		if (Maximum_Students<1)
			throw new IllegalArgumentException("The max number of student limit must be greater than 1.");
		
		this.Course_Name = Course_Name;
		this.Course_id =Course_id;
		this.Course_Instructor =Course_Instructor;
		this.Course_Location= Course_Location;
		this.Course_Section_Number =Course_Section_Number;
		this.Current_Students =Current_Students;
		this.Maximum_Students =Maximum_Students;
		this.List_Of_Names = List_Of_Names;

	}
	public Course(String Course_id){
		this.Course_Name = null ;
		this.Course_id =Course_id;
		this.Course_Instructor = null;
		this.Course_Location= null;
		this.Course_Section_Number =0;
		this.Current_Students =0;
		this.Maximum_Students =0;
		this.List_Of_Names = null;
	}
	
	public static ArrayList get_all_course(){
		return Course.All_course;
	}
	//course id 
	public String get_Course_id(){
		return Course_id;
	}
	
	//course location
	public String get_Course_Locations(){
		return Course_Location;
	}
	
	//student instructor
	public String get_Course_Instructor(){
		return Course_Instructor;
	}
	
	//get student limit number
	public int get_Max_Students(){
		return Maximum_Students;
	}
	
	//get current student number
	public int get_Current_Students(){
		return Current_Students;
	}
	
	//get course name 
	public String get_Course_Name(){
		return Course_Name;
	}
	
	public int get_Course_Section_Number(){
		return Course_Section_Number;
	}
	
	//course list of names 
	public ArrayList get_List_of_name(){
		return List_Of_Names;
	}
	
	//based on id, check course exsists or not 
	public static String get_Course(String id,int sec){
		for(int i =0;i<All_course.size();i++){
			if (id.equals(All_course.get(i).Course_id)&& sec ==All_course.get(i).Course_Section_Number){
				return All_course.get(i).Course_Name+ All_course.get(i).Course_id + All_course.get(i).Current_Students +All_course.get(i).Maximum_Students+ All_course.get(i).List_Of_Names+All_course.get(i).Course_Location+All_course.get(i).Course_Section_Number +All_course.get(i).Course_Instructor ;
				}
		}
		return null;
	}
	
	
	
	public static String get_Course_Name(String coursename){
		for(int i =0;i<All_course.size();i++){
			if (coursename.equals(All_course.get(i).Course_Name)){
				return All_course.get(i).Course_Name;
			}
		}
		return null;
	}
	public static void delete_course(String course_name,int sec_number){
		for (int i =0;i<All_course.size();i++){
			if (course_name.equals(All_course.get(i).Course_id)& sec_number == All_course.get(i).Course_Section_Number){
				//System.out.println(All_course.get(i).Course_id);
				//System.out.println(All_course.get(i).List_Of_Names);
				//System.out.println("-------------------------");
				//System.out.println(All_course.get(i));
				All_course.remove(All_course.get(i));
				System.out.println("The course has been deleted");
			}
			
			}
			
		
	}
	public static void edit_course(String course_name,int sec_number){
		for (int i =0;i<All_course.size();i++){
			if (course_name.equals(All_course.get(i).Course_id)& sec_number == All_course.get(i).Course_Section_Number){
				Scanner input = new Scanner (System.in);
				int Choice;
				System.out.println("Choose the option below");
				System.out.println("1. Change course name");
				System.out.println("2. Change course id");
				System.out.println("3. Change course max_student");
				System.out.println("4. Change course current student");
				System.out.println("5. Change course list of student");
				System.out.println("6. Change course instructor");
				System.out.println("7. Change course section");
				System.out.println("8. Change courselocation");
				Choice = input.nextInt();
				input.nextLine();
				switch (Choice){
				case 1:
					System.out.println("Enter new course name");
					String new_course_name = input.nextLine(); 
					All_course.get(i).set_Course_name(new_course_name);
				case 2:
					System.out.println("Enter new course id");
					String new_course_id = input.nextLine(); 
					All_course.get(i).set_Course_ID(new_course_id);
				case 3:
					System.out.println("Enter new max stu number"); 
					int s1 = input.nextInt(); 
					input.nextLine();
					All_course.get(i).set_Course_maximum_students(s1);
				case 4:
					System.out.println("Enter new current stu number"); 
					int s2 = input.nextInt(); 
					input.nextLine();
					All_course.get(i).set_Course_current_students(s2);
				case 5:
				case 6:
					System.out.println("Enter new course instructor");
					String new_course_ins = input.nextLine(); 
					All_course.get(i).set_Course_instructor(new_course_ins);
				case 7:
					System.out.println("Enter section number"); 
					int sec2 = input.nextInt(); 
					input.nextLine();
					All_course.get(i).set_Course_section(sec2);
				case 8:
					System.out.println("Enter new course location");
					String new_course_loc = input.nextLine(); 
					All_course.get(i).set_Course_location(new_course_loc);
				}
			}}}
	
	//Admin find the names of student in one class
	public static ArrayList<Course> find_studentnames_inclass(String id){
		ArrayList<Course> list_names = new ArrayList<Course>();
		for (int i =0;i<All_course.size();i++){
			if (id.equals(All_course.get(i).Course_id)){
				System.out.println(All_course.get(i).Course_id);
				System.out.println(All_course.get(i).List_Of_Names);
				System.out.println("Above This is the list of names in that course ");
			}
		}
		return list_names;
	}
	//Admin add a student in class
	public static void add_student(String id, String student_name){
		for (int i =0;i<All_course.size();i++){
			if (id.equals(All_course.get(i).Course_id)&All_course.get(i).Maximum_Students>All_course.get(i).Current_Students){
				
				All_course.get(i).List_Of_Names.add(student_name);
				System.out.println(All_course.get(i).Course_id);
				System.out.println(All_course.get(i).List_Of_Names);
				All_course.get(i).Current_Students+=1;
				System.out.println("From admin: This is the list of names after the student name was added ");
				
				
			}
			/*else{
				System.out.println("Add student unscessfully");}
			
		}*/}
	}
	
	// Student register in a class
	public static void add_student_studentside(String course_name,int section_number,String student_name){
		ArrayList<Course> temp = new ArrayList<Course>();
				
		for (int i =0;i<All_course.size();i++){	
			int x = All_course.get(i).get_Course_Section_Number();
			if (course_name.equals(All_course.get(i).Course_id) &  section_number ==x &All_course.get(i).Maximum_Students>All_course.get(i).Current_Students){
				
				temp.add(All_course.get(i));
				All_course.get(i).List_Of_Names.add(student_name);
				System.out.println(All_course.get(i).Course_id);
				System.out.println(All_course.get(i).List_Of_Names);
				All_course.get(i).Current_Students+=1;
				System.out.println("This is the list of names after the student name was added ");
				
			}
		}
	}
	
	
	//Student withdraws from one class
	public static void withdraw_student(String full_name, String id , int sec_number, String course_name){
		for (int i =0;i<All_course.size();i++){
			if (course_name.equals(All_course.get(i).Course_Name)& sec_number == All_course.get(i).Course_Section_Number){
				System.out.println(All_course.get(i).Course_Name);
				System.out.println(All_course.get(i).List_Of_Names);
				All_course.get(i).List_Of_Names.remove(full_name);
				All_course.get(i).Current_Students-=1;
			}
	}
		}
	
	//Find a student's course list 
	public static void find_student_all_class(String full_name){
		String personal_course = "";
		System.out.println("The searching kid is "+full_name);
		
		for (int i=0; i<All_course.size();i++){
			//System.out.println(All_course.get(i).List_Of_Names.contains(full_name));
			if (All_course.get(i).List_Of_Names.contains(full_name)!= true){
				//System.out.println("The name is not found");
			}
			else {
				String x =All_course.get(i).Course_Name; 
				personal_course+= " " + x;
				
			}
		}
		
		System.out.println(full_name+" Has course list:"+personal_course);
	}
	
	//Sort course based on current student number 
	
	public static ArrayList<Course> sort_list(){
		ArrayList<Course> full_course = new ArrayList<Course>();
		for(int x =0; x<All_course.size();x++){
			int tempValue = All_course.get(x).Current_Students;
	        for(int y = 0; y < All_course.size(); y++){
		           if(All_course.get(x).Current_Students < All_course.get(y).Current_Students) {
			              // full_course.get(x).Current_Students = tempValue;
			            }
			        }
			    }

			    return full_course;
			}		
	
	
	public Course get_course_name_info(String name){
		for(int i =0;i<All_course.size();i++){
			if (name.equals(All_course.get(i))){
				return All_course.get(i);
			}
		}
		return null;
	}
	
	//check class if it's full
	public static void check_if_class_full(){
		ArrayList<Course> full_course = new ArrayList<Course>();
		for(int i =0; i<All_course.size();i++){
			if ((All_course.get(i).Maximum_Students)==All_course.get(i).Current_Students){
				full_course.add(All_course.get(i));
				int x = All_course.get(i).Maximum_Students;
				System.out.println("The max student number is "+ x);
				
			}
		}
		for (int i =0; i<full_course.size();i++){
		
		System.out.println("The courses are full "+full_course.get(i).Course_Name+ '\n');}
		System.out.println("Check class full compelted");
	}
	
	public static String list_if_class_full(){
		ArrayList<Course> full_course = new ArrayList<Course>();
		String x = "" ;
		for(int i =0; i<All_course.size();i++){
			if ((All_course.get(i).Maximum_Students)==All_course.get(i).Current_Students){
				full_course.add(All_course.get(i));
			}
		}
		
		for (int i =0; i<full_course.size();i++){
		x += full_course.get(i).Course_Name;}
		return x;
	}
	
	public static void check_if_class_not_full(){
		ArrayList<Course> full_course = new ArrayList<Course>();
		for(int i =0; i<All_course.size();i++){
			if ((All_course.get(i).Maximum_Students)>All_course.get(i).Current_Students){
				full_course.add(All_course.get(i));
				
				
			}
		}
		for (int i =0; i<full_course.size();i++){
			System.out.print(full_course.get(i).Course_Name + '\n');}
		System.out.print("Check class not full compelted");
	}
	
	
	//course section number 
	
	
	public void set_Course_name(String new_course_name){
		Course_Name = new_course_name;
	}
	
	public void set_Course_ID( String new_course_ID){
		Course_id = new_course_ID;
	}
	public void set_Course_maximum_students( int  new_course_max_student){
		Maximum_Students = new_course_max_student;
	}
	public void set_Course_current_students( int new_course_current_student){
		Current_Students = new_course_current_student;
	}
	
	public void set_Course_add_student( String new_course_add_student){
		List_Of_Names.add(new_course_add_student);
	}
	public void set_Course_instructor( String new_course_instructor){
		Course_Instructor = new_course_instructor;
	}
	public void set_Course_section( int new_course_section){
		Course_Section_Number = new_course_section;
	}
	public void set_Course_location( String new_course_location){
		Course_Location = new_course_location;
	}
	
	
	
	
	
	
	//ArrayList<> course = new ArrayList<t>(); 
	//ArrayList<> admin = new ArrayList<t>(); 
	
	
	//seri
	//course.ser
	//student.ser 
}
