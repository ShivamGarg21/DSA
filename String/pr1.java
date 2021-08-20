import java.util.Scanner;
public class pr1{
        public static Scanner scn = new Scanner (System.in);
        // public static boolean ispalindrome(String str)
        // {
        //     boolean s;
        //     int si=0,ei=str.length()-1;
        //     while(si<ei)
        //     {
        //             if(str.charAt(si++)==str.charAt(ei--]))
        //                 s=true;
        //             else
        //                 return false;
                    
        //     }
        //     return s;
        // }
        // public static void getallsubstring(String str)
        // {
        //         for(int i=0;i<str.length;i++)
        //             for(len=1;i+len<str.length;len++)
        //             string s = str.substring(i,len+1);
        //         for(int i=0;i<str.length;i++)
        //             System.out.println(s[i]);
        // }
        // 
        // public static void compression(String str)
        // {
        //      //   StringBuilder sb = new StringBuilder();
        //       //  sb.append(str.charAt(0));
        //         int i=1,count=1;

        //         while(i<str.length())
        //         {
        //                 if(i==str.length()-1)
        //                 {
        //                     System.out.print(str.charAt(i-1)+count);
        //                     break;
        //                 }
        //                 if(str.charAt(i)==str.charAt(i-1))
        //                     count++;
        //                 else{
        //                         if(count==1)
        //                             System.out.print(str.charAt(i-1));
        //                         else   
        //                             System.out.print(str.charAt(i-1)+count);
        //                         count=1;
        //                 }
        //                 i++;
        //         }
        // }
        // public static String compression1(String str)
        // {
        //         StringBuilder sb = new StringBuilder();
        //         sb.append(str.charAt(0));
        //         //int count =1;
        //         for(int i=1; i<=str.length();i++)
        //         {
        //                 while(i<str.length() && str.charAt(i)==str.charAt(i-1))
        //                 {
        //                         i++;
        //                        // count++;
        //                 }   
        //           //      if(count!=1) sb.append(count);
        //             //    count=1;
        //                 if(i<str.length())
        //                 sb.append(str.charAt(i)); 
        //         }
        //         return sb.toString();
        // }
        
        public static String toggle(String str)
        {
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<str.length();i++)
                {
                        char ch = str.charAt(i);
                        if(ch>='A' && ch<='Z')
                            sb.append((char)(ch - 'A' + 'a'));
                        else
                            sb.append((char)(ch + 'A' - 'a'));
                }
                return sb.toString();
        }
        public static void main(String[] args)
        {
            String str = scn.nextLine();
            System.out.print(toggle(str));
        }
}