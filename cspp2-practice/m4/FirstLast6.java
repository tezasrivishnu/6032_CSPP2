import java.util.Scanner;
/**
 * Class for first last 6.
 * @author tezasrivishnu.
 */
public final class FirstLast6 {
    /**
     * setting the value of 6.
     */
    private static final int SIX = 6;
    /**
     * Constructs the object.
     */
    private FirstLast6() {
        //not using.
    }

    /**
     * main function.
     * @param args is the parameter.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        if (ar[0] == SIX || ar[ar.length - 1] == SIX) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
