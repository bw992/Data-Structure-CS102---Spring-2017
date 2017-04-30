package hw5;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class program {
	public static void main(String[] args) throws ParseException, IOException{
		BST<Integer, Person> bst = new BST<Integer, Person>();
		File cusFile = null;
		File queries = null;
		if (0 < args.length) {
		   cusFile = new File(args[0]);//read first file from command line : community.txt
		   queries = new File(args[1]);//read second file from command line: queriesfile.txt
		} 
		else {
		   System.err.println("Invalid arguments count:" + args.length);
		   System.exit(0);
		}
		
		BufferedReader br = null;//first file reader 
		BufferedReader cr = null;//2nd file reader 
		
		  try {

	            String sCurrentLine;
	            String cCurrentLine;

	            br = new BufferedReader(new FileReader(cusFile));
	           
	            
	           // System.out.println("This is the serving time: "+serving_time);
	           
	            while ((sCurrentLine = br.readLine()) != null) {
	            	String[] lineArray = sCurrentLine.split(": ");
	            	String first_name = lineArray[1];
	            	System.out.println(first_name);
	            	sCurrentLine = br.readLine();
	            	lineArray = sCurrentLine.split(": ");
	            	String last_name = lineArray[1];
	            	System.out.println(last_name);
	            	//int id_int = Integer.parseInt(id);
	            	//System.out.println(id_int);
	            	sCurrentLine = br.readLine();
	            	lineArray = sCurrentLine.split(": ");
	            	String ssn = lineArray[1];
	            	int ssn_int = Integer.parseInt(ssn);
	            	System.out.println(ssn_int);
	                System.out.println(sCurrentLine); // print the entire line 
//	                df = new SimpleDateFormat("HH:mm:ss");
//	                java.util.Date d =   df.parse(arr_time); 
//	                Calendar cal = Calendar.getInstance();
//	                cal.setTime(d);
	                sCurrentLine = br.readLine();
	                lineArray = sCurrentLine.split(": ");
	            	String father_ssn = lineArray[1];
	            	int father_ssn_int = Integer.parseInt(father_ssn);
	            	System.out.println(father_ssn_int);
	               sCurrentLine = br.readLine();
	               lineArray = sCurrentLine.split(": ");
	               String mother_ssn = lineArray[1];
	               int mother_ssn_int = Integer.parseInt(mother_ssn);
	               System.out.println(mother_ssn_int);
	               sCurrentLine = br.readLine();
	               lineArray = sCurrentLine.split(": ");
	               String friend = lineArray[1];
	               System.out.println(friend);
	               // How to store friend into a BST for each person 
	               Person temp1 = new Person(ssn_int,first_name,last_name,father_ssn_int,mother_ssn_int); // Add person into community 
//	                community.insert(temp1); // Insert person into community
	                br.readLine();
	                bst.insert(ssn_int, temp1);
	            }
	            
	            cr = new  BufferedReader(new FileReader(queries));
	            
	            while((cCurrentLine = cr.readLine()) != null) {
//	            	System.out.println(cCurrentLine);
	            	//Display the query here 
	            }
	            
	          
	        } 

	        catch (IOException e) {
	            e.printStackTrace();
	        } 

			catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  String temp_name = name_of_ssn(bst,1);
		  System.out.println("NAME-OF 1:"+temp_name);
		  temp_name = father_of_ssn(bst,10);
		  System.out.println("FATHER-OF 10:"+temp_name);
		  temp_name = mother_of_ssn(bst,11);
		  System.out.println("MOTHER-OF 10:"+temp_name);
		  temp_name = mother_of_ssn(bst,11);
		  System.out.println("MOTHER-OF 11:"+temp_name);
		  int mo = mother_of_ssn_int(bst,1);
		  int fa = father_of_ssn_int(bst,1);
		  bst.preOrderTraversal_full(fa,mo);
		  mo = mother_of_ssn_int(bst,11);
		  fa = father_of_ssn_int(bst,11);
		  System.out.println("HALF-SIBLINGS-OF 11:");
		  bst.preOrderTraversal(fa, mo);
		  
		  
	}
	
	public static String name_of_ssn(BST bst,int i){
		Person p = (Person) bst.find(i);
		String x = p.getFullname();
		return x;
	}
	
	public static String mother_of_ssn(BST bst,int i){
		Person p = (Person) bst.find(i);
		int x = p.getMotherSSN();
		Person p1 = (Person)bst.find(x);
		String mother_name = p1.getFullname();
		return mother_name;
	}
	
	public static String father_of_ssn(BST bst,int i){
		Person p = (Person) bst.find(i);
		int x = p.getFatherSSN();
		Person p1 = (Person)bst.find(x);
		String father_name = p1.getFullname();
		return father_name;
	}
	
	public static int father_of_ssn_int(BST bst,int i){
		Person p = (Person) bst.find(i);
		int x = p.getFatherSSN();
		return x;
}
	public static int mother_of_ssn_int(BST bst,int i){
		Person p = (Person) bst.find(i);
		int x = p.getMotherSSN();
		return x;
}
	}
