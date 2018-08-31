import java.util.Scanner;
/**
 * Program to reverse of a string.
 * @author tezasrivishnu
 */
public final class Solution {
    /**
     * empty constructor.
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
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
     * finfing the reverse of a string.
     * @param a string is the parameter.
     * @return sum is a string .
     */
    public static String reverseString(final String a) {
        int l = a.length();
        String temp = "";
        for (int i = l - 1; i >= 0; i--) {
            temp += a.charAt(i);
        }
        return temp;
    }
}