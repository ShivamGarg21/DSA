public class practicehs{
    public static Scanner scn = new Scanner(System.in);
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void downheapify(int[] arr, int pi, int size){
        int mididx = pi;
        int lc = 2*pi + 1;
        int rc = 2*pi + 2;

        if(lc<size && arr[lc]>arr[mididx])
            mididx = lc;
        if(rc<size && arr[rc]>arr[mididx])
            mididx = rc;
        while(mididx!=pi){
            swap(arr,mididx,pi);
            downheapify(arr,mididx,li);
        }
    }
    public static void main(String[] args){
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scn.nextInt();
        int k = scn.nextInt();
        for(int i=n-1;i>=0;i++)
            downheapify(arr,0,n-1);
        int size = n-1;
        while(k>1){
            swap(arr,0,size--);
            downheapify(arr,0,size);
            k--;
        }
    }
}