package hw3;

import java.util.Arrays;

public class plainquick <T extends Comparable<? super T>> implements ISorting<T>  {

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
		
		if(low<high){
		int right = partition(A, low,high);
		//System.out.println("in the right end: Original Array "+Arrays.toString(A));
		quick_aux(A,low,right-1);
		//System.out.println("in the right end: Original Array "+Arrays.toString(A));
		quick_aux(A,right+1, high);}
		//System.out.println("in the right end: Original Array "+Arrays.toString(A));
	
	}
	
	private static int partition(double[]A, int low, int high){
		double pivot = A[high];
		//System.out.println("The pivot is "+pivot);
		int i = low -1;
		for (int j=low; j<=high-1; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (A[j] <= pivot)
            {
                i++;
 
                
                double temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
		double temp = A[i+1];
        A[i+1] = A[high];
        A[high] = temp;
 
        return i+1;
    }
	
	
	  public static double medianOf3(double[] intArray, int left, int right) {
		   //Simple verison return the first elemnt 
		    return intArray[right-1] ;
		    	
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
