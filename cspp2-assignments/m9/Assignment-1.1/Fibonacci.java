import java.util.Scanner;
import java.util.Arrays;
/*
 * In the previous module you have created List ADT.
 * ADTs are developed as reusable libraries
 * i.e., anyone who needs the ADT can use it in their program
 * A program that uses the ADT is called a "client" of the ADT
 * The client typically instantiates an object of the ADT
 * and invokes the public methods on the ADT object.
 *
 * This assignment is to practice the idea of client to the ADT.
 * Client class is Fibonacci and the client needs to use the List ADT
 * to store fibonacci numbers in the List ADT.
 * So, Fibonacci is going to instantiate an object of List ADT
 * generate fibonacci numbers and add them to the list
 * by invoking the add method provided in the List ADT.
 *
 */
/**
 * Class for fibonacci.
 * @author tezasrivishnu.
 */
public class Fibonacci {
    /*
     * fib is a static method takes a argument n.
     * n is the count of the fibonacci numbers to be generated.
     * The method returns a List with the n fibonacci numbers.
     * Look for the hint.txt if some of the testcases fail.
     */
    /**
     * finding the fibnocci.
     * @param      n     int is the input.
     */
    public static List fib(final int n) {
        List l = new List();
        int[] a = new int[n];
        a[0] = 0;
        a[1] = 1;
        int i;
        //String str = "[";
        for (i = 2; i < n; i++ ) {
            a[i] = a[i - 1] + a[i - 2];
        }
        for (i = 0; i < a.length; i++) {
            // str += a[i] + ",";
            l.add(a[i]);
        }
        // str += a[i] + "]";
        return l;
    }
    /**
     * main function.
     * @param      args  is the parameter.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fib(n));
        // fib(n);
    }
}