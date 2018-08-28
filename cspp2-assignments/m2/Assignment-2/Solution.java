import java.util.Scanner;
import java.lang.Math;

public final class Solution {
	/**
	*empty constructor.
	*/
	private Solution() {
		//not using.
	}
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	public static void rootsOfQuadraticEquation(final int a, final int b, final int c) {
		double d = (b * b) - (4 * a * c);
		double r1 = (-b + Math.sqrt(d)) / (2 * a);
		double r2 = (-b - Math.sqrt(d)) / (2 * a);
		System.out.println(r1 + " " + r2);
		// } else if (d == 0) {
		// 	double r1 = (-b + Math.sqrt(d))/(2 * a);
		// 	System.out.println(r1);
		// } else {
		// 	System.out.println("roots are imaginary");
		// }
	}
}
