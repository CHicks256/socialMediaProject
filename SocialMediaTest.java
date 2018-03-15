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
    public static void main(){
        Post p = new Post();
        Scanner user = new Scanner(System.in);
        p.setUp();
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

    }
}
