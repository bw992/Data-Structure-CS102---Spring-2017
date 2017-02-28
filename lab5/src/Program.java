import java.util.Arrays;

public class Program {

    public static void main(String[] args) {

        Integer[] answer = {3, 3, 4, 5, 5, 7, 9, 9, 10, 10, 11, 19, 20, 24, 28, 29, 30, 43, 43, 63, 85};
        Integer[] Descanswer = {85, 63, 43, 43, 30, 29, 28, 24, 20, 19, 11, 10, 10, 9, 9, 7, 5, 5, 4, 3, 3};
        Integer[] x = {4, 5, 3, 63, 7, 9, 10, 43, 28, 43, 85, 20, 19, 3, 5, 10, 11, 9, 24, 29, 30};
        Integer[] copyOfx = Arrays.copyOf(x, x.length);

        ISorting<Integer> sorter = new BubbleSort<>();
        Integer[] result = sorter.sort(x);
        Integer[] result1 = sorter.descendingSort(x);
        
        //System.out.println(Arrays.toString(result1));
        if (Arrays.equals(result1,Descanswer)) {
            System.out.println("BubbleSort Desc Correct.");
            //System.out.println(Arrays.toString(result));
        } else {
            System.err.println("BubbleSort Desc InCorrect:");
            System.err.println(Arrays.toString(result));
        }

        if (Arrays.equals(result,answer)) {
            System.out.println("BubbleSort Correct.");
            //System.out.println(Arrays.toString(result));
        } else {
            System.err.println("BubbleSort InCorrect:");
            System.err.println(Arrays.toString(result));
        }

        if (!Arrays.equals(x,copyOfx)){
            System.err.println("Contents of x has been changed.");
        }

        sorter = new InsertionSort<>();
        result = sorter.sort(x);
       
        Integer[] result2 = sorter.descendingSort(x);
        
        //System.out.println(Arrays.toString(result1));
        if (Arrays.equals(result2,Descanswer)) {
            System.out.println("Insertion Desc Correct.");
            //System.out.println(Arrays.toString(result));
        } else {
            System.err.println("Insertion Desc InCorrect:");
            System.err.println(Arrays.toString(result));
        }

        if (Arrays.equals(result,answer)) {
            System.out.println("InsertionSort Correct.");
            //System.out.println(Arrays.toString(result));
        } else {
            System.err.println("InsertionSort InCorrect:");
            System.err.println(Arrays.toString(result));
        }
        
       /* String x1 ="google";
        String x2 ="kayak";
        String x3 ="dad";
        System.out.println(x1.charAt(x1.length()-1)+"  "+x1.charAt(0))*/;}}
        
        
        //mergeSort(x);
        //System.out.println(Arrays.toString(x));
        
      /*  
        public static void mergeSort(Comparable[] A) {
        	  Comparable[] temp = new Comparable[A.length];
        	  mergeAux(A,temp, 0, A.length - 1); // call the aux. function to do all the work
        	}

        private static void mergeAux(Comparable[] A,Comparable [ ] tmp, int low, int high)
        	{
        	  // base case
        	     if (low <high) {

        	  // recursive case
        	  // Step 1: Find the middle of the array (conceptually, divide it in half)
        	     int mid = (low + high) / 2;
        	  // Steps 2 and 3: Sort the 2 halves of A
        	     mergeAux(A,tmp, low, mid);
        	     mergeAux(A,tmp, mid+1, high);
        	     merge(A,tmp,low,mid+1,high);}}

        	  // Step 4: Merge sorted halves into an auxiliary array
        	     private static void merge(Comparable[ ] A, Comparable[ ] tmp, int left, int right, int high )
        	     {
        	     int mid = right -1; // index into left half
        	     // index into right half
        	     // index into tmp
        	     int pos = left; 
        	     int num = high -left +1;
        	    
        	        
        	     
        	     while ((left <= mid) && (right <= high)) {
        		// choose the smaller of the two values "pointed to" by left, right
        		// copy that value into tmp[pos]
        		// increment either left or right as appropriate
        		// increment pos
        	    	 if(A[left].compareTo(A[right]) <= 0){
        	                tmp[pos++] = A[left++];}
        	            else{
        	                tmp[pos++] = A[right++];}}
        	    		
        	    	     
        	       while (left <= mid) {
        	           tmp[pos++] = A[left++];}
        	       while (right <= high) {
        	           tmp[pos++] = A[right++];}
        		   
        		   
        		   for(int i = 0; i < num; i++, high--){
        	            A[high] = tmp[high];
        	       }    
        	       
        	       
        	     }
           	
    }
*/
