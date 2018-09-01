import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author :
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = 0;
        int count1 = 0;
        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count += 1;
                }
            }
            if (count != 2 && i % 2 != 0) {
                oddComposites(i);
                if (count1 == n) {
                    break;
                }

            }
        }
    }
    /**
     * printing the composite number.
     *
     * @param      i     is the parameter.
     */
    public static void oddComposites(final int i) {
        System.out.println(i);
    }
}
