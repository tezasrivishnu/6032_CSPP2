import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 * @author tezasrivishnu.
 */
public final class TodoistMain {
    /**
     * initialising value of 6.
     */
    private static final int SIX = 6;
    /**
     * initialising value of 4.
     */
    private static final int FOUR = 4;
    /**
     * initialising value of 5.
     */
    private static final int FIVE = 5;
    /**
     * initialising value of 3.
     */
    private static final int THREE = 3;
    /**
     * Constructs the object.
     */
    private TodoistMain() {

    }
    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
            case "task":
                testTask(tokens);
                break;
            case "add-task":
                testAddTask(todo, tokens);
                break;
            case "print-todoist":
                todo.totoString();
                break;
            case "get-next":
                System.out.println(todo.getNextTask(tokens[1]));
                break;
            case "get-next-n":
                int n = Integer.parseInt(tokens[2]);
                Task[] tasks = todo.getNextTask(tokens[1], n);
                System.out.println(Arrays.deepToString(tasks));
                break;
            case "total-time":
                System.out.println(todo.totalTime4Completion());
                break;
            default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo,
        final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        //Task s = new Task();
        String title = tokens[1];
        int flag = SIX;
        if (title.length() == 0) {
            flag -= 1;
            throw new Exception("Title not provided");
        }
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[THREE]);
        if (timeToComplete < 0) {
            flag -= 1;
            throw new Exception("Invalid timeToComplete "
                + timeToComplete);
        }
        boolean important = tokens[FOUR].equals("y");
        boolean urgent = tokens[FIVE].equals("y");
        String status = tokens[SIX];
        if (!(status.equals("todo") || status.equals("done"))) {
            flag -= 1;
            throw new Exception("Invalid status " + status);
        }
        return new Task(
                   title, assignedTo, timeToComplete,
                   important, urgent, status);
    }


    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
/**
 * Class for task.
 */
class Task {
    /**
     * declaring string title.
     */
    private String title;
    /**
     * declaring string assignnedTo.
     */
    private String assignedTo;
    /**
     * declaring int timetocomplete.
     */
    private int timeToComplete;
    /**
     * declaring string important or not.
     */
    private String important;
    /**
     * declaring string urgent.
     */
    private String urgent;
    /**
     * declaring string status.
     */
    private String status;
    /**
     * Constructs the object.
     *
     * @param      tasktitle       The tasktitle
     * @param      taskassignedto  The taskassignedto
     * @param      tasktime        The tasktime
     * @param      imp             The imp
     * @param      urg             The urg
     * @param      status1          The status
     */
    Task(final String tasktitle, final String taskassignedto,
         final int tasktime, final boolean imp,
         final boolean urg, final String status1) {
        this.title = tasktitle;
        this.assignedTo = taskassignedto;
        this.timeToComplete = tasktime;
        if (imp) {
            this.important = "Important";
        } else {
            this.important = "Not Important";
        }
        if (urg) {
            this.urgent = "Urgent";
        } else {
            this.urgent = "Not Urgent";
        }
        this.status = status1;
    }
    /**
     * Gets the title.
     *
     * @return     The title.
     */
    public String getTitle() {
        return this.title;
    }
    /**
     * Gets the assigned to.
     *
     * @return     The assigned to.
     */
    public String getAssignedTo() {
        return this.assignedTo;
    }
    /**
     * Gets the time.
     *
     * @return     The time.
     */
    public int getTime() {
        return this.timeToComplete;
    }
    /**
     * Gets the important.
     *
     * @return     The important.
     */
    public String getImportant() {
        return this.important;
    }
    /**
     * Gets the urgent.
     *
     * @return     The urgent.
     */
    public String getUrgent() {
        return this.urgent;
    }
    /**
     * Gets the status.
     *
     * @return     The status.
     */
    public String getStatus() {
        return this.status;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        s += this.title + ", ";
        s += this.assignedTo + ", ";
        s += this.timeToComplete + ", ";
        s += this.important + ", ";
        s += this.urgent + ", ";
        s += this.status;
        return s;
    }
    /**
     * Returns a string representation of the object.
     */
    public void totoString() {
        String s = "";
        s += this.title + ", ";
        s += this.assignedTo + ", ";
        s += this.timeToComplete + ", ";
        s += this.important + ", ";
        s += this.urgent + ", ";
        s += this.status;
        System.out.println(s);
    }
}
/**
 * Class for todoist.
 */
class Todoist {
    /**
     * declaring list array for TASK class.
     */
    private List<Task> taskarr;
    /**
     * Constructs the object.
     */
    Todoist() {
        taskarr = new List<Task>();
    }
    /**
     * Adds a task.
     *
     * @param      task  The task
     */
    public void addTask(final Task task) {
        taskarr.add(task);
    }
    /**
     * calculating the total time.
     *
     * @return     total time.
     */
    public int totalTime4Completion() {
        int time = 0;
        for (int i = 0; i < taskarr.size(); i++) {
            if ((taskarr.get(i).getStatus()).equals("todo")) {
                time += taskarr.get(i).getTime();
            }
        }
        return time;
    }
    /**
     * Gets the next task.
     *
     * @param      name  The name
     *
     * @return     The next task.
     */
    public Task getNextTask(final String name) {
        for (int i = 0; i < taskarr.size(); i++) {
            if (name.equals(taskarr.get(i).getAssignedTo())
                     && (((taskarr.get(i).getImportant())
                        .equals("Important"))
                     && ((taskarr.get(i).getUrgent())
                        .equals("Not Urgent"))
                     && ((taskarr.get(i).getStatus())
                        .equals("todo")))) {
                return taskarr.get(i);
            }
        }
        return null;
    }
    /**
     * Gets the next task for a person.
     *
     * @param      name  The name
     * @param      num   The number
     *
     * @return     The next task.
     */
    public Task[] getNextTask(final String name, final int num) {
        Task[] ne = new Task[num];
        int count = 0;
        for (int i = 0; i < taskarr.size(); i++) {
            if (name.equals(taskarr.get(i).getAssignedTo())
                    && (taskarr.get(i).getStatus())
                    .equals("todo")) {
                ne[count] = taskarr.get(i);
                count += 1;
            }
            if (count == num) {
                return ne;
            }
        }
        return ne;
    }
    /**
     * string representation of the object.
     */
    public void totoString() {
        for (int i = 0; i < taskarr.size(); i++) {
            taskarr.get(i).totoString();
        }
    }
}

