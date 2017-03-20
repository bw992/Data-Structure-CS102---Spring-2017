package lab7;

public class RecursiveBinarySearch {

	public static int binarySearch(int[] x, int i) {
		
		return bs_rec(x,i,0,x.length);
	}

	private static int bs_rec(int[] x, int key, int sta, int end) {
		if (sta>end){
			System.out.println( "The int is not in the array:  "+key );
			return -1;
		}
		
		int mid = (sta + end)/2;
		
		if (key>x[mid]){
			return bs_rec(x,key,mid+1,end);
			}
		
		else if (key<x[mid]){
			return bs_rec(x,key,sta,mid-1);
			}
		
		else {
			System.out.println("The correct index of key is : "+ mid);
			return mid; 
			}
	}
}
