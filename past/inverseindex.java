import java.util.Scanner;

public class inverseindex{
        public static Scanner scn = new Scanner(System.in);

        public static int count(int n)
        {
                int count=0;
                while(n!=0)
                {
                        n/=10; 
                        count++;
                }
                return count;
        }
        public static void inverse(int n)
        {
                int len=count(n);
                int res=0;
                int a = len;
                int num;
                for (int j=1;j<=len;j++)
                {
                        int x=n;
                        for(int i=len;i>=1;i--)
                        {
                                num=x%10;
                                x/=10;
                                if(num==a)
                                    res = res*10 + (len-i+1);
                        }
                        a--;
                }
                System.out.println(res);
        }
        public static void main(String[] args)
        {
                int n=scn.nextInt();
                inverse(n);
        }
}