import java.util.Scanner;
/**
 * @author vishnu.
 */
public final class Solution {
    /**
     * setting the value of 4.
     */
    private static final int FOUR = 4;
    /**
    *empty constructor.
    */
    private Solution() {
        //not using.
    }
    /*
    Do not modify this main function.
    */
    /**
     * main program
     * @param args is the parameter
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadEq(a, b, c);
    }
    /*
    Need to write the rootsOfQuadEq function and print the output.
    */
    /**
     *calculating the roots
     * @param a is int type
     * @param b is int type
     * @param c is int type
     */
    public static void rootsOfQuadEq(final int a, final int b, final int c) {
        double d = (b * b) - (FOUR * a * c);
        double r1 = (-b + Math.sqrt(d)) / (2 * a);
        double r2 = (-b - Math.sqrt(d)) / (2 * a);
        System.out.println(r1 + " " + r2);
        // } else if (d == 0) {
        //  double r1 = (-b + Math.sqrt(d))/(2 * a);
        //  System.out.println(r1);
        // } else {
        //  System.out.println("roots are imaginary");
        // }
    }
}
