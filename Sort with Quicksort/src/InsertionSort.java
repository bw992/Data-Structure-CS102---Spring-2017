import java.util.Arrays;

public class InsertionSort<T extends Comparable<? super T>> implements ISorting<T> {
	
	@Override
	public T[] sort(T[] elements) {
		// TODO Auto-generated method stub
		T [] copy = Arrays.copyOf(elements, elements.length);
		elements[0].compareTo(elements[1]);
		int b = copy.length;
		T temp;
	    for (int i = 1; i < b; i++) {
	          for(int j = i ; j > 0 ; j--){
	              if(copy[j].compareTo(copy[j-1])==(-1)){
	                    temp = copy[j];
	                    copy[j] = copy[j-1];
	                    copy[j-1] = temp;
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
