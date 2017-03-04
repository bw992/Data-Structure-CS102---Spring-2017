import java.util.Arrays;

public class BubbleSort_Re<T extends Comparable<? super T>> implements ISorting<T> {
	
	@Override
	public T[] sort(T[] elements) {
		// TODO Auto-generated method stub
		
		T [] copy = Arrays.copyOf(elements, elements.length);
		elements[0].compareTo(elements[1]);
		int b = copy.length;
		//System.out.println(b);
		 T temp;
		 bubble_rec(copy,b);
		 return copy;
		 } 
		 
		 
		 
		 public static Object bubble_rec(Comparable[]copy,int b){
			 if(b ==1){
				 return copy;
			 }
			 Comparable temp1;
			 for(int i=0;i<b-1;i++){
				 if (copy[i+1].compareTo(copy[i])==(-1)){
					 temp1 =  copy[i];
					 copy[i] = copy[i+1];
					 copy[i+1] =temp1;
					 
				 }
			 }
			return   bubble_rec(copy, b-1);
			 
		 }
		
	
	



	@Override
	public T[] descendingSort(T[] elements) {
		// TODO Auto-generated method stub
		return null;
	}
	
}