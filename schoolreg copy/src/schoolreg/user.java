package schoolreg;

import java.io.Serializable;
import java.util.ArrayList;

public class user {
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
	
	//override or inheritance 
	public String toString(){
		return first_name + last_name;
	}

}
