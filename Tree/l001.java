public class l001{
    public class Node{
            int data=0;
            Node left=null;
            Node right=null;
            Node(int data){
                    this.data = data;
            }
    }
    private Node root;
    public void preorder(Node root,ArrayList<Integer> ans){
            if(root==null)
                    return;
            ans.add(root.data);
            preorder(root.left,ans);
            preorder(root.right,ans);

    }
    public int sum(Node root){
            if(root.next==null){
                return root.data;
            }
            return sum(root.left)+sum(root.right)+root.data;

    }

    public boolean findData(Node root,int data){
        if(root==null)
            return false;
        if(root.data == data)
            boolean ans =true;
        return ans || findData(root.left,data)==true||findData(root.right,data);
    }
    public static boolean rootToNodePath(Node root,int data,ArrayList<Integer> ans){
        if(root==null)
            return false;
        boolean res = (root.data==data) || rootToNodePath(root.left,data)==true||rootToNodePath(root.right,data);
        if(res)
            ans.add(root);
        return ans;

    }
    public static void printAtKDepth(Node root, int k, ArrayList<Integer> ans){
        if(root == null || k<0)
            return;
        if(k==0){
            ans.add(root.data);
            return;
        }
        printAtKDepth(root.left,k-1,ans);
        printAtKDepth(root.right,k-1,ans);

    }
    public static void printAtKDepth2(Node root, int k,Node block, ArrayList<Integer> ans){
        if(root == null||block == null || k<0)
            return;
        if(k==0){
            ans.add(root.data);
            return;
        }
        printAtKDepth(root.left,block,k-1,ans);
        printAtKDepth(root.right,block,k-1,ans);
    }
    public ArrayList<Integer> distanceK(Node root, Node target, int K,ArrayList<Integer> ans){
        ArrayList<Node> path = new ArrayList<>();
        rootToNodePath(root,target.data,path);
        Node block = null;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<path.size();i++){
                printAtDepth2(path.get(i),block,k-i,ans);
                block = path.get(i);
        }
        return ans;
    }
}
public static boolean rootToNodePath(Node root,int data,ArrayList<Node> ans){
    if(root==null)
        return false;
    boolean res = (root.data==data) || rootToNodePath(root.left,data,ans)==true||rootToNodePath(root.right,data,ans);
    if(res)
        ans.add(root);
    return res;

}
public static void printAtKDepth2(Node root,Node block,int k){
    if(root == null||root == block || k<0)
        return;
    if(k==0){
        System.out.println(root.data);
        return;
    }
    printAtKDepth2(root.left,block,k-1);
    printAtKDepth2(root.right,block,k-1);
}
// public void distanceK(Node root, int target, int k){
//     ArrayList<Node> path = new ArrayList<>();
//     rootToNodePath(root,target,path);
//     Node block = null;
//     //ArrayList<Integer> ans = new ArrayList<>();
//     for(int i=0;i<path.size();i++){
//             printAtKDepth2(path.get(i),block,k-i);
//             block = path.get(i);
//     }
// }

public static void printKNodesFar(Node root, int target, int k) {
// write your code here
//distanceK(node,data,k);
ArrayList<Node> path = new ArrayList<>();
    rootToNodePath(root,target,path);
    Node block = null;
    //ArrayList<Integer> ans = new ArrayList<>();
    for(int i=0;i<path.size();i++){
            printAtKDepth2(path.get(i),block,k-i);
            block = path.get(i);
    }

}
public static boolean isBST(Node node) {
    if (node == null)
        return true;

    boolean leftRes = isBST(node.left);
    if (!leftRes)
        return false;

    if (prev != null && prev.data > node.data)
        return false;
    prev = node;

    boolean rightRes = isBST(node.right);
    if (!rightRes)
        return false;

    return true;
}

public class isBSTSolPair {
    int maxEle = -(int) 1e8;
    int minEle = (int) 1e8;
    boolean isBST = true;
}

public isBSTSolPair isBST_(Node node) {
    if (node == null) {
        // isBSTSolPair base = new isBSTSolPair();
        // return base;

        return new isBSTSolPair();
    }

    isBSTSolPair left = isBST_(node.left);
    isBSTSolPair right = isBST_(node.right);

    isBSTSolPair myRes = new isBSTSolPair();
    myRes.isBST = false;
    if (left.isBST && right.isBST && left.maxEle < node.data && node.data < right.minEle) {
        myRes.isBST = true;
        myRes.maxEle = Math.max(node.data, right.maxEle);
        myRes.minEle = Math.min(node.data, left.minEle);
    }

    return myRes;
}

public static class isBalPair {
    int height = -1;
    boolean balanceTree = true;
}

public static isBalPair isBal_(Node node) {
    if (node == null)
        return new isBalPair();

    isBalPair left = isBal_(node.left);
    if (!left.balanceTree)
        return left;

    isBalPair right = isBal_(node.right);
    if (!right.balanceTree)
        return right;
    

    isBalPair myRes = new isBalPair();
    myRes.balanceTree = false;
    if (left.balanceTree && right.balanceTree && Math.abs(left.height - right.height) <= 1) {
        myRes.balanceTree = true;
        myRes.height = Math.max(left.height, right.height) + 1;
    }

    return myRes;
}

public static boolean isBal(Node node) {
    isBalPair ans = isBal_(node);
    return ans.balanceTree;
}