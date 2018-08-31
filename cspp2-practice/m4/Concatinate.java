import java.util.Scanner;
/**
 * Class for concatinate.
 */
public final class Concatinate {
    /**
     * empty constructor.
     */
    private Concatinate() {
        //not using.
    }
    /**
     * mainprogram.
     * @param args is the parameter.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String r = "Hello ".concat(sc.next()).concat("!");
        // String s = sc.next();
        // r = r.concat(s).concat("!");
        System.out.println(r);
    }
}
