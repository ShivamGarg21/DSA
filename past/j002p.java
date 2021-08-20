import java.util.Scanner;
public class j002p{
    public static Scanner scn= new Scanner(System.in);
    public static boolean isprime(int n)
    {
        for (int i=2;i*i<=n;i++)
        {
            if(n%i==0)
                    return false;
        }
        return true;
    }
    public static void number()
    {
            int low = scn.nextInt();
            int high = scn.nextInt();
            for (int i=low;i<=high;i++)
            {
                    if(isprime(i))
                            System.out.println(i);
            }
    }
    public static void main(String[] args)
    {
            number();
    }
}