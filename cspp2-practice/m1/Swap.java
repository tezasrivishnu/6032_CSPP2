/**
* HelloWorld.java.
* @author tezasrivishnu.
*/
public final class Swap {
    /**
    * empty constructor.
    */
    private Swap() {
        // not using
    }
    /**
    *main function to swap two variables.
    * @param args is the parameter for this function.
    */
    public static void main(final String[] args) {
        int i = 101;
        int j = 102;
        int temp;
        temp = i;
        i = j;
        j = temp;
        System.out.println(i);
        System.out.println(j);
        // i = i^j;
        // j = i^j;
        // i = i^j;
    }
}
