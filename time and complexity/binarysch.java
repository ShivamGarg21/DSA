import java.util.Scanner;
public class binarysch{
        public static Scanner scn = new Scanner(System.in);
        public static void main(String[] args){
                int n = scn.nextInt();
                int[] arr = new int[n];
                for(int i=0;i<n;i++)
                    arr[i] = scn.nextInt();
                int x = scn.nextInt();
                System.out.print(binarysch(arr,x));
        }
        public static int binarysch(int[] arr, int x){
                int si=0,ei=arr.length-1,mid=0;
                while(si<=ei){
                        mid = (si+ei)/2;
                        if(arr[mid]==x)
                            return mid;
                        else if(arr[mid]<x)
                                si=mid+1;
                        else    ei=mid-1;
                }
             
                if((x-arr[si])<(arr[ei])-x)
                    return ei;
                else    
                    return si;
        }
}