import java.util.Scanner;
public class l00ar{
    public static Scanner scn = new Scanner(System.in);

    public static void max(int[] arr)
    {   
            int temp=arr[0];
            for(int i=0;i<arr.length;i++)
            {
                    if(arr[i]>=temp)
                        temp=arr[i];
            }
            System.out.println(temp);
    }
    public static void input(int[] arr)
    {
            for(int i=0;i<arr.length;i++)
                arr[i] =scn.nextInt();
    }

    public static int find(int [] arr,int b)
    {
            for(int i=0;i<arr.length;i++)
            {
                    if(arr[i]==b)
                        return i;
            }
            return -1;
    }

    public static void main(String[] args)
    {
        int i;    
        int n=scn.nextInt();
        int[] arr = new int[n];
        input(arr);
        int b = scn.nextInt();
        System.out.print(find(arr,b));
    }
}