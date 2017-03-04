import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Program {

    public static void main(String[] args) {

        Integer[] answer = {2, 4, 20, 22, 30, 49, 50, 77, 77, 98};
        Integer[] x = {4,77,98,30,20,50,77,22,49,2};
        Integer[] copyOfx = Arrays.copyOf(x, x.length);
        
        //DecimalFormat df = new DecimalFormat("#.00000"); 
        double startTime = System.currentTimeMillis();
       // System.out.println(startTime);
        ISorting<Integer> sorter = new BubbleSort<>();
        Integer[] result = sorter.sort(x);
        double endTime = System.currentTimeMillis();
      //  System.out.println(endTime);
        double totalTime = endTime - startTime;
       // System.out.println(totalTime);
    	System.out.println("The Bubble Sort method taks time:"+ String.format( "%.10f", totalTime ));

        if (Arrays.equals(result,answer)) {
        		//
            System.out.println("1. BubbleSort Correct.");
            
            //
        	
            //System.out.println(Arrays.toString(result));
        } else {
            System.err.println("BubbleSort InCorrect:");
            System.err.println(Arrays.toString(result));
        }

        if (!Arrays.equals(x,copyOfx)){
            System.err.println("Contents of x has been changed.");
        }

        double startTime1 = System.currentTimeMillis();
        // System.out.println(startTime);
          sorter = new BubbleSort_Re<>();
          result = sorter.sort(x);
         double endTime1 = System.currentTimeMillis();
       //  System.out.println(endTime);
         double totalTime1 = endTime1 - startTime1;
        // System.out.println(totalTime);
     	System.out.println("The Bubble Sort method taks time:"+ String.format( "%.10f", totalTime ));

         if (Arrays.equals(result,answer)) {
         		//
             System.out.println("1. BubbleSort -Recursive Correct.");
             
             //
         	
             //System.out.println(Arrays.toString(result));
         } else {
             System.err.println("BubbleSort -Recursive InCorrect:");
             System.err.println(Arrays.toString(result));
         }

         if (!Arrays.equals(x,copyOfx)){
             System.err.println("Contents of x has been changed.");
         }

        double start2 = System.currentTimeMillis();
        //System.out.println(startTime);
        sorter = new InsertionSort<>();
        result = sorter.sort(x);
        double end2 = System.currentTimeMillis();
        //System.out.println(endTime);
        double total2 = end2 - start2;
        System.out.println("The Insertion Sort method taks time:"+ String.format( "%.10f", total2 ));
        


        if (Arrays.equals(result,answer)) {
            System.out.println("2. InsertionSort Correct.");
        } else {
            System.err.println("InsertionSort InCorrect:");
            System.err.println(Arrays.toString(result));
        }
        
        
        double start3 = System.currentTimeMillis();
        //System.out.println(startTime);
        sorter = new SelectionSort<>();
        result = sorter.sort(x);
        double end3 = System.currentTimeMillis();
        //System.out.println(endTime);
        double total3 = end3 - start3;
    
    	System.out.println("The selection method takes time:"+ String.format( "%.10f", total3 ));
        


        if (Arrays.equals(result,answer)) {
            System.out.println("3. The selection Correct.");
        } else {
            System.err.println("selection InCorrect:");
            System.err.println(Arrays.toString(result));
        }
        
        double start4 = System.currentTimeMillis();
        //System.out.println(startTime);
        sorter = new MergeSort<>();
        result = sorter.sort(x);
        double end4 = System.currentTimeMillis();
        //System.out.println(endTime);
        double total4 = end4 - start4;
        System.out.println("The Merge Sort method takes time:"+ String.format( "%.10f", total4 ));
    	
        


        if (Arrays.equals(result,answer)) {
            System.out.println("4 . Merge Sort Correct.");
        } else {
            System.err.println("Merge Sort InCorrect:");
            System.err.println(Arrays.toString(result));
        }
        
        double start5 = System.currentTimeMillis();
        //System.out.println(startTime);
        sorter = new QuickSort<>();
        result = sorter.sort(x);
        double end5 = System.currentTimeMillis();
        //System.out.println(endTime);
        double total5 = end5 - start5;
        System.out.println("The Quick sort method takes time:"+ String.format( "%.10f", total5 ));
    	
        


        if (Arrays.equals(result,answer)) {
            System.out.println("5 . Quick Sort Correct.");
        } else {
            System.err.println("Quick Sort InCorrect:");
            System.err.println(Arrays.toString(result));
        }
        
        
        System.out.println(max_binary(x,0,x.length-1));
        compare_two_string("aba","bba");
        compare_two_string("aaba","bba");
        compare_two_string("e   lgoog","google");
        compare_two_string("aba","aba");
        
        System.out.println("kayak is palindrone true or flase: " + is_pal("kayak"));
        System.out.println("radar is palindrone true or flase: " + is_pal("radar"));
        System.out.println("dad is palindrone true or flase: " + is_pal("dad"));
        sort_in_three("Other entries include a historic district in Charlottesville Virginia cut-flower greenhouse complex");
        System.out.println("Number of zero in a byte representation 0 is " +num_zero("0"));
        System.out.println("Number of zero in a byte representation 01001001010101010 is " +num_zero("01001001010101010"));
        String xxx ="0010";
        //System.out.println(xxx.charAt(2));
       // System.out.println(xxx.substring(3, xxx.length()));
       /* 
        String x1 ="google";
        String x2 ="kayak";
        String x3 ="dad";
        System.out.println(x1.charAt(x1.length()-1)+"  "+x1.charAt(0));*/
        
    }
    //Recursive Q1 Recursive find max 
    public static int max_binary(Comparable[] copy, int sta,int end){
    	if (sta==end){
    		return (int) copy[sta]; 
    	}
    	
		int mid =(sta+end)/2;
		int max1 = max_binary(copy,sta,mid);
		int max2 = max_binary(copy,mid+1,end);
		
		if (max2>=max1){return max2;}
		else{return max1;}
		
		
	}
    
    public static int num_zero(String x){
    	//System.out.println(x);
    	
    	if(x.length()==0 ){
    		//System.out.println("String has length 0, returning 0");
    		return 0;
    	}
    	
    	int count = 0;
    	if(x.substring(0, 1).equals("0")){
    		//System.out.println("Character is an '0' adding 1 to the count");
    		count=1;}
    	
    	return count + num_zero(x.substring(1));
    	}
    	
    	
    
    //Recursive Q3 . Panlidromes
    public static boolean is_pal(String x){
		if (x.length()==0 ||x.length()==1)
			return true; 
		if (x.charAt(0) == x.charAt(x.length()-1)){
			is_pal(x.substring(1, x.length()-1));}
		return true;
			
		}
    //Arrays Q1 
	public static void compare_two_string(String x ,String y ){
		String x11 = x.toLowerCase();
		String y11 = y.toLowerCase();
		x11=x11.replaceAll("\\s+","");
		//System.out.println(x11);
		y11= y11.replaceAll("\\s+","");
		int count =0;
		if (x11.length()!=y11.length()){
			System.out.println("Not reversed:  "+ " 0"); 
			
		}
		else{for (int i=0;i<x11.length();i++){
		char x1 = x11.charAt(i);
		char y1 = y11.charAt(y.length()-i-1);
		if (x1!=y1){
			count+=0;
			}
		
		else{
			count+=1; }}
		
		if (count == x11.length()){
			System.out.println("Yes Reverse:"+"  1"); }
		else {System.out.println("Not reversed: "+ "  0"); }
		
		}}
	
	
	//Arrays Q2 
	public static void sort_in_three(String x){
		/* StringTokenizer st = new StringTokenizer(x);
	     while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken());
	     }*/
	     
	     String[] arr = x.split("\\s");
	    
	     int len = arr.length;
	     //System.out.println(len);//Figure out how to take null out of the array 
	     String[] arr1 = new String[(len/3)];
	    // System.out.println(arr1);
	    // System.out.println(arr[9].length());
	     //System.out.println(arr[11].length());
	     //System.out.println("Compare the cut_flower and complex "+arr[9].compareTo(arr[11]));
	     /*for (int x1=0; x1<arr1.length; x1++)
	         System.out.println(arr1[x1]);*/
	     if(len%3==0){
	    	 for (int i =0;i<len/3;i++){
	    		 //System.out.println("This is the number of times run"+i);
	    		 String temp=arr[3*i];
	    		 for (int j =3*i ;j<3*i+2;j++){
	    			 //System.out.println("This is the number of insdide loop run "+j);
	    			 if (arr[j+1].length()<temp.length()){
	    				 temp = arr[j+1];
	    			 }
	    			 //else{temp =arr[j];}

	    		 }
	    		// System.out.println(temp);
	    		 arr1[i]=temp;
	    	 }
	    	 	 	 
	     for (int x1=0; x1<arr1.length; x1++)
	         System.out.println(arr1[x1]);}
			}
	}
