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

import javax.xml.crypto.Data;


public class program {
	public static void main(String[] args) throws ParseException, IOException{
		customer temp = null;
		customerlist thelist = new customerlist();
		customerlist final_list = new customerlist();
		int  T =300;
		int  num_cus_served =0;
		int  break_time=0;
		int  total_break_time=0;
		int  max_break_time =0 ; 
		int  longest_break =0;
		int  temp_longest_break = 0; //place holder for longest break 
		int  total_idel_time =0;
		int  max_num_of_people_in_queue =0;
		int  serving_time = 0;
		int  after_hour_service = 1; // token as the extreme case when employee works over time 
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        String open_time="09:00:00";
        String close_time = "05:00:00";
        String current_time = "09:00:00";// Current Time
		java.util.Date d1 =   df.parse(open_time); 
		java.util.Date d2 =   df.parse(close_time); 
		java.util.Date d3 =   df.parse(current_time); 
	    Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        Calendar cal3 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        cal3.setTime(d3);
        String open_time1= df.format(cal1.getTime());
        String close_time1= df.format(cal2.getTime());
        String close_time3= df.format(cal3.getTime());
//        System.out.println(open_time1);
//        System.out.println(close_time1);
//        System.out.println(close_time3);
        
    
        cal1.add(Calendar.SECOND, 300);
        String newTime = df.format(cal1.getTime());
//        System.out.println("opening time adds 300 seconds "+ newTime);
//        System.out.println("+++++");
//        System.out.println("Test  case 1 : calculation_seconds method : convert hh:mm:ss to seconds");
//       
        int x1= calculation_seconds(open_time);
        int x2= calculation_seconds(open_time1);
        int x3 =calculation_seconds(newTime);
        
//        System.out.println(x1);
//        System.out.println(x2);
//        System.out.println(x3);
//        
//        System.out.println("+++++");
//        System.out.println("Test  case 2 : time_diff method : calculate time difference  b/t opening and closing calendar");
//       
        cal1.add(Calendar.SECOND, -300);
        
        int temp111 = time_diff(cal3,cal1);
        String result = compare_time(cal1,cal3);
        int temp_divide = temp111/3600;
//        System.out.println("Test case 3 compare_time() The compare time result between 9 and 9 " + result);
//        System.out.println(result=="LESS");
//        System.out.println("The hour difference is  "+ temp_divide);
//      	System.out.println(temp111);
//      	System.out.println("_________________________");  
//      	 System.out.println("Test  case 3 time_add method : add 300 seconds to calendar");
      	Calendar test_time_add = time_add (cal1,300);
        String test_time= df.format(test_time_add.getTime());
      	//System.out.println(test_time);
		
		File cusFile = null;
		File queries = null;
		if (0 < args.length) {
		   cusFile = new File(args[0]);//read first file from command line : customersfile.txt
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
	            
	            String s1= br.readLine();
	            serving_time =Integer.parseInt(s1);
	            T = serving_time;
	           // System.out.println("This is the serving time: "+serving_time);
	            br.readLine();
	            while ((sCurrentLine = br.readLine()) != null) {
	            	String[] lineArray = sCurrentLine.split("  ");
	            	String id = lineArray[1];
	            	int id_int = Integer.parseInt(id);
	            	//System.out.println(id_int);
	            	sCurrentLine = br.readLine();
	            	String[] lineArray2 = sCurrentLine.split(" ");
	            	String arr_time = lineArray2[1];
	            	
	                //System.out.println(sCurrentLine);
	                df = new SimpleDateFormat("HH:mm:ss");
	                java.util.Date d =   df.parse(arr_time); 
	                Calendar cal = Calendar.getInstance();
	                cal.setTime(d);
	               
	                String newTime1 = df.format(cal.getTime());
	               // System.out.println(newTime1);
	                customer temp1 = new customer(id_int,cal);
	                thelist.enqueue(temp1);
	                br.readLine();
	            }
	            
	            cr = new  BufferedReader(new FileReader(queries));
	            
	            //cCurrentLine = cr.readLine();
	           
	            
	            

	        } 

	        catch (IOException e) {
	            e.printStackTrace();
	        } 

			catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  	int counter =1;
		  	//readfile(thelist, temp);
		  	while((compare_time(cal3,cal2)=="LESS")&& thelist.isEmpty()!=true){
		  		
		  		//Current time < closing time 
		  		customer temp2 = thelist.dequeue(temp);
		  		
		  	//	System.out.println("Stores open  Customer ID:"+ counter);
		  		counter++;
		  		
		  		if(compare_time(temp2.arrival_time,cal1)=="LESS"){ // Come in before 9 scenario 
		  			temp2.waitingTime = time_diff(cal3,temp2.arrival_time);
		  			//System.out.println("1st customer in line waiting time:"+ temp2.waitingTime);
		  			if (compare_time(cal3,cal1)=="EQUAL"){//people come in line before 9 
		  				temp2.queueLength=0;
		  			}
		  			else{//if there is already people come in before 9, and in the queue, the queue number increment
		  				temp2.queueLength = (time_diff(cal3,cal1)/T);
		  				//System.out.println("numebe of peopel in queue :"+ temp2.queueLength);
		  				if(temp2.queueLength>max_num_of_people_in_queue){
		  					max_num_of_people_in_queue  = temp2.queueLength;
		  				}
		  			}
		  			cal3.add(Calendar.SECOND, T);// Current add 300seconds serving time 
		  			num_cus_served++;
		  			final_list.enqueue(temp2);
//		  			System.out.println("num_cus_served:"+num_cus_served);
//		  			
//		  			System.out.println("These are the customer come before 9 AM");
//		  			System.out.println("______________________________________");
		  		}
		  		
		  		else if (compare_time(cal3,temp2.arrival_time)=="GREATER"){
		  			temp2.waitingTime =time_diff(cal3,temp2.arrival_time);
		  			//System.out.println("After 9 AM customer in line waiting time:"+ temp2.waitingTime);
		  			temp2.queueLength = (temp2.waitingTime/T)+1;
		  			if(temp2.queueLength>max_num_of_people_in_queue){
	  					max_num_of_people_in_queue  = temp2.queueLength;
	  				}
		  			cal3.add(Calendar.SECOND, T);
		  			num_cus_served++;
		  			final_list.enqueue(temp2);
		  			
		  			
		  		}
		  		
		  		else if (compare_time(cal3,temp2.arrival_time)=="LESS"){
		  			break_time = time_diff(temp2.arrival_time,cal3);
		  			//System.out.println("Break time is :" +break_time);
		  			if ( break_time>max_break_time ){
		  					max_break_time = break_time;
		  			}
		  			cal3.add(Calendar.SECOND, break_time);
		  			total_break_time +=break_time;
		  			
		  			temp2.waitingTime =0;
		  			temp2.queueLength =0;
		  			cal3.add(Calendar.SECOND, T);
		  			
		  	
		  			num_cus_served ++;
		  			final_list.enqueue(temp2);
		  			
		  		}
		  		
		  		if((compare_time(cal3,cal2)=="LESS") && thelist.isEmpty()){
		  			//The case when no one is in line until closing time 
		  			break_time=time_diff(cal2,cal3);
		  			if ( break_time>max_break_time ){
		  					max_break_time = break_time;
		  			}
		  			total_break_time +=break_time;
		  			
		  		}
		  	}
		  	
		  	while(thelist.isEmpty()!=true){
		  		customer temp2 =thelist.dequeue(temp);
		  		if (compare_time(temp2.arrival_time,cal2)=="LESS"){
		  			temp2.waitingTime = time_diff(cal2,cal3);
		  			
		  		}
		  		else if (compare_time(temp2.arrival_time,cal2)=="GREATER"){
		  			temp2.waitingTime =0;
		  		}
		  		else{
		  			temp2.waitingTime = 0 ; 
		  		
		  		}
		  		final_list.enqueue(temp2);
		  	}
		  	 
		  	cr = new  BufferedReader(new FileReader(queries));
		  
		  	 read_queries(final_list,cr, total_break_time, max_break_time,num_cus_served, max_num_of_people_in_queue) ;
		  	 
//		  	 System.out.println("NUMBER-OF-CUSTOMERS-SERVED:"+num_cus_served);
//		     System.out.println("LONGEST-BREAK-LENGTH:"+max_break_time);
//		     System.out.println("TOTAL-IDLE-TIME:"+total_break_time);
//		     System.out.println("MAXIMUM-NUMBER-OF-PEOPLE-IN-QUEUE-AT-ANY-TIME:"+max_num_of_people_in_queue);
//		     System.out.println("WAITING-TIME-OF 1:"+ final_list.getwaittime(1));
//		     System.out.println("WAITING-TIME-OF 2:"+final_list.getwaittime(2));
//		     System.out.println("WAITING-TIME-OF 3:"+final_list.getwaittime(3));
//		     System.out.println("WAITING-TIME-OF 7:"+final_list.getwaittime(7));
		     
		  	
	}
    
