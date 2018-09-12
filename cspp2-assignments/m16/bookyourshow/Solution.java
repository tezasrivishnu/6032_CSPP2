import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for show.
 * @author tezasrivishnu.
 */
class Show {
	/**
	 * initializing movie.
	 */
	private String movie;
	/**
	 * initializing datetime.
	 */
	private String datetime;
	/**
	 * initializing array seats.
	 */
	private String[] seats;
	/**
	 * Constructs the object.
	 *
	 * @param      movi     The movie
	 * @param      datetime The datetime
	 * @param      seat     The seats
	 */
	Show(final String movi, final String datetim, final String[] seat) {
		this.movie = movi;
		this.datetime = datetim;
		this.seats = seat;
	}
	/**
	 * Gets the movie.
	 *
	 * @return     The movie.
	 */
	public String getMovie() {
		return movie;
	}
	/**
	 * Gets the datetime.
	 *
	 * @return     The datetime.
	 */
	public String getDatetime() {
		return datetime;
	}
	/**
	 * Gets the seats.
	 *
	 * @return     The seats.
	 */
	public String[] getSeats() {
		return seats;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String printExceptTickets() {
		String s = "";
		s += movie + "," + datetime;
		return s;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String s = "";
		s += movie + "," + datetime + ","
		     + Arrays.toString(seats).replace(", ", ",");
		return s;
	}

}
/**
 * Class for patron.
 */
class Patron {
	/**
	 * initializing customer.
	 */
	private String customer;
	/**
	 * initializing phone.
	 */
	private String phone;
	/**
	 * initializing array book.
	 */
	private String[] book;
	/**
	 * Constructs the object.
	 *
	 * @param      custome The customer
	 * @param      phon     The phone
	 * @param      boo      The book
	 */
	Patron(final String custome, final String phon, final String[] boo) {
		this.customer = custome;
		this.phone = phon;
		this.book = boo;
	}
	/**
	 * Gets the customer name.
	 *
	 * @return     The customer.
	 */
	public String getCustomer() {
		return customer;
	}
	/**
	 * Gets the phone number.
	 *
	 * @return     The phone.
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * Gets the seats.
	 *
	 * @return     The seats.
	 */
	public String[] getSeats() {
		return book;
	}
}
/**
 * Class for book your show.
 */
class BookYourShow {
	/**
	 * initializing the show array.
	 */
	private Show[] show;
	/**
	 * initializing the patron array.
	 */
	private Patron[] patron;
	/**
	 * initializing the show size.
	 */
	private int scount;
	/**
	 * 
	 * initializing the patron size.
	 */
	private int pcount;
	/**
	 * Constructs the object.
	 */
	BookYourShow() {
		show = new Show[10];
		patron = new Patron[10];
		scount = 0;
		pcount = 0;
	}
	/**
	 * Adds a show.
	 *
	 * @param      movie  is the input parameter.
	 */
	public void addAShow(final Show movie) {
		if (scount == show.length) {
			sResize();
		} else {
			show[scount] = movie;
			scount += 1;
		}
	}
	/**
	 * adding a patron.
	 * @param movie is the input parameter.
	 */
	public void addAPatron(final Patron movie) {
		if (pcount == patron.length) {
			pResize();
		} else {
			patron[pcount] = movie;
			pcount += 1;
		}
	}
	/**
	 * resizing the show array.
	 */
	public void sResize() {
		show = Arrays.copyOf(show, scount + 2);
		/**
		 * resizing the patron.
		 */
	} public void pResize() {
		patron = Arrays.copyOf(patron, pcount + 2);
	}
	/**
	 * Gets a show.
	 *
	 * @param      movie     is the input parameter.
	 * @param      datetime  is the input parameter.
	 *
	 * @return     A show.
	 */
	public Show getAShow(final String movie, final String datetime) {
		for (int i = 0; i < scount; i++) {
			if ((movie.equals(show[i].getMovie()))
				&& (datetime.equals(show[i].getDatetime()))) {
				return show[i];
			}
		}
		return null;
	}
	/**
	 * printing the ticket.
	 *
	 * @param      movie     is the input parameter.
	 * @param      datetime  is the input parameter.
	 * @param      phone    is the input parameter.
	 */
	public void printTicket(final String movie,
		final String datetime, final String phone) {
		Show print = getAShow(movie, datetime);
		int a = 0;
		if (print != null) {
			for (int i = 0; i < pcount; i++) {
				if (phone.equals(patron[i].getPhone())) {
					System.out.println(phone
						+ " " + movie + " " + datetime);
					a += 1;
					return;
				}
			}
			if (a == 0) {
				System.out.println("Invalid");
			}
		} else {
			System.out.println("Invalid");
		}
	}
	/**
	 *
	 * booking a show.
	 *
	 * @param      movie     is the input parameter.
	 * @param      datetime  is the input parameter.
	 * @param      patro    is the input parameter.
	 */
	public void bookAShow(final String movie,
		final String datetime, final Patron patro) {
		Show available = getAShow(movie, datetime);
		addAPatron(patro);
		if (available != null) {
			for (int i = 0; i < patro.getSeats().length; i++) {
				for (int j = 0; j < available.
					getSeats().length; j++) {
					if ((patro.getSeats()[i]).
						equals(available.
							getSeats()[j])) {
						available.getSeats()[j] = "N/A";
					}
				}
			}
			// if (a == patron.getSeats().length) {
			// 	for (int i = 0; i < patron.
			// 	getSeats().length; i++) {
			// 		for (int j = 0; j < available.
			// 		getSeats().length; j++) {
			// 			if ((patron.getSeats()[i])
			// 			.equals
			// 			(available.getSeats()[j]))
			// 			{
			// 				available.getSeats()[j]
			// 				= "N/A";
			// 				//System.out.println
			// 				(available.getSeats()[j]);
			// 			}
			// 		}
			// 	}
			// }
		} else {
			System.out.println("No show");
		}
	}
	/**
	 * method for showing all the avaiable shows and seats.
	 */
	public void showAll() {
		for (int i = 0; i < scount; i++) {
			System.out.println(show[i]);
		}
	}
}
/**
 * Class Solution.
 */
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
			                  replace("[", "").
			                  replace("]", "").split(",");
			String[] check = tokens[0].split(" ");
			switch (check[0]) {
			case "add":
				int k = 2;
				String[] seats = new String[tokens.length - 2];
				for (int j = 0; j < seats.length; j++) {
					seats[j] = tokens[k++];
				}
				bys.addAShow(new Show(check[1],
				                      tokens[1], seats));
				break;

			case "book":
				k = 2 + 2;
				seats = new String[tokens.length - 2 - 2];
				for (int j = 0; j < seats.length; j++) {
					seats[j] = tokens[k++];
				}
				bys.bookAShow(check[1], tokens[1],
				              new Patron(tokens[2],
				                         tokens[2 + 1], seats));
				break;

			case "get":
				Show show = bys.getAShow(check[1], tokens[1]);
				if (show != null) {
					System.out.println(show.
					        printExceptTickets());
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

