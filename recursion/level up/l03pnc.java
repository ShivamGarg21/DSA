public class l03pnc{
    // leet code 46
    public static void permute1(int[] arr, int idx, List<Integer> set,List<List<Integer>> ans ){
        if(idx == arr.length){
            List<Integer> base = new ArrayList<>(set);
            ans.add(base);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>-11){
                int val = arr[i];
                arr[i] = -11;
                set.add(val);
                permute1(arr,idx+1,set,ans);
                set.remove(set.size()-1);
                arr[i] = val;
            }
        }
    }
        
        
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<>();
        int idx = 0;
        //boolean[] vis = new boolean[nums.length];
        permute1(nums,idx,set,ans);
        return ans;
    }
    //leetcode 47
    // cheack permute unique line of sort============================================================= example aray {-9,-9,-1,2,5,5,9}
    // call ist call will only be -9,-1,2,5,9 by comparing previous value only the call of new value take place
    public static int permute1(int[] arr, int num, List<Integer> set,List<List<Integer>> ans){
        if(num == arr.length){
            List<Integer> base = new ArrayList<>(set);
            ans.add(base);
            return 1;
        }
        int count = 0;
        int prev = -12;
        for(int i=0; i<arr.length;i++){
            if(prev != arr[i] && arr[i]>-11){      // -10<= arr[i] <= 10 so prev = -12 non existing value in array so obvio ki arr[0] != prev but  if arr[1] == arr[0] then check 6 lines below 
                int val = arr[i];
                set.add(val);
                arr[i] = -11;
                count += permute1(arr,num+1,set,ans);
                set.remove(set.size()-1);
                arr[i] = val;
                
                prev = arr[i];          // so now value of prev = arr[0] and next cycle wont run because of if statm. so mean repeat call wont take place 
            }
        } 
        return count;
    }
    
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<>();
        int idx = 0;
        Arrays.sort(nums);       // why? because if there is repeating numbers they will come in line and after a single call by checking prev. value we can avoid same call again 
        //boolean[] vis = new boolean[nums.length];
        permute1(nums,idx,set,ans);
        return ans;
    }
    // leet code 39
    public int combinationsum(int[] arr, int idx, int target, List<Integer> set, List<List<Integer>> ans){
        if(target == 0){
            List<Integer> base = new ArrayList<>(set);
            ans.add(base);
            return 1;
        }
        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(target - arr[i] >= 0){
                set.add(arr[i]);
                count += combinationsum(arr,i,target-arr[i],set,ans);
                set.remove(set.size() - 1 );
            }
        }
        return count;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        int x = combinationsum(candidates,0,target,set,ans);
        return ans;
    }
    // leet code 40
    public int combinationsum(int[] arr, int target, int idx, List<Integer> set, List<List<Integer>> ans){
        if(target == 0){
            List<Integer> base = new ArrayList<>(set);
            ans.add(base);
            return 1;
        }
        int count = 0;
        int prev = -1;
        for(int i=idx;i<arr.length;i++){
            if(prev!=arr[i] && target - arr[i]>= 0){
                set.add(arr[i]);
                count += combinationsum(arr,target - arr[i],i+1,set,ans);
                set.remove(set.size()-1);
                prev = arr[i];
            }
            if(target-arr[i]<0)
                    break;
            
        }
        return count;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Arrays.sort(candidates);
        combinationsum(candidates,target,0,set,ans);
        return ans;
    }

    // leet code 77
     public int combine(int n,int k,int idx, List<Integer> set, List<List<Integer>> ans){
        if(k==0){
            List<Integer> base = new ArrayList<>(set);
            ans.add(base);
            return 1;
        }
        int count = 0;
        for(int i=idx;i<=n;i++){
                set.add(i);
                count += combine(n,k-1,i+1,set,ans);
                set.remove(set.size()-1);
        }
        return count;
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        combine(n,k,1,set,ans);
        return ans;
        
    }
    // leetcode 216
     public int combinationsum3(int k, int target,int idx, List<Integer> set, List<List<Integer>> ans){
        if(k == 0 || target == 0 ){
            if(k == 0 && target == 0){
                List<Integer> base = new ArrayList<>(set);
                ans.add(base);
                return 1;
            }
            return 0;
        }
        int count = 0;
        for(int i=idx;i<=9;i++){
            if(target - i >= 0){
                set.add(i);
                count += combinationsum3(k-1,target-i,i+1,set,ans);
                set.remove(set.size()-1);
            }
        }
        return count;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> set = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combinationsum3(k,n,1,set,ans);
        return ans;
    }

    // leet code 784
    // by subsequence method 1 recursice call stays the same and 1 changes the alphabet
     public int lettercasepermute(String s, String str,int idx,List<String> ans){
        if(idx == s.length()){
            ans.add(str);
            return 1;
        }
        int count = 0;
        count += lettercasepermute(s, str + s.charAt(idx),idx+1,ans);
        if(s.charAt(idx) >='A' && s.charAt(idx) <='Z' || s.charAt(idx) >='a' && s.charAt(idx) <='z'){
            if(s.charAt(idx) >='A' && s.charAt(idx) <='Z'){
                int diff = 'a' - 'A';
                int converted = (int)s.charAt(idx) + diff;
                char add =  (char)converted;
                count += lettercasepermute(s, str + add,idx+1,ans);
            }
            else{
                int diff = 'A' - 'a';     // -ve value so basically subtract
                int converted = (int)s.charAt(idx) + diff;
                char add =  (char)converted;
                count += lettercasepermute(s, str + add,idx+1,ans);
            }
        }
        return count;
        
    }
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        lettercasepermute(s,"",0,ans);
        return ans;
    }
    
    public static void main(String[] args){

    }
}