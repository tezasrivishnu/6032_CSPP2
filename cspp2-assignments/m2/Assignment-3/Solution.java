import java.util.Scanner;
/**
*@author vishnu
*/
public final class Solution {
    /**
    *empty constructor.
    */
    private Solution() {
        //not using.
    }
    /**
    *Do not modify this main function.
    *@param args is the parameter
    */
    public static void main(final String[] args) {
        /**
        *giving the input
        */
        Scanner s = new Scanner(System.in);
        long base = s.nextInt();
        long exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    Need to write the power function and print the output.
    *@param base is the parameter.
    *@param exponent is the parameter.
    *@return long value
    */
    public static long power(final long base, final long exponent) {
        /**
        calculating the power
        */
        if (exponent != 0) {
            return (base * power(base, exponent - 1));
        } else {
            return 1;
        }
    }
}