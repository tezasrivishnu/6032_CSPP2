import java.util.Scanner;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.lang.Math;
class Solution {
	public static void main(String[] args) {
		Lcs lcs = new Lcs();
		Double beg = 0.0;
		Double max = 0.0;
		int l = 0;
		int m = 0;
		try {
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			File files = new File(input);
			File[] filelist = files.listFiles();
			int length = filelist.length;
			if (length == 0) {
				throw new Exception("Empty Directory");
			} else {
				for (int i = 0; i < length; i++) {
					String s = toText(filelist[i]).toLowerCase();
					lcs.addWords(new Words(s, s.length()));
				}
				System.out.print("\t"+"     ");
				for (int s = 0; s < length; s++) {
					System.out.print("file" + (s + 1) + ".txt" + "    ");
				}
				System.out.println();
				for (int i = 0; i < length; i++) {
					System.out.print("file" + (i + 1) + ".txt" + "        ");
					for (int j = 0; j < length; j++) {
						beg = lcs.frequencyWords(i, j);
						if (max < beg && beg != 100.0) {
							max = beg;
							l = i;
							m = j;
						}
						System.out.print(Math.round(beg-0.1)+".0");
						System.out.print("        ");
					}
					System.out.println();
				}
				System.out.println("Maximum similarity is between file" + (l+1)
					+ ".txt and file" + (m+1) + ".txt");
			}
		} catch (Exception e) {
			System.out.println("Empty Directory");
		}
	}
	/**
	 * converting the file into string.
	 *
	 * @param      file  The file
	 *
	 * @return     string representation
	 */
	public static String toText(File file) {
		String str = "";
		try {
			Scanner input = new Scanner(new FileReader(file));
			StringBuilder text = new StringBuilder();
			while (input.hasNext()) {
				text.append(input.next());
				text.append(" ");
			}
			input.close();
			str = text.toString().replaceAll("[^\\p{Alpha} ]", "");
		} catch (Exception e) {
			System.out.println("No File");
		}
		return str;
	}
	// String s = "what is your name";
	// int len = s.length();
	// //String[] tokens = s.split(" ");
	// lcs.addWords(new Words(s, len));
	// String s1 = "my name is xyz";
	// int len1 = s1.length();
	// //String[] tokens1 = s.split(" ");
	// lcs.addWords(new Words(s1, len1));
	// System.out.println(lcs.frequencyWords(0, 1));
}
class Lcs {
	Words[] words;
	int a;
	/**
	 * Constructs the object.
	 */
	Lcs() {
		words = new Words[20];
		a = 0;
	}
	/**
	 * Adds words.
	 *
	 * @param      token  The token
	 */
	public void addWords(Words token) {
		words[a++] = token;
	}
	public double frequencyWords(int on, int tw) {
		// String[] token = words[one].getWords();
		// double length = words[one].getLenth();
		// String[] token1 = words[two].getWords();
		// double length1 = words[two].getLenth();
		// double lcs = 0.0;
		// int start = 0;
		// int end = 0;
		// String[] str = new String[length+length1];
		// int in = 0;
		// for (int i = 0; i < length; i++) {
		//           for (int j = 0; j < length1; j++) {
		//           	if(token[i].equals(token1[j])) {
		//           		str[in] = token[i];
		//           	}
		// double totallen = length + length1;
		// double freq = (lcs * 2.0) / totallen;
		// System.out.println(freq * 100);
		String one = words[on].getWords();
		String two = words[tw].getWords();
		int len = words[on].getLength();
		int len1 = words[tw].getLength();
		int[][] lcs = new int[len + 1][len1 + 1];
		int l = 0;
		int start = 0;
		int end = 0;
		double lcspercentage = 0.0;
		for (int i = 0; i <= len; i++) {
			for (int j = 0; j <= len1; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (one.charAt(i - 1) == two.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
					if (l < lcs[i][j]) {
						l = lcs[i][j];
						start = i;
						end = j;
					}
				} else
					lcs[i][j] = 0;
			}
		}
		String str = "";
		while (lcs[start][end] != 0) {
			str = one.charAt(start - 1) + str;
			l -= 1;
			start -= 1;
			end -= 1;
		}
		if (one == two) {
			lcspercentage = 100.0;
			return lcspercentage;
		}
		double count = str.length();
		//System.out.println(count+" "+(len+len1));
		lcspercentage = (count * 2) / (len + len1);
		return (lcspercentage * 100.0);
	}
}
class Words {
	String words;
	int length;

	/**
	 * Constructs the object.
	 *
	 * @param      tokens  The tokens
	 */
	Words(final String tokens, final int le) {
		this.words = tokens;
		this.length = le;
	}
	/**
	 * Gets the words.
	 *
	 * @return     The words.
	 */
	public String getWords() {
		return this.words;
	}
	public int getLength() {
		return this.length;
	}
}