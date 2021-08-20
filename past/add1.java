import java.util.Scanner;
  
  public class add1{
      public static int getSum(int b, int n1, int n2)
      {
         // write ur code here
              int sum=0,ld,cr=0,res=0,pwr=1;
                  while(n1!=0 || n2!=0 || cr!=0)
                {
                        sum = n1%10 + n2%10 +cr; 
                        n1/=10;
                        n2/=10;
                        cr=sum/b;
                        ld=sum%b;
                        res+=ld * pwr;
                        pwr *=10;
                }
                return res;
      }
      public static void main(String[] args) {
                  Scanner scn = new Scanner(System.in);
                  int b = scn.nextInt();
                  int n1 = scn.nextInt();
                  int n2 = scn.nextInt();
              
                  int d = getSum(b, n1, n2);
                  System.out.println(d);
               }
}