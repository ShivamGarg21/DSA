public class l0x{
    public static boolean isvalidBST_02(TreeNode root, TreeNode[] prev){
        if(isvalidBST_02(root.left, prev))
            return false;
        if(prev[0] != null && prev[0].val >= root.val)
            return false;
        prev[0] = root;

        if(!isvalidBST_02(root.right,prev))
            return false;
        
        return true;
    }
    public static void main(String[] args){
        
    }
}