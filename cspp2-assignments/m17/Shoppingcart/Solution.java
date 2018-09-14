import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for item.
 * @author tezasrivishnu.
 */
class Item {
	private String name;
	private int quantity;
	private double price;
	Item(final String nam, final int quan, final double pric) {
		this.name = nam;
		this.quantity = quan;
		this.price = pric;
	}
	Item(final String nam, final int quan) {
		this.name = nam;
		this.quantity = quan;
	}
	public String getName() {
		return this.name;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public double getPrice() {
		return this.price;
	}
	public int setQuantity(int quant) {
		return this.quantity = quant;
	}
	public String toString() {
		String str = "";
		str += name + " " + quantity + " " + price;
		return str;
	}
}
class ShoppingCart {
	private Item[] catalog;
	private Item[] cart;
	private int car;
	private int cat;
	private double disc;
	private double tax;
	private double discamount;
	private boolean available = false;
	private String[] coupans = {"IND10", "IND20", "IND30", "IND40", "IND50"};
	ShoppingCart() {
		catalog = new Item[10];
		cart = new Item[10];
		car = 0;
		cat = 0;

	}
	public void addToCatalog(Item item) {
		if (cat >= catalog.length) {
			itemResize();
		}
		if (!(contains(item.getName()))) {
			catalog[cat] = item;
			cat += 1;
		}
	}

	public boolean contains(final String item) {
		return indexOf(item) != -1;
	}
	public int indexOf(final String item) {
		for (int i = 0; i < cat; i++) {
			if (item.equals(catalog[i].getName())) {
				return i;
			}
		}
		return -1;
	}
	public int carIndexOf(final String item) {
		for (int i = 0; i < car; i++) {
			if (item.equals(cart[i].getName())) {
				return i;
			}
		}
		return -1;
	}
	public void addToCart(Item item) {
		if (car == cart.length) {
			itemResize();
		}
		for (int i = 0; i < cat; i++) {
			if ((item.getName().equals(catalog[i].getName())) &&
			        (item.getQuantity() <= catalog[i].getQuantity())) {
				cart[car] = item;
				car += 1;
			}else {
				int index = carIndexOf(item.getName());
				int quant = cart[index].getQuantity()+item.getQuantity();
				cart[index].setQuantity(quant);
			}
		}
	}
	public void cartResize() {
		cart = Arrays.copyOf(cart, car + 2);

	} public void itemResize() {
		catalog = Arrays.copyOf(catalog, cat + 2);
	}
	public void removeFromCart(Item item) {
		for (int i = 0; i < car; i++) {
			if (item.getName().equals(cart[i].getName())) {
				int quant = cart[i].getQuantity() - item.getQuantity();
				cart[i].setQuantity(quant);
				if (cart[i].getQuantity() <= 0) {
					for (int j = i; j < car; j++) {
						cart[i] = cart[i + 1];
					}
					car -= 1;
				}

			}
		}
	}
	public void showCart() {
		for (int i = 0; i < car; i++) {
			System.out.println(cart[i].getName() + " " + cart[i].getQuantity());
		}
	}
	public void showCatalog() {
		for (int i = 0; i < cat; i++) {
			System.out.println(catalog[i]);
		}
	}
	public double getTotalAmount() {
		double amount = 0.0;
		for (int i = 0; i < car; i++) {
			amount += catalog[indexOf(cart[i].getName())].getPrice() * cart[i].getQuantity();
		}
		return amount;
	}
	public double getPayableAmount() {
		double total = getTotalAmount();
		discamount = total * (disc);
		total -= discamount;
		tax = total * 0.15;
		total += tax;
		return total;
	}
	public void applyCoupon(String coupan) {
		//System.out.println(coupans.length);
		for (int i = 0; i < coupans.length ; i++) {
			//System.out.println(coupan.equals(coupans[i]) && !available);
			if (coupan.equals(coupans[i]) && !available) {
				available = true;
				disc = Character.getNumericValue(coupan.charAt(3)) / 10.0;
				//System.out.println(disc);
			}
		}
	}
	public void printInvoice() {
		double sum = 0;
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < car; i++) {
			sum = catalog[indexOf(cart[i].getName())].getPrice();
			System.out.println(cart[i].getName() + " " + cart[i].getQuantity() + " " + sum);
		}
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:" + discamount);
		System.out.println("Tax:" + tax);
		System.out.println("Payable amount: " + getPayableAmount());
	}
}
public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ShoppingCart ne = new ShoppingCart();
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(" ");
			switch (tokens[0]) {
			case "Item":
				String[] items = tokens[1].split(",");
				ne.addToCatalog(new Item(items[0], Integer.parseInt(items[1]), Double.parseDouble(items[2])));
				break;
			case "add":
				items = tokens[1].split(",");
				ne.addToCart(new Item(items[0], Integer.parseInt(items[1])));
				break;
			case "remove":
				items = tokens[1].split(",");
				ne.removeFromCart(new Item(items[0], Integer.parseInt(items[1])));
				break;
			case "show":
				ne.showCart();
				break;
			case "totalAmount":
				System.out.println("totalAmount: " + ne.getTotalAmount());
				break;
			case "payableAmount":
				System.out.println("Payable amount: " + ne.getPayableAmount());
				break;
			case "catalog":
				ne.showCatalog();
				break;
			case "coupon":
				ne.applyCoupon(tokens[1]);
				break;
			case "print":
				ne.printInvoice();
				break;
			default:

			}
		}
	}
}