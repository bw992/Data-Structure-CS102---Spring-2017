package lab7;

import java.util.ArrayList;

/**
 * Created by fredf on 3/7/2017.
 */
public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle.print(6);
    }

	private static void print(int n) {
		// i is row number 
		// TODO Auto-generated method stub
		for(int i =0;i<n;i++){
			for(int j = 0 ; j <= i; j ++){
				System.out.print(pascal(i,j) + " ");
			}
			System.out.println();
		}
	
}

	static int pascal(int row, int col) {
		  if (col == 0 || col == row) {
		    return 1;
		  } else {
		    return pascal(row - 1, col - 1) + pascal(row - 1, col);
		  }
		}
	}
