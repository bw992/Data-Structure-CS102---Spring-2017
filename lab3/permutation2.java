package lab3;
import java.util.ArrayList;
import java.util.List;

public class permutation2 {
	public static List<List<Integer>> permute(int n) {
		 List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		
		 //create the final list of list 
		 permutations.add(new ArrayList<Integer>());
		 
		 //add a list 
		 for ( int i = 0; i <n; i++ ) {
			 //for n times loop 
			 List<List<Integer>> current = new ArrayList<List<Integer>>();
			 //create a current loop 
		        for ( List<Integer> permutation : permutations ) {
		        	
	                
		            for ( int j = 0, x = permutation.size() + 1; j < x; j++ ) {
		            	System.out.println("j is :" +j);
		            	System.out.println("x is:" + x);
		                List<Integer> temp = new ArrayList<Integer>(permutation);
		                System.out.println("xxxxasdwadadawdawdwda"+temp);
		                temp.add(j,x);
		                //add at index j, with the elements [i] 
		                
		                System.out.println("the current list is "+current);
		                System.out.println("the current temp  list is "+temp);
		                current.add(temp);
		                System.out.println("the current2 list is "+current);
		                //add the temp into the current 
		            }
		        }
		        permutations = new ArrayList<List<Integer>>(current);
		        // point the current to permutations 
			 
		 }
		 return permutations;
	}
	



public static void main(String[] args) {
	System.out.println( permute(3));
}
}
