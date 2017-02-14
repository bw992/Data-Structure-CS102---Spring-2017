package schoolreg;

import java.util.ArrayList;

public class Course {
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
	
	//course id 
	public String Course_id(){
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
	
	public static Course get_Course(String id){
		for(int i =0;i<All_course.size();i++){
			if (id.equals(All_course.get(i))){
				return All_course.get(i);
			}
		}
		return null;
	}
	
	public static void add_student(String id, String student_name){
		for (int i =0;i<All_course.size();i++){
			if (id.equals(All_course.get(i))&All_course.get(i).Maximum_Students>All_course.get(i).Current_Students){
				Course tmp = All_course.get(i);
				tmp.List_Of_Names.add(student_name);
				
			}
		}
	}
	public static void add_student_studentside(String id,String course_name, String student_name){
		for (int i =0;i<All_course.size();i++){
			if (id.equals(All_course.get(i)) &  course_name.equals(All_course.get(i))&All_course.get(i).Maximum_Students>All_course.get(i).Current_Students){
				Course tmp = All_course.get(i);
				tmp.List_Of_Names.add(student_name);
				
			}
		}
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
	public static ArrayList<Course> check_if_class_full(){
		ArrayList<Course> full_course = new ArrayList<Course>();
		for(int i =0; i<All_course.size();i++){
			if (All_course.get(i).Maximum_Students>All_course.get(i).Current_Students){
				full_course.add(All_course.get(i));
				
			}
		}
		return full_course;
	}
	//check class if it's not full
	public static ArrayList<Course> check_if_class_not_full(){
		ArrayList<Course> not_full_list = new ArrayList<Course>();
		for(int i =0;i<All_course.size();i++){
			if(All_course.get(i).Maximum_Students<=All_course.get(i).Current_Students){
				not_full_list.add(All_course.get(i));
			}
		}
		return not_full_list;
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
