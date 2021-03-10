/**
 * HashTable.java
 * @author Samhith Kakarla
 * Final Proj
 */
public class HashTableTest {
    public static void main(String[] args) {
        HashTable<User> hashTable = new HashTable<User>(21);

        User u1 = new User("Jhon bo");
        User u2 = new User("Jhon bo");
        User u3 = new User("Jhon bo");
        User u4 = new User("max fan");
        User u5 = new User("rick dick");
        User u6 = new User("hitch na");
        User u7 = new User("sam voom");


        hashTable.put(u1, u1.getFirstName() + u1.getLastName());
        hashTable.put(u2, u2.getFirstName() + u2.getLastName());
        hashTable.put(u3, u3.getFirstName() + u3.getLastName());
        hashTable.put(u4, u4.getFirstName() + u4.getLastName());
        hashTable.put(u5, u5.getFirstName() + u5.getLastName());
        hashTable.put(u6, u6.getFirstName() + u6.getLastName());
        hashTable.put(u7, u7.getFirstName() + u7.getLastName());

        hashTable.printTable();

        User user = new User("Jhon bo");
        System.out.println(hashTable.search(user, user.getFirstName() + user.getLastName(), new NameComparator()));

        hashTable.remove(user, user.getFirstName() + user.getLastName(), new NameComparator());

        System.out.println(hashTable.search(user, user.getFirstName() + user.getLastName(), new NameComparator()));

        HashTable<User> hashTable2 = new HashTable<User>(25);
        User userA = new User("Jhonny123", "football");
        User userB = new User("bagels@gmail", "mom123");
        User userC = new User("mary2003", "maryIsTheBest");
        User userD = new User("kevinA", "Cupertino");
        User userE = new User("SamBAB", "USA987");
        User userF = new User("Bob@gmail.com", "pizza");

        hashTable2.put(userA, userA.getUserName() + userA.getPassword());
        hashTable2.put(userB, userB.getUserName() + userB.getPassword());
        hashTable2.put(userC, userC.getUserName() + userC.getPassword());
        hashTable2.put(userD, userD.getUserName() + userD.getPassword());
        hashTable2.put(userE, userE.getUserName() + userE.getPassword());
        hashTable2.put(userF, userF.getUserName() + userF.getPassword());

        hashTable2.printTable();

    }

}