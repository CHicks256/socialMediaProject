
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
            currentPost = dataString.substring(0, dataString.indexOf("|"));//get all characters in a single post
            p.addPost(currentPost); //adds post to the posts array
            dataString = dataString.substring(dataString.indexOf("|") + 1); //updates the dataString (no infinite loop)
            if (dataString.length() == 0){
                System.out.println(dataString);
                break;
            }
        }
        p.readingData = false;
    }
}
