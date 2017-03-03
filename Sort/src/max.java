import java.util.Arrays;

public class max<T extends Comparable<? super T>> implements ISorting<T> {
	
	@Override
	public T[] sort(T[] elements) {
		// TODO Auto-generated method stub
		T [] copy = Arrays.copyOf(elements, elements.length);
		elements[0].compareTo(elements[1]);
		int b = copy.length;
		double result = max_binary(copy,0,b);
		
		return copy;
}
	public static double max_binary(Comparable[] copy, int sta,int end){
		int mid =(sta+end)/2;
		double max1 = max_binary(copy,sta,mid);
		double max2 = max_binary(copy,mid+1,end);
		
		if (max2>max1){return max2;}
		else{return max1;}
		
		
	}
	@Override
	public T[] descendingSort(T[] elements) {
		// TODO Auto-generated method stub
		return null;
	}}
