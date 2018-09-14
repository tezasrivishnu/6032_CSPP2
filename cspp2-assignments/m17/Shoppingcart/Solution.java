import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for item.
 * @author tezasrivishnu.
 */
class Item {
    /**
     * initializing String name.
     */
    private String name;
    /**
     * initializing quantitiy.
     */
    private int quantity;
    /**
     * initializing price.
     */
    private double price;
    /**
     * Constructs the object.
     *
     * @param      nam   The nam
     * @param      quan  The quan
     * @param      pric  The pric
     */
    Item(final String nam, final int quan, final double pric) {
        this.name = nam;
        this.quantity = quan;
        this.price = pric;
    }
    /**
     * Constructs the object.
     *
     * @param      nam   The nam
     * @param      quan  The quan
     */
    Item(final String nam, final int quan) {
        this.name = nam;
        this.quantity = quan;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the quantity.
     *
     * @return     The quantity.
     */
    public int getQuantity() {
        return this.quantity;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public double getPrice() {
        return this.price;
    }


    /**
     * Sets the quantity.
     *
     * @param      quant  The quant
     */
    public void setQuantity(final int quant) {
        this.quantity = quant;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        str += name + " " + quantity + " " + price;
        return str;
    }
}
/**
 * Class for shopping cartesian.
 */
class ShoppingCart {
    /**
     * assigning value of 10.
     */
    private static final int TEN = 10;
    /**
     * assigning value of 3.
     */
    private static final int THREE = 3;
    /**
     * assigning value of 10.0.
     */
    private static final double TEND = 10.0;
    /**
     * assigning value of tax.
     */
    private static final double TAX = 0.15;

    /**
     * initializing catalog array.
     */
    private Item[] catalog;
    /**
     * initializing cart array.
     */
    private Item[] cart;
    /**
     * initializing cart size.
     */
    private int car;
    /**
     * initializing catalog size.
     */
    private int cat;
    /**
     * initializing discount variable..
     */
    private double disc;
    /**
     * initializing tax variable.
     */
    private double tax;
    /**
     * initializing discount amount variable.
     */
    private double discamount;
    /**
     * initializing boolean value avaiable.
     */
    private boolean available = false;
    /**
     * assigning coupons values.
     */
    private String[] coupans = {"IND10", "IND20", "IND30", "IND50"};
    /**
     * Constructs the object.
     */
    ShoppingCart() {
        catalog = new Item[TEN];
        cart = new Item[TEN];
        car = 0;
        cat = 0;

    }
    /**
     * Adds to catalog.
     *
     * @param      item  The item
     */
    public void addToCatalog(final Item item) {
        if (cat >= catalog.length) {
            itemResize();
        }
        if (!(contains(item.getName()))) {
            catalog[cat] = item;
            cat += 1;
        }
    }
    /**
     * check if it is contained or not.
     * @param      item  The item
     *
     * @return     boolean value.
     */
    public boolean contains(final String item) {
        return indexOf(item) != -1;
    }
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     the index in catalog array.
     */
    public int indexOf(final String item) {
        for (int i = 0; i < cat; i++) {
            if (item.equals(catalog[i].getName())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * index of the item in cart.
     *
     * @param      item  input parameter.
     *
     * @return     the index of element;
     */
    public int carIndexOf(final String item) {
        for (int i = 0; i < car; i++) {
            if (item.equals(cart[i].getName())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Adds to cart.
     *
     * @param      item  The item.
     */
    public void addToCart(final Item item) {
        if (car >= cart.length) {
            itemResize();
        }
        int index = carIndexOf(item.getName());
        if (index == -1) {
            for (int i = 0; i < cat; i++) {
                if ((item.getName().equals(catalog[i].
                    getName()))
                        && (item.getQuantity()
                            <= catalog[i].getQuantity())) {
                    cart[car] = item;
                    car += 1;
                }
            }
        } else {
            int quant = cart[index].getQuantity()
            + item.getQuantity();

            cart[index].setQuantity(quant);
        }
    }
    /**
     * rezizing the cart array.
     */
    public void cartResize() {
        cart = Arrays.copyOf(cart, car + 2);
    }
    /**
     * rezizing the catalog array.
     */
    public void itemResize() {
        catalog = Arrays.copyOf(catalog, cat + 2);
    }
    /**
     * Removes a from cart.
     *
     * @param      item  The item
     */
    public void removeFromCart(final Item item) {
        for (int i = 0; i < car; i++) {
            if (item.getName().equals(cart[i].getName())) {
                int quant = cart[i].getQuantity()
                - item.getQuantity();
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
    /**
     * Shows the items in the cart.
    */
    public void showCart() {
        for (int i = 0; i < car; i++) {
            System.out.println(cart[i].getName() + " "
                               + cart[i].getQuantity());
        }
    }
    /**
     * Shows the catalog items.
     */
    public void showCatalog() {
        for (int i = 0; i < cat; i++) {
            System.out.println(catalog[i]);
        }
    }
    /**
     * Gets the total amount.
     *
     * @return     The total amount.
     */
    public double getTotalAmount() {
        double amount = 0.0;
        for (int i = 0; i < car; i++) {
            amount += catalog[indexOf(cart[i].getName())].
                      getPrice() * cart[i].getQuantity();
        }
        return amount;
    }
    /**
     * Gets the payable amount.
     * @return     The payable amount.
     */
    public double getPayableAmount() {
        double total = getTotalAmount();
        discamount = total * (disc);
        total -= discamount;
        tax = total * TAX;
        total += tax;
        return total;
    }
    /**
     * Calculating the discount.
     * @param      coupan  The coupan
     */
    public void applyCoupon(final String coupan) {
        //System.out.println(coupans.length);
        for (int i = 0; i < coupans.length; i++) {
            //System.out.println(coupan.
            //equals(coupans[i]) && !available);
            if (coupan.equals(coupans[i]) && !available) {
                available = true;
                disc = Character.
                       getNumericValue(coupan.charAt(THREE)) / TEND;
                //System.out.println(disc);
            }
        } if (!available) {
            System.out.println("Invalid coupon");
        }
    }
    /**
     * printing invoice.
     */
    public void printInvoice() {
        double sum = 0;
        System.out.println("Name   quantity   Price");
        for (int i = 0; i < car; i++) {
            sum = catalog[indexOf(cart[i].getName())].getPrice();
            System.out.println(cart[i].getName() + " "
                              + cart[i].getQuantity() + " " + sum);
        }
        System.out.println("Total:" + getTotalAmount());
        System.out.println("Disc%:" + discamount);
        System.out.println("Tax:" + tax);
        System.out.println("Payable amount: " + getPayableAmount());
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not using.
    }
    /**
     * main program.
     * @param      args  is the input parameter.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart ne = new ShoppingCart();
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(" ");
            switch (tokens[0]) {
            case "Item":
                String[] items = tokens[1].split(",");
                ne.addToCatalog(new Item(items[0], Integer.
                                         parseInt(items[1]), Double.
                                         parseDouble(items[2])));
                break;
            case "add":
                items = tokens[1].split(",");
                ne.addToCart(new Item(items[0],
                                      Integer.parseInt(items[1])));
                break;
            case "remove":
                items = tokens[1].split(",");
                ne.removeFromCart(new Item(items[0],
                                           Integer.parseInt(items[1])));
                break;
            case "show":
                ne.showCart();
                break;
            case "totalAmount":
                System.out.println("totalAmount: "
                                   + ne.getTotalAmount());
                break;
            case "payableAmount":
                System.out.println("Payable amount: "
                                   + ne.getPayableAmount());
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
