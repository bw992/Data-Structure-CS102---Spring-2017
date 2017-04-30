package hw5;

public class Person {
	int ssn;
	String first_name;
	String last_name;
	int fatherssn;
	int motherssn;
	//tree friend; 
	// List of friends as tree 
	// Linked list , 1d arraylist
	
	public Person(int ssn, String first, String last, int father_ssn_int,int mother_ssn_int){
		this.ssn = ssn;
		this.first_name = first ;
		this.last_name = last;
		this.fatherssn =father_ssn_int;
		this.motherssn = mother_ssn_int;
		
	}
	public int getSSN(){
		return ssn;
	}
	
	public String getFullname(){
		return first_name + " "+last_name;
	}
	
	public int getFatherSSN(){
		return fatherssn;	
	}
	
	public int getMotherSSN(){
		return motherssn;	
	}
	public int getFriend(){
		return motherssn;	
	}
	
	public boolean isYourFriend(int ssn ){
		// Traverse friend tree 
		// if node match ssn 
		return true;
	}
	
	public void setSSN(int x){
		ssn = x;
	}
	
	public void setFather(int x ){
		fatherssn = x;
	}
	
	public void setMother(int x ){
		motherssn = x;
	}
	
	public void setFirstlname(String x ){
		first_name = x;
	}
	
	public void setLastname(String x ){
		last_name = x;
	}
	
	//Friend has to be figured out later 
	public void setFriend(int x ){
		motherssn = x;
	}
	 
	
}
