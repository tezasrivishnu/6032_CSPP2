import java.util.Scanner;
/**
 * Class for average.
 * @author tezasrivishnu.
 */
public final class Average {
    /**
     * Constructs the object.
     */
    private Average() {
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
        int sum = 0;
        for (int j = 0; j <= ar.length - 1; j++) {
            sum = sum + ar[j];
        }
        float avg = sum / ar.length;
        System.out.println(avg);
    }
}
