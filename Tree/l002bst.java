public class l001bst{
    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }
    }
    public static Node constructtree(int[] arr, int si, int ei){
            if(si>ei) return null;
            int mid = (si+ei)/2;
            Node node = new Node(arr[mid]);
            node.left = constructtree(arr,0,mid-1);
            node.right = constructtree(arr,mid+1,ei);
            return node;
    }
    public static Node constructtree(int[] arr){
        return constructtree(arr,0,arr.length-1);
    }
    public static int size(Node node){
        if(node == null){
            return 0;
        }
        return size(node.left) + size(node.right) +1;
    }
    public static int height(Node node){
        if(node == null){
            return -1;
        }
        return Max.math(height(node.left),height(node.left)) + 1;
    }
    public static int maximum(Node node){
        Node curr = node;
        while(curr.right!=null){
            curr = curr.right;
        }
        return curr.data;
    }
    public static int minimum(Node node){
        Node curr = node;
        while(curr.left!=null){
            curr = curr.left;
        }
        return curr.data;
    }
    public static boolean find(Node node,int data){
        Node curr = node;
        while(curr==null){
            if(curr.data==data) return true;
            else if(curr.data>data) curr = curr.left;
            else    curr = curr.left;
        }
        return false;
    }
    public static Node addData(Node node,int data){
        if(node == null) return new node(data);
        if(node.data<data) 
            node.right = addData(node.rigth,data);
        else    
            node.left = addData(node.left,data);
        return node;
    }
    public static void addData(Node node,int data){
            if(node== null) return new node(data);
            Node curr = node;
            Node node1 = new Node(data);
            while(1){
                if(curr.data == data)
                    break;
                if(curr.data>data){ 
                    if(curr.left!=null)
                        curr = curr.left;
                        else {
                            curr.left == node1;
                            break;
                        }
                }
    
                else {
                    if(curr.right!=null)
                        curr = curr.right;
                    else{
                        curr.right == node1;
                        break;
                    }
                }
            }
        }
    }
}