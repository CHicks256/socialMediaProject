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
    static String name;
    //change user
    public static void changeUser(String n){
        name = n;
        boolean pass = false;
        while (!pass){
            for (Object i: accounts){
                //check if username is in the system
                if (i.equals(name)){
                    System.out.println("Account Name: " + name);
                }
            }
        }
    }

    //remove
    public static void removePost(int id){
        int postID = id;
    }

    //add
    public static void addPost(String p){
        posts.add(p);
        int postID = posts.size() - 1;
        System.out.print(posts.get(postID));
    }

    //quit
    public static void quit(){

    }

    public static void setUp(){
        Post p = new Post();
        //sets up all arraylists
        accounts.add("zach");
        accounts.add("chistian");
        accounts.add("chris");
        accounts.add("darlin");
        choices.add("add post");
        choices.add("remove post");
        choices.add("switch account");
        choices.add("quit");

        System.out.print("*Awesome animation*\nWelcome to the app. Please enter your account name:  " );
        name = sc.getString();
        name = name.toLowerCase();
        p.changeUser(name);
        System.out.print("Welcome back " + name + ", would you like to:\n");
        for (String i: choices){
            System.out.println(i.substring(0,1).toUpperCase() + i.substring(1));
        }
    }
}
