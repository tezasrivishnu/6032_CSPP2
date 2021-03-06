import java.util.Scanner;
/**
 *@author tezasrivishnu.
 *program to convert string binary value to decimal.
 */
public final class Solution {
    /**
     * empty constructor.
     */
    private Solution() {
        //not using
    }
    /**
     * main program.
     * @param args is the parameter.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            double res = binaryToDecimal(s);
            System.out.println((int) res);
        }
    }
    /**
     * converting binary to decimal.
     * @param s string is the parameter.
     * @return  double value.
     */
    static double binaryToDecimal(final String s) {
        int a = s.length();
        double sum = 0;
        long b = a;
        for (int i = 0; i <= a - 1; i++) {
            long n = Character.getNumericValue(s.charAt(i));
            sum = sum + (n * Math.pow(2, b - 1));
            b -= 1;
        } return sum;
    }
}
