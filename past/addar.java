import java.util.Scanner;
public class addar{
        public static Scanner scn = new Scanner(System.in);
        public static void add(int[] a, int[] b)
        {
                int n1=a.length-1;
                int n2=b.length-1;
                System.out.println(n2);
                int carry=0;
                int x=Math.max(n1,n2);
                int [] c = new int[x+1];
                for(int i=0;i<=x;i++)
                {
                    int sum = carry;
                    if(n1-i>=0)
                        sum+=a[n1-i];
                    if(n2-i>=0)
                    {
                        sum += b[n2-i];
                        System.out.println(b[n2-i]);
                    }
                    carry = sum/10;
                    sum = sum%10;
                    c[c.length-1-i]=sum;
                }
                
                for(int l=0;l<c.length;l++)
                {
                        if(l==0 && c[l]==0)
                            continue;
                        System.out.print(c[l]);
                }

        }
        public static void input(int[] arr)
        {
                for(int i=0;i<arr.length;i++)
                    arr[i]=scn.nextInt();
        }
        public static void main(String[] args)
        {
                int n = scn.nextInt();
                int[] a = new int[n];
                input(a);
                int m=scn.nextInt();
                int[] b= new int[m];
                input(b);
                add(a,b);
        }
}