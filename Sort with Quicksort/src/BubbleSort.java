import java.util.Arrays;

public class BubbleSort<T extends Comparable<? super T>> implements ISorting<T> {
	
	@Override
	public T[] sort(T[] elements) {
		// TODO Auto-generated method stub
		
		T [] copy = Arrays.copyOf(elements, elements.length);
		elements[0].compareTo(elements[1]);
		int b = copy.length;
		//System.out.println(b);
		 T temp; 
		for (int i = 0; i<b; i++){
			 for(int j=1; j < (b-i); j++){  
	           
		     if (copy[j].compareTo(copy[j-1])==(-1)){
		    	temp =  copy[j-1];
		    	copy[j-1] = copy[j];
		    	copy[j] = temp;
		    	}
			 }
		}
		
		return copy;
		}	
	
	
	   
	@Override
	public T[] descendingSort(T[] elements) {
		// TODO Auto-generated method stub
		return null;
	}
	
}