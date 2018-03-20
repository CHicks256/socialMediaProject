import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
/**
 * Write a description of class ReadData here.
 *
 * @author Zach, Christian, Chris, Darlin
 * @version 3.19.18 Reinventing the memory card
 */
public class ReadData
{
    static Post p = new Post();
    static String dataString = null;
    static String currentPost = "";
    /**
     * Reads user's data if any.
     */
    public static void readData(){
        p.readingData = true;
        dataString = MemoryCard.readString(); //gets string value in file
        while (dataString != null)
        {
            System.out.println(dataString);
            String temp = dataString.substring(0, dataString.indexOf("|"));
            //date = substring ~ + 1 to |
            currentPost = temp.substring(0, temp.indexOf("~"));//get all characters in a single post
            temp = temp.substring(temp.indexOf("~") + 1);
            p.addPost(currentPost); //adds post to the posts array
            p.dates.add(temp);
            dataString = dataString.substring(dataString.indexOf("|") + 1); //updates the dataString (no infinite loop)
            if (dataString.length() == 0){
                System.out.println(dataString);
                break;
            }
        }
        p.readingData = false;
    }
}
