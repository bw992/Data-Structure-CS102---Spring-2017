package hw3;
import java.util.ArrayList;



import java.io.*;
import java.text.NumberFormat;

public class state {
	private String state;
	private int year2010;
	private int year2011;
	private int year2012;
	private int year2013;
	private int year2014;
	private int year2015;
	private int year2016;
	private double per_change;
	public static ArrayList<state> All_state= new ArrayList<state>();
	
	public state(String state, int year2010, int year2011,int year2012,int year2013,int year2014,int year2015,int year2016 ,double per_change ){
		this.state = state;
		this.year2010 = year2010;
		this.year2011 = year2011;
		this.year2012 = year2012;
		this.year2013 = year2013;
		this.year2014 = year2014;
		this.year2015 = year2015;
		this.year2016 = year2016;
		this.per_change = per_change;
	}
	
	public String getstate(){
		return state;
	}
	
	public int year2010(){
		return year2010;
	}
	public int year2011(){
		return year2011;
	}
	public int year2012(){
		return year2012;
	}
	public int year2013(){
		return year2013;
	}
	public int year2014(){
		return year2014;
	}
	public int year2015(){
		return year2015;
	}
	public int year2016(){
		return year2016;
	}
	public double per_change(){
		return per_change;
	}
	
	public void setstate(String new_state){
		state = new_state; 
	}
	public void setyear2010(int year2010_new){
		year2010 = year2010_new; 
	}
	public void setyear2011(int year2011_new){
		year2011 = year2011_new; 
	}
	public void setyear2012(int year2012_new){
		year2012 = year2012_new; 
	}
	public void setyear2013(int year2013_new){
		year2013 = year2013_new; 
	}
	public void setyear2014(int year2010_new){
		year2014 = year2010_new; 
	}
	public void setyear2015(int year2010_new){
		year2015 = year2010_new; 
	}
	public void setyear2016(int year2010_new){
		year2016 = year2010_new; 
	}
	public void setper_change(double year2010_new){
		per_change= year2010_new; 
	}
	
	public int set_year(int year ){
		switch (year){
        case 2010: return 1;
              
        case 2011: return 2;
        	
        case 2012: return 3;
        	
        case 2013: return 4;
        	
        case 2014: return 5;
        
        case 2015: return 6;
        
        case 2016: return 7;
		}
		return year;
	
		
	}
	
	public static void per_calculation ( int x , int y ){
		int temp = 0,temp2 = 0;
		
		for (int i =0; i<All_state.size(); i++){
			
		switch (x){
        case 2010: 
        	  temp =All_state.get(i).year2010();
              break;
        case 2011:
        	temp =All_state.get(i).year2011();
        	break;
        case 2012: temp =All_state.get(i).year2012();
        break;
        case 2013:
        	temp =All_state.get(i).year2013();
        	break;
        case 2014: temp =All_state.get(i).year2014();
        break;
        case 2015: temp =All_state.get(i).year2015();
        break;
        case 2016: temp =All_state.get(i).year2016();
        break;
        default:
            System.out.println("Invalid year.");
            break;
       
		}
		
		//System.out.println("With in the lop" + temp);
		switch (y){
        case 2010: temp2 =All_state.get(i).year2010();
        break;  
        case 2011: temp2 =All_state.get(i).year2011();
        break;
        case 2012: temp2 =All_state.get(i).year2012();
        break;
        case 2013: temp2 =All_state.get(i).year2013();
        break;
        case 2014: temp2 =All_state.get(i).year2014();
        break;
        case 2015: temp2 =All_state.get(i).year2015();
        break;
        case 2016: temp2 =All_state.get(i).year2016();
        break;
        default:
            System.out.println("Invalid year.");
            break;
       		}
		
//		
//		System.out.println(temp2);
//		System.out.println(temp);
//		
			//System.out.println("Year 2010 : "+ All_state.get(i).year2010());
			double numerator = temp2 -temp; // Calculate numerator 
			//System.out.println(numerator);
			double denominator = temp;  //Calculate denominator
			//System.out.println(denominator);
			NumberFormat defaultFormat = NumberFormat.getPercentInstance(); // Format Method
			defaultFormat.setMinimumFractionDigits(2);			 // Set digit to 1 decimal 	
			double temp_per_change = (numerator/denominator);
				
			//System.out.println( All_state.get(i).state +": "+ "  Per change - Percent format:   " + defaultFormat.format(temp_per_change));
			All_state.get(i).setper_change(temp_per_change);
		}
	}
}

