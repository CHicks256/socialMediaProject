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
    static scanner sc = new scanner(); //user input
    //object delcaration
    static Post p = new Post();
    static MemoryCard m = new MemoryCard();
    static ReadData r = new ReadData();
    //variables
    static String name = ""; //sets name to blank string
    static int postID; //holds post's Id
    static int loginAttempts = 0; //checks number of login attempts
    static boolean readingData = false; /**You will need this for parts of the program**/

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
                // options();
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
     * Removes post with a specific id. Id is subtracted by one to match up with array indexing.
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
        posts.add(p); //adds user string input to application
        /**
         * System.out.print(posts.get(postID) + "                  Post ID: " + (postID + 1));//fancy print out
         * Not needed as it makes UI look messy. Keep in if you want or you can take it out and have the addition of posts run in the background.
         */

        /**
         * Implement code to add posts from text file in the background if it is being read. hint: use !readingData
         */
        System.out.println("Your post has been added successfully!"); //displays every time a post is added
    } 

    //refresh feed
    public static void refresh(){
        /**
         * Implement code to show message: "There is nothing to see here" if there are no postsinstead of printing ---Feed--- and a blank feed.
         */
        System.out.println("---Feed---");
        for (String i: posts){
            int currentID = posts.indexOf(i) + 1;
            System.out.println("Name: " + name + "          Post ID: " + currentID + "\n" + i );
            //System.out.println("ID: " + (currentID) + " Posts Size: " + posts.size()); //Debug code
            if (currentID != posts.size()){
                System.out.println("-----------------");
            }
        } 
    }

    //quit
    public static void quit(){
        for (String i: posts){
            /**
             * Implement code to not duplicate posts within the text file. hint: use the dataString variable from readData to check for post.
             */
            m.writeString(i);
        }
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
        System.out.println("Welcome to Get A Life");
        while (name.equals("") || loginAttempts != 0){
            System.out.print("Enter a username: ");
            name = sc.getString();
            name = name.toLowerCase();
            m.changeFileName(name);
            p.changeUser(name);
            /**
             * Implement code to read user file.
             */
        }
    }
}
