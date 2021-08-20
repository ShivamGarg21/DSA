public class l02{
    
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> nodeToRootPath(TreeNode root, int target){
        if(root == null){
            return new ArrayList<>();
        }
        if(root.val == target){
            ArrayList<Integer> base = new ArrayList<>();
            base.add(root.val);
            return base;
        }
        if(target > root.val){
            ArrayList<Integer> left = nodeToRootPath(root.left)
            if(left.size() != 0)
                left.add(root.val);
            return left;
        }
        if(target < root.val){
            ArrayList<Integer> right = nodeToRootPath(root.left)
            if(right.size() != 0)
                right.add(root.val);
            return right;
        }

    }

    public static ArrayList<TreeNode> nodeToRootPath(TreeNode root, int target){
        if(root == null)
            return new ArrayList<>();

        ArrayList<TreeNode> ans = new ArrayList<>();
        TreeNode curr = root;
        boolean flag = false;
        while(curr != null){
            if(curr.val == target){
                ans.add(curr);
                flag = true;
                berak;
            }
            else if(curr.val < target){
                ans.add(curr);
                curr = curr.right;
            }
            else{
                ans.add(curr);
                curr = curr.left;
            }
        }
        if(!flag)
            ans.clear();

        return ans;
    }

    //=================== bst itrator 173 leetcode======================
    class BSTIterator {
        private ArrayDeque<TreeNode> st = new ArrayDeque<>();
        
        private void addAllLeft(TreeNode root){
            TreeNode curr = root;
            while(curr != null){
                st.addFirst(curr);
                curr = curr.left;
            }
        }
        public BSTIterator(TreeNode root) {
            addAllLeft(root);
        }
    
        public int next() {
            TreeNode rnode = st.removeFirst();
            addAllLeft(rnode.right);
            
            return rnode.val;
        }
    
        public boolean hasNext() {
                return st.size() != 0;
        }
    }
    
    //================== lowest comman ancestor l02 last mey krvaya tha =====================

    public static TreeNode lowerstCommanAncester(TreeNode root){

    }

    public static void main(String[] args){

    }
}