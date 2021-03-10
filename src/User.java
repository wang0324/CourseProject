/**
 * HashTable.java
 * @author Samhith Kakarla
 * @author Kevin Wang
 * CIS 22C Final Project
 */

import java.util.Comparator;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String city;
    private int ID;
    private BST<User> friends;
    private List<String> interests;

    public User() {
        this.firstName = "";
        this.lastName = "";
        userName = "";
        password = "";
        city = "";
        ID = 0;
        friends = null;
        interests = null;
    }

    public User(String name) {
        this.firstName = name.split(" ")[0];
        this.lastName = name.split(" ")[1];
        userName = "";
        password = "";
        city = "";
        ID = 0;
        friends = null;
        interests = null;
    }

    public User(String userName, String password) {
        this.firstName = "";
        this.lastName = "";
        this.userName = userName;
        this.password = password;
        city = "";
        ID = 0;
        friends = null;
        interests = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return lastName;
    }


    public String toString() {
        return firstName + " " + lastName;
    }


}

class NameComparator implements Comparator<User> {

    @Override
    public int compare(User u1, User u2) {
        String a1 = u1.getFirstName() + u1.getLastName();
        String a2 = u2.getFirstName() + u2.getLastName();

        return a1.compareTo(a2);
    }
} // end class NameComparator

class UPComparator implements Comparator<User> {

    @Override
    public int compare(User u1, User u2) {
        String a1 = u1.getUserName() + u1.getPassword();
        String a2 = u2.getUserName() + u2.getPassword();

        return a1.compareTo(a2);
    }
} // end class NameComparator