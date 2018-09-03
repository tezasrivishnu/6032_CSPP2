import java.util.Scanner;
/**
 * Class for valid input.
 * @author tezasrivishnu.
 */
class InputValidator {
    /**
     * setting value of 6.
     */
    private static final int SIX = 6;
    String input;
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
    public static boolean validateData(final String input) {
        if (input.length() >= SIX) {
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
    /**
     * main function.
     * @param args is the parameter.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData(input));
    }
}
