import java.util.Scanner;

public class pattern01{
        public static Scanner scn = new Scanner (System.in);

        public static void pattern(int n)
        {
                int j;
                for (int i=1;i<=n;i++)
                {
                        for (j=1;j<=n-i;j++)
                        {
                            System.out.print("\t");
                        }
                        while(j<=n)
                        {
                            System.out.print("*\t");
                            j++;
                        }
                        System.out.println();
                }
        }
        public static void main(String[] args)
        {
                int n= scn.nextInt();
                pattern(n);
        }
}