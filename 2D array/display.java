import java.util.Scanner;    
public class display{    
    public static Scanner scn = new Scanner(System.in);

    public static void input (int [][] arr)
    {
            int a= arr.length;
            int b=arr[0].length;
            for(int i=0;i<a;i++)
              for(int j=0;j<b;j++)
                 arr[i][j]=scn.nextInt();
                display1(arr);
    }
    //public static int find()
//     public static void display3 (int [][] arr)
//     {
//             int a= arr.length;
//             int b=arr[0].length;
//             for(int i=0;i<a;i++)
//             {
//               for(int j=i;j<b;j++)
//                  System.out.print(arr[i][j] + " ");
//             System.out.println();
//             }
//     }
    // public static void display(int [][] arr)
    // {
            
    //         for(int[] ar : arr){
    //             for(int e : ar)
    //                 System.out.print(e+" ");
    //             System.out.println();
    //         }

    // }
    // public static void display1(int[][] arr)
    // {
    //     int a= arr.length;
    //     int b=arr[0].length;
    //     int j=0;
    //     for(int i=0;i<a;i++)
    //     {
    //         if(j<b)
    //         {
    //             if(j==-1)
    //                 j++;
    //             while(j<b)
    //             {
    //                  System.out.print(arr[i][j]+" ");
    //                   j++;
    //             }
    //         }
    //         else
    //         {
    //             j--;
    //             while(j>=0)
    //             {
    //                 System.out.print(arr[i][j]+" ");
    //                 j--;
    //             }
    //         }
    //         System.out.println();
    //     }
    // }
    // public static void display2(int[][] arr)
    // {
    //     int a= arr.length;
    //     int b=arr[0].length;
    //     int j=0;
    //     for(int i=0;i<a;i++)
    //     {
    //         if(j<b)
    //         {
    //             if(j==-1)
    //                 j++;
    //             while(j<b)
    //             {
    //                  System.out.print(arr[j][i]+" ");
    //                   j++;
    //             }
    //         }
    //         else
    //         {
    //             j--;
    //             while(j>=0)
    //             {
    //                 System.out.print(arr[j][i]+" ");
    //                 j--;
    //             }
    //         }
    //         System.out.println();
    //     }
    // }
    public static void display1(int[][] arr)
    {
        for(int j=0;j<arr[0].length;j++){
                if(j%2==0)    
                    for(int i=0;i<arr.length;i++){
                        System.out.print(arr[i][j]+" ");
                    }
                else
                for(int i=arr.length-1;i>=0;i--){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
    }
    public static void main(String[] args)
    {
            int n=scn.nextInt();
            int m= scn.nextInt();
            int [][] arr= new int [n][m];
            input (arr); 
    }
}