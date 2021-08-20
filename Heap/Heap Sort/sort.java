import java.util.Scanner;
public class sort{
    //public static int size;
    public static void swap(int[]arr,int si, int ei){
        int se = arr[si];
        arr[si] = arr[ei];
        arr[ei] = se;
    }

    // public static int[] remove(int[] arr){
    //     int n = arr.length;
    //     //int rv = arr[0];
    //     swap(arr,0,n-1);
    //     downheapify(arr,0);
    //     size--;
    //     return arr;
    // }


    // public static void heapify(int[] arr, int pi, int size){
    //     for(int i=arr.length-1;i>=0;i--)
    //         downheapify(arr,pi);
    //         this.size = arr.length;
        
    //     for(int i=0;i<arr.length;i++)
    //        arr =  remove(arr);
    //     for(int i=0;i<arr.length;i++)
    //         System.out.println(arr[i]);
        
    // }

    public static void heapify(int[] arr, int pi,int lc){
        int maxidx = pi;
        int li = 2*pi+1;
        int ri = 2*pi+2;
        if(li<lc && arr[li]>arr[maxidx])
            maxidx = li;
        if(ri<lc && arr[ri]>arr[maxidx])
            maxidx = ri;
        if(maxidx!=pi){
            swap(arr,pi,maxidx);
            heapify(arr,maxidx,lc);
        }
    }
    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+ " ");
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scn.nextInt();
        for(int i=arr.length-1;i>=0;i--)
            heapify(arr,0,n);
        int li = n-1;
        while(li>=0){
            swap(arr,0,li--);
            heapify(arr,0,li);
        }
        display(arr);
    }
}