	public static void read_queries(customerlist ll,BufferedReader cr,int total_break_time,int max_break_time,int num_cus_served, int max_num_of_people_in_queue) throws IOException{
		

		int id;
		int waittime; 
		String cCurrentLine;
		
		while((cCurrentLine = cr.readLine()) != null) {
			//System.out.println(cCurrentLine); 
	
			    
			    if(cCurrentLine.equals("NUMBER-OF-CUSTOMERS-SERVED")){
			    	System.out.println("NUMBER-OF-CUSTOMERS-SERVED:"+num_cus_served);
			    	}
			    if(cCurrentLine.equals("LONGEST-BREAK-LENGTH")){
			    	System.out.println("LONGEST-BREAK-LENGTH:"+max_break_time);
			    }
			    if(cCurrentLine.equals("TOTAL-IDLE-TIME")){
			    	System.out.println("TOTAL-IDLE-TIME:"+total_break_time);
			    }
			    if(cCurrentLine.equals("MAXIMUM-NUMBER-OF-PEOPLE-IN-QUEUE-AT-ANY-TIME")){ 
			    	System.out.println("MAXIMUM-NUMBER-OF-PEOPLE-IN-QUEUE-AT-ANY-TIME:"+max_num_of_people_in_queue);
			    }
			    
			    String[] lineArray = cCurrentLine.split(" ");
			   // System.out.println(lineArray[0]);
			    if(lineArray[0].equals("WAITING-TIME-OF")){
			    	int id_temp = Integer.parseInt(lineArray[1]);
			    	//System.out.println(id_temp);
			    	 System.out.println(lineArray[0]+":"+ ll.getwaittime(id_temp));
			    	
			    }
			   
			   
			    }
       
	}
	  public static int calculation_seconds(String x){
	        String[] tokens = x.split(":");
	        int hours = Integer.parseInt(tokens[0]);
	        int minutes = Integer.parseInt(tokens[1]);
	        int seconds = Integer.parseInt(tokens[2]);
	        int duration = 3600 * hours + 60 * minutes + seconds;
	        return duration ; 
	        }
	  
	  public static String compare_time(Calendar x , Calendar y) throws ParseException{
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
		  
		  if(t1_second>t2_second){
			  return "GREATER";
		  }
		  
		  if (t1_second<t2_second){
		  return "LESS";  }
		  
		  else{
			  return "EQUAL";
		  }
		
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
	  
	  public static Calendar time_add (Calendar x, int seconds) throws ParseException{
		 
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
		  Date d = new Date(temp * 1000L);
		  String Time = df.format(d);
		  Date d2 =   df.parse(Time); 
		  Calendar new_time = Calendar.getInstance();
		  return new_time;
		  
	  }
	        
	}
