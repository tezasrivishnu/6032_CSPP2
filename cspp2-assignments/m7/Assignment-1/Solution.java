import java.util.Scanner;
/**
 * Class for valid input.
 * @author tezasrivishnu.
 */
class InputValidator {
	private String input;
	/**
	 * setting the input.
	 * @param input string is the parameter.
	 */
	public InputValidator(String input) {
		this.input = input;
	}
	/**
	 * validating the data.
	 * @param input string is the parameter.
	 * @return boolean value.
	 */
	public static boolean validateData(String input) {
		if (input.length() >= 6) {
			return true;
		} else {
			return false;
		}
	}
}
/**
 * Class for printing the answer.
 */
public class Solution {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		InputValidator i = new InputValidator(input);
		System.out.println(i.validateData(input));
	}
}
