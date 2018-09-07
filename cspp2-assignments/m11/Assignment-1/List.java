import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * @author tezasrivishnu.
 */
public class List {
    //Implement all the methods mentioned to build a ListADT

    /*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, assume we are only going to have ints in the list
     * We need to create an array of ints to store the items
     * added to the list.
     *
     * Create a variable of the type int[]
     * Use the private access specifier
     * Why private access specifier and why not public?
     * Well, we don't want the array to be manipulated by
     * methods that are outside the List class.
     * If you allow methods outside the List class to manipulate
     * the array then there is a possibility of having a corrupted
     * list i.e., a list with incorrect items.
     * This is not desirable and so having private access specifer
     * will protect the array such corruption.
     * This is a hard concept to understand. Discuss with your mentor.
     *
    */
    /**
     * setting value of 10.
     */
    private static final int TEN = 10;
    /**
     * initializing int array.
     */
    private int[] a;
    // declare a private int[]
    // don't create the array yet using new
    // that's the job of the List
    // constructor
    /**
    * initializing i.
    */
    private int i;

    /*
     * What are the other class variables needed for creating a list?
     * How about keeping track of the size of the list?
     * If you add 2 items to the list then the size should be 2.
     * Let's think about the size of the list by comparing it to the
     * length of the array. Do they mean the same?
     * No, Array length signifies the maximum number of items
     * you can store in the list. Whereas, the size of the list
     * denotes the number of items in the list. Makes sense?
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * The length of the array is 10 and size is 3.
     * This means you can store 10 items in the list and
     * currently it has 3 items.
     * So, to keep track of the size we need a variable called size
     * Again, we use private as we don't want that size variable
     * to be accessed by the methods that are outside of the List class.
     *
     */

    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor

    /*
     * The purpose of the constructor is to
     * initialize the class variables with
     * some default values.
     */
    /**
     * Constructs the object.
     */
    public List() {

        // what are the two variables to be initialized
        // here? think about the
        // private variables described above.
        // What should be the default values?
        // In the case of the list, it should be
        // empty but it should be
        // initialized with an array size like 10
        a = new int[TEN];
        i = 0;
        // Think about the initial value for size.
        // How many items do we have in the list when
        // you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.

    }
    // public List(int start, int end) {
    //  i = 0;
    //  a = new int[end - start];
    // }

    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the
     * end of the list What is the
     * end of the list? Is it the same as the end
     * of the array? Think about how
     * you can use the size variable to add item
     * to the list.
     *
     * The method returns void (nothing)
     */
    /**
     * adding a element in list.
     *
     * @param      item  is the input parameter.
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        if (i < TEN) {
            a[i] = item;
            i += 1;
        }   else {
            resize(item);
        }
    }

    /*
     * The size method returns the value of the
     * size. The purpose of the method
     * is to announce the size of the list to the
     * objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     *
     */
    /**
     * @return     size.
     */
    public int size() {
        // replace the code below to implement the size method
        if (i == 0) {
            return 0;
        } else {
            return i;
        }
    }
    /**
     * resizing the list array.
     *
     * @param      item  is the input parameter.
     */
    private void resize(final int item) {
        a = Arrays.copyOf(a, i + 2);
        a[i] = item;
        i += 1;
    }

    /*
     * The remove method does what the name
     * suggests. Removes an int item,
     * specified by the index argument, from
     * the list It also does an additional
     * step. Think about what happens when an item is
     * removed from the middle of
     * the list It creates a hole in the list, right?
     * This would mean, all the
     * items that are to the right side of the removed
     * item should be moved to
     * the left by one position. Here is an example: array =
     * [1,2,3,0,0,0,0,0,0,0] remove(1) would remove the
     * item 2 which is at index
     * position 1. But how do you remove the item from an
     * array? Well, the way
     * to remove it is to move all the items, that are
     * to the right of the
     * removed item, to the left So, the new array looks
     * like this. array =
     * [1,3,0,0,0,0,0,0,0,0] The method returns void (nothing)
     *
     */
    /**
     * removes a element.
     *
     * @param      index  is the input parameter.
     */
    public void remove(final int index) {
        // write the logic for remove here.
        // Think about what to do to the size
        // variable.
        // int j;
        int l = 0;
        if (index > a.length) {
            System.out.println("Invalid Position Exception");
        } else {
            for (int j = 0; j < i - 1; j++) {
                if (j + 1 == index) {
                    a[j + 1] = 0;
                    l = j + 1;
                }
            }
            for (int y = l; y < a.length - 1; y++) {
                a[y] = a[y + 1];
            }
            i -= 1;
        }
    }

    /*
     * Get method has to return the items
     * that is at the index position passed
     * as an argument to the method. If the
     * item doesn't exist then return a -1
     * to indicate that there is no element at that
     * index. How can an element
     * not be there at a given position? Well,
     * if the position is greater than
     * the number of items in the list then that
     * would mean the item doesn't
     * exist. How do we check if the position is greater
     * than the number of
     * items in the list? Would size variable be useful?
     */
    /**
     * @param      index  is the input parameter.
     *
     * @return     the value at that index.
     */
    public int get(final int index) {
        // Replace the code below to write the code for get
        if (index > i) {
            return -1;
        } else {
            return a[index];
        }
    }

