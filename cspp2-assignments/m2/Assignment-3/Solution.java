import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);      
        double base = s.nextInt();
        double exponent = s.nextInt();
        double result=power(base,exponent);
        System.out.println(result);
	}
	/*
	Need to write the power function and print the output.
	*/
	public static double power(double base, double exponent){
		if (exponent!=0){
			return (base * power(base, exponent-1));
		}
		else {
			return 1;
		}
}
}
