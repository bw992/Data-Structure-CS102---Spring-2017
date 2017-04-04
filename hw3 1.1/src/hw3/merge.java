package hw3;

import java.text.NumberFormat;
import java.util.Arrays;

public class merge<T extends Comparable<? super T>> implements ISorting<T>  {
	public double[] sort(double[]elements){
		double[] copy  = Arrays.copyOf(elements, elements.length);
		int b = copy.length;
		mergesort(copy);
		return copy;
		
	}
	public static void mergesort(double[] A){
		double[] temp =   new double[A.length];
		mergeAux(A,temp,0, A.length-1);
		//System.out.println("Runing mergesort");
		
	}
	public static void mergeAux(double[]A, double[]temp, int low, int high){
		if (low<high){
		int mid = (low+high)/2;
		//System.out.println("Runing mergeaux");
		mergeAux(A,temp,low,mid);
		mergeAux(A,temp,mid+1,high);
	//	System.out.println("left: Original Array "+Arrays.toString(A));
		merge_end(A,temp,low,mid+1,high);
		//System.out.println("right: Original Array "+Arrays.toString(A));
		}
	}
	
	private static void merge_end(double[] A, double[] temp, int low, int right, int high) {
		//System.out.println("Runing mergeend");
//		NumberFormat defaultFormat = NumberFormat.getPercentInstance(); // Format Method
//		defaultFormat.setMinimumFractionDigits(2);	
//		defaultFormat.setMinimumFractionDigits(3);
		
		int mid = right-1;
		int pos = low;
		int num = high -low +1 ; 
		
		while(low<=mid && right<=high){
		if (A[low]>A[right]){ 
//			
//			System.out.println("Add smaller from left array into merge end");
//			String result_per = defaultFormat.format(A[low]);
//			System.out.println(result_per);
			temp[pos++]= A[low++];
		
		}
		
		else{ 
//				System.out.println("Add biggerfrom left array into merge end");
//				
//				String result_per1  = defaultFormat.format(A[right]);
//				System.out. println(result_per1 );
				temp[pos++] = A[right++];}
		}
		
		while(low<=mid){    temp[pos++] = A[low++];}
		while(right<=high){ temp[pos++]= A[right++];}
		
		for(int i = 0; i < num; i++, high--){
	            A[high] = temp[high];}
	           // System.out.println("last for loop : Original Array "+Arrays.toString(A));}
			}
	@Override
	public double[] descendingSort(double[] elements) {
		// TODO Auto-generated method stub
		return null;
	}
	}
