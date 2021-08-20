import java.util.Scanner;

public class digitp{
        public static Scanner scn = new Scanner(System.in);

        public static int countdigit(int n)
        {
                int b=0;
                while(n!=0)
                {
                            n=n/10;
                            b++;
                }
                return b;
        }

        public static void main(String[] args)
        {
                int a;
                int n = scn.nextInt();
                a=countdigit(n);
                System.out.println(a);
        }
}