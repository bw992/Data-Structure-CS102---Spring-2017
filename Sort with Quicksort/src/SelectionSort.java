import java.util.Arrays;

public class SelectionSort<T extends Comparable<? super T>> implements ISorting<T> {

	
		@Override
		public T[] sort(T[] elements) {
			// TODO Auto-generated method stub
			
			T [] copy = Arrays.copyOf(elements, elements.length);
			elements[0].compareTo(elements[1]);
			int b = copy.length;
			int k,j,minindex;
			//System.out.println(b);
			T min; 
			for (k = 0; k<b; k++){
				min = copy[k];
				minindex = k; 
				 for(j=k+1; j <b ; j++){  
					 if (copy[j].compareTo(min)==(-1)){
						 min =  copy[j];
						 minindex = j;
			     	}
				 }
				 copy[minindex]=copy[k];
			     copy[k]=min;
			}
			
			return copy;
			}	
		
		
		   
		@Override
		public T[] descendingSort(T[] elements) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

