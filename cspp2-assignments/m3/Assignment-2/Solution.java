import java.util.Scanner;
/**
 * Finding 7's below n.
 * @author tezasrivishnu.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution(){
		//not using.
	}
	/**
	 * Main program.
	 * @param args is the parameter.
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int count = 0;
		for (int i = 7; i <= n; i++) {
			count += finding(i);
		}
	System.out.println(count);
	}
	/**
	 * Calculating the 7's below i.
	 * @param i int value is the parameter.
	 * @return  an int value.
	 */
	public static int finding(int i) {
		int count = 0;
		while (i > 0) {
			if (i % 10 == 7) {
				count += 1;
			}
		i = i / 10;
		}
		return count;
	}
}