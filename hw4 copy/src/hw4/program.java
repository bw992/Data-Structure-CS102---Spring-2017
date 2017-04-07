package hw4;
//When run in terminal, have to // the package line 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class program {
	public static void main(String[] args) throws FileNotFoundException, ParseException{
		customer temp;
		customerlist thelist = new customerlist();
		
		int  num_cus_served =0;
		int  break_time=0;
		int  total_break=0;
		int  longest_break =0;
		int  total_idel_time =0;
		int  max_num_of_people_in_queue =0;
		int  serving_time = 0;
		int  after_hour_service = 1; // token as the extreme case when employee works over time 
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        String open_time="09:00:00";
        String close_time = "04:45:00";
        String close_time2 = "05:00:00";
		java.util.Date d1 =   df.parse(open_time); 
		java.util.Date d2 =   df.parse(close_time); 
		java.util.Date d3 =   df.parse(close_time2); 
	    Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        Calendar cal3 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        cal3.setTime(d3);
        String open_time1= df.format(cal1.getTime());
        String close_time1= df.format(cal2.getTime());
        String close_time3= df.format(cal3.getTime());
        System.out.println(open_time1);
        System.out.println(close_time1);
        System.out.println(close_time3);
        
    
        cal1.add(Calendar.SECOND, 300);
        String newTime = df.format(cal1.getTime());
        System.out.println("opening time adds 300 seconds "+ newTime);
        System.out.println("+++++");
        System.out.println("Test  case 1 : calculation_seconds method : convert hh:mm:ss to seconds");
       
        int x1= calculation_seconds(open_time);
        int x2= calculation_seconds(open_time1);
        int x3 = calculation_seconds(newTime);
        
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);
        
        System.out.println("+++++");
        System.out.println("Test  case 2 : time_diff method : calculate time difference  b/t opening and closing calendar");
       
        cal1.add(Calendar.SECOND, -300);
        
        int temp111 = time_diff(cal3,cal1);
        int temp_divide = temp111/3600;
        System.out.println("The hour difference is  "+ temp_divide);
      	System.out.println(temp111);
      	System.out.println("_________________________");  
      	 System.out.println("Test  case 3 time_add method : add 5000 seconds to calendar");
      	int test_time_add = time_add (cal1, 5000);
      	System.out.println(test_time_add);
		
		File cusFile = null;
		File queries = null;
		if (0 < args.length) {
		   cusFile = new File(args[0]);//read first file from command line : customersfile.txt
		   queries = new File(args[1]);//read second file from command line: queriesfile.txt
		} else {
		   System.err.println("Invalid arguments count:" + args.length);
		   System.exit(0);
		}
		BufferedReader br = null;//first file reader 
		BufferedReader cr = null;//2nd file reader 
		
		  try {

	            String sCurrentLine;
	            String cCurrentLine;

	            br = new BufferedReader(new FileReader(cusFile));
	            
	            String s1= br.readLine();
	            serving_time =Integer.parseInt(s1);
	            System.out.println("This is the serving time: "+serving_time);
	            br.readLine();
	            while ((sCurrentLine = br.readLine()) != null) {
	            	String[] lineArray = sCurrentLine.split("  ");
	            	String id = lineArray[1];
	            	int id_int = Integer.parseInt(id);
	            	 System.out.println(id_int);
	            	sCurrentLine = br.readLine();
	            	String[] lineArray2 = sCurrentLine.split(" ");
	            	String arr_time = lineArray2[1];
	            	
	                //System.out.println(sCurrentLine);
	                df = new SimpleDateFormat("HH:mm:ss");
	                java.util.Date d =   df.parse(arr_time); 
	                Calendar cal = Calendar.getInstance();
	                cal.setTime(d);
	               // cal.add(Calendar.SECOND, 300);
	                //cal.add(Calendar.SECOND, -400);
	                String newTime1 = df.format(cal.getTime());
	                System.out.println(newTime1);
	                if(cal.after(cal2) &&cal.before(cal3)&&after_hour_service==1){
	                	num_cus_served+=1;
	                	after_hour_service--;
	                }
	                if(cal.after(cal2) &&cal.before(cal3)&&after_hour_service==0){
	                	num_cus_served+=0;
	                }
	                else{
	                	num_cus_served+=1;
	                }
	                br.readLine();
	            }
	            
	            cr = new  BufferedReader(new FileReader(queries));
	            
	            cCurrentLine = cr.readLine();
	            System.out.println(cCurrentLine+":"+num_cus_served);
	            cCurrentLine = cr.readLine();
	            System.out.println(cCurrentLine+":"+longest_break);
	            cCurrentLine = cr.readLine();
	            System.out.println(cCurrentLine+":"+total_idel_time);
	            cCurrentLine = cr.readLine();
	            System.out.println(cCurrentLine+":"+max_num_of_people_in_queue);
	            cCurrentLine = cr.readLine();
	            System.out.println(cCurrentLine+":");
	            cCurrentLine = cr.readLine();
	            System.out.println(cCurrentLine+":");
	            cCurrentLine = cr.readLine();
	            System.out.println(cCurrentLine+":");
	            cCurrentLine = cr.readLine();
	            System.out.println(cCurrentLine+":");
	            
	            
	            

	        } 

	        catch (IOException e) {
	            e.printStackTrace();
	        } 

			catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		  	int temp_longest_break = 0; //place holder for longest break 
		  	
	}
	  public static int calculation_seconds(String x){
	        String[] tokens = x.split(":");
	        int hours = Integer.parseInt(tokens[0]);
	        int minutes = Integer.parseInt(tokens[1]);
	        int seconds = Integer.parseInt(tokens[2]);
	        int duration = 3600 * hours + 60 * minutes + seconds;
	        return duration ; 
	        }
	  
	  public static int time_diff(Calendar x, Calendar y) throws ParseException{
		  SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		  int t1_second;
		  int t2_second; 
		  String x1 =df.format(x.getTime());
		  String y1 =df.format(y.getTime());
		  String open_time = "06:00:00";
		  java.util.Date d1 =   df.parse(open_time); 
	      Calendar cal1 = Calendar.getInstance();
	      cal1.setTime(d1);
	      String open_time1= df.format(cal1.getTime());
	  
		  
		  if(x.before(cal1)){
			  x.add(Calendar.HOUR, 12);
			  x1 = df.format(x.getTime());
			
             
		  }
		  
		  if(y.before(cal1)){
			  y.add(Calendar.HOUR, 12);
			  y1 = df.format(y.getTime());
			 
              
		  }
		  
		  t1_second = calculation_seconds(x1);
		  t2_second = calculation_seconds(y1);
		  
		  
			 return (t1_second - t2_second);
		  
	  }
	  
	  public static int time_add (Calendar x, int seconds) throws ParseException{
		 
		  SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		  String x1 =df.format(x.getTime());
		  int temp =0;
		  String open_time = "06:00:00";
		  java.util.Date d1 =   df.parse(open_time); 
	      Calendar cal1 = Calendar.getInstance();
	      cal1.setTime(d1);
	      String open_time1= df.format(cal1.getTime());
	      
		  	if(x.before(cal1)){
			  x.add(Calendar.HOUR, 12);
			  x1 = df.format(x.getTime());
             
		  }
		  	
		  temp = calculation_seconds(x1)+seconds;
		  return temp;
		  
	  }
	        
	}
