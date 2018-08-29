import java.util.Scanner;
/**
 * @author .
 */
public final class Pattern {
    /**
     * Constructs the object.
     */
    private Pattern() {
        //not using.
    }
    /**
     * main progarm.
     * @param args is the parameter.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= a; b++) {
                System.out.print(b);
            }
            System.out.println();
        }
    }
}
