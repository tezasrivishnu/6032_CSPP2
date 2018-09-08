import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
	/**
	 * initialzing the set array.
	 */
	int[] set;
	/**
	 * initializing the size.
	 */
	int size;
	private static final int TEN = 10;
	/**
	 * Constructs the object.
	 */
	public Set() {
		set = new int[10];
		size = 0;
	}
	/**
	 * size.
	 *
	 * @return  size of array.
	 */
	public int size() {
		if (size == 0) {
			return 0;
		} else {
			return size;
		}
	}
	/**
	 * resizing for array elements.
	 *
	 * @param      item  is the input parameter.
	 */
	public void resize(int item) {
		set = Arrays.copyOf(set, size + 2);
		set[size] = item;
		size += 1;
	}
	/**
	 * resizing for array elements.
	 *
	 * @param      items  is the input parameter.
	 */
	public void resize(final int[] items) {
		set = Arrays.copyOf(set, size + 2);
		int in = 0;
		while (in < items.length) {
			for (int j = size; j < set.length; j++) {
				if (!(contains(items[in]))) {
					set[j] = items[in];
					size += 1;
				}
			}
			in += 1;
		}
	}
	/**
	 * tells us if item is present in array or not.
	 *
	 * @param      item  is the input parameter.
	 *
	 * @return     true or false.
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
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		int i;
		String str = "{";
		for (i = 0; i < size - 1; i++) {
			str += set[i] + ", ";
		}
		str += set[i] + "}";
		if (size == 0) {
			str = "{}";
		}
		return str;
	}
	/**
	 * adds a element in list.
	 *
	 * @param      item  is the input parameter.
	 */
	public void add(int item) {
		if (size < TEN) {
			set[size] = item;
			size += 1;
		}   else {
			resize(item);
		}
	}
	/**
	 * adding elelemet array to input array.
	 *
	 * @param      items  is the input array.
	 */
	public void add(int[] items) {
		int g = items.length;
		int in = 0;
		if ((size + g) < set.length) {
			while (in < g) {
				for (int j = size; j < set.length; j++) {
					if (!(contains(items[in]))) {
						set[j] = items[in];
						size += 1;
					}
				}
				in += 1;
			}
		} else {
			// for (int c = in; c < g; c++) {
			// 	if (!(contains(items[in]))) {
			// 		resize(items[in]);
			// 	}
			// }
			resize(items);
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
				for ( i = 0; i < l - 1; i++) {
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
	/**
	 * cartesianProduct methos.
	 *
	 * @param      t   is the input parameter.
	 *
	 * @return     string value.
	 */
	public String cartesianProduct(final Set t) {
		String str = "[";
		int i = 0;
		int j = 0;
		if (size() == 0 || t.size() == 0) {
			return "null";
		} else {
			for (i = 0; i < size() - 1; i++) {
				for (j = 0; j < t.size - 1; j++) {
					str += "[" + set[i] + ", "
					+ t.set[j] + "], ";
				}
				str += "[" + set[i] + ", " + t.set[j] + "], ";
			}
			for (j = 0; j < t.size - 1; j++) {
				str += "[" + set[i] + ", " + t.set[j] + "], ";
			}
			str += "[" + set[i] + ", " + t.set[j] + "]]";
			return str;
		}

	}
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

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
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// instantiate this set
		Set s = new Set();
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
			case "size":
				System.out.println(s.size());
				break;
			case "contains":
				System.out.println(s.
					contains(Integer.
					parseInt(tokens[1])));
				break;
			case "print":
				System.out.println(s);
				break;
			case "add":
				int[] intArray = intArray(tokens[1]);
				if (intArray.length == 1) {
					s.add(intArray[0]);
				} else {
					s.add(intArray);
				}
				break;
			case "intersection":
				s = new Set();
				Set t = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				t.add(intArray);
				System.out.println(s.intersection(t));
				break;
			case "retainAll":
				s = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				System.out.println(s.retainAll(intArray));
				break;
			case "cartesianProduct":
				s = new Set();
				t = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				t.add(intArray);
				System.out.println(s.cartesianProduct(t));
				break;
			default:
				break;
			}
		}
	}
}
