import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class SocialMediaTest here.
 *
 * @author Zach, Christain, Chris, Darlin
 * @version 3.19.18 Home Stretch
 */
public class SocialMediaTest
{
    static String choice;
    static String post;
    static boolean inProgress = true;
    static Post p = new Post();

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

    public static void main(){
        Scanner user = new Scanner(System.in);
        ReadData d = new ReadData();
        addItems();
        p.setUp(); //sets up program
        d.readData();
        while (inProgress){
            p.options();
            choice = user.nextLine();
            if (choice.equalsIgnoreCase("add post")){
                System.out.println("---Posting---");
                System.out.println("What do you want to tell the world?");
                post = user.nextLine();
                if (!post.equalsIgnoreCase("Cancel")){
                    p.addPost(post);
                }
            }
            else if (choice.equalsIgnoreCase("remove post")){
                System.out.println("---Deleting---");
                System.out.println("What post doesn't meet your expectations?");
                int index = user.nextInt();
                if (index != 000){
                    p.removePost(index);
                }
            }

            else if (choice.equalsIgnoreCase("refresh feed")){
                p.refresh();
            }
            else if (choice.equalsIgnoreCase("switch user")){
                System.out.println("---Change User---");
                System.out.print("Which account would you like to change to?");
                choice = user.nextLine();
                p.changeUser(choice);
                /**Implement code to delete posts from current posts array**/
                p.setUp(); //re-sets up application for switched user
            }
            else if (choice.equalsIgnoreCase("quit")){
                p.quit();
                inProgress = false;
            }
            else{
                System.out.println("You cannot do that, please only perform actions that you are allowed to do.");
            }
        }

    }
}
