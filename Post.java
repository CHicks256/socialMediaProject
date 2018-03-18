import java.util.Scanner;
import java.util.ArrayList;
/**
 * add posts, delete posts, switch accounts, and quit app.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Post
{
    static ArrayList<String>choices = new ArrayList<String>(); //holds choices, shortens code
    static ArrayList<String>accounts = new ArrayList<String>(); //holds accounts, ease of use
    static ArrayList<String>posts = new ArrayList<String>(); //holds posts
    static scanner sc = new scanner();
    static Post p = new Post();
    static MemoryCard m = new MemoryCard();
    static ReadData r = new ReadData();
    static String name = "";
    static int postID;
    static int loginAttempts = 0;
    static boolean inSystem = false;
    //change user
    public static void changeUser(String n){
        int index = 0;
        boolean checking = true;
        name = n;
        m.changeFileName(name);
        System.out.println(accounts);
        while (checking){

            if (name.equals(accounts.get(0))||name.equals(accounts.get(1))||name.equals(accounts.get(2))||name.equals(accounts.get(3))){
                System.out.println("Account Name: " + name);
                loginAttempts = 0;
                checking = false;
                inSystem = true;
                System.out.print("Welcome back " + name + ", would you like to:\n");
                options();
                break;
            }
            // System.out.println("Checking: " + name.compareTo(accounts.get(index)));
            index++;

            loginAttempts++;
            if (loginAttempts == 3){
                System.out.println("You have exceded the number of login attempts.");
                System.exit(0);
            }
            else{
                System.out.println("There is no user with the account name " + name + " please try again.");
            }
            checking = false;
        }
    }

    //remove
    public static void removePost(int id){
        postID = id; //sets post ID to be deleted by user
        posts.remove(postID - 1);
        System.out.println(posts);
        System.out.println("Your post has been removed."); //comfirmation that post has been deleted
        options();
    }

    //add
    public static void addPost(String p){
        posts.add(p); //adds user string input to application
        m.writeString(p); //writes post to text file
        postID = posts.size() - 1; //sets id to most recent
        System.out.print(posts.get(postID) + "                  Post ID: " + (postID + 1));//fancy print out
        System.out.println(" ");
        options();
    } 

    //refresh feed
    public static void refresh(){
        for (String i: posts){
            int currentID = posts.indexOf(i) + 1;
            System.out.println("Name: " + name + "          Post ID: " + currentID + "\n" + i);
        } 
        options();
    }

    //quit
    public static void quit(){
        m.saveAndClose(); //saves text file
        System.out.println("*Cool closing animation*\nThanks for using Get A Life."); //quit screen
        System.exit(0); 
    }
    //options
    public static void options(){
        System.out.println("\n----Options----");
        for (String i: choices){
                    System.out.println(i.substring(0,1).toUpperCase() + i.substring(1));
               }
    }
    //sets up platform
    public static void setUp(){
        //sets up all arraylists
        accounts.add("zach");
        accounts.add("christian");
        accounts.add("chris");
        accounts.add("darlin");
        choices.add("add post");
        choices.add("remove post");
        choices.add("refresh feed");
        choices.add("switch user");
        choices.add("quit");

        System.out.println("Welcome to Get A Life");
        while (name.equals("") || loginAttempts != 0){
            System.out.print("Enter a username: ");
            name = sc.getString();
            name = name.toLowerCase();
            m.changeFileName(name);
            p.changeUser(name);
        }
    }
}
