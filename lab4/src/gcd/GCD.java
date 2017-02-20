package gcd;

import java.util.Scanner;

public class GCD {
	public static int gcd(int a, int b){
		int temp =1; 
		for (int i =1; i<Math.max(a,b); i++){
			if (a%i ==0 & b%i==0){
				temp = i;
		 	}
	 }
	return temp;
  }

	public static int gcd_recur(int a, int b){
		//int x = Math.min(a,b);
		//int y = Math.max(a, b);
		//int temp =1;
		if (b ==0){
			return a;
		}
		else{
			return gcd (b,a%b);
		}
		}
	

		
	

public static void main(String[] args){
	Scanner scanner = new Scanner(System.in); 
	System.out.println("Please enter first number to find GCD"); int a= scanner.nextInt(); 
	System.out.println("Please enter second number to find GCD"); int b= scanner.nextInt(); 
	System.out.println("GCD of two numbers by recursion method " + a +" and " + b +" is :" + gcd_recur(a,b)); 
	System.out.println("GCD of two numbers by for loop method " + a +" and " + b +" is :" + gcd(a,b));
	System.out.println("if Two method has the same result: "+  (gcd(a,b)==gcd_recur(a,b)));
	
	//System.out.println(gcd(12,48));
	//System.out.println(gcd_recur(12,48));
	}
}