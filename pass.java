import java.util.*;
import java.io.*;

public class pass {
   static int count = 0;
   public static void main(String args[]) {

      String appended, str;
      Scanner sn = new Scanner(System.in);
      System.out.println("!!! If there is passwords.txt in same folder of program remove it to avoid appending of new passwords to prevoius passwords.txt file");
      System.out.print(">>>   Enter character (a-Z , 0-9 , ~-) : ");
      str = sn.next();

      char[] arr = str.toCharArray();

      int len = arr.length;
      crack(arr, len);
   }
   // function generate
   static void generate(char[] arr, int i, String s, int len) {
      if (i == 0) {
         count++;

         try {
            String data = "";
            File f1 = new File("passwords.txt");
            if (!f1.exists()) {
               f1.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(f1.getName(), true);
            BufferedWriter bw = new BufferedWriter(fileWritter);

            bw.write(s + "\n");
            bw.close();

         } catch (IOException e) {
            e.printStackTrace();
         }
         return;
      }
      for (int j = 0; j < len; j++) {
         String appended = s + arr[j];
         generate(arr, i - 1, appended, len);
      }
      return;
   }

   // function crack
   static void crack(char[] arr, int len) {

      for (int i = 1; i <= len; i++) {
         generate(arr, i, "", len);
      }
      System.out.println("[ " + count + " ]   passwords are generated and saved to passwords.txt ");
   }
   // class end
}