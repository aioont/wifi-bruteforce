 //https://www.geeksforgeeks.org/generate-passwords-given-character-set/
//https://www.smartprix.com/byte`s/how-to-remove-bloatware-from-realme-xiaomi-and-samsung-phones/

import java.util.*;
import java.io.*;

public class pass {
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
// function generate  
 static void generate(char[] arr, int i, String s, int len)
	{
    //int cnt = 0;
    //String password="";
      if (i ==0)
        {
           // System.out.println(s);
           // cnt++;
          
           try { 
            String data = "";
            File f1 = new File("passwords.txt");
            if(!f1.exists()) 
            {
               f1.createNewFile();
            }
        
            FileWriter fileWritter = new FileWriter(f1.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
             
          bw.write(s+"\n");         
          bw.close();
          //System.out.println("Passwords stored to passwords.txt in current directory");
       
        } 
         catch(IOException e)
         {
            e.printStackTrace();
         }    
      return;
       }
       for (int j = 0; j < len; j++)
            {
			String appended = s + arr[j];
			generate(arr, i - 1, appended, len);
		}
     //System.out.println(cnt + " password generated ");
     System.out.println("Passwords stored to passwords.txt in current directory");	
	return;
	}


static void crack(char[] arr, int len)
	{
   for(int i = 1; i <= len; i++)
		 {
			generate(arr, i, "", len);
		 }
	}
  //class end
}

  
