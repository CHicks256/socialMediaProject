import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class SocialMediaTest here.
 *
 * @author Zach, Christain, Chris, Darlin
 * @version 3.19.18 What am I even doing anymore?
 */
public class SocialMediaTest
{
    static String choice;
    static String post;
    static boolean inProgress = true;
    //Object Declaration
    static Post p = new Post();
    static Scanner user = new Scanner(System.in);
    static ReadData d = new ReadData();
    static MemoryCard m = new MemoryCard();

    /**
     * Adds items to ArrayLists. 
     */
    public static void addItems(){
        //sets up all arraylists
        p.accounts.add("zach");
        p.accounts.add("christian");
        p.accounts.add("chris");
        p.accounts.add("darlin");
        p.choices.add("add post");
        p.choices.add("remove post");
        p.choices.add("refresh feed");
        p.choices.add("switch user");
        p.choices.add("quit");
    }

    /**
     * Controls user options.
     */
    public static void menu(){
        while (inProgress){
            p.options();
            choice = user.nextLine();
            if (choice.equalsIgnoreCase("add post")){
                System.out.println("---Posting---");
                System.out.println("What do you want to tell the world? Type 'Cancel' to go back to menu.");
                post = user.nextLine();
                if (!post.equalsIgnoreCase("Cancel")){
                    p.addPost(post);
                }
            }
            else if (choice.equalsIgnoreCase("remove post")){
                System.out.println("---Deleting---");
                System.out.println("What post doesn't meet your expectations? Type '000' to go back to menu.");
                choice = user.nextLine();
                int index = Integer.parseInt(choice);
                if (index != 000){
                    p.removePost(index);
                }
            }

            else if (choice.equalsIgnoreCase("refresh feed")){
                p.refresh();
            }
            else if (choice.equalsIgnoreCase("switch user")){
                System.out.println("---Change User---");
                System.out.println("Which account would you like to change to? Type 'Cancel' to go back to menu.");
                choice = user.nextLine();
                if (!choice.equalsIgnoreCase("Cancel")){
                    for (String i: p.posts){
                        if(d.dataString == null || !d.dataString.contains(i)){
                            m.writeString(i + "~" + p.dates.get(p.posts.indexOf(i)));
                        }
                    }
                    m.saveAndClose(); //saves text file
                    p.changeUser(choice);
                    p.posts = new ArrayList<String>();
                    p.dates = new ArrayList<String>();
                    p.setUp(); //re-sets up application for switched user
                    d.readData();
                }
            }
            else if (choice.equalsIgnoreCase("quit")){
                System.out.print("Are you sure you want to quit? ");
                choice = user.nextLine();
                if(choice.equalsIgnoreCase("yes")){
                    p.quit();
                    inProgress = false;
                }
            }
            else{
                System.out.println("You cannot do that, please only perform actions that you are allowed to do.");
            }
        }
    }

    /**
     * Main Method used to run program.
     */
    public static void main(){
        addItems(); //adds items to arraylists
        p.setUp(); //sets up program
        d.readData(); //reads data file
        menu();
    }
}
