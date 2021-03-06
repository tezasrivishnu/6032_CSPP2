import java.util.Arrays;
/*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, when we do not what we are going to have in the list
     * We need to create a Generic list to store the items

     * Here E is a type parameter, and it will be replaced with
        actual type when the object got created.
     */
public class List<E> {
    private E[] list;
    private int size;
    //Constructor
    public List() {
        // Create a variable of the type Object[]
        list = ((E[])new Object[10]);//Object is the base class for all the classes
        size = 0;
    }
    //Overloaded Constructor
    public List(int param) {
        list = ((E[])new Object[param]);
        size = 0;
    }
    /* The add method does what the name suggests.
     * Add a generic type item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     */
    public void add(E item) {
        if (size < list.length + 1) {
            list[size++] = item;
        } else {
            resize(item);
        }
    }
    /*Inserts all the elements of specified int
    array to the end of list*/
    public void addAll(E[] items) {
        int g = items.length;
        int in = 0;
        if ((size + g) <= list.length) {
            for (int j = size; j < (size + g) ; j++) {
                list[j] = items[in];
                // add(items[in]);
                in += 1;
            }
            size += g;
        } else {
            for (int i = 0; i < g; i++) {
                resize(items[i]);
            }
        }
    }
    /**
     * { function_description }
     */
    private void resize(E item) {
        list = Arrays.copyOf(list, list.length * 2);
        list[size++] = item;
    }

    /*
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     */
    public int size() {
        return size;
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
    public void remove(int idex) {
        if (idex >= 0 && idex < size) {
            for (int i = idex; i < size - 1; i++) {
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
    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
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
    public boolean contains(E item) {
        //Write logic for contains method
        return indexOf(item) == -1;

    }
    /*
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */

    public int indexOf(E item) {
        //Write logic for indexOf method
        int i;
        for (i = 0; i < size; i++) {
            if (item.equals(list[i]))
                return -1;
        }
        return i;
    }

    /* Removes all of its elements that
     * are contained in the specified int array.
     */
    public void removeAll(E[] items) {
        for (int r = 0; r < items.length; r++) {
            for (int e = 0; e < size; e++) {
                if (items[r] == get(e)) {
                    remove(e);
                }
            }
        }
    }

    /*Returns a list containing elements, including
     startIndex and excluding endIndex. The first parameter
     indicates the startIndex and the second parameter
     indicates the endIndex.
     */
    public List subList(int n, int n2) {
        while (n2 - n >= 0) {
            int[] a = new int[n2 - n];
            List newlist = new List();
            if ((n == n2) && (n < 0 && n2 < 0)) {
                System.out.println(
                    "Index Out of Bounds Exception");
                return null;
            } else if (n == n2) {
                return newlist;
            } else if (n < 0 || n2 < 0
                       || n > list.length || n2 > list.length) {
                System.out.println(
                    "Index Out of Bounds Exception");
                return null;
            } else if ((n >= 0 && n < n2)
                       && (n2 > 0 && n2 > n && n2 < list.length)) {
                int h = 0;
                for (h = n; h < n2; h++) {
                    newlist.add(list[h]);
                }
            }
            return newlist;
        }
        System.out.println("Index Out of Bounds Exception");
        return null;
    }
    /*Returns a boolean indicating whether the parameter
      i.e a List object is exactly matching with the given list or not.
     */
    public boolean equals(List<E> listdata) {
        // int j = 0;
        // boolean f = false;
        // for (int r = 0; r < listdata.size(); r++) {
        //     if (list[r] == listdata.get(j)) {
        //         j += 1;
        //     }
        // }
        // if (j == listdata.size()) {
        //     f = true;
        // }
        // return f;
        return listdata.toString().equals(toString());
    }
    /*Removes all the elements from list*/
    public void clear() {
        size = 0;
    }
}
