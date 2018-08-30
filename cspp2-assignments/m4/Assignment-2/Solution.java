import java.util.Scanner;
/**
 * Adition of two matrices.
 * @author tezasrivishnu.
 */
public final class Solution {
    /**
     * empty constructor.
     */
    private Solution() {
        //not using.
    }
    /**
     * main program.
     * @param args is the parameter.
     */
    public static void main(final String args[]) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n  = in.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int x = in.nextInt();
        int y  = in.nextInt();
        int[][] b = new int[x][y]; 
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                b[i][j] = in.nextInt();
            }
        }
        if (m == x && n == y) {
            int i;
            int j;
            int[][] sum = new int[m][y];
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++) {
                    sum[i][j] = a[i][j] + b[i][j];
                }
            }
            for (i = 0; i <= m - 1; i++) {
                for (j = 0; j < n - 1; j++) {
                    System.out.print(sum[i][j] + " ");
                }
                System.out.println(sum[i][j]);
            }
        } else {
            System.out.println("not possible");
        }
    }
}