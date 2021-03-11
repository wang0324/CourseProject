/**
 * Main.java
 * @author Kevin Wang
 * @author Grace Xiaoli Zheng
 * CIS 22C Course Project
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

        String first, last, userName, userId, password, city, friendsList, interestsList;
        int numOfFriends, numOfInterests;

        try {
            File userData = new File("US_Presidents.txt");
            Scanner fileReader = new Scanner(userData);

            // Read information from File and put them in respective data structures
            while (fileReader.hasNextLine()) {
                //TODO: Read in File Input and store i
                first = fileReader.next();
                last = fileReader.nextLine();
                userName = fileReader.nextLine();
                userId = fileReader.nextLine();
                password = fileReader.nextLine();
                city = fileReader.nextLine();
                numOfFriends = fileReader.nextInt();

                // should we create array list to store both friendlist and interstlist?
                for(int i = 0; i < numOfFriends; i++) {
                    friendsList = fileReader.nextLine() + "\n";
                }
                numOfInterests = fileReader.nextInt();
                for(int i = 0; i < numOfInterests; i++) {
                    interestsList = fileReader.nextLine() + "\n";
                }

            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Invalid file name.\n" + "Please enter a valid file name: ");

            //TODO: Come up with name for our "app" // USPF, FriendTree

            // Login to social media program
            System.out.println("Welcome to USPF!");

            Scanner input = new Scanner(System.in);

            System.out.print("Please enter your username: ");
            input.nextLine();

            System.out.print("Please enter your password: ");
            input.nextLine();

            System.out.println("Welcome back!");
            System.out.println("A: View My Friends");
            System.out.println("B: Search for a New Friend");
            System.out.println("C: Get Friend Recommendations");
            System.out.println("Q: Quit");
            System.out.print("Please enter your choice: ");
            String choice = input.next();
            switch(choice) {

                // View My Friends (has sub-menu)
                //+View Friends Sorted by Name
                //+View a Selected Friend's Profile
                //+Remove a Friend
                case "A":
                    System.out.println("a. View Friends Sorted by Name");
                    System.out.println("b. View a Selected Friend's Profile");
                    System.out.println("c. Remove a Friend");
                    System.out.print("Please enter your choice: ");
                    String choice1 = input.next();

                    switch(choice1) {
                        case "a":
                            // use BST to print the friends list by name
                            // didn't have bst file yet
                            break;
                        case "b":
                            System.out.print("Please enter the friends' userId to see his Profile: ");
                            userId = // show the friend profile
                            break;
                        case "c":
                            System.out.print("Please enter the friends' userId you want to remove");
                            //
                            break;
                        default:
                            System.out.print("Invalid choice!\n Please enter a valid choice: ");
                    }
                    break;

                //- Search for a New Friend (has sub-menu)
                //+ Search by Name (user types a String name)
                //+ Search by Interest (user types a String interest)
                case "B":
                    System.out.println("Find new friends by:");
                    System.out.println("N: Name");
                    System.out.println("I: Interst");
                    System.out.print("Please enter your choice: ");
                    String choice2 = input.next();
                    switch(choice2) {
                        case "N":
                            // show friends list by name
                            break;
                        case "I":
                            // show friends list by Interest
                            break;
                        default:
                            System.out.print("Invalid choice!\n Please enter a valid choice: ");
                    }
                    break;

                //- Get Friend Recommendations (has sub-menu)
                //+ View Recommendations
                //+ Add Friend
                case "C":
                    System.out.println("Here are what we found for you:");
                    // print the friend list by distance
                    System.out.println("Do you want to add friends now?");
                    System.out.println("Y: add friends now");
                    System.out.println("N: not now");
                    System.out.print("please enter your choice: ");
                    String choice3 = input.next();
                    switch(choice3) {
                        case "Y":
                            //should decide how to rank friends
                            //System.out.println("");
                            // ask user if they want to add more friends
                            break;
                        case "N":

                        default:
                            System.out.print("Invalid choice!\n Please enter a valid choice: ");
                    }
                    break;

                // - Quit and Write Records to a File
                case "Q":
                    //output a file of all new users information
                    break;

                default:
                    System.out.print("Invalid choice!\n Please enter a valid choice: ");
            }
        }
    }
}