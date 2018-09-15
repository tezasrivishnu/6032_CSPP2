import java.util.Scanner;

/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * intitializing value of 4.
     */
    private static final int FOUR = 4;
    /**
     * intitializing value of 3.
     */
    private static final int THREE = 3;
    /**
     * intitializing value of 5.
     */
    private static final int FIVE = 5;
    /**
     * intitializing value of 2.
     */
    private static final int TWO = 2;
    /**
     * initilizing Quiz array.
     */
    private static Quiz[] quizarr = new Quiz[FOUR];
    /**
     * initilizing array.
     */
    private static int[] array = new int[FOUR];
    /**
     * initilizing choices array.
     */
    private static String[] choices = {"choice 1", "choice 2",
    "choice 3", "choice 4"};
    /**
     * initilizing size.
     */
    private static int size = 0;
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s,
        final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount == 0) {
            System.out.println("Quiz does not have questions");
        } else {
            System.out.println(questionCount + " are added to the quiz");
            for (int i = 0; i < questionCount; i++) {
                String str = s.nextLine();
                String[] items = str.split(":");
                String[] choice = items[1].split(",");
                if (items.length != FIVE) {
                    System.out.println("Error! Malformed question");
                } else {
                    quizarr[size] = new Quiz(items[0], Integer.
                        parseInt(items[TWO]), Integer.
                        parseInt(items[THREE]), Integer.
                        parseInt(items[FOUR]));
                    size += 1;
                }
            }
        }
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s,
        final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        if (size > 0) {
            for (int i = 0; i < answerCount; i++) {
                String string = s.nextLine();
                String[] arrays = string.split(" ");
                array[i] = Integer.parseInt(arrays[1]);
                System.out.println(quizarr[i].getQuestion()
                    + "(" + quizarr[i].getMarks() + ")");
                System.out.println(choices[0] + "\t" + choices[1]
                    + "\t" + choices[2] + "\t" + choices[THREE]);
                System.out.println();
            }
        }
    }

    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        int total = 0;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                System.out.println(quizarr[i].getQuestion());
                if (array[i] == quizarr[i].getCorrect()) {
                    total += quizarr[i].getMarks();
                    System.out.println(" Correct Answer! - Marks Awarded: "
                        + quizarr[i].getMarks());
                } else {
                    total += quizarr[i].getPenalty();
                    System.out.println(" Wrong Answer! - Penalty: "
                        + quizarr[i].getPenalty());
                }
            }
            System.out.print("Total Score: " + total);
        }
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * intitializing questions.
     */
    private String question;
    /**
     * intitializing choices.
     */
    private String choices;
    /**
     * intitializing correct.
     */
    private int correct;
    /**
     * intitializing marks.
     */
    private int marks;
    /**
     * intitializing penalty.
     */
    private int penalty;
    /**
     * Constructs the object.
     */
    Quiz() {

    }
    /**
     * Constructs the object.
     *
     * @param      questio  The question
     * @param      correc   The correct
     * @param      mark    The marks
     * @param      penalt   The penalty
     */
    Quiz(final String questio, final int correc,
    final int mark, final int penalt) {
        this.question = questio;
        this.correct = correc;
        this.marks = mark;
        this.penalty = penalt;
    }
    /**
     * Gets the question.
     *
     * @return     The question.
     */
    public String getQuestion() {
        return this.question;
    }
    /**
     * Gets the correct.
     *
     * @return     The correct.
     */
    public int getCorrect() {
        return this.correct;
    }
    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public int getMarks() {
        return this.marks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return this.penalty;
    }
}
