import java.util.Scanner;
import java.util.ArrayList;
/**
 * add posts, delete posts, switch accounts, and quit app.
 *
 * @author Zach, Christian, Chris, Darlin
 * @version 3.19.18 Meat and Potatoes
 */
public class Post
{
    static ArrayList<String>choices = new ArrayList<String>(); //holds choices, shortens code
    static ArrayList<String>accounts = new ArrayList<String>(); //holds accounts, ease of use
    static ArrayList<String>posts = new ArrayList<String>(); //holds posts
    static Scanner sc = new Scanner(System.in); //user input
    //object delcaration
    static Post p = new Post();
    static MemoryCard m = new MemoryCard();
    static ReadData r = new ReadData();
    //variables
    static String name = ""; //sets name to blank string
    static int postID; //holds post's Id
    static int loginAttempts = 0; //checks number of login attempts
    static boolean readingData = false;
    static int spamCount = 0;

    /**
     * Changes user to user input if in the system. Each player has file that corresponds to their name. 
     * If no file is found then an error will be thrown saying that there is no file by that name, this is ok as the program will still run.
     */
    public static void changeUser(String n){
        int index = 0;
        boolean checking = true;
        name = n;
        m.changeFileName(name);//changes file name to username
        //System.out.println(accounts); //Debug Code
        while (checking){
            if (name.equals(accounts.get(0))||name.equals(accounts.get(1))||name.equals(accounts.get(2))||name.equals(accounts.get(3))){
                System.out.println("Account Name: " + name);
                loginAttempts = 0;
                checking = false;
                System.out.print("Welcome back " + name + ", would you like to:\n");
                break;
            }
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

    /**
     * Removes post with a specific ID. ID is subtracted by one to match up with array indexing.
     */
    public static void removePost(int id){
        postID = id; //sets post ID to be deleted by user
        posts.remove(postID - 1);
        //System.out.println(posts); //debug code
        System.out.println("Your post has been removed."); //comfirmation that post has been deleted
    }

    /**
     * Adds post to posts ArrayList.
     */
    public static void addPost(String p){
        if(!readingData){
            if (posts.size() == 0 || !posts.get(posts.size() - 1).equalsIgnoreCase(p) && !posts.get(posts.size() - 2).equalsIgnoreCase(p)){
                posts.add(p); //adds user string input to application
                System.out.println("Your post has been added successfully!"); //displays every time a post is added
                spamCount = 0;
            }
            else{
                System.out.println("Your post has not been added. You have already made that post within your last two posts. It's not cool to spam people.");
                spamCount++;
                
                if (spamCount == 3){
                    System.out.println("Didn't I tell you that it is not nice to spam!? Let's see how you like getting spammed!");
                    for (int x = 0; x <= name.length(); x++){
                        System.out.println("HOW DO YOU LIKE BEING SPAMMED, HUH? SSSSSSPPPPPPAAAAMMMMM!!!!!!");
                    }
                    System.out.println("System.Error: Code 406: Not Acceptable");
                    System.exit(0);
                }
            }
        }
    } 

    /**
     * Refreshes feed. Displays all posts made by the user in a clean way.
     */
    public static void refresh(){
        System.out.println("---Feed---");
        if (posts.size() == 0){
            System.out.println("There is nothing to see here. Add a post to liven up your feed!");
        }
        else{
            for (String i: posts){
                int currentID = posts.indexOf(i) + 1;
                System.out.println("Name: " + name + "          Post ID: " + currentID + "\n" + i );
                //System.out.println("ID: " + (currentID) + " Posts Size: " + posts.size()); //Debug code
                if (currentID != posts.size()){
                    System.out.println("-----------------");
                }
            } 
        }
    }

    /**
     * Saves posts to user's file with no duplications in them before quiting the program.
     */
    public static void quit(){
        for (String i: posts){
            if(r.dataString == null || !r.dataString.contains(i)){
                m.writeString(i);
            }
        }
        m.saveAndClose(); //saves text file
        System.out.println("*Cool closing animation*\nThanks for using Get A Life."); //quit screen
        System.exit(0); 
    }

    /**
     * Displays options.
     */
    public static void options(){
        System.out.println("\n----Options----");
        for (String i: choices){
            System.out.println(i.substring(0,1).toUpperCase() + i.substring(1));
        }
    }

    /**
     * Sets up main program by getting a name, checking the system, and reading the user's data if any.
     */
    public static void setUp(){
        System.out.println("Welcome to Get A Life");
        while (name.equals("") || loginAttempts != 0){
            System.out.print("Enter a username: ");
            name = sc.nextLine();//getString();
            name = name.toLowerCase();
            m.changeFileName(name);
            p.changeUser(name);
            r.readData();
        }
    }
}
