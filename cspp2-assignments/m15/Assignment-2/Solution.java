import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Exception for signaling invalid subset selection errors.
 */
class InvalidSubsetSelectionException extends Exception {
    /**
     * Constructs the object.
     * @param      s     is the input parameter.
     */
    InvalidSubsetSelectionException(final String s) {
        super(s);
    }
}
/**
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
    /**
     * Constructs the object.
     * @param      s     is the input parameter.
     */
    SetEmptyException(final String s) {
        super(s);
    }
}
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
     * @throws InvalidSubsetSelectionException error.
     */
    public int[] subSet(final int a, final int b) throws
     InvalidSubsetSelectionException {
        int[] ne = new int[Math.abs(indexOf(b) - indexOf(a))];
        if (a > b) {
            throw new InvalidSubsetSelectionException(
                "Invalid Arguments to Subset Exception");
        }
        if (size == 0) {
            return ne;
        } else {
            int j = 0;
            for (int i = indexOf(a); i < indexOf(b); i++) {
                ne[j] = set[i];
                j += 1;
            }
        }
        return ne;
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
     * @throws SetEmptyException error.
     */
    public int[] headSet(final int item) throws SetEmptyException {
        if (size == 0 || item <= set[0]) {
            throw new SetEmptyException("Set Empty Exception");
        }
        int[] gre = new int[indexOf(item)];
        int r = 0;
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
     * @throws SetEmptyException error.
     */
    public int last() throws SetEmptyException {
        int num = 0;
        if (size == 0) {
            throw new SetEmptyException("Set Empty Exception");
            //return -1;
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
    public void sString() {
        int i;
        String array = "{";
        for (i = 0; i < size - 1; i++) {
            array += set[i] + ", ";
        }
        array += set[i] + "}";
        if (size == 0) {
            array = "{}";
        }
        System.out.println(array);
    }
    /**
     * prints the string representation.
     * @param      item  The item
     * @param      siz   The siz
     */
    public void toString(final int[] item, final int siz) {
        int i;
        String array = "{";
        for (i = 0; i < siz - 1; i++) {
            array += item[i] + ", ";
        }
        array += item[i] + "}";
        if (siz == 0) {
            array = "{}";
        }
        System.out.println(array);
    }
    /**
     * sorting of the array.
     * @param      set1   is the input array.
     */
    public void sort(final int[] set1) {
        int temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (set1[i] > set1[j]) {
                    temp = set1[i];
                    set1[i] = set1[j];
                    set1[j] = temp;
                }
            }
        }
    }
    /**
     * intersection method.
     *
     * @param      t  is the input parameter.
     *
     * @return     the items common in two sets.
     */
    public String intersection(final Set t) {
        if (size() == 0 || t.size() == 0) {
            return "{}";
        } else {
            int l = 0;
            int len = Math.abs(size() + t.size());
            int[] inter = new int[len];
            for (int i = 0; i < size(); i++) {
                for (int j = 0; j < t.size(); j++) {
                    if (set[i] == t.set[j]) {
                        inter[l] = set[i];
                        l += 1;
                    }
                }
            }
            if (l == 0) {
                return "{}";
            } else {
                int i;
                String str1 = "{";
                for (i = 0; i < l - 1; i++) {
                    str1 += inter[i] + ", ";
                }
                str1 += inter[i] + "}";
                return str1;
            }
        }
    }
    /**
     * retainAll method.
     *
     * @param      items  is the input parameter.
     *
     * @return     the items common in two sets.
     */
    public String retainAll(final int[] items) {
        if (size() == 0 || items.length == 0) {
            return "{}";
        } else {
            int l = 0;
            int len = Math.abs(size() + items.length);
            int[] inter = new int[len];
            for (int i = 0; i < size(); i++) {
                for (int j = 0; j < items.length; j++) {
                    if (set[i] == items[j]) {
                        inter[l] = set[i];
                        l += 1;
                    }
                }
            }
            if (l == 0) {
                return "{}";
            } else {
                int i;
                String str1 = "{";
                for (i = 0; i < l - 1; i++) {
                    str1 += inter[i] + ", ";
                }
                str1 += inter[i] + "}";
                return str1;
            }
        }
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not using.
    }
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
                try {
                    String[] token = tokens[1].split(",");
                    int[] temp = s.subSet(Integer.
                                          parseInt(token[0]), Integer.
                                          parseInt(token[1]));
                    if (s.size() == 0) {
                        System.out.println("{}");
                    } else {
                        s.toString(temp, temp.length);
                    }
                } catch (InvalidSubsetSelectionException mes) {
                    System.out.println(mes.getMessage());
                }
                break;
            case "headSet":
                try {
                    int[] temp1 = s.headSet(Integer.parseInt(tokens[1]));
                    // if (temp1.length == 0) {
                    //     System.out.println("{}");
                    // } else {
                    s.toString(temp1, temp1.length);
                } catch (SetEmptyException mes) {
                    System.out.println(mes.getMessage());
                }
                break;
            case "last":
                try {
                    int we = s.last();
                    System.out.println(we);
                } catch (SetEmptyException mes) {
                    System.out.println(mes.getMessage());
                }
                break;
            case "print":
                s.sString();
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            default:
                break;
            }
        }
    }
}
