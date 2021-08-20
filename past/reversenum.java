import java.util.Scanner;
public class reversenum{
        public static Scanner scn = new Scanner (System.in);

        public static void reverse(int n)
        {
                    int res=0;
                    while (n!=0)
                    {
                            res=res*10+ (n%10);
                            n/=10;
                    }
                    System.out.println(res);
        }
        public static void main(String [] agrs){
                            int  n=scn.nextInt();
                            reverse(n);
        }
}