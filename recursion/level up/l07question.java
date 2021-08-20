import java.util.ArrayList;
public class l07question{
    // public static void subset(int[] main, boolean[] vis,int a,int b){
        
    //     for(int i=0;i<main.length;i++){
    //         if()
    //     }
    // }


    public static void kSubsetEqualSum(int[] arr , int target, boolean[] vis, boolean[] repeat,ArrayList<Integer> set, ArrayList<ArrayList<Integer>> ans){
        if(target == 0){
            ArrayList<Integer> base = new ArrayList<>(set);
            ans.add(base);
            for(int i=0;i<arr.length;i++)
            repeat[i] = vis[i];
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            if(!vis[i]){
                vis[i] = true;
                set.add(arr[i]);
                kSubsetEqualSum(arr,target-arr[i],vis,repeat,set,ans);
                set.remove(set.size()-1);
                vis[i] = false;
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> kSubsetEqualSum(int[] arr, int k){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> set = new ArrayList<>();
        int sum = 0;
        for(int ele : arr){
            sum += ele;
        }
        if(sum%k != 0 || arr.length < k){
            return ans;
        }
        int target = sum/k;
        boolean[] vis = new boolean[arr.length];
        boolean[] repeat = new boolean[arr.length];
        for(int i=0;i<k;i++){
            for(int j=0;j<arr.length;j++)
            vis[j] = repeat[j];
            kSubsetEqualSum(arr,target,vis,repeat,set,ans);
        }
        return ans;
    }
    
    public static void main(String[] args){
            int[] arr = {1,2,3,4,5,6};
            System.out.println(kSubsetEqualSum(arr,3));
    }
}