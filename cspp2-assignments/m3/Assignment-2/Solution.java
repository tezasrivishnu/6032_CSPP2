import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int count = 0;
		for (int i = 7; i <= n; i++) {
			count += finding(i);
		}
	System.out.println(count);
	}
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