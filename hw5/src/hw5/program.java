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
		
		BufferedReader br = null; //first file reader 
		BufferedReader cr = null; //2nd file reader 
		
		  try {

	            String sCurrentLine;
	            String cCurrentLine;

	            br = new BufferedReader(new FileReader(cusFile));
	           
	            
	            while ((sCurrentLine = br.readLine()) != null) {
	            	String[] lineArray = sCurrentLine.split(": ");
	            	String first_name = lineArray[1];
	            	sCurrentLine = br.readLine();
	            	lineArray = sCurrentLine.split(": ");
	            	String last_name = lineArray[1];
//	            	System.out.println(last_name);
	            	//int id_int = Integer.parseInt(id);
	            	//System.out.println(id_int);
	            	sCurrentLine = br.readLine();
	            	lineArray = sCurrentLine.split(": ");
	            	String ssn = lineArray[1];
	            	int ssn_int = Integer.parseInt(ssn);
//	            	System.out.println(ssn_int);
//	                System.out.println(sCurrentLine); // print the entire line
	                sCurrentLine = br.readLine();
	                lineArray = sCurrentLine.split(": ");
	            	String father_ssn = lineArray[1];
	            	int father_ssn_int = Integer.parseInt(father_ssn);
//	               System.out.println(father_ssn_int);
	               sCurrentLine = br.readLine();
	               lineArray = sCurrentLine.split(": ");
	               String mother_ssn = lineArray[1];
	               int mother_ssn_int = Integer.parseInt(mother_ssn);
//	               System.out.println(mother_ssn_int);
	               sCurrentLine = br.readLine();
	               lineArray = sCurrentLine.split(": ");
	               String friend = lineArray[1];
	               lineArray = friend.split(",");
	               BST<Integer, Integer> bst1 = new BST<Integer, Integer>();
	               for (int i =0 ; i<lineArray.length;i++){
	            	   int friend_ssn = Integer.parseInt(lineArray[i]);
	            	   bst1.insert(friend_ssn,friend_ssn);
	               }
	               // How to store friend into a BST for each person 
	                Person temp1 = new Person(ssn_int,first_name,last_name,father_ssn_int,mother_ssn_int,bst1); // Add person into community 

	                br.readLine();
	                bst.insert(ssn_int, temp1);
	            }
	        } 

	        catch (IOException e) {
	            e.printStackTrace();
	        } 

			catch (NumberFormatException e) {
				e.printStackTrace();
			}
		
		  cr = new  BufferedReader(new FileReader(queries));
		  read_queries(bst,cr) ;

	}
	
	private static void read_queries(BST<Integer, Person> bst, BufferedReader cr) throws IOException {
		String cCurrentLine;
		
		while((cCurrentLine = cr.readLine()) != null) {
			   String[] lineArray = cCurrentLine.split(" ");
			   //System.out.println(lineArray[0]);
			    if(lineArray[0].equals("NAME-OF")){
			    	int id_temp = Integer.parseInt(lineArray[1]);
			    	 System.out.println(lineArray[0]+ " "+lineArray[1]+":"+ name_of_ssn(bst,id_temp));
			    }
			  
			    if(lineArray[0].equals("FATHER-OF")){
			    	int id_temp = Integer.parseInt(lineArray[1]);
			    	 System.out.println(lineArray[0]+ " "+lineArray[1]+":"+ father_of_ssn(bst,id_temp));
			    }
			    if(lineArray[0].equals("MOTHER-OF")){
			    	int id_temp = Integer.parseInt(lineArray[1]);
			    	 System.out.println(lineArray[0]+ " "+lineArray[1]+":"+ mother_of_ssn(bst,id_temp));
			    }
			    if(lineArray[0].equals("HALF-SIBLINGS-OF")){
			    	int id_temp = Integer.parseInt(lineArray[1]);
					int mo = mother_of_ssn_int(bst,id_temp);
					int fa = father_of_ssn_int(bst,id_temp);
					 
					String x = bst.preOrderTraversal(fa, mo,11);

			    	 System.out.println(lineArray[0]+ " "+lineArray[1]+":"+ x);
			    }
			    if(lineArray[0].equals("FULL-SIBLINGS-OF")){
			    	int id_temp = Integer.parseInt(lineArray[1]);
			    	int mo = mother_of_ssn_int(bst,id_temp);
					int fa = father_of_ssn_int(bst,id_temp);
					
					String x = bst.preOrderTraversal_full(fa,mo,1);
			    	 System.out.println(lineArray[0]+ " "+lineArray[1]+":"+ x);
			    }
			    if(lineArray[0].equals("CHILDREN-OF")){
			    	int id_temp = Integer.parseInt(lineArray[1]);
			    	String h = bst.preOrderTraversal_children(id_temp);
			    	 System.out.println(lineArray[0]+ " "+lineArray[1]+":"+ h);
			    }
			    if(lineArray[0].equals("MUTUAL-FRIENDS-OF")){
			    	int id_temp = Integer.parseInt(lineArray[1]);
			    	Person p1 = bst.find(id_temp);
					BST fri = p1.getFriend();
					String h =fri.preOrderTraversal_mutual(id_temp, bst);
			    	System.out.println(lineArray[0]+ " "+lineArray[1]+":"+h);
			    }
			    if(lineArray[0].equals("INVERSE-FRIENDS-OF")){
			    	int id_temp = Integer.parseInt(lineArray[1]);
			    	String x =bst.preOrderTraversal_inverse(id_temp);
			    	System.out.println(lineArray[0]+ " "+lineArray[1]+":"+x);
			    }
			    if(cCurrentLine.equals("WHO-HAS-MOST-MUTUAL-FRIENDS")){
			    	int i = bst.size();
			    	Person p1 = bst.find(5);
					BST fri = p1.getFriend();
					//System.out.println(i);
					  int count_mutual=0;
					  Person most_mutual_friend = null; 
					  
					  for (int m =0 ; m<i;m++){
						  Person p2 = bst.find(m);
						  if(fri.preOrderTraversal_mutual_count(m,bst)>count_mutual){
							  count_mutual=fri.preOrderTraversal_mutual_count(m, bst);
							  most_mutual_friend = p2;
						  };
					  }
					  
					  System.out.println("WHO-HAS-MOST-MUTUAL-FRIENDS:"+most_mutual_friend.getFullname());
					 
			    	 
			    }
			    
		}
		
		
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
