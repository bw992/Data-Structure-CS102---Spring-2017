import java.util.Arrays;

public class QuickSort<T extends Comparable<? super T>> implements ISorting<T> {

	@Override
	public T[] sort(T[] elements) {
		// TODO Auto-generated method stub
		
		T [] copy = Arrays.copyOf(elements, elements.length);
		elements[0].compareTo(elements[1]);
		int b = copy.length;
		quicksort(copy);
		return copy;}
	
	public static void quicksort(Comparable[] A){
		quick_aux(A,0,A.length-1);
	}
	
	private static void quick_aux(Comparable[] A, int low, int high ){
		int right = partition(A, low,high);
		quick_aux(A,low,right);
		quick_aux(A,right +2, high);
		
	}
	
	private static int partition(Comparable[]A, int low, int high){
		Comparable pivot =  medianOf3(A, low, high);
		int left = low+1;
		int right = high -2;
		while (left <right){
			while(A[left].compareTo(pivot)<0) {left++;}
			while(A[right].compareTo(pivot)>0) {right--;}
			if (left<right){
				swap(A,left,right);
				left++;
				right--;
			}	
		}
		swap (A,left,high -1); //Put the pivot point into the right position
		return right;
	}
	
	  public static int medianOf3(Comparable[] intArray, int left, int right) {
		    int center = (left + right) / 2;

		    if (intArray[left].compareTo(intArray[center])>0)
		      swap(intArray, left, center);

		    if (intArray[left].compareTo(intArray[right]) >0 )
		      swap(intArray, left, right);

		    if (intArray[center].compareTo(intArray[right]) > 0)
		      swap(intArray, center, right);

		    swap(intArray, center, right - 1);
		    return (int) intArray[right - 1];
		  }
	
	public static void swap(Comparable[]A, int low, int high){
		Comparable temp;
		temp = A[low];
		A[low] =A[high];
		A[high] = temp;
	}


	@Override
	public T[] descendingSort(T[] elements) {
		// TODO Auto-generated method stub
		return null;
	}

	
		
				
		
		
		   
}

