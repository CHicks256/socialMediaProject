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
    static ArrayList<Object>accounts = new ArrayList<Object>(); //holds accounts, ease of use
    static ArrayList<String>posts = new ArrayList<String>(); //holds posts
    static scanner sc = new scanner();
    static MemoryCard m = new MemoryCard();
    static String name;
    static int postID;
    //change user
    public static void changeUser(String n){
        name = n;
        m.writeString("Account name: "+ name);

        for (Object i: accounts){
            if (i.equals(name)){
                System.out.println("Account Name: " + name);
            }
        }
    }

    //remove
    public static void removePost(int id){
        postID = id; //sets post ID to be deleted by user
        posts.remove(postID - 1);
        System.out.println("Your post has been removed."); //comfirmation that post has been deleted
    }

    //add
    public static void addPost(String p){
        posts.add(p); //adds user string input to application
        m.writeString(p);
        postID = posts.size() - 1; //sets id to most recent
        System.out.print(posts.get(postID) + "                  Post ID: " + postID + 1);//fancy print out
    }

    //refresh feed
    public static void refresh(){
        for (String i: posts){
            int currentID = posts.indexOf(i) + 1;
            System.out.println("Name: " + name + "          Post ID: " + currentID + "\n" + i);
        }
    }

    //quit
    public static void quit(){
        m.writeString(String.valueOf(postID));
        m.saveAndClose();
        System.out.println("*Cool closing animation*\nThanks for using Get A Life.");//quit screen
    }

    //sets up platform
    public static void setUp(){
        Post p = new Post();
        //sets up all arraylists
        accounts.add("zach");
        accounts.add("chistian");
        accounts.add("chris");
        accounts.add("darlin");
        choices.add("add post");
        choices.add("remove post");
        choices.add("refresh feed");
        choices.add("switch user");
        choices.add("quit");
        //reading data file
        System.out.println("Reading System Data: Please Wait");
        ReadData.readData();
        if (ReadData.isEmpty()){
            name = ReadData.getName();
            System.out.println("Account Found: " + name);
        }
        else{
            name = "";
            System.out.print("*Awesome animation*\nWelcome to Get A Life.\nPlease enter your account name:  " );
        }
        while (name.equals("")){
            name = sc.getString();
            name = name.toLowerCase();
            p.changeUser(name);
        }
        System.out.print("Welcome back " + name + ", would you like to:\n");
        for (String i: choices){
            System.out.println(i.substring(0,1).toUpperCase() + i.substring(1));
        }
    }
}
