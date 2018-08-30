import java.util.Scanner;
/**
 * program to find largest in array.
 * @author tezasrivishnu.
 */
public final class Solution {
    /**
     * empt constructor.
     */
    private Solution() {
        //not using.
    }
    /**
     * main function.
     * @param args is the parameter.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] ar = new int[l];
        for (int i = 0; i < l; i++) {
            ar[i] = sc.nextInt();
        }
        int i = ar[0];
        for (int a = 0; a <= ar.length - 1; a++) {
            if (ar[a] > i) {
                i = ar[a];
            }
        } System.out.println(i);
    }
}