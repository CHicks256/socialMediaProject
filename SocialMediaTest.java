import java.util.Scanner;
/**
 * Write a description of class SocialMediaTest here.
 *
 * @author Zach, Christain, Chris, Darlin
 * @version 3.15.18 socialPlatform getALife = new socialPlatform();
 */
public class SocialMediaTest
{
    static String choice;
    static String post;
    static boolean inProgress = true;
    public static void main(){
        Post p = new Post();
        Scanner user = new Scanner(System.in);
        ReadData d = new ReadData();
        d.readData();
        p.setUp();
        while (inProgress){
            choice = user.nextLine();
            if (choice.equalsIgnoreCase("add post")){
                System.out.println("What do you want to tell the world?");
                post = user.nextLine();
                p.addPost(post);
            }
            else if (choice.equalsIgnoreCase("remove post")){
                System.out.println("What post doesn't meet your expectations?");
                post = user.nextLine();
            }
            else if (choice.equalsIgnoreCase("refresh feed")){
                p.refresh();
            }
            else if (choice.equalsIgnoreCase("switch user")){
                System.out.print("Which account would you like to change to?");
                choice = user.nextLine();
                p.changeUser(choice);
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
