import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 *@author : tezasrivishnu.
 * List of Integers.
 */
public class Solution {
    /**
     * list as integer array.
     */
    private int[] list;
    /**
     * size variable.
     */
    private int size;

    /**
     * The purpose of the constructor is to initialize the class variables with
     * some default values.
     */
    public Solution() {
        list = new int[1];
        size = 0;
    }

    /**
     * Constructs the object.
     * @param      capacity  is the input parameter.
     */
    public Solution(final int capacity) {
        list = new int[capacity];
        size = 0;
    }
    /**
     * Adding a element in the list.
     * @param      item  The item
     */
    public void add(final int item) {
        if (list.length == size) {
            resize();
        }
        list[size++] = item;
    }

    /**
     * method to resize the array.
     */
    private void resize() {
        list = Arrays.copyOf(list, 2 * size);
    }
    /**
     * The method returns size.
     * @return     integer size.
     */
    public int size() {
        return size;
    }
    /**
     * removing a element.
     *
     * @param      index    is the input parameter.
     *
     * @throws     Exception  invalid position exception.
     */
    public void remove(final int index) throws Exception {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            throw new Exception("Invalid Position Exception");
        }
    }
    /**
     * @param      index  input parameter.
     * @return    index of the element.
     */
    public int get(final int index) {
        if (index >= 0 && index < size) {
            return list[index];
        }
        return -1;
    }
    /**
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        if (size == 0) {
            return "[]";
        }
        String toPrint = "[";
        int i;
        for (i = 0; i < size() - 1; i++) {
            toPrint = toPrint + list[i] + ",";
        }
        return toPrint + list[i] + "]";
    }
    /**
     * checks if element is present or not.
     * @param      item  is the input parameter
     * @return     boolean value.
     */
    public boolean contains(final int item) {
        // Replace the code below
        return indexOf(item) != -1;
    }
    /**
     * Returns the index of the first occurrence of the specified element in
     * @param      item  is the input parameter.
     * @return     the index value.
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size(); i++) {
            if (item == get(i)) {
                return i;
            }
        }
        return -1;
    }
    /**
    Inserts all the elements of specified int array to the end of list.
    @param      newArray  is the input array.
    */
    public void addAll(final int[] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            add(newArray[i]);
        }
    }
    /**
     Removes all of its elements that are contained in the specified int array.
     @param      newArray  is the array to remove the elements.
     @throws Exception Invalid Position.
    */
    public void removeAll(final int[] newArray) throws Exception {
        for (int i = 0; i < newArray.length; i++) {
            int index = indexOf(newArray[i]);
            while (index != -1) {
                remove(i);
                index = indexOf(newArray[i]);
            }
        }
    }
    /**
     gives the sublist of the given input.
     @param      start  is the start position.
     @param      end   is the end position.
     @return     the object.
     @throws Exception index out of bounds.
    */
    public Solution subList(final int start, final int end) throws Exception {
        if (start >= end || start > size || end > size) {
            throw new Exception("Index Out of Bounds Exception");
            //return null;
        } else if (start < 0 || end < 0) {
            throw new Exception("Index Out of Bounds Exception");
            //return null;
        }
        Solution newList = new Solution(end - start);
        for (int i = start; i < end; i++) {
            newList.add(this.get(i));
        }
        return newList;
    }
    /**
    Returns a boolean indicating whether the parameter i.e a List object is
    exactly matching with the given list or not.
    @param      other  is the object.
    @return     the boolean value.
    */
    public boolean equals(final Solution other) {
        return other.toString().equals(this.toString());
    }
    /**
    * Removes all the elements from list
    * Think about this case and make the method
    * the simpler.
    */
    public void clear() {
        size = 0;
    }
    /**
     * count the elements in array.
     * @param      item  is the input parameter.
     * @return     the count of a element.
     */
    public int count(final int item) {
        // write the logic
        int count = 0;
        for (int j = 0; j < size; j++) {
            if (list[j] == item) {
                count += 1;
            }
        } return count;
    }

    /**
     * main method to drive program.
     * @param      args  is the input parameter.
     */
    public static void main(final String[] args) {
        Solution l = new Solution();
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "add":
                if (tokens.length == 2) {
                    String[] t = tokens[1].split(",");
                    if (t.length == 1) {
                        l.add(Integer.parseInt(tokens[1]));
                    }
                }
                break;
            case "size":
                System.out.println(l.size());
                break;
            case "print":
                System.out.println(l);
                break;
            case "remove":
                try {
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                } catch (Exception mes) {
                    System.out.println(mes.getMessage());
                }
                break;
            case "indexOf":
                if (tokens.length == 2) {
                    System.out.println(l.indexOf(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "get":
                if (tokens.length == 2) {
                    System.out.println(l.get(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "contains":
                if (tokens.length == 2) {
                    System.out.println(l.contains(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "addAll":
                if (tokens.length == 2) {
                    String[] t1 = tokens[1].split(",");
                    int[] temp = new int[t1.length];
                    for (int i = 0; i < temp.length; i++) {
                        temp[i] = Integer.parseInt(t1[i]);
                    }
                    l.addAll(temp);
                }
                break;
            case "removeAll":
                try {
                    if (tokens.length == 2) {
                        String[] t2 = tokens[1].split(",");
                        int[] a = new int[t2.length];
                        for (int i = 0; i < t2.length; i++) {
                            a[i] = Integer.parseInt(t2[i]);
                        }
                        l.removeAll(a);
                    }
                } catch (Exception mes) {
                    System.out.println(mes.getMessage());
                }
                break;
            case "count":
                System.out.println(l.count(Integer.parseInt(tokens[1])));
                break;
            case "subList":
                try {
                    if (tokens.length != 2) {
                        break;
                    }
                    String[] arrstring3 = tokens[1].split(",");
                    Solution object = l.subList(Integer.
                        parseInt(arrstring3[0]),
                                Integer.parseInt(arrstring3[1]));
                    if (object != null) {
                        System.out.println(object);
                    }
                } catch (Exception mes) {
                    System.out.println(mes.getMessage());
                }
                break;
            case "equals":
                if (tokens.length == 2) {
                    String[] lt = tokens[1].split(",");
                    Solution l2 = new Solution();
                    for (int k = 0; k < lt.length; k++) {
                        l2.add(Integer.parseInt(lt[k]));
                    }
                    System.out.println(l.equals(l2));
                }
                break;
            case "clear":
                l.clear();
                break;
            default:
                break;
            }
        }
    }
}
