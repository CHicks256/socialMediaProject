
/**
 * Write a description of class ReadData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReadData
{
    static Post p = new Post();
    static String dataString = null;
    static String currentPost = "";
    public static void readData(){
        dataString = MemoryCard.readString(); //gets string value in file
        while (dataString != null)
        {
            currentPost = dataString.substring(0, dataString.indexOf("|"));//get all characters in a single post
            p.addPost(currentPost); //adds post to the posts array
            dataString = dataString.substring(dataString.indexOf("|") + 1); //updates the dataString (no infinite loop)
        }
        MemoryCard.writeString("");
    }
}
