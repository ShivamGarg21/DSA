import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class l0012{
     
    public static void minpq(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=10;i>=0;i--){
            pq.add(i);
        }
        while(pq.size() != 0){
            int ele = pq.remove();
            System.out.print(ele + " ");
        }
    }

    public static void maxpq(){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
           // return a - b ; DEFAULT behaviour THIS - OTHER
             return b - a;//OTHER - THIS , reverse of deafult;

        });
        for(int i=10;i>=0;i--){
            pq.add(i);
        }
        while(pq.size() != 0){
            int ele = pq.remove();
            System.out.print(ele + " ");
        }
    }
    public static void kLargest(int[] arr ,int k){//k==4
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : arr){//putting every element of arr in priority queue.
            pq.add(ele);

            if(pq.size() > k){//check if pq .size() > k that means there are 5 largest member of array present in pq 
                 pq.remove();//remove the smaleer element bcs pq is of default type and it will remove the samleer eelement from pq
            }
        } 
        while(pq.size() != 0){//print the pq all 4 largest element will b printed.
            System.out.println(pq.remove());
        }
    }
    public static void kSmallest(int[] arr ,int k){//k==4
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b - a;
        });
        for(int ele : arr){//putting every element of arr in priority queue.
            pq.add(ele);

            if(pq.size() > k){//check if pq .size() > k that means there are 5 largest member of array present in pq 
                 pq.remove();//remove the smaleer element bcs pq is of not default type and it will remove the greatest element present from pq
            }
        } 
        while(pq.size() != 0){//print the pq all 4 largest element will b printed.
            System.out.println(pq.remove());
        }
    }
    public static int[] topKFrequent(int[] nums,int k){
        HashMap<Integer,Integer> map =new HashMap<>();//making hashMap of arr
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele, 0 ) + 1 );
        }

        //[val,freq]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{//min priority queue
            return a[1] -b[1];//calculating the priority that smaller frequent number will be deleted from the pq and comparing the index [1] .
        }); 

        for(int ele : map.keySet()){//for every ele in keySet();
            int val = ele;
            int freq = map.get(val);//get the freq of every value

            int[] arr = new int[]{val,freq };//making array of 2 size and put the values of val and freq into it
            pq.add(arr);//put the arr in pq

            if(pq.size() > k){//if pq.size() > k
                pq.remove();//remove the smaleet frequent number
            }
        }

        int [] ans = new int[k];//make ur ans arr
        int idx =0;
        while(pq.size() != 0){//while pq is not empty.
            ans[idx++] = pq.remove()[0];//store those values which are highly frequent and store the arr[0] ind to ans arr
        }
        return ans;
    }
    public static int[] topKFrequenttype2(int[] nums,int k){
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele, 0 ) + 1 );
        }

        //[val,freq]
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return map.get(a) - map.get(b);
        }); 

        for(int ele : map.keySet()){
            pq.add(ele);

            if(pq.size() > k){
                pq.remove();
            }
        }

        int [] ans = new int[k];
        int idx =0;
        while(pq.size() != 0){
            ans[idx++] = pq.remove();
        }
        return ans;
    }

    public List<String> topKFrequentWord(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b)) {
                return b.compareTo(a);
            }
            return map.get(a) - map.get(b);
        });

        for (String word : map.keySet()) {
            pq.add(word)
;
            if (pq.size() > k)
                pq.remove();
        }

        int idx = pq.size();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < idx; i++)
            ans.add("");
        while (pq.size() != 0) {
            ans.set(--idx, pq.remove());
        }
        return ans;
    }
    public static void sortksorted(int[] arr,int k){
        int idx =0;
        PriorityQueue<Integer> pq =new PriorityQueue<>();
        for(int ele : arr){
            pq.add(ele);

            if(pq.size() > k){
                arr[idx++] = pq.remove();
            }
        }
        while(pq.size() != 0){
            arr[idx++] = pq.remove();
        }
        for(int ele : arr){
            System.out.println(ele);
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
        
          
          PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->{
              return a[0]-b[0];
          });
          
          for(int i=0 ; i<lists.size() ; i++){
              pq.add(new int[]{lists.get(i).get(0) , 0 , i});
          }
          
          while(pq.size() != 0){
              int[] arr = pq.remove();
              rv.add(arr[0]);
              
              int idx = arr[1];
              int listidx = arr[2];
              int length = lists.get(listidx).size();
              
              if(idx + 1 < length){
                  arr[1]++;
                  arr[0] = lists.get(listidx).get(idx+1);
                  pq.add(arr);
              }
          }    
        return rv;
     }
     public static ArrayList<Integer> mergetwolists(ArrayList<Integer> list1,ArrayList<Integer> list2){

        ArrayList<Integer> ans = new ArrayList<>();

        int i=0,n=list1.size();
        int j=0,m=list2.size();

        while(i<n &&j<m){
            if(list1.get(i) < list2.get(j)){
                ans.add(list1.get(i++));
            }
            else{
                ans.add(list2.get(j++));
            }   
        }

        while(i<n){
            ans.add(list1.get(i++));
        }
        while(j<m){
            ans.add(list2.get(j++));
        }
        
        return ans;

    }
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists ,int si ,int ei){
        if(si==ei){
            return lists.get(si);
        }
        int mid = (si + ei) /2;
        ArrayList<Integer> list1= mergeKSortedLists(lists, si , mid-1);
        ArrayList<Integer> list2 = mergeKSortedLists(lists, mid+1 , ei);
        return mergetwolists(list1, list2);
    }    
    
    public static boolean isanagram(String s,String r){
        if(s.length() != r.length()){
            return false;
        }

        int[] arr = new int[26];
        for(int i=0; i<s.length() ;i++){
            arr[s.charAt(i)  - 'a' ]++;
            arr[r.charAt(i)  - 'a' ]--;
        }
        for(int i=0;i<26;i++){
            if(arr[i] !=0){
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args){
        minpq();
        System.out.println();
        maxpq();
    }
}