//https://www.geeksforgeeks.org/generate-passwords-given-character-set/
//https://www.smartprix.com/byte`s/how-to-remove-bloatware-from-realme-xiaomi-and-samsung-phones/

import java.util.*;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


class Main {
public static void main(String args[]) {
  
  String appended,str;
 
 // char str[] = new char[94]; 
  Scanner sn = new Scanner(System.in);
  System.out.println("Enter character (a-Z , 0-9 , ~-) : ");
  str=sn.next();

  char[] arr = str.toCharArray();
          
  int len=arr.length; 
  crack(arr, len);
	}

 static void generate(char[] arr, int i, String s, int len)
	{
	 if (i == 0)
		{
             try {
                 File myObj = new File("password.txt");
                 if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                 myWriter.write(s);
                 myWriter.close();
                  } else {
                    System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
			System.out.println(i);
			return;
		}
       for (int j = 0; j < len; j++)
            {
			String appended = s + arr[j];
			generate(arr, i - 1, appended, len);
		}

		return;
	}


static void crack(char[] arr, int len)
	{
      for (int i = 1; i <= len; i++)
		{
			generate(arr, i, "", len);
		}
	}
}

  