    /*
     * What happens when you print an object using println?
     * Java provides a
     * method named toString that is internally invoked when
     * an object variable
     * is used in println. For example: List l = new List();
     * System.out.println(l); This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to
     * display the items in the list in the
     * square brackets notation. i.e., if the
     * list has numbers 1, 2, 3 return
     * the string [1,2,3] Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0] toString
     * should only return the items in
     * the list and not all the elements of the array.
     */
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        int b;
        String emp = "[";
        for (b = 0; b < i - 1; b++) {
            emp += a[b] + ",";
        }
        emp += a[b] + "]";
        if (i == 0) {
            emp = "[]";
        }
        return emp;
    }
    /*
     * Contains return true if the list has
     * the item passed as an argument to
     * the method So, iterate through the list and return true if the item
     * exists and otherwise false
     */
    /**
     * checks if contains element or not.
     *
     * @param      item  is the input parameter.
     *
     * @return     boolean.
     */
    public boolean contains(final int item) {
        // Replace the code below
        boolean f = false;
        for (int j = 0; j < a.length; j++) {
            if (a[j] == item) {
                f = true;
                break;
            }
        }
        return f;
    }
    /*
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     */
    /**
     * Searches for the first match.
     *
     * @param      item  is the input parameter.
     *
     * @return     index value.
     */
    public int indexOf(final int item) {
        // Replace the code below
        int j;
        int z = -1;
        for (j = 0; j < i; j++) {
            if (a[j] == item) {
                z = j;
            }
        } return z;
    }
    /*
    Inserts all the elements of specified int array to the end of list
    */
    /**
     * Adds all the elements in the list.
     * @param      newArray  is the
     */
    public void addAll(final int[] newArray) {
        int g = newArray.length;
        int in = 0;
        if ((i + g) <= a.length) {
            for (int j = i; j < (i + g); j++) {
                a[j] = newArray[in];
                in += 1;
            }
            i += g;
        } else {
            for (int c = 0; c < g; c++) {
                resize(newArray[c]);
            }
        }
    }
    /*
     Removes all of its elements that are contained in the specified int
     array.
    */
     /**
      * Removes the elements in the list.
      *
      * @param      newArray  is the input array.
      */
    public void removeAll(final int[] newArray) {
        for (int r = 0; r < newArray.length; r++) {
            for (int e = 0; e < i; e++) {
                if (newArray[r] == get(e)) {
                    remove(e);
                }
            }
        }
    }
    /*
    Returns a list object containing elements, including startIndex and
    excluding endIndex. The first parameter indicates the startIndex and the
    second parameter indicates the endIndex. Returns null and print
    "Index Out of Bounds Exception" if any
    //of values start and end are negative
    and also if start is greater than end.
    */
    /**
     * printing a sublist in a list.
     * @param      start  is the starting index.
     * @param      end    is the ending index.
     * @return     the sublist.
     */
    public List subList(final int start, final int end) {
        while (end - start >= 0) {
            int[] list = new int[end - start];
            List newlist = new List();
            if ((start == end) && (start < 0 && end < 0)) {
                System.out.println
                ("Index Out of Bounds Exception");
                return null;
            } else if (start == end) {
                return newlist;
            } else if (start < 0 || end < 0
                || start > a.length || end > a.length) {
                System.out.println
                ("Index Out of Bounds Exception");
                return null;
            } else if ((start >= 0 && start < end)
                && (end > 0 && end > start && end < a.length)) {
                int h = 0;
                for (h = start; h < end; h++) {
                    newlist.add(a[h]);
                }
            }
            return newlist;
        }
        System.out.println("Index Out of Bounds Exception");
        return null;
    }
    /*
    Returns a boolean indicating whether the parameter i.e a List object is
    exactly matching with the given list or not.
    */
    /**
     * checks if elements are present or not.
     *
     * @param      list  is the input parameter.
     *
     * @return     boolean value.
     */
    public boolean equals(final List list) {
        int j = 0;
        boolean f = false;
        for (int r = 0; r < list.size(); r++) {
            if (contains(list.get(r))) {
                j += 1;
            }
        }
        if (j == list.size()) {
            f = true;
        }
        return f;
    }
    /*
    * Removes all the elements from list
    * Think about this case and make the method
    * the simpler.
    */
    /**
     * removing all he elements.
     */
    public void clear() {
        i = 0;
    }
    /**
     * main program.
     *
     * @param      args  is the parameter.
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        List l = new List();

        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation
            //invoke the corresponding method
            switch (tokens[0]) {
            case "add":
                if (tokens.length == 2) {
                    String[] t = tokens[1].split(",");
                    if (t.length == 1) {
                        l.add(Integer.
                            parseInt(tokens[1]));
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
                if (tokens.length == 2) {
                    l.remove(Integer.parseInt(tokens[1]));
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
                    System.out.println(l.
                                contains(
                            Integer.parseInt(tokens[1])));
                }
                break;
            case "addAll":
                if (tokens.length == 2) {
                    String[] t1 = tokens[1].split(",");
                    int[] temp = new int[t1.length];
                    for (int i = 0; i < temp.length; i++) {
                        temp[i] = Integer.
                                  parseInt(t1[i]);
                    }
                    l.addAll(temp);
                }
                break;
            case "removeAll":
                if (tokens.length == 2) {
                    String[] t2 = tokens[1].split(",");
                    int[] a = new int[t2.length];
                    for (int i = 0; i < t2.length; i++) {
                        a[i] = Integer.parseInt(t2[i]);
                    }
                    l.removeAll(a);
                }
                break;
            case "subList": 
            {
                if (tokens.length != 2) {
                    break;
                };
                String[] arrstring3 = tokens[1].split(",");
                List object = l.subList(Integer.
                    parseInt(arrstring3[0]),Integer.
                    parseInt(arrstring3[1]));
                if (object != null) {
                    System.out.println(object);
                }
                break;
            }
            case "equals":
                if (tokens.length == 2) {
                    String[] lt = tokens[1].split(",");
                    List l2 = new List();
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