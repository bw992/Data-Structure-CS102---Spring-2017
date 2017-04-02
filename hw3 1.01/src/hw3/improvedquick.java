package hw3;

import java.util.Arrays;

public class improvedquick <T extends Comparable<? super T>> implements ISorting<T> {
	@Override
	public double[] sort(double[] elements) {
		// TODO Auto-generated method stub
		double[] copy = Arrays.copyOf(elements, elements.length);
		double[] copy1 = Arrays.copyOf(elements, elements.length);
		int b = copy.length;
		quicksort(copy);
		for (int i =0; i <b;i++){
			copy1[b-i-1]=copy[i];
		}
		return copy1;}
	
	public static void quicksort(double[] A){
		
		quick_aux(A,0,A.length-1);
	}
	
	private static void quick_aux(double[] A, int low, int high ){
		
		int size =high -low +1;
		
		if (size<3){
			manualSort(A,low,high);
		}
		
		else{
		int right = partition(A, low,high);
		//System.out.println("in the right end: Original Array "+Arrays.toString(A));
		quick_aux(A,low,right);
		//System.out.println("in the right end: Original Array "+Arrays.toString(A));
		quick_aux(A,right +2, high);}
		//System.out.println("in the right end: Original Array "+Arrays.toString(A));
		
	}
	
	private static int partition(double[]A, int low, int high){
		double pivot =  medianOf3(A, low, high);
		//System.out.println("The pivot is "+pivot);
		int left = low+1;
		int right = high -2;
		while (left <=right){
			while(A[left]<pivot) {left++;}
			while(A[right]>pivot) {right--;}
			if (left<right){
				//System.out.println("left " + left + "right is "+right);
				swap(A,left,right);
				left++;
				right--;
				//System.out.println("swap");
				//System.out.println(" Original Array "+Arrays.toString(A));
			}	
		}
		swap (A,left,high -1); //Put the pivot point into the right position
		return right;
	}
	
	  public static double medianOf3(double[] intArray, int left, int right) {
		    int center = (left + right) / 2;

		    if (intArray[left]>intArray[center])
		      swap(intArray, left, center);
		    	
		    if (intArray[left]>intArray[right])  
		      swap(intArray, left, right);

		    if (intArray[center]>intArray[right] )
		      swap(intArray, center, right);

		    swap(intArray, center, right - 1);
			double x= (double)intArray[right - 1];
		    return x ;
		    	
		  }
	
	public static void swap(double[]A, int low, int high){
		double temp;
		temp = A[low];
		A[low] =A[high];
		A[high] = temp;
	}
	
	  public static void manualSort(double[] intArray, int left, int right) {
		    int size = right - left + 1;
		    if (size <= 1)
		      return;
		    if (size == 2) {
		      if (intArray[left]>(intArray[right]))
		        swap(intArray, left, right);
		      return;
		    } 
		    else {
		      if (intArray[left]>intArray[right-1])
		        swap(intArray, left, right - 1);
		      if (intArray[left]>intArray[right] )
		        swap(intArray, left, right);
		      if (intArray[right-1]>intArray[right])
		        swap(intArray, right - 1, right);
		    }
		  }


	@Override
	public double[] descendingSort(double[] elements) {
		// TODO Auto-generated method stub
		return null;
	}

	
		

}
