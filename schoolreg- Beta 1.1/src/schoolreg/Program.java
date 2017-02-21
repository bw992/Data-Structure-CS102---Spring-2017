package schoolreg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program implements Serializable{
	

	

	
	public static ArrayList course_deserlaize(){
		//File file1  =new File("CourseRegis.ser");
		ArrayList<Course> arraylist= new ArrayList<Course>();
	try
    {
        FileInputStream fis = new FileInputStream("course_arraylist.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        arraylist = (ArrayList) ois.readObject();
        ois.close();
        fis.close();
        System.out.println("Deserilization arraylist compelted");
     }catch(IOException ioe){
         ioe.printStackTrace();
         return arraylist;
      }catch(ClassNotFoundException c){
         System.out.println("Class not found");
         c.printStackTrace();
         return arraylist;
      }
	return arraylist;
    }
	
	public static ArrayList student_deserlaize(){
		//File file1  =new File("CourseRegis.ser");
		ArrayList<Course> arraylist= new ArrayList<Course>();
	try
    {
        FileInputStream fis = new FileInputStream("student_arraylist.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        arraylist = (ArrayList) ois.readObject();
        ois.close();
        fis.close();
        System.out.println("Deserilization arraylist compelted");
     }catch(IOException ioe){
         ioe.printStackTrace();
         return arraylist;
      }catch(ClassNotFoundException c){
         System.out.println("Class not found");
         c.printStackTrace();
         return arraylist;
      }
	return arraylist;
    }	
	public static void course_seralize(ArrayList All_course){
		
		try{
	        FileOutputStream fos= new FileOutputStream("course_arraylist.ser");
	        ObjectOutputStream oos= new ObjectOutputStream(fos);
	        oos.writeObject(All_course);
	        oos.close();
	        fos.close();
	        System.out.println("Serilization Arraylist compelted");
	      }catch(IOException ioe){
	           ioe.printStackTrace();
	       
}}
	public static void student_seralize(ArrayList All_course){
		
		try{
	        FileOutputStream fos= new FileOutputStream("student_arraylist.ser");
	        ObjectOutputStream oos= new ObjectOutputStream(fos);
	        oos.writeObject(All_course);
	        oos.close();
	        fos.close();
	        System.out.println("Serilization Arraylist compelted");
	      }catch(IOException ioe){
	           ioe.printStackTrace();
	       
}}
	public static Database deserlaize(){
		//File file1  =new File("CourseRegis.ser");
		Database arraylist = null;
	try
    {
        FileInputStream fis = new FileInputStream("CourseRegis.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        arraylist = (Database) ois.readObject();
        //System.out.println(arraylist.All_course.get(0).get_Course_Name());
        System.out.println(arraylist.All_course);
        ois.close();
        fis.close();
        System.out.println("Deserilization compelted");
     }catch(IOException ioe){
         ioe.printStackTrace();
         return null;
      }catch(ClassNotFoundException c){
         System.out.println("Class not found");
         c.printStackTrace();
         return null ;
      }
	
	System.out.println(arraylist.message);
	return arraylist;
    }
  
	public static void seralize(Database datz){
		datz.set_message();
		System.out.println(datz.message);
		System.out.println("Here");
		try{
	        FileOutputStream fos = new FileOutputStream("CourseRegis.ser");
	        ObjectOutputStream oos= new ObjectOutputStream(fos);
	        System.out.println(datz.All_course.get(0).get_Course_Name());
	        oos.writeObject(datz);
	        oos.close();
	        fos.close();
	        System.out.println("Serilization compelted");
	      }catch(IOException ioe){
	           ioe.printStackTrace();
	       
}
  }
	
	public static void main(String[] args) {
		
		Database nyu = new Database();
		
		//nyu.getCourses_list();
		//nyu.getStudent_list();
	
		//File file1 = ;
		Path path1 = Paths.get("student_arraylist.ser");
		//Path path2 = Paths.get("CourseRegis.ser");
		Path path2 = Paths.get("course_arraylist.ser");
		
		if(Files.exists(path1)==false &&Files.exists(path2) ==false){//
			System.out.println("The ser file is not there, read from csv file");
				
			ArrayList<Course> initiate_course= new ArrayList<Course>();
			String csvFile = "bin/schoolreg/MyUniversityCourses.csv";
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(new File(csvFile)));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String cvsSplitBy = ",";
			String line = "";	
			
			try {
				String line1 = br.readLine(); // this will read the first line
				
				line1=null;
				
				while((line1 = br.readLine())!=null){
		
					String[] lineArray = line1.split(",");
					
					ArrayList<String> myList = new ArrayList<String>();
					int max_stud =Integer.parseInt(lineArray[2]);
					//System.out.println(lineArray[0]);
					int cur_stud = Integer.parseInt(lineArray[3]);
					int cur_sec= Integer.parseInt(lineArray[6]);
					Course cos = new Course(lineArray[0],lineArray[1],max_stud,cur_stud,myList,lineArray[5],cur_sec,lineArray[7]);
					initiate_course.add(cos);
					Course.All_course.add(cos);
					
					//Course.set_all_course(nyu.getCourses_list());
					
				}
				nyu.set_all_course(Course.All_course);
				System.out.println(Course.All_course.size());
				System.out.println(nyu.All_course.size());

				//System.out.println(Course.All_course.get(5).get_Course_Locations());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//string_deserlaize();
			//System.out.println(nyu.message);
			//System.out.println(nyu);
			//System.out.println(Course.All_course.get(1).get_Course_id());
		}
		
	else{
			System.out.println("The ser file has alreayd exsisted, then deserlaizae");
			nyu.student_list = student_deserlaize();
			nyu.All_course =course_deserlaize();
			
			//System.out.println(nyu.All_course.get(1).get_Course_Name());
			//System.out.println(nyu..get(0));
			//System.out.println(Course.All_course.size());
			//System.out.println(nyu.All_course);
			//Course.set_all_course(nyu.getCourses_list());
			//Course.set_all_course(nyu.getCourses_list());
			
			Course.All_course =nyu.All_course;
			}
		
		nyu.display();
		
		course_seralize(nyu.All_course);
		student_seralize(nyu.student_list);
		//seralize(nyu);
		//course_seralize(Course.get_all_course());
		//System.out.println(Course.All_course.get(1).get_Course_id());
		
				}
}
	


