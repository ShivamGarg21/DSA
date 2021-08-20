public class l05{
    public static TreeNode constructFromInorder_helper(int[] inOrder, int si, int ei){
        if(si > ei){
            return null;
        }
        int mid = (si + ei)/2;
        TreeNode root = new TreeNode(inOrder[mid]);
        root.left = constructFromInorder_helper(inOrder, si, mid-1);
        root.right = constructFromInorder_helper(inOrder,mid+1,ei);

    }
    public static TreeNode constructFromInorder(int[] inOrder)
}