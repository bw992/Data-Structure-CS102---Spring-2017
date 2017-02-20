package schoolreg;

import java.io.Serializable;
import java.util.Scanner;


import java.util.ArrayList;

public class user implements Serializable {
	private String username;
	private String password;
	private String first_name;
	private String last_name; 
	
	public user(String username,String password,String first_name,String last_name){
		this.username =username;
		this.first_name = first_name;
		this.password =password;
		this.last_name = last_name;
	}
	
	public String getFirstname(){
		return first_name;
	}
	
	public String getUsername(){
		return username;
	}
	public String getlastname(){
		return last_name;
	}
	
	public String getpassword(){
		return password;
	}
	
	public void setlastname(String last){
		last_name = last;
	}
	
	public void setfirstname(String last){
		first_name = last;
	}

	public void setusername(String last){
		username = last;
	}
	public void setpassword(String last){
		password= last;
	}
	
	//override or inheritance 
	public String toString(){
		return first_name + last_name;
	}
	/*Scanner input = new Scanner (System.in);
	int Choice;
	public void display(){
			System.out.println("Choose the option below");
			System.out.println("1-Admin, 2-Student, 3-exit");
			Choice = input.nextInt();
			input.nextLine();
			switch (Choice){
			case 3: System.exit(0);
			case 1: 
				System.out.println("Enter Admin Menu");
				String username = input.nextLine(); 
				System.out.println(username);
				
				
				if (username.equals( "Admin")){
					System.out.println("Enter password"); 
					String password = input.nextLine(); 
					if (password == "Admin001");{
						System.out.println("Login successfully");
					
						admin.display();
				}
				}

				else{
					System.out.println("Login denied");}	
				
				break;
					
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
				Student st1 =new Student(stud_username,stud_password,stud_firstname,stud_lastname,id, null);
				st1.display();
				break;
			
		    default:
					System.out.println("Invalid input, exit system");
					System.exit(0);
					
					
		}

		
	}*/
}


