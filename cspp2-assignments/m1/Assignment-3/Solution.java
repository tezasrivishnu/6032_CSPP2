import java.util.Scanner;
/**
*@author vishnu
*/
public class Solution {
    /**
    *empty constructor
    */
    private Solution(){
        //not using
    }
    /**
    *main program 
    * @param args is the parameter
    */
    /*
    Do not modify this main function.
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        areaOfTriangle(base, height);
    }
    /*
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
    static void areaOfTriangle(int base, int height) {
        double area = 0.5 * base * height;
        System.out.println(area);
    }
}
