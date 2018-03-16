
/**
 * Write a description of class ReadData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReadData
{
    static String accountName = "";
    static String dataString = null;
    public static void readData(){
        dataString = MemoryCard.readString();
        while (dataString != null)
        {
            int numOfPosts = 0;
            //hard coded number of post checker one diget
            numOfPosts = Integer.parseInt(dataString.substring(dataString.length()-2, dataString.length()-1));
            accountName = dataString.substring(dataString.indexOf(":") + 2, dataString.indexOf("|"));
            System.out.println(accountName);
            /**for (int x = 0; x < dataString.length()-1; x++){
                accountName = dataString.indexOf(":");
            }
            /**for(int x = 10; x > 0; x--)
            {
            accountName = dataString.substring(0, dataString.indexOf("|"));
            numOfPosts = dataString.substring(dataString.indexOf("|") + 1);
            }**/

            System.out.print(numOfPosts);
            //MemoryCard.writeString("Account Name: " + accountName);
            //dataString = MemoryCard.readString();

        }
    }
    
    public static String getName(){
        return accountName;
    }
    
    public static boolean isEmpty(){
        if (dataString == null){
            return false;
        }
        else{
            return true;
        }
    }
}
