package hw3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;


import java.awt.List;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;

public class program {
	
	

	public static void main(String[] args)  {
		state s1 = new state(null, 0, 0, 0, 0, 0, 0,0, 0);
		ArrayList<state> myList = new ArrayList<state>();
		int counter = 0 ; 
		NumberFormat defaultFormat = NumberFormat.getPercentInstance(); // Format Method
		defaultFormat.setMinimumFractionDigits(2);			 // Set digit to 1 decimal 	
		
		ArrayList<String> initiate_course= new ArrayList<String>();
		String csvFile = "bin/hw3/ds.csv";
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(new File(csvFile)));
		} 
		
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String cvsSplitBy = ",";
		String line = "";	
		
		try {
			
			br.readLine();
			br.readLine();
			br.readLine();
			String line1 = br.readLine(); // this will read the first line
			
			line1=null;
			
			
			
			while((line1 = br.readLine())!=null){

				String[] lineArray = line1.split(",");
				counter ++;
				System.out.println(lineArray[0]);	
				//Visualize each state has been read through csv 
				int year2010  =Integer.parseInt(lineArray[3]);
				System.out.println(lineArray[3]);	
				int year2011  =Integer.parseInt(lineArray[4]);
				int year2012  =Integer.parseInt(lineArray[5]);
				int year2013  =Integer.parseInt(lineArray[6]);
				int year2014  =Integer.parseInt(lineArray[7]);
				int year2015  =Integer.parseInt(lineArray[8]);
				int year2016  =Integer.parseInt(lineArray[9]);
				double per_change = 0 ; 
				
				
				state temp =  new state(lineArray[0],year2010,year2011,year2012,year2013,year2014,year2015,year2016,per_change);
				// ArrayList contains state objects 
				//System.out.println(temp.year2010());
				
				s1.All_state.add(temp);
				myList.add(temp);
				// add each state object into the list 
				
			
				
			}
			
			
			
			// Make sure reads info from csv 
			System.out.println("Number of state and region in the list:  " + counter);}
			catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		Scanner input = new Scanner (System.in);
		System.out.println("Please enter the  base year XD - from 2010 - 2016");
		int x = input.nextInt(); 
		input.nextLine();
		if (x>2016 || x<2010){
			System.out.println("Don't have this year data. please choose from 2010 - 2016 " );
			System.out.println("Program ends " );
			System.exit(1);
		}
			
		else
		{System.out.println("The base year you enter is : " + x);}
		System.out.println("Please enter the second base year XD - from 2010 - 2016");
		int y = input.nextInt();
		input.nextLine();
		
		if (y>2016 || y<2010){
			System.out.println("Don't have this year data. please choose from 2010 - 2016 " );
			System.out.println("Program ends " );
			System.exit(1);
		}
		
		else{System.out.println("The second base year you enter is : " + y);}
		
		
		s1.per_calculation(x, y);
		System.out.println("Per change calculation compeleted");
		System.out.println("------------------------------------");
		System.out.println("The unsorted array: ");
		for (int i =0; i<s1.All_state.size(); i++){
			
			System.out.printf("%-30.30s  %-30.30s%n",s1.All_state.get(i).getstate(), defaultFormat.format(s1.All_state.get(i).per_change()));
		}
		//Per Centage change method
