import java.util.Scanner;
/**
 * GCD program.
 * @author tezasrivishnu.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not using.
    }
    /**
     * Main program.
     * @param args is the parameter.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int i = 1;
        System.out.println(Divisor(a, b));
    }
    /**
     * calculating the GCD.
     * @param a   is a int value.
     * @param b   is a int value.
     * @return a int value.
     */
    public static int Divisor(final int a, final int b) {
        int temp;
        int gcd = 1;
        if (a == b) {
            return a;
        } else {
            if (a > b) {
                temp = b;
            } else {
                temp = a;
            }
            for (int i = 1; i <= temp; i++) {
                if ((a % i == 0) && (b % i == 0)) {
                    gcd = i;
                }
            }
        }
    return gcd;
    }
}