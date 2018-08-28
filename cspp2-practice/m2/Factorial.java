import java.util.Scanner;
/**
*@author vishnu
*/
public final class Factorial {
    /**
    *empty constructor.
    */
    private Factorial() {
        //not using.
    }
    /**
    * main function for the program.
    *@param args is the parameter.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        System.out.println((fact(f)));
    }
    /**
    *@param f is the parameter.
    *@return its returning a int value.
    */
    public static int fact(final int f) {
        if ((f == 0) || (f == 1)) {
            return 1;
        } else {
            return (f * fact(f - 1));
        }
    }
}
