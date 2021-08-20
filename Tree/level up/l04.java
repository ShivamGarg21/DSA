public class l04{
    
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public class ListNode{
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public static void VerticalOrderSum(TreeNode root, ListNode node){
        if(root == null){
            return;
        }
        node.val = node.val + root.val;

        if(root.left != null){
            if(node.prev == null){
                ListNode newnode = new ListNode(0);
                newnode.next = node;
                node.prev = newnode;
            }
            VerticalOrderSum(root.left,node.prev);
        }
        if(root.right != null){
            if(node.next == null){
                ListNode newnode = new ListNode(0);
                newnode.prev = node;
                node.next = newnode;
            }
            VerticalOrderSum(root.right,node.next);
        }
    }

    public static ArrayList<Integer> VerticalOrderSum(TreeNode root){
        ListNode node = new ListNode(0);
        VerticalOrderSum(root, node);

    } 
    //Function to convert binary tree to doubly linked list and return it.
    static Node prev = null;
    void bToDLL_(Node root){
        if(root == null) return;
        bToDLL_(root.left);
        prev.right = root;
        root.left = prev;
        
        prev = root;
        bToDLL_(root.right);
    }
    Node bToDLL(Node root)
    {
	//  Your code here
	    Node dummy = new Node(-1);
	    prev = dummy;
	    bToDLL_(root);
	    prev = dummy.right;
	    dummy.right = prev.left =null;
	    
	    return prev;
    }
    

    //==========binary tree to circular LinkedList==============================
    static Node prev = null;
    void bToDLL_(Node root){
        if(root == null) return;
        bToDLL_(root.left);
        prev.right = root;
        root.left = prev;
        
        prev = root;
        bToDLL_(root.right);
    }
    Node bTreeToClist(Node root)
    {
        //your code here
        Node dummy = new Node(-1);
	    prev = dummy;
	    bToDLL_(root);
	    Node head = dummy.right;
	    dummy.right = head.left =null;
	    
	    prev.right = head;
	    head.left = prev;
	    
	    return head;
    }
    public static void main(String[] args){

    }
}