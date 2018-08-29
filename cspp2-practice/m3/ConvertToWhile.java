/**
 * @author vishnu.
 */
public final class ConvertToWhile {
    /**
     * seeting value of 10.
     */
    private static final int TEN = 10;
    /**
     * Constructs the object.
     */
    private ConvertToWhile() {
        //not using.
    }

    /**
     * main program.
     * @param args is the parameter.
     */
    public static void main(final String[] args) {
        int a = 2;
        while (a <= TEN) {
            System.out.println(a);
            a = a + 2;
        }
        System.out.println("GoodBye!");
    }
}
