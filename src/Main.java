/**
 * Main.java
 * @author Kevin Wang
 * CIS 22C Course Project
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Load in File data
        final int NUM_USERS = 15;

        HashTable <User> userLogin = new HashTable<>(45);
        HashTable <User> userFriends = new HashTable<>(45);
        ArrayList <BST <User>> usersByInterest = new ArrayList<>();
        HashTable <Interest> interests = new HashTable<>(45);
        Graph userGraph = new Graph(15);

        String first, last, username, userId, password;

        File userData = new File("");
        Scanner fileReader = new Scanner(userData);

        // Read information from File and put them in respective data structures
        while (fileReader.hasNextLine()) {
            //TODO: Read in File Input and store i
        }

        //TODO: Come up with name for our "app"

        // Login to social media program
        System.out.println("Welcome to ");

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your username: ");
        input.nextLine();

        System.out.print("Please enter your password: ");
        input.nextLine();




    }
}
