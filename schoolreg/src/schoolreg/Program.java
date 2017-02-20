package schoolreg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program {
	

	

	
	/*public static ArrayList string_deserlaize(){
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
    }*/
	
	/*public static void course_seralize(ArrayList All_course){
		
		try{
	        FileOutputStream fos= new FileOutputStream("course_arraylist.ser");
	        ObjectOutputStream oos= new ObjectOutputStream(fos);
	        oos.writeObject(All_course);
	        oos.close();
	        fos.close();
	        System.out.println("Serilization Arraylist compelted");
	      }catch(IOException ioe){
	           ioe.printStackTrace();
	       
}}*/
	public static Database deserlaize(){
		//File file1  =new File("CourseRegis.ser");
		Database arraylist= new Database();
	try
    {
        FileInputStream fis = new FileInputStream("CourseRegis.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        arraylist = (Database) ois.readObject();
        ois.close();
        fis.close();
        System.out.println("Deserilization compelted");
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
  
	public static void seralize(Database datz){
		
		try{
	        FileOutputStream fos= new FileOutputStream("CourseRegis.ser");
	        ObjectOutputStream oos= new ObjectOutputStream(fos);
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
		
		nyu.getCourses_list();
		nyu.getStudent_list();
	
		//File file1 = ;
		Path path = Paths.get("CourseRegis.ser");
		Path path2 = Paths.get("course_arraylist.ser");
		
		if(Files.exists(path)==false){//&&Files.exists(path2)
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
					//nyu.All_course.add(cos);
					
					
				}
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
			nyu = deserlaize();}
		
		nyu.display();
		
		seralize(nyu);
		//course_seralize(Course.get_all_course());
		//System.out.println(Course.All_course.get(1).get_Course_id());
		
				}
}
	


