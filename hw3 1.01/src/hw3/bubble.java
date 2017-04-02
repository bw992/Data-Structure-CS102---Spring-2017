package hw3;

import java.util.Arrays;
import java.lang.*;

public class bubble<T extends Comparable<? super T>> implements ISorting<T> {
	

	@Override
	public double[] sort(double[] elements) {
		// TODO Auto-generated method stub
		double[] copy = Arrays.copyOf(elements, elements.length);
		double x = elements[0];
			
		int b = copy.length;
		//System.out.println(b);
		double temp; 
		 //1. Loop Through the 0 - b-1
		for (int i = 0; i<b; i++){
			//2.pair-wise comparison
			 for(int j=1; j < (b-i); j++){  
	           // 3.if one is less than the next element, swap 
		     if ((copy[j]>copy[j-1])){
		    	//System.out.println("the element in Index "+j +" : " + copy[j]+" is less than " + "the element in Index "+(j-1) +" : " + copy[j-1]);
		    	//System.out.println("swap");
		    	 
		    	temp =  copy[j-1];
		    	copy[j-1] = copy[j];
		    	copy[j] = temp;
		    	//System.out.println(Arrays.toString(copy));
		    	}
		     
			 }
			 
		}
		
		return copy;
		}	
	
	



	@Override
	public double[] descendingSort(double[] elements) {
		// TODO Auto-generated method stub
		return null;
	}}