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
    /**
     * declaring string.
     */
    private String input;
    /**
     * setting the input.
     * @param input string is the parameter.
     */
    public InputValidator(final String inp) {
        this.input = inp;
    }
    /**
     * validating the data.
     * @param input string is the parameter.
     * @return boolean value.
     */
    public static boolean validateData(final String input) {
        return (input.length() >= SIX);
    }
}
/**
 * Class for printing the answer.
 */
public final class Solution {
    /**
     * empty constructor.
     */
    private Solution() {
        //not using.
    }
    /**
     * main function.
     * @param args is the parameter.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData(input));
    }
}