//		for (int i =0; i<s1.All_state.size(); i++){
//			System.out.println("Year 2010 : "+ s1.All_state.get(i).year2010());
//			double temp_per_change1 = (s1.All_state.get(i).year2011() -s1.All_state.get(i).year2010());
//			double x2 = temp_per_change1/10;
//			NumberFormat defaultFormat = NumberFormat.getPercentInstance();
//			defaultFormat.setMinimumFractionDigits(1);
//			double temp_per_change = (temp_per_change1/s1.All_state.get(i).year2010());
//			
//			System.out.println("Per change - Percent format: " + defaultFormat.format(temp_per_change));
//			s1.All_state.get(i).setper_change(temp_per_change);
//		}
		double[] arr= new double[counter];
		for (int i = 0; i <counter; i++) {
			  arr[i]=s1.All_state.get(i).per_change();
			 // System.out.println("add completed ");
			  //System.out.println(s1.All_state.get(i).per_change());
			}
		
		
		double[] copyOfx = Arrays.copyOf(arr,arr.length);
		
		
		//System.out.println(Arrays.toString(copyOfx));
		
		System.out.println("Please enter the Sorting Algorithm  you want to sort");
		System.out.println("1. Bubble Sort ");
		System.out.println("2. Merge Sort  ");
		System.out.println("3. Quick Sort");
		System.out.println("4. Improved Quick Sort");
		System.out.println("5. Exit ");
		int Choice = input.nextInt(); 
		System.out.print(Choice);
		input.nextLine();
		switch (Choice){
		case 5 : break;
		case 1: 
				double startTime = System.nanoTime();
		        ISorting<Double> sorter = new bubble<>();
		        double[] result = sorter.sort(copyOfx);
		        double endTime = System.nanoTime();
		        System.out.println(startTime);
		        System.out.println(endTime);
		        double totalTime = endTime - startTime;
		    	System.out.println("The Bubble Sort method taks time (in nano Time) :"+ String.format( "%.10f", totalTime ));
		    	System.out.println("This is the sorted result ");
		    	//System.out.println(Arrays.toString(result));
		    	for (int i = 0 ; i <result.length;i++){
		    		
		    		defaultFormat.setMinimumFractionDigits(3);
		    		String result_per = defaultFormat.format(result[i]);
		    		
		    		for (int j =0; j<result.length;j++){
		    			if (s1.All_state.get(j).per_change()==result[i]){
		    				
		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(j).getstate(), result_per);
		    			}
		    		}
		    	}
			System.out.println("Bubble Sort - Compeleted");
		//	System.out.println( String.format( "%.10f", startTime ));
	     //   System.out.println(String.format( "%.10f", endTime ));
	        System.out.println("The Bubble Sort method taks time (in nano Time) :"+ String.format( "%.10f", totalTime ));
			System.out.println("Choose a state that you want to find similar percentage change ");
			String state = input.nextLine(); 
			//String state = state1.replaceAll("\\s","");

			System.out.println("The state you have entered is : " +  state);
			int counter1  =0 ; 
			
			for (int j =0; j<result.length;j++){
				counter1++;
				
				//System.out.println(s1.All_state.get(result.length-1).getstate().equals(state));
				//System.out.println(s1.All_state.get(0).getstate().equals(state));
				if (s1.All_state.get(j).getstate().equals(state)){
					//System.out.println("The state is the list is " + s1.All_state.get(j).getstate());
					//System.out.println("The index is the unsorted list is : "+ j);
					for(int i = 0; i <result.length;i++){
						if (s1.All_state.get(j).per_change() ==result[i] ){
						//	System.out.println("The Index I in the sorted list is "+ i);
							int temp1= i-1;
		    				int temp2 = i+1; 
		    				double gap1=0;
		    				if (temp1>0){
		    						gap1 = Math.abs(result[temp1]-result[i]) ;}
		    				double gap2=0;
		    				if(temp2<result.length)
		    					{Math.abs(result[temp2]-result[i]); }
		    				//System.out.println("The previous index is "+ temp1+"The after index is "+ temp2 );
		    				//System.out.println("The previous gap is " + gap1 + "the second gap is "+gap2);
		    				
		    				if (gap1<gap2 && temp1>0 && temp2<result.length){
		    					//System.out.println("The most similar rate is gap 1 " + gap1);
		    					for (int k =0; k<result.length;k++){
		    		    			if (s1.All_state.get(k).per_change()==result[temp1]){
		    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
		    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[temp1])) ;
		    		    			}
		    		    		}
		    					
		    				}
		    				
		    				if (gap2<gap1 && temp1>0 && temp2<result.length){
		    					System.out.println("The most similar rate is gap2  " + gap2);
		    					for (int k =0; k<result.length;k++){
		    		    			if (s1.All_state.get(k).per_change()==result[temp2]){
		    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
		    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[temp2])) ;
		    		    			}
		    		    		}
		    				}
		    				
		    				if (temp1<0){
		    					System.out.println("The most similar rate is extreme case when the choosing state is the first state " );
	    					for (int k =0; k<result.length;k++){
	    		    			if (s1.All_state.get(k).per_change()==result[1]){
	    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
	    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[1])) ;
	    		    			}
	    		    		}
		    				}
		    				
		    				if(temp2>=result.length){
		    					System.out.println("The most similar rate is extreme case when the choosing state is the last state " );
		    					for (int k =0; k<result.length;k++){
		    		    			if (s1.All_state.get(k).per_change()==result[result.length-2]){
		    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
		    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[result.length-2])) ;
		    		    			}
		    		    		}	
		    				}
		    				
					}
						
				}
	
				}
				
				
			}
			System.out.println("Program compeleted ");
			break;
				
		case 2: 
			System.out.println("Merge Sort - Ongoing ");
			startTime = System.nanoTime();
			ISorting<Double>sorter1 = new merge<>();
			result = sorter1.sort(copyOfx);
	        endTime = System.nanoTime();
	        System.out.println(startTime);
	        System.out.println(endTime);
	        totalTime = endTime - startTime;
	    	System.out.println("The Merge Sort method taks time (in nano Time) :"+ String.format( "%.10f", totalTime ));
	    	System.out.println("This is the sorted result ");
	    	//System.out.println(Arrays.toString(result));
	    	for (int i = 0 ; i <result.length;i++){
	    		
	    		defaultFormat.setMinimumFractionDigits(3);
	    		String result_per = defaultFormat.format(result[i]);
	    		
	    		for (int j =0; j<result.length;j++){
	    			if (s1.All_state.get(j).per_change()==result[i]){
	    				
	    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(j).getstate(), result_per);
	    			}
	    		}
	    	}
	
			System.out.println("Merge Sort - Compelted ");
			System.out.println("The Merge Sort method taks time (in nano Time) :"+ String.format( "%.10f", totalTime ));
		//	System.out.println( String.format( "%.10f", startTime ));
	     //   System.out.println(String.format( "%.10f", endTime ));
			System.out.println("Choose a state that you want to find similar percentage change ");
			state = input.nextLine(); 
			//state = state.replaceAll("\\s","");

			System.out.println("The state you have entered is : " +  state);
			counter1  =0 ; 
			
			for (int j =0; j<result.length;j++){
				counter1++;
				
				//System.out.println(s1.All_state.get(result.length-1).getstate().equals(state));
				//System.out.println(s1.All_state.get(0).getstate().equals(state));
				if (s1.All_state.get(j).getstate().equals(state)){
					//System.out.println("The state is the list is " + s1.All_state.get(j).getstate());
					//System.out.println("The index is the unsorted list is : "+ j);
					for(int i = 0; i <result.length;i++){
						if (s1.All_state.get(j).per_change() ==result[i] ){
						//	System.out.println("The Index I in the sorted list is "+ i);
		    				int temp1= i-1;
		    				int temp2 = i+1; 
		    				double gap1=0;
		    				if (temp1>0){
		    						gap1 = Math.abs(result[temp1]-result[i]) ;}
		    				double gap2=0;
		    				if(temp2<result.length)
		    					{Math.abs(result[temp2]-result[i]); }
		    				//System.out.println("The previous index is "+ temp1+"The after index is "+ temp2 );
		    				//System.out.println("The previous gap is " + gap1 + "the second gap is "+gap2);
		    				
		    				if (gap1<gap2 && temp1>0 && temp2<result.length){
		    					//System.out.println("The most similar rate is gap 1 " + gap1);
		    					for (int k =0; k<result.length;k++){
		    		    			if (s1.All_state.get(k).per_change()==result[temp1]){
		    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
		    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[temp1])) ;
		    		    			}
		    		    		}
		    					
		    				}
		    				
		    				if (gap2<gap1 && temp1>0 && temp2<result.length){
		    					System.out.println("The most similar rate is gap2  " + gap2);
		    					for (int k =0; k<result.length;k++){
		    		    			if (s1.All_state.get(k).per_change()==result[temp2]){
		    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
		    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[temp2])) ;
		    		    			}
		    		    		}
		    				}
		    				
		    				if (temp1<0){
		    					System.out.println("The most similar rate is extreme case when the choosing state is the first state " );
	    					for (int k =0; k<result.length;k++){
	    		    			if (s1.All_state.get(k).per_change()==result[1]){
	    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
	    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[1])) ;
	    		    			}
	    		    		}
		    				}
		    				
		    				if(temp2>=result.length){
		    					System.out.println("The most similar rate is extreme case when the choosing state is the last state " );
		    					for (int k =0; k<result.length;k++){
		    		    			if (s1.All_state.get(k).per_change()==result[result.length-2]){
		    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
		    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[result.length-2])) ;
		    		    			}
		    		    		}	
		    				}
		    				
					}
						
				}
	
				}
				
				
			}
			System.out.println("Program compeleted ");
			break;
		case 3: 
			startTime = System.nanoTime();
	        sorter = new plainquick<>();
	        result = sorter.sort(copyOfx);
	        endTime = System.nanoTime();
	        
	        totalTime = endTime - startTime;
	    	
	    	System.out.println("This is the sorted result ");
	    	//System.out.println(Arrays.toString(result));
	    	for (int i = 0 ; i <result.length;i++){
	    		
	    		defaultFormat.setMinimumFractionDigits(3);
	    		String result_per = defaultFormat.format(result[i]);
	    		
	    		for (int j =0; j<result.length;j++){
	    			if (s1.All_state.get(j).per_change()==result[i]){
	    				
	    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(j).getstate(), result_per);
	    			}
	    		}
	    	}
	    	System.out.println("The Quick Sort method taks time (in nano Time) :"+ String.format( "%.10f", totalTime ));
	    //	System.out.println( String.format( "%.10f", startTime ));
	     //   System.out.println(String.format( "%.10f", endTime ));
	    	System.out.println("Quick Sort - Compeleted");
			System.out.println("Choose a state that you want to find similar percentage change ");
			 state = input.nextLine(); 
			 //state = state.replaceAll("\\s","");

			System.out.println("The state you have entered is : " +  state);
			 counter1  =0 ; 
			
			for (int j =0; j<result.length;j++){
				counter1++;
				
				//System.out.println(s1.All_state.get(result.length-1).getstate().equals(state));
				//System.out.println(s1.All_state.get(0).getstate().equals(state));
				if (s1.All_state.get(j).getstate().equals(state)){
					//System.out.println("The state is the list is " + s1.All_state.get(j).getstate());
					//System.out.println("The index is the unsorted list is : "+ j);
					for(int i = 0; i <result.length;i++){
						if (s1.All_state.get(j).per_change() ==result[i] ){
						//	System.out.println("The Index I in the sorted list is "+ i);
							int temp1= i-1;
		    				int temp2 = i+1; 
		    				double gap1=0;
		    				if (temp1>0){
		    						gap1 = Math.abs(result[temp1]-result[i]) ;}
		    				double gap2=0;
		    				if(temp2<result.length)
		    					{Math.abs(result[temp2]-result[i]); }
		    				//System.out.println("The previous index is "+ temp1+"The after index is "+ temp2 );
		    				//System.out.println("The previous gap is " + gap1 + "the second gap is "+gap2);
		    				
		    				if (gap1<gap2 && temp1>0 && temp2<result.length){
		    					//System.out.println("The most similar rate is gap 1 " + gap1);
		    					for (int k =0; k<result.length;k++){
		    		    			if (s1.All_state.get(k).per_change()==result[temp1]){
		    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
		    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[temp1])) ;
		    		    			}
		    		    		}
		    					
		    				}
		    				
		    				if (gap2<gap1 && temp1>0 && temp2<result.length){
		    					System.out.println("The most similar rate is gap2  " + gap2);
		    					for (int k =0; k<result.length;k++){
		    		    			if (s1.All_state.get(k).per_change()==result[temp2]){
		    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
		    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[temp2])) ;
		    		    			}
		    		    		}
		    				}
		    				
		    				if (temp1<0){
		    					System.out.println("The most similar rate is extreme case when the choosing state is the first state " );
	    					for (int k =0; k<result.length;k++){
	    		    			if (s1.All_state.get(k).per_change()==result[1]){
	    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
	    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[1])) ;
	    		    			}
	    		    		}
		    				}
		    				
		    				if(temp2>=result.length){
		    					System.out.println("The most similar rate is extreme case when the choosing state is the last state " );
		    					for (int k =0; k<result.length;k++){
		    		    			if (s1.All_state.get(k).per_change()==result[result.length-2]){
		    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
		    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[result.length-2])) ;
		    		    			}
		    		    		}	
		    				}
		    				
					}
						
				}
	
				}
				
				
			}
			System.out.println("Program compeleted ");
			System.out.println("Mission Accomplished bye XD");
			
			break;
		case 4: 
			double startTime1 = System.nanoTime();
	        sorter = new improvedquick<>();
	        result = sorter.sort(copyOfx);
	        double endTime1 = System.nanoTime();
	        System.out.println(startTime1);
	        System.out.println(endTime1);
	        double totalTime1 = endTime1 - startTime1;
	    	System.out.println("The improved quick sort method taks time (in nano Time) :"+ String.format( "%.10f", totalTime1 ));
	    	System.out.println("This is the sorted result ");
	    	//System.out.println(Arrays.toString(result));
	    	for (int i = 0 ; i <result.length;i++){
	    		
	    		defaultFormat.setMinimumFractionDigits(3);
	    		String result_per = defaultFormat.format(result[i]);
	    		
	    		for (int j =0; j<result.length;j++){
	    			if (s1.All_state.get(j).per_change()==result[i]){
	    				
	    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(j).getstate(), result_per);
	    			}
	    		}
	    	}
		
			System.out.println("Improved Quick Sort - Compeleted");
			System.out.println("The Improved Quick Sort method taks time (in nano Time) :"+ String.format( "%.10f", totalTime1 ));
			//System.out.println( String.format( "%.10f", startTime1 ));
	        //System.out.println(String.format( "%.10f", endTime1 ));
			System.out.println("Choose a state that you want to find similar percentage change ");
			state = input.nextLine(); 
			//state = state1.replaceAll("\\s","");

			System.out.println("The state you have entered is : " +  state);
			counter1  =0 ; 
			
			for (int j =0; j<result.length;j++){
				counter1++;
				
				//System.out.println(s1.All_state.get(result.length-1).getstate().equals(state));
				//System.out.println(s1.All_state.get(0).getstate().equals(state));
				if (s1.All_state.get(j).getstate().equals(state)){
					//System.out.println("The state is the list is " + s1.All_state.get(j).getstate());
					//System.out.println("The index is the unsorted list is : "+ j);
					for(int i = 0; i <result.length;i++){
						if (s1.All_state.get(j).per_change() ==result[i] ){
						//	System.out.println("The Index I in the sorted list is "+ i);
							int temp1= i-1;
		    				int temp2 = i+1; 
		    				double gap1=0;
		    				if (temp1>0){
		    						gap1 = Math.abs(result[temp1]-result[i]) ;}
		    				double gap2=0;
		    				if(temp2<result.length)
		    					{Math.abs(result[temp2]-result[i]); }
		    				//System.out.println("The previous index is "+ temp1+"The after index is "+ temp2 );
		    				//System.out.println("The previous gap is " + gap1 + "the second gap is "+gap2);
		    				
		    				if (gap1<gap2 && temp1>0 && temp2<result.length){
		    					//System.out.println("The most similar rate is gap 1 " + gap1);
		    					for (int k =0; k<result.length;k++){
		    		    			if (s1.All_state.get(k).per_change()==result[temp1]){
		    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
		    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[temp1])) ;
		    		    			}
		    		    		}
		    					
		    				}
		    				
		    				if (gap2<gap1 && temp1>0 && temp2<result.length){
		    					System.out.println("The most similar rate is gap2  " + gap2);
		    					for (int k =0; k<result.length;k++){
		    		    			if (s1.All_state.get(k).per_change()==result[temp2]){
		    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
		    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[temp2])) ;
		    		    			}
		    		    		}
		    				}
		    				
		    				if (temp1<0){
		    					System.out.println("The most similar rate is extreme case when the choosing state is the first state " );
	    					for (int k =0; k<result.length;k++){
	    		    			if (s1.All_state.get(k).per_change()==result[1]){
	    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
	    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[1])) ;
	    		    			}
	    		    		}
		    				}
		    				
		    				if(temp2>=result.length){
		    					System.out.println("The most similar rate is extreme case when the choosing state is the last state " );
		    					for (int k =0; k<result.length;k++){
		    		    			if (s1.All_state.get(k).per_change()==result[result.length-2]){
		    		    				System.out.println("The  most similar state  in terms of percent change in population is :  ");
		    		    				System.out.printf("%-30.30s  %-30.30s%n", s1.All_state.get(k).getstate(),defaultFormat.format(result[result.length-2])) ;
		    		    			}
		    		    		}	
		    				}
		    				
					}
						
				}
	
				}
				
				
			}
			System.out.println("Program compeleted ");
			System.out.println("Improved quicksort mission accomplished BYE XD");
			break;
			}
	}
	
	
}
	
		

	
