import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 */
class Set {
    /**
     * initialzing the array set.
     */
    private int[] set;
    /**
     * initializing the size.
     */
    private int size;
    /**
     * initializing value of 10.
     */
    private static final int TEN = 10;
    /**
     * Constructs the object.
     */
    Set() {
        set = new int[TEN];
        size = 0;
    }
    /**
     * returns size.
     *
     * @return     int size.
     */
    public int size() {
        return size;
    }
    /**
     * checks if element is containing or not.
     * @param      item  is the input parameter.
     * @return     boolean expression.
     */
    public boolean contains(final int item) {
        boolean f = false;
        for (int j = 0; j < set.length; j++) {
            if (set[j] == item) {
                f = true;
                break;
            }
        }
        return f;
    }
    /**
     * Searches for the first match.
     * @param      item  is the parameter.
     * @return     index of the element.
     */
    public int indexOf(final int item) {
        int j;
        int count = 0;
        int z = -1;
        for (j = 0; j < size; j++) {
            if (set[j] == item) {
                z = j;
            }
        }
        if (z == -1) {
            for (j = 0; j < size; j++) {
                if (set[j] > item) {
                    z = j;
                    count += 1;
                    break;
                }
            }
            if (count == 0) {
                z = j;
            }
        }
        return z;
    }
    /**
     * subset method.
     * @param      a     is the input parameter.
     * @param      b     is the input parameter.
     * @return     array of subset.
     */
    public int[] subSet(final int a, final int b) {
        int[] ne = new int[Math.abs(indexOf(b) - indexOf(a))];
        if (a > b) {
            return null;
        } else {
            if (size == 0) {
                return ne;
            } else {
                int j = 0;
                for (int i = indexOf(a); i < indexOf(b); i++) {
                    ne[j] = set[i];
                    j += 1;
                }
            } return ne;
        }
    }
    /**
     * Adds all the elements in set.
     * @param      item  Tis the input parameter.
     */
    public void addAll(final int[] item) {
        int g = item.length;
        int in = 0;
        while (in < g) {
            for (int j = size; j < set.length; j++) {
                if (!(contains(item[in]))) {
                    set[j] = item[in];
                    size += 1;
                }
            }
            in += 1;
        }
        sort(set);
    }
    /**
     * returns set till the element given.
     * @param      item  is the input parameter.
     * @return     the array.
     */
    public int[] headSet(final int item) {
        int[] gre = new int[indexOf(item)];
        int r = 0;;
        for (int l = 0; l < size; l++) {
            if (set[l] < item) {
                gre[r] = set[l];
                r += 1;
            }
        }
        return gre;
    }
    /**
     * highest element in array.
     * @return     int value.
     */
    public int last() {
        int num = 0;
        if (size == 0) {
            return num;
        } else {
            for (int k = 0; k < size; k++) {
                if (set[k] > num) {
                    num = set[k];
                }
            }
        }
        return num;
    }
    /**
     * prints the string representation.
     */
    public void String() {
        int i;
        String array = "{";
        for (i = 0; i < size - 1; i++) {
            array += set[i] + ", ";
        }
        array += set[i] + "}";
        if (size == 0) {
            array = "{}";
        }
        System.out.println(array);;
    }
    /**
     * prints the string representation.
     * @param      item  The item
     * @param      siz   The siz
     */
    public void String(int[] item, int siz) {
        int i;
        String array = "{";
        for (i = 0; i < siz - 1; i++) {
            array += item[i] + ", ";
        }
        array += item[i] + "}";
        if (siz == 0) {
            array = "{}";
        }
        System.out.println(array);;
    }
    /**
     * sorting of the array.
     * @param      set   is the input array.
     */
    public void sort(final int[] set) {
        int temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (set[i] > set[j]) {
                    temp = set[i];
                    set[i] = set[j];
                    set[j] = temp;
                }
            }
        }
    }
}
/**
 * Class for solution.
 */
public class Solution {
     /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function.
     *
     * @param      args  is the input parameter.
     */
    public static void main(final String[] args) {
        Set s = new Set();
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "addAll":
                int[] intArray = intArray(tokens[1]);
                s.addAll(intArray);
                break;
            case "subSet":
                String[] token = tokens[1].split(",");
                int[] temp = s.subSet(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
                if (temp == null) {
                    System.out.println("Invalid Arguments to Subset Exception");
                } else if (s.size() == 0) {
                    System.out.println("{}");
                } else {
                    s.String(temp, temp.length);
                }
                break;
            case "headSet":
                int[] temp1 = s.headSet(Integer.parseInt(tokens[1]));
                if (temp1.length == 0) {
                    System.out.println("{}");
                } else {
                    s.String(temp1, temp1.length);
                }
                break;
            case "last":
                int we = s.last();
                if (we == 0) {
                    System.out.println("Set Empty Exception");
                } else {
                    System.out.println(we);
                }
                break;
            case "print":
                s.String();
                break;
            default:
                break;
            }
        }
    }
}