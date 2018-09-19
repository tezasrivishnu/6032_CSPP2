import java.util.Scanner;
import java.util.Arrays;
// class AddConnection {
//  AddConnection() {

//  }
// }
// class GetConnection {
//  GetConnection() {

//  }
// }
// class GetCommonConnection {
//  GetConnection() {

//  }
// }

/**
 * Class for user.
 * @author tezasrivishnu.
 */
class User {
    String username;
    List<String> userfriends;
    /**
     * Constructs the object.
     *
     * @param      name     The name
     * @param      friends  The friends
     */
    User(final String name, final List<String> friends) {
        this.username = name;
        this.userfriends = friends;
    }
    /**
     * Gets the username.
     *
     * @return     The username.
     */
    public String getUsername() {
        return this.username;
    }
    /**
     * Gets the userfriends.
     *
     * @return     The userfriends.
     */
    public List<String> getUserfriends() {
        return this.userfriends;
    }
    /**
     * Sets the userfriends.
     *
     * @param      friend  The friend
     */
    public void setUserfriends(final List<String> friend) {
        this.userfriends = friend;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "[";
        int i;
        for (i = 0; i < userfriends.size() - 1; i++) {
            s += userfriends.get(i) + ",";
        }
        s += userfriends.get(i) + "]";
        return s;
    }
}
/**
 * Class for social network.
 */
class SocialNetwork {
    private List<User> userarr;
    /**
     * Constructs the object.
     */
    SocialNetwork() {
        userarr = new List<User>();
    }
    /**
     * new connection.
     *
     * @param      friends  The friends
     */
    public void newConnection(final User friends) {
        userarr.add(friends);
        // if (userarr.size() == 0) {
        //  userarr.add(friends);
        // } else {
        //  for (int i = 0; i < userarr.size(); i++) {
        //      if (!(friends.getUsername().equals(userarr.get(i).getUsername()))) {
        //          userarr.add(friends);
        //      }
        //  }
        // }
        // for (int i = 0; i < userarr.size(); i++) {
        //  System.out.println(userarr.get(i).getUsername());
        //  System.out.println(Arrays.toString(userarr.get(i).getUserfriends()));
        // }
    }
    /**
     * Adds a connection.
     *
     * @param      one   One
     * @param      two   Two
     */
    public void addConnection(final String one, final String two) {
        for (int i = 0; i < userarr.size(); i++) {
            if (one.equals(userarr.get(i).getUsername())) {
                List<String> friend = userarr.get(i).getUserfriends();
                //friend = Arrays.copyOf(friend, friend.length+1);
                friend.add(two);
                // friend[friend.length-1] = two;
                userarr.get(i).setUserfriends(friend);
            }
        }
    }
    /**
     * Gets the connection.
     *
     * @param      name  The name
     *
     * @return     The connection.
     */
    public List<String> getConnection(final String name) {
        for (int i = 0; i < userarr.size(); i++) {
            if (name.equals(userarr.get(i).getUsername())) {
                return userarr.get(i).getUserfriends();
            }
        }
        return null;
    }
    /**
     * Gets the common connection.
     *
     * @param      one   One
     * @param      two   Two
     */
    public void getCommonConnection(final String one, final String two) {
        for (int i = 0; i < userarr.size(); i++) {
            for (int j = 0; j < userarr.size(); j++) {
                if (one.equals(userarr.get(i).getUsername())
                        && two.equals(userarr.get(j).getUsername())) {
                    commonfriends(userarr.get(i).getUserfriends(), userarr.get(j).getUserfriends());
                }
            }
        }
    }
    /**
     * common friends.
     *
     * @param      one   One
     * @param      two   Two
     */
    public void commonfriends(final List<String> one, final List<String> two) {
        String[] common = new String[20];
        int size = 0;
        for (int i = 0; i < one.size(); i++) {
            for (int j = 0; j < two.size(); j++) {
                if (one.get(i).equals(two.get(j))) {
                    common[size] = one.get(i);
                    size += 1;
                }
            }
        }
        if (size == 0) {
            System.out.println("[]");
        } else {
            String s = "[";
            int j;
            for (j = 0; j < size - 1; j++) {
                s += common[j] + ",";
            }
            s += common[j] + "]";
            System.out.println(s);
        }
    }
    /**
     * Gets the summary.
     */
    public void getSummary() {
        String[] names = new String[userarr.size()];
        for (int i = 0; i<names.length; i++) {
            names[i] = userarr.get(i).getUsername();
        }
        Arrays.sort(names);

        String s = "";
        int j;
        for (j = 0; j<names.length-1; j++) {
            s += names[j] + ":" + getConnection(names[j])+"\n";
        }
        s += names[j] + ":" + getConnection(names[j]);
        // for (i = 0; i < userarr.size() - 1; i++) {
        //  s += userarr.get(i).getUsername() + ":" + userarr.get(i).getUserfriends() + "\n";
        // }
        // s += userarr.get(i).getUsername() + ":" + userarr.get(i).getUserfriends();
        System.out.println(s);
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetwork social = new SocialNetwork();
        String[] str = sc.nextLine().split(" ");
        int j = 0;
        while (j < Integer.parseInt(str[1])) {
            String string = sc.nextLine();
            String[] tokens = string.split(" is connected to ");
            String[] friends = tokens[1].replace(".", "").replace(" ", "").split(",");
            List<String> abc = new List<String>();
            for (int i = 0; i < friends.length; i++) {
                abc.add(friends[i]);
            }
            social.newConnection(new User(tokens[0], abc));
            j++;
        }
        while (sc.hasNext()) {
            String cases = sc.nextLine();
            String[] items = cases.split(" ");
            switch (items[0]) {
            case "addConnections":
                social.addConnection(items[1], items[2]);
                break;
            case "getConnections":
                if (social.getConnection(items[1]) == null) {
                    System.out.println("Not a user in Network");
                } else {
                    System.out.println(social.getConnection(items[1]));
                }
                break;
            case "CommonConnections":
                social.getCommonConnection(items[1], items[2]);
                break;
            case "Network":
                social.getSummary();
                break;
            }
        }
        // social.addConnection("John", "Vishnu");
        // social.getCommonConnection("John", "Bryant");
        //    System.out.println(social.getConnection("John"));
        // System.out.println(social.getConnection("Bryant"));
    }
}
