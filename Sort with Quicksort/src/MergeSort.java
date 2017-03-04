import java.util.Arrays;

public class MergeSort<T extends Comparable<? super T>> implements ISorting<T> {

	
		@Override
		public  T[] sort(T[] elements) {
			// TODO Auto-generated method stub
			
			T [] copy = Arrays.copyOf(elements, elements.length);
			int b = copy.length;
			mergeSort(copy);
			return copy;
			
		}
	
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
         	
  
		
	
		@Override
		public T[] descendingSort(T[] elements) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
