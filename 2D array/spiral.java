import java.util.Scanner;
public class spiral{
        public static Scanner scn = new Scanner(System.in);

        // public static void spiral(int [][] arr)
        // {
        //         int n=arr.length;
        //         int m=arr[0].length;
        //         int dir=0,i=0,j=0;
        //         while(true)
        //         {
        //                 dir=(dir+arr[i][j])%4;
        //                 if(dir==0)
        //                 {
        //                     j++;
        //                     if(j==m)
        //                     {
        //                         System.out.print(i+"\n"+--j);
        //                         break;
        //                     }
        //                 }
        //                 else if(dir==1)
        //                 {
        //                     i++;
        //                     if(i==n)
        //                     {
        //                         System.out.print(--i+"\n"+j);
        //                         break;
        //                     }
        //                 }
        //                 else if(dir==2)
        //                 {
        //                     j--;
        //                     if(j==-1)
        //                     {
        //                         System.out.print(i+"\n"+--j);
        //                         break;
        //                     }
        //                 }
        //                 else
        //                 {
        //                     i--;
        //                     if(i==-1)
        //                     {
        //                         System.out.print(--i+"\n"+j);
        //                         break;
        //                     }
        //                 }
        //         }
        //     }
        public static void spiral1(int[][] arr)
        {
                
        }

        public static void main(String[] args)
        {
                int n=scn.nextInt();
                int m = scn.nextInt();
                int[][] arr = new int [n][m];
                
                for(int i=0;i<arr.length;i++)
                    for(int j=0;j<arr[0].length;j++)
                         arr[i][j] = scn.nextInt();


                spiral1(arr);
        }
}