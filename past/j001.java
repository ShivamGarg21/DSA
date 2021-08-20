import java.util.Scanner;
public class j001{
    public static Scanner scn = new Scanner(System.in);

        public static int multiply(int a, int b)
        {
            return a*b;
        }
        public static int add(int a, int b)
        {
                return a+b;
        } 
        public static void tableofn(int n){
                for(int i=1;i<=10;i++)
                    System.out.println(n + "X" + i + "=" + n*i);
        }
        public static void tableuptom(int m)
        {
                for(int i=1;i<=m;i++)
                {
                    tableofn(i);
                    System.out.println(" ");
                }
        }
        public static void oddeven(int n)
        {
                int c=n/2;
                if(n==2*c)
                    System.out.println("even");
                else
                    System.out.println("odd");
        }
        public static boolean isprime(int c)
        {
            for(int i=2;i*i<=c;i++)
            {
                    if(c % i==0)
                        return false;
            }
             return true;
        }
        public static void population(int n)
        {
            for(int i=1; i<=n;i++)
            {
                int c=scn.nextInt();
                if(isprime(c))
                    System.out.println("prime");
                else
                    System.out.println("not prime");

            }

        }

        public static void review(int marks)
        {
                if(marks>90)
                    System.out.println("Excellent");
                else if(marks>80)
                    System.out.println("good");
                else if(marks>70)
                    System.out.println("fair");
                else
                    System.out.println("bad");
        }

        public static void main(String[] args)
        {
        //int a = scn.nextInt();
        //int b = scn.nextInt();

        // System.out.println(multiply(a,b));
        // System.out.println(add(a,b));
        // review(marks);
        int n= scn.nextInt();
        population(n);
        
        }
}