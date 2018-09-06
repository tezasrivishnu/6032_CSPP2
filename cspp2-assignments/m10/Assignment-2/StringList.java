//An interface for ListADT of strings
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedInputStream;
/**
 * Interface for string list interface.
 */
interface StringListInterface {
    public void add(String item);
    public void addAll(String items[]);
    public String get(int index);
    public int size();
    public void remove(int index);
    public boolean contains(String item);
    public int indexOf(String item);
}
//Write a StringList class which implements StringListInterface
/**
* @author tezasrivishnu.
*/
public class StringList implements StringListInterface {
    //Implement all the methods mentioned to build a ListADT

    /*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, assume we are only going to have strings in the list
     * We need to create an array of strings to store the items
     * added to the list.
     *
     * Create a variable of the type String[]
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

    // declare a private String[]
    // don't create the array yet using new
    // that's the job of the List constructor
    /**
    *initializing the string array.
    */
    private String[] list;

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
    /**
    * initialaizing the size variable.
    */
    private int size;

    /*
     * The purpose of the constructor is to initialize the
     * class variables with some default values.
     */


    /**
     * Constructs the object.
     */
    public StringList() {

        // what are the two variables to be initialized here?
        // think about the private variables described above.
        // What should be the default values?
        // In the case of the list, it should be empty but
        // it should be initialized with an array size like 10
        list = new String[10];

        // Think about the initial value for size.
        // How many items do we have in the list when you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.
        size = 0;
    }

    /*
     * Overloaded constructor with list capacity as argument
     * The default constructor sets the list capacity to 10
     * So, adding an item when the list size is 10
     * raises a Index Out of Bounds Exception
     * There will be some clients of the ADT that will require
     * the list to contain n elements which is known
     * at the time of creating the list.
     *
     * The overloaded constructor is a way to initialize a list with
     * a list capacity of n items where n is given as an argument to
     * constructor.
     *
     */

    // todo - add an overloaded constructor here
    /**
    * overloading the constructor acc. to parameter.
    */
    public void ListString(final int n) {
        size = 0;
        list = new String[n];
    }

    /*
     * The add method does what the name suggests.
     * Add an String item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     *
     * The method returns void (nothing)
     */
    /**
     * adding a element in array.
     * @param      item  is the input parameter.
     */
    public void add(final String item) {
        //Inserts the specified element at the end of the list.
        if (size < list.length + 1) {
            list[size++] = item;
        } else {
            resize(item);
        }
    }
    /*Inserts all the elements of specified int
    array to the end of list*/
    /**
     * Adds all aray elements in a array.
     * @param      items  is the input parameter.
     */
    public void addAll(final String[] items) {
        int g = items.length;
        int in = 0;
        if ((size + g) <= list.length) {
            for (int j = size; j < (size + g) ; j++) {
                list[j] = items[in];
                in += 1;
            }
            size += g;
        } else {
            for (int i = 0; i < g; i++) {
                resize(items[i]);
            }
        }
    }
    /*
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     */
    /**
     * finding the size of array.
     * @return     int size of the array.
     */
    public int size() {
        return size;
    }
    /**
     * increasing the size of array.
     * @param      item  is the input parmeter.
     */
    private void resize(final String item) {
        list = Arrays.copyOf(list, size + 2);
        list[size++] = item;
    }

    /*
     * The remove method does what the name suggests.
     * Removes a String item, specified by the index argument, from the list
     * It also does an additional step.
     * Think about what happens when
     * an item is removed from the middle of the list
     * It creates a hole in the list, right?
     * This would mean, all the items that are
     * to the right side of the removed item should be
     * moved to the left by one position.
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * remove(1) would remove the item 2 which is at index position 1.
     * But how do you remove the item from an array?
     * Well, the way to remove it is to move all
     * the items, that are to the right of the removed item, to the left
     * So, the new array looks like this.
     * array = [1,3,0,0,0,0,0,0,0,0]
     * The method returns void (nothing)
     */
    /**
     * removing a element on a particular index.
     * @param      index  is the input parameter.
     */
    public void remove(final int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }

    /*
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     */
    /**
     * to get value at a particular index.
     * @param      index  is the input parameter.
     * @return     the value.
     */
    public String get(final int index) {
        if (index < 0 || index >= size) {
            return "-1";
        } else {
            return list[index];
        }
    }

    /*
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the array.
     *
     */
    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String str = "[";
            int i = 0;
            for (i = 0; i < size - 1; i++) {
                str = str + list[i] + ",";
            }
            str = str + list[i] + "]";
            return str;
        }
    }

    /*
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false
     */
    /**
     * checks if value is present in array or not.
     * @param      item  is the input parameter.
     * @return     boolean value.
     */
    public boolean contains(final String item) {
        return indexOf(item) == -1;
    }

    /*
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    /**
     * Searches for the first match.
     * @param      item  is the input parameter.
     * @return     the index of first occurence.
     */
    public int indexOf(final String item) {
        int i;
        for (i = 0; i < size; i++) {
            if (item.equals(list[i]))
                return -1;
        }
        return i;
    }
    // /**
    //  * main function of the program.
    //  * @param      args  is the input parameter.
    //  */
    // public static void main(final String[] args) {
    //     // create an object of the list to invoke methods on it
    //     StringList sl = new StringList();
    //     StringListInterface l = (StringListInterface)sl; //Typecasting is done for StringListInterface
    //     // code to read the test cases input file
    //     Scanner stdin = new Scanner(new BufferedInputStream(System.in));
    //     // check if there is one more line to process
    //     while (stdin.hasNext()) {
    //         // read the line
    //         String line = stdin.nextLine();
    //         // split the line using space
    //         String[] tokens = line.split(" ");
    //         // based on the list operation invoke the corresponding method
    //         switch (tokens[0]) {
    //         case "add":
    //             l.add(tokens[1]);
    //             break;
    //         case "addAll":
    //             if (tokens.length == 2) {
    //                 String[] t1 = tokens[1].split(",");
    //                 l.addAll(t1);
    //             }
    //             break;
    //         case "size":
    //             // invoke size method and print the list size
    //             // BTW, list size is not the array size
    //             // it is the number of items in the list
    //             System.out.println(l.size());
    //             break;
    //         case "print":
    //             // print the list (implement toString in StringList class
    //             //for this to work)
    //             // expected format is [item-1,item-2,...,item-n]
    //             // review the output testcase file
    //             System.out.println(l);
    //             break;
    //         case "remove":
    //             l.remove(Integer.parseInt(tokens[1]));
    //             break;
    //         case "indexOf":
    //             System.out.println(l.indexOf(tokens[1]));
    //             break;
    //         case "get":
    //             System.out.println(l.get(Integer.parseInt(tokens[1])));
    //             break;
    //         case "contains":
    //             System.out.println(l.contains(tokens[1]));
    //             break;
    //         }
    //     }
    // }
}