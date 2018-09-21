import java.util.Scanner;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * main program for the solution.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) throws Exception {
        BagOfWords bag = new BagOfWords();
        try {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            File files = new File(input);
            File[] filelist = files.listFiles();
            int length = filelist.length;
            if (length == 0) {
                throw new Exception();
            } else {
                for (int i = 0; i < length; i++) {
                    String s = toText(filelist[i]);
                    String[] tokens = s.toLowerCase().split(" ");
                    bag.addWords(new Words(tokens));
                    String[] distinct = bag.getDistinct(tokens);
                    int[] count = bag.getCount(tokens, distinct);
                }
                for (int s = 0; s < length; s++) {
                    System.out.print("\t\t");
                    System.out.print("File" + (s + 1)+ ".txt");
                }
                System.out.println();
                for (int i = 0; i < length; i++) {
                    System.out.print("File" + (i + 1) + ".txt" + "\t\t");
                    for (int j = 0; j < length; j++) {
                        Double beg = bag.getFrequency(i, j);
                        System.out.printf("%.2f", beg);
                        System.out.print("\t\t");
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("empty directory");;
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
}
/**
 * Class for bag of words.
 */
class BagOfWords {
    Words[] words;
    int a;
    /**
     * Constructs the object.
     */
    BagOfWords() {
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
    /**
     * Gets the distinct.
     *
     * @param      names  The names
     *
     * @return     The distinct.
     */
    public String[] getDistinct(final String[] names) {
        String[] distinct = new String[names.length];
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < index + 1; j++) {
                if (names[i].equals(distinct[j])) {
                    flag = true;
                }
            }
            if (!flag && names[i].length() != 0) {
                distinct[index] = names[i];
                index += 1;
            }
            flag = false;
        }
        distinct = Arrays.copyOf(distinct, index);
        words[a - 1].setDistinct(distinct);
        return distinct;
    }
    /**
     * Gets the count.
     *
     * @param      tokens    The tokens
     * @param      distinct  The distinct
     *
     * @return     The count.
     */
    public int[] getCount(final String[] tokens, final String[] distinct) {
        int[] count = new int[distinct.length];
        int index = 0;
        int size = 0;
        for (String dis : distinct) {
            if (null == dis) {
                break;
            }
            for (String word : tokens) {
                if (dis.equals(word)) {
                    size += 1;
                }
            }
            count[index] = size;
            index += 1;
            size = 0;
        }
        words[a - 1].setCount(count);
        return count;
    }
    /**
     * Gets the frequency.
     *
     * @param      index   The index
     * @param      index1  The index 1
     *
     * @return     The frequency.
     */
    public double getFrequency(final int index, final int index1) {
        String[] one = words[index].getDistinctWords();
        int[] onecount = words[index].getCountWords();
        String[] two = words[index1].getDistinctWords();
        int[] twocount = words[index1].getCountWords();
        double freq = 0.0;
        double onecoun = 0.0;
        double twocoun = 0.0;
        double answer = 0.0;
        if (index == index1) {
            answer = 100.0;
            return answer;
        }
        if (one.length == 0 || two.length == 0) {
            answer = 0.0;
            return answer;
        }
        // if (one.length == 0) {
        //     for (int f = 0; f < two.length; f++) {
        //         freq += twocount[f];
        //         onecoun = 1.0;
        //     }
        //     for (int ele = 0; ele < two.length; ele++) {
        //         twocoun += twocount[ele] * twocount[ele];
        //     }
        //     double ans = freq / (Math.sqrt(onecoun * twocoun));
        //     answer = ans;
        // }
        // if (two.length == 0) {
        //     for (int g = 0; g < one.length; g++) {
        //         freq += onecount[g];
        //         twocoun = 1.0;
        //     }
        //     for (int ele = 0; ele < one.length; ele++) {
        //         onecoun += onecount[ele] * onecount[ele];
        //     }
        //     double ans = freq / (Math.sqrt(onecoun * twocoun));
        //     answer = ans;
        // }
        // if (one.length > 0 && two.length > 0) {
        for (int g = 0; g < one.length; g++) {
            for (int f = 0; f < two.length; f++) {
                if (one[g].equals(two[f])) {
                    freq += (onecount[g] * twocount[f]);
                }
            }
        }
        for (int ele = 0; ele < two.length; ele++) {
            twocoun += twocount[ele] * twocount[ele];
        }
        for (int ele = 0; ele < one.length; ele++) {
            onecoun += onecount[ele] * onecount[ele];
        }
        double ans = freq / (Math.sqrt(onecoun * twocoun));
        answer = ans * 100.0;
        return answer;
    }
}

/**
 * Class for words.
 */
class Words {
    String[] words;
    int[] count;
    String[] distinct;
    /**
     * Constructs the object.
     *
     * @param      tokens  The tokens
     */
    Words(final String[] tokens) {
        this.words = tokens;
    }
    /**
     * Gets the words.
     *
     * @return     The words.
     */
    public String[] getWords() {
        return this.words;
    }
    /**
     * Gets the distinct words.
     *
     * @return     The distinct words.
     */
    public String[] getDistinctWords() {
        return this.distinct;
    }
    /**
     * Gets the count words.
     *
     * @return     The count words.
     */
    public int[] getCountWords() {
        return this.count;
    }
    /**
     * Sets the count.
     *
     * @param      tokens  The tokens
     */
    public void setCount(final int[] tokens) {
        this.count = tokens;
    }
    /**
     * Sets the distinct.
     *
     * @param      tokens  The tokens
     */
    public void setDistinct(final String[] tokens) {
        this.distinct = tokens;
    }
}