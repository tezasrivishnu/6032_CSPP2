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
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        calculateFromDegreesToFarenheit(degreesCelsius);
    }
    /**
    printing the output of faranheit
    of fahrenheit.
    *@param degreesCelcius is the parameter
    */
    static void calculateFromDegreesToFarenheit(double degreesCelsius) {
        double faran = (degreesCelsius * 1.8) + 32;
        System.out.println(faran);
    }
}
