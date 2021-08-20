import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class basic {

    // public static void MinPQ() {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default min PQ.
    //     for (int i = 10; i >= 0; i--) {
    //         pq.add(i);
    //     }

    //     while (pq.size() != 0) {
    //         int ele = pq.remove();
    //         System.out.print(ele + " ");
    //     }

    // }

    // public static void MaxPQ() {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
    //         // return a - b; // this - other, default behaviour.
    //         return b - a; // other - this, reverse of default.
    //     }); 

    //     for (int i = 10; i >= 0; i--) {
    //         pq.add(i);
    //     }

    //     while (pq.size() != 0) {
    //         int ele = pq.remove();
    //         System.out.print(ele + " ");
    //     }

    // }
    // public static void klargest(int[] arr, int k){
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     for(int ele : arr){
    //         pq.add(ele);
    //         if(pq.size()>k) pq.remove();
    //     }
    //     while(pq.size()>0){
    //         System.out.println(pq.remove());
    //     }
    // }
    // public static void ksmallest(int[] arr, int k){
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
    //         return b-a;
    //     });
    //     for(int ele : arr){
    //         pq.add(ele);
    //         if(pq.size()>k) pq.remove();
    //     }
    //     while(pq.size()>0){
    //         System.out.print(pq.remove()+ " ");
    //     }
    // }
    // public int[] topfrequency2(int[] words, int k){
    //     HashMap<String, Integer> map = new HashMap<>();
    //     for(String word : words){
    //         map.put(word, map.getOrDefault(word,0)+1);
    //     }
    //     PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
    //         return map.get(a)-map.get(b);
    //     });
    //     for(String word : map.keySet()){
    //         pq.add(word);
    //         if(pq.size()>k) pq.remove();
    //     }
    //     List<String> ans = new ArrayList<>();
    //     while(pq.size()!=0){
    //         ans.add(pq.remove());
    //     }
    //     return ans;

    // }
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        
        for(int i=0;i<lists.size();i++)
                pq.add(lists.get(i).get(0),0,i);
        while(pq.size()!=0){
            int[] ar = pq.remove();
            rv.add(ar[0]);
            int idx = ar[1];
            int listIdx = ar[2];
            int length = lists.get(listIdx).size();
            if(idx+1  < length){
                ar[1]++;
                ar[0] = lists.get(listsIdx).get(idx+1);
                pq.add(ar);
            }
        }
        return rv;
    
    }
    public static void main(String[] args) {
        //MinPQ();
        //System.out.println();
        //MaxPQ();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int [n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ksmallest(arr,k);

    }

}