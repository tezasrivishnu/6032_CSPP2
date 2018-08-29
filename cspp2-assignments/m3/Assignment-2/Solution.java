import java.util.Scanner;
/**
 * Finding 7's below n.
 * @author tezasrivishnu.
 */
public final class Solution {
    /**
     * setting value of 10.
     */
    private static final int TEN = 10;
    /**
     * setting value of 7.
     */
    private static final int SEVEN = 7;
    /**
     * setting value of 7.
     */
    private static final int i = 0;
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
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for (int i = SEVEN; i <= n; i++) {
            count += finding(i);
        }
        System.out.println(count);
    }
    /**
     * Calculating the 7's below i.
     * @param i int value is the parameter.
     * @return  an int value.
     */
    public static int finding(int i) {
        int count = 0;
        while (i > 0) {
            if (i % TEN == SEVEN) {
                count += 1;
            }
            i = i / TEN;
        }
        return count;
    }
}
