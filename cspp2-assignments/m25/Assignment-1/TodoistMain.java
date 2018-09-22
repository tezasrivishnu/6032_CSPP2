import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 * @author tezasrivishnu.
 */
public class TodoistMain {

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
	public static void testAddTask(final Todoist todo, final String[] tokens) {
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
		int flag = 6;
		if (title.length() == 0) {
			flag -= 1;
			throw new Exception("Title not provided");
		}
		String assignedTo = tokens[2];
		int timeToComplete = Integer.parseInt(tokens[3]);
		if (timeToComplete < 0) {
			flag -= 1;
			throw new Exception("Invalid timeToComplete " + timeToComplete);
		}
		boolean important = tokens[4].equals("y");
		boolean urgent = tokens[5].equals("y");
		String status = tokens[6];
		if (!(status.equals("todo") || status.equals("done"))) {
			flag -= 1;
			throw new Exception("Invalid status " + status);
		}
		return new Task(
		           title, assignedTo, timeToComplete, important, urgent, status);
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
class Task {
	private String title;
	private String assignedTo;
	private int timeToComplete;
	private String important;
	private String urgent;
	private String status;
	Task(final String tasktitle, final String taskassignedto,
		final int tasktime, final boolean imp, final boolean urg, final String status) {
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
		this.status = status;
	}
	public String getTitle() {
		return this.title;
	}
	public String getassignedTo() {
		return this.assignedTo;
	}
	public int getTime() {
		return this.timeToComplete;
	}
	public String getImportant() {
		return this.important;
	}
	public String getUrgent() {
		return this.urgent;
	}
	public String getStatus() {
		return this.status;
	}
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
class Todoist {
	List<Task> taskarr;
	Todoist() {
		taskarr = new List<Task>();
	}
	public void addTask(final Task task) {
		taskarr.add(task);
	}
	public int totalTime4Completion() {
		int time = 0;
		for (int i = 0; i < taskarr.size(); i++) {
			if ((taskarr.get(i).getStatus()).equals("todo")) {
				time += taskarr.get(i).getTime();
			}
		}
		return time;
	}
	public Task getNextTask(final String name) {
		for (int i = 0; i < taskarr.size(); i++) {
			if (name.equals(taskarr.get(i).getassignedTo()) &&
				(((taskarr.get(i).getImportant()).equals("Important"))
				 && ((taskarr.get(i).getUrgent()).equals("Not Urgent"))
				 && ((taskarr.get(i).getStatus()).equals("todo")))) {
				return taskarr.get(i);
			}
		}
		return null;
	}
	public Task[] getNextTask(final String name, final int num) {
		Task[] ne = new Task[num];
		int count = 1;
		for (int i = 0; i < taskarr.size(); i++) {
			if (name.equals(taskarr.get(i).getassignedTo())) {
				ne[count-1] = taskarr.get(i);
				count += 1;
			} if(count == num) {
				return ne;
			}
		}
		return ne;
	}



	public void totoString() {
		for (int i = 0; i < taskarr.size(); i++) {
			taskarr.get(i).totoString();
		}
	}
}
