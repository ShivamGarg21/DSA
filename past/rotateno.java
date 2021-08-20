import java.util.Scanner;
public class rotateno{
        public static Scanner scn = new Scanner (System.in);

        public static int len(int n)
        {
                int len=0;
                while(n!=0)
                {
                        n=n/10;
                        len++;
                }
                return len;
        }
        public static void rotate(int n, int r)
        {
                int len=len(n);
                r%=len;
                if(r<0)
                    r+=len;
                int move=1;
                int stay=1;
                for (int i=1;i<=len;i++)
                {
                        if(i<=r)
                                move *= 10;
                        else 
                        stay *=10;
                }
                int a=n%move;
                int b=n/move;
                int res=a*stay+b;
                System.out.println(res);
        }
        public static void main (String[] args)
        {
                int n=scn.nextInt();
                int r=scn.nextInt();
                rotate(n,r);
        }
}