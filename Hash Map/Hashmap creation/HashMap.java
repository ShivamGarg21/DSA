import java.util.ArrayList;
import java.util.LinkedList;
public class HashMap{        // for default value hashmap<K,V> and all the Integer accompany key will be replaced by K and value by V
    private void intialize(int size){
        buckets = new LinkedList[size];
        for(int i=0;i<size;i++){
            buckets[i] = new LinkedList<>();
        }
        this.maxSizeOfBucket = size;
    }
    HashMap(){
            intialize(10);
    }
    
    private class Node{
        int key = 0;
        int val = 0;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }

        @override
        public String toString(){
            return key + " = " + val;
        }

    }
    private LinkedList<Node>[] buckets;
    private int NoOFElements = 0;
    private int maxSizeOfBucket = 0;

    @override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int sizeofmap = NoOFElements;
        for(int i=0;i<maxSizeOfBucket;i++){
            LinkedList<Node> group = buckets[i];
            int size = group.size();
            while(size-->0){
                sb.append(group.getFirst());
                if(sizeofmap > 1)
                    sb.append(", ");
                group.addLast(group.removeFirst());
                sizeofmap--;
            }
        }
        sb.append("]");
        return ab.toString();
    }


    private int size(){
        return this.NoOFElements;
    }
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    private void rehash(){
        LinkedList<Node> temp = this.buckets;
        intialize(2*this.maxSizeOfBucket);
        for(int i=0;i<temp.length;i++){
            LinkedList<Node> group = temp[i];
            int size = group.size();
            while(size-->0){
                Node node = group.removeFirst();
                put(node.key, node.val);
            }
        }
    }

    public void put(Integer key, Integer value){      // example public void put(K key, V value) 
        LinkedList<Node> group = group(key);
        boolean res = containsKey(key);
        if(res){
            group.getFirst().val = value;
        }
        else{
            Node node = new Node(key,value);
            group.addLast(node);
            NoOFElements++;

            double lambda = (0.4)*this.maxSizeOfBucket;
            if(group.size()>=lambda) rehash();
        }
    }

    public boolean containsKey(Integer key){
        LinkedList<Node> group = group(key);
        int size = group.size();
        while(size-->0){
            if(group.getFirst == key)
                return true;
            group.addLast(group.removeFirst());
        }
        return false;

    }

    public void get(Integer key){
        LinkedList<Node> group = group(key);
        if(containsKey(key)){
            return group.getFirst().val;
        }
    }

    public int remove(Integer key){
        LinkedList<Node> group = group(key);
        if(containsKey(key)){
            this.NoOFElements--;
            return group.removeFirst().val;
        }
        return null
    }
    public ArrayList<Integer> keySet(){
         ArrayList<Integer> ans = new ArrayList<>();
         for(int i=0;i<maxSizeOfBucket;i++){
            allkeysofgroup(this.buckets[i],ans);
         }
         return ans;
    }

    public void allkeysofgroup(LinkedList<Node> group, ArrayList<Integer> ans){
            int size = group.size(); 
            while(size-->0){
                ans.add(getFirst().key);
                group.addLast(group.removeFirst());
            }
    }

    public Integer getOrDefault(Integer key, Integer defaultValue){
        int val = get(key);
            ret
        if(val == null){
            return defaultValue;
        }
        return val;
    }

    public void putIfAbsent(int key, int value){
        LinkedList<Node> group = group(key);
        boolean res = containsKey(key);
        if(!res)
            put(key,value);
    }

    private LinkedList<Node> group(Integer key){
        int groupNo = groupNo(key);
        return this.buckets[groupNo];
    }
    private Integer groupNo(Integer key){
        Integer hs = Math.abs(key.hashCode);
        return hs%maxSizeOfBucket;
    }
}