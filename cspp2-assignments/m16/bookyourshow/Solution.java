import java.util.Arrays;
import java.util.Scanner;
class Show {
	private String movie;
	private String datetime;
	private String[] seats;
	Show(String movie, String datetime, String[] seats) {
		this.movie = movie;
		this.datetime = datetime;
		this.seats = seats;
	}
	public String getMovie() {
		return movie;
	}
	public String getDatetime() {
		return datetime;
	}
	public String[] getSeats() {
		return seats;
	}
	public String toString() {
		String s = "";
		s += movie + "," + datetime + ","
		     + Arrays.toString(seats).replace(", ", ",");
		return s;
	}

}
class Patron {
	private String customer;
	private String phone;
	private String[] book;
	Patron(String customer, String phone, String[] book) {
		this.customer = customer;
		this.phone = phone;
		this.book = book;
	}
	public String getCustomer() {
		return customer;
	}
	public String getPhone() {
		return phone;
	} public String[] getSeats() {
		return book;
	}
}
class BookYourShow {
	private Show[] show;
	private Patron[] patron;
	private int scount;
	private int pcount;

	BookYourShow() {
		show = new Show[10];
		patron = new Patron[10];
		scount = 0;
		pcount = 0;
	}
	public void addAShow(Show movie) {
		if (scount == show.length) {
			sResize();
		} else {
			show[scount] = movie;
			scount += 1;
		}
	} public void addAPatron(Patron movie) {
		if (pcount == patron.length) {
			pResize();
		} else {
			patron[pcount] = movie;
			pcount += 1;
		}
	}
	public void sResize() {
		show = Arrays.copyOf(show, scount + 2);
	} public void pResize() {
		patron = Arrays.copyOf(patron, pcount + 2);
	}
	public Show getAShow(String movie, String datetime) {
		for (int i = 0; i < scount; i++) {
			if ((movie.equals(show[i].getMovie())) &&
			        (datetime.equals(show[i].getDatetime()))) {
				return show[i];
			}
		}
		return null;
	}
	// public showAll() {

	// }
	public void printTicket(String movie, String datetime, String phone) {
		Show print = getAShow(movie, datetime);
		if (print != null) {
			for (int i = 0; i < pcount; i++) {
				if (phone.equals(patron[i].getPhone())) {
					System.out.println(phone + " " + movie + " " + datetime);
					return;
				}
			}
		} else {
			System.out.println("Invalid");
		}
	}
	public void bookAShow(String movie, String datetime, Patron patron) {
		Show available = getAShow(movie, datetime);
		addAPatron(patron);
		if (available != null) {
			for (int i = 0; i < patron.getSeats().length; i++) {
				for (int j = 0; j < available.getSeats().length; j++) {
					if ((patron.getSeats()[i]).equals(available.getSeats()[j])) {
						available.getSeats()[j] = "N/A";
					}
				}
			} 
			// if (a == patron.getSeats().length) {
			// 	for (int i = 0; i < patron.getSeats().length; i++) {
			// 		for (int j = 0; j < available.getSeats().length; j++) {
			// 			if ((patron.getSeats()[i]).equals(available.getSeats()[j])) {
			// 				available.getSeats()[j] = "N/A";
			// 				//System.out.println(available.getSeats()[j]);
			// 			}
			// 		}
			// 	}
			// }
		} else {
			System.out.println("No Show");
		}
	}
	public void showAll() {
		for (int i = 0; i < scount; i++) {
			System.out.println(show[i]);
		}
	}
}
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * main method to drive program.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		BookYourShow bys = new BookYourShow();
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testCases; i++) {
			String[] tokens = scan.nextLine().
			                  replace("[", "").replace("]", "").split(",");
			String[] check = tokens[0].split(" ");
			switch (check[0]) {
			case "add":
				int k = 2;
				String[] seats = new String[tokens.length - 2];
				for (int j = 0; j < seats.length; j++) {
					seats[j] = tokens[k++];
				}
				bys.addAShow(new Show(check[1], tokens[1], seats));
				break;

			case "book":
				k = 2 + 2;
				seats = new String[tokens.length - 2 - 2];
				for (int j = 0; j < seats.length; j++) {
					seats[j] = tokens[k++];
				}
				bys.bookAShow(check[1], tokens[1],
				              new Patron(tokens[2], tokens[2 + 1], seats));
				break;

			case "get":
				Show show = bys.getAShow(check[1], tokens[1]);
				if (show != null) {
					System.out.println(show);
				} else {
					System.out.println("No show");
				}
				break;

			case "print":
				bys.printTicket(check[1], tokens[1], tokens[2]);
				break;

			case "showAll":
				bys.showAll();
				break;

			default:
				break;
			}
		}
	}
}

