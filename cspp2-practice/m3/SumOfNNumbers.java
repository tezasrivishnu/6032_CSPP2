import java.util.Scanner;
/**
 * @author vishnu.
 */
public final class SumOfNNumbers {
    /**
     * Constructs the object.
     */
    private SumOfNNumbers() {
        //not using.
    }
    /**
     * main program.
     * @param args is parameter.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int a = 1; a <= n; a++) {
            sum = sum + a;
        }
        System.out.println(sum);
    }
}
