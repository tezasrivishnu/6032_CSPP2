import java.util.Scanner;
/**
*@author vishnu.
*/
public final class AreaOfCircle {
    /**
    * varaiable PI of double.
    */
    private static final double PI = 3.14;
    /**
    *empty constructor.
    */
    private AreaOfCircle() {
        //not using.
    }
    /**
    *main program.
    * @param args is the parameter.
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        double p = pi();
        double area = area(r, p);
        System.out.println(area);
    }
    /**
    *@return pi value(double) for calculating area of circle.
    */
    public static double pi() {
        /**
        * returning pi value.
        */
        return PI;
    }
    /**
    *@param r is the parameters.
    *@param p is the parameters.
    * @return area(double).
    */
    public static double area(final double r, final double p) {
        /**
        * returning the area after calculating.
        */
        return (p * r * r);
    }
}
