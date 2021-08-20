public class l02recusiontree{
    public static int permutation_infi_coin(int[] arr, int target, String ans){
        if(target == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int num : arr){
            if(target - num >=0)
                count += permutation_infi_coin(arr,target - num,ans + num + " ");
        }
        return count;
    }

    public static int combination_infi_coin_helper(int[] arr, int idx, int target, String ans){
        if(target == 0){
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        for(int i = idx; i<arr.length;i++){
            if(target - arr[i] >= 0)
                count += combination_infi_coin_helper(arr,i,target-arr[i],ans + arr[i]);
        }
        return count;
    }

    public static int combination_infi_coin(int[] arr, int target, String ans){
        return combination_infi_coin_helper(arr, 0,target, ans);
    }

    public static int permutation_single_coin_helper(int[] arr, boolean[] vis, int target, String ans){
        if(target == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = 0; i<arr.length;i++){
            if(target-arr[i]>=0 && !vis[i]){
                vis[i] = true;
                count += permutation_single_coin_helper(arr,vis,target-arr[i],ans + arr[i]);
                vis[i] = false;
            }
        }
        return count;

    }

    public static int permutation_single_coin(int[] arr, int target, String ans){
        boolean[] vis = new boolean[arr.length];
        return permutation_single_coin_helper(arr,vis,target,ans);
    }

     public static int combination_single_coin_helper(int[] arr, int idx, int target, String ans){
        if(target == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = idx; i<arr.length;i++){
            if(target-arr[i]>=0){
                //vis[i] = true;
                count += combination_single_coin_helper(arr,i+1,target-arr[i],ans + arr[i]);
                //vis[i] = false;
            }
        }
        return count;

    }

    public static int combination_single_coin(int[] arr, int target, String ans){
        return combination_single_coin_helper(arr,0,target,ans);
    }

    public static int permutation_infi_coin_subseq(int[] arr, int idx, int target, String ans){
        if(target == 0 || idx == arr.length){
            if(target == 0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if(target - arr[idx] >= 0)
            count += permutation_infi_coin_subseq(arr, 0, target-arr[idx], ans + arr[idx]);
            
        count += permutation_infi_coin_subseq(arr, idx + 1, target, ans);
        return count;
    }

    public static int permutation_single_coin_subseq_helper(int[] arr, int idx, boolean[] vis, int target, String ans){
        if(target == 0 || idx == arr.length){
            if(target == 0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if(target - arr[idx] >= 0 &&  !vis[idx]){
            vis[idx] = true;
            count += permutation_single_coin_subseq_helper(arr, 0, vis,target-arr[idx], ans + arr[idx]);
            vis[idx] = false;
        }  
        count += permutation_single_coin_subseq_helper(arr, idx + 1,vis, target, ans);
        return count;
    }

    public static int permutation_single_coin_subseq(int[] arr, int idx, int target, String ans){
        boolean[] vis = new boolean[arr.length];
        return permutation_single_coin_subseq_helper(arr,0,vis,target,ans);
    }

    public static int combination_infi_coin_subseq(int[] arr, int idx, int target, String ans){
        if(target == 0 || idx == arr.length){
            if(target == 0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if(target - arr[idx] >= 0)
            count += combination_infi_coin_subseq(arr, idx, target - arr[idx], ans + arr[idx]);
        count += combination_infi_coin_subseq(arr, idx+1, target, ans);
        return count;
    }

    public static int combination_single_coin_subseq(int[] arr,int idx,int target, String ans){
        if(target == 0 || idx == arr.length){
            if(target == 0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if(target - arr[idx] >= 0)
            count += combination_single_coin_subseq(arr,idx+1,target-arr[idx],ans+arr[idx]);
        count += combination_single_coin_subseq(arr,idx+1,target,ans);    
        return count;
    }

    //======== Queen's sitting ==========================================================

    public static int combinationqueenset(int totalboxes, int tousebox, int totalqueens, int tositqueen, String ans){
        if(totalqueens == tositqueen){    // to sit queen become 4 bcoz when i make 3 no queen sit she will make a call for 4no queen 
            System.out.println(ans);      // ans 3no queen get stored in ans so it will always enter here to make queen no. 3 sit
            return 1;
        }
        int count = 0;
        for(int i=tousebox;i<totalboxes;i++){
            count += combinationqueenset(totalboxes,i+1,totalqueens,tositqueen+1,ans + "b" + i + "q" + tositqueen + " ");   // queen placed when enter here
        }
        return count;
    }

    public static int permutationqueenset(int totalboxes, int tousebox, int totalqueens, int tositqueen, boolean[] vis,String ans){
        if(totalqueens == tositqueen){    // to sit queen become 4 bcoz when i make 3 no queen sit she will make a call for 4no queen 
            System.out.println(ans);      // ans 3no queen get stored in ans so it will always enter here to make queen no. 3 sit
            return 1;
        }
        int count = 0;
        for(int i=tousebox;i<totalboxes ;i++){
            if(!vis[i]){
                vis[i] = true;
                count += permutationqueenset(totalboxes,0,totalqueens,tositqueen+1,vis,ans + "b" + i + "q" + tositqueen + " ");   // queen placed when enter here
                vis[i] = false;
            }
        }
        return count;
    }

    public static int combinationqueen(int totalboxes, int currentbox, int tqe, int currentqueen, String ans){
        if(tqe == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = currentbox;i<totalboxes;i++){
            count += combinationqueen(totalboxes,i+1,tqe-1,currentqueen+1,ans+"b"+i+"q"+currentqueen);
        }
        return count;
    }
     public static int permutationqueen(int totalboxes, int currentbox, int tqe, int currentqueen, boolean[] vis,String ans){
        if(tqe == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = currentbox;i<totalboxes;i++){
            if(!vis[i]){
                vis[i] = true;
                count += permutationqueen(totalboxes,0,tqe-1,currentqueen+1,vis,ans+"b"+i+"q"+currentqueen+" ");
                vis[i] = false;
            }
        }
        return count;
    }


    //==============2D queen problem===============

    public static int combinationqueen(boolean[][] boxes, int idx, int tqe, String ans){
        if(tqe == 0){
            System.out.println(ans);
            return 1;
        }
        int n = boxes.length;
        int m = boxes[0].length;
        int count = 0;
        for(int i = idx;i<n*m;i++){          //converting 2d into 1d and now its same as my old problem instead of 6 boxes 16 boxes and then 
            int r = idx/m;                             // making on 2 into 2d
            int c = idx%m;
            count += combinationqueen(boxes,i+1,tqe-1,ans+"("+r+", "+c+")");
        }
        return count;
    }

     
    public static void main(String[] args){
        int[] arr = {2,3,5,7};
        int target = 10;
        int totalboxes = 6;
        boolean[] vis = new boolean[totalboxes];
        boolean[][] boxes = new boolean[3][3];
        System.out.println(queenCombination2D(boxes,0,4,""));
    }
}