import java.util.Scanner;
/**
*@author vishnu
*/
public final class BiggerEqualSmaller {
    /**
    *empty constructor.
    */
    private BiggerEqualSmaller() {
        //not using.
    }
    /**
    * intitializing the main.
    * @param args the parameter.
    */
    public static void main(final String[] args) {
        /**
        * giving the input and comparing.
        */
        Scanner sc = new Scanner(System.in);
        double varA = sc.nextDouble();
        double varB = sc.nextDouble();
        System.out.println(which(varA, varB));
    }
    /**
    *@param varA are parameters.
    *@param varB are parameters.
    *@return a string.
    */
    public static String which(final double varA, final double varB) {
        /**
        * we are finding which is bigger.
        */
        if (varA == varB) {
        return "both are equal";
        } else if (varA > varB) {
        return "varA is bigger";
        } else {
        return "varB is bigger";
        }
    }
}
