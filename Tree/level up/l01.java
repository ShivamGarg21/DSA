public class l01{

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static int size(TreeNode root){
        if(root == null )
            return -1;
        int left = size(root.left);
        int right = size(root.right);
        return left+right+1;
    }

    public static int height(TreeNode root){
        if(root == null){
            return -1;
        }
        return Math.max(height(root.left),height(root.right)) +1;
    }

    public static int maximum(TreeNode root){
        if(root == null)
            return -1e9;
        return Math.max(Math.max(maximum(root.left),maximum(root.right)),root.val);
    }

    public static boolean findnode(ListNode root , int value){
        if(node == null){
            return false;
        }
        if(root.val == value)
            return true;
        return findnode(root.left) || findnode(root.right,value);
    }

    public static ArrayList<Integer> nodePath(TreeNode root , int value){
        if(root == null){
            return new ArrayList<>();
        }
        if(root.val == value){
            ArrayList<Integer> base = new ArrayList<>();
            base.add(value);
            return base;
        }
        ArrayList<Integer> left = nodePath(root.left,value);
        if(left.size() != 0){
            left.add(root.val);
            return left;
        }
        ArrayList<Integer> right= nodePath(root.right,value)
        if(right.size() != 0){
            right.add(root.val);
            return right;
        }
        return left;

    }

    public static boolean nodePath(TreeNode root, int value, ArrayList<Integer> path){
        if(root == null){
            return false;
        }
        if(root.val == value){
            path.add(value);
            return true;
        }
        if(nodePath(root.left,value,path)){
            path.add(root.val);
            return true;
        }
        if(nodePath(root.right,value,path)){
            path.add(root.val);
            return true;
        }
    }

    public static void rootToLeafNodePath_helper(TreeNode root, ArrayList<Integer> set, ArrayList<ArrayList<Integer>> ans){
        if(root.left == null && root.right == null){
            ArrayList<Integer> base = new ArrayList<>(set);
            base.add(root.val);
            ans.add(base);
            return;
        }
        set.add(root.val);
        rootToLeafNodePath_helper(root.left,set,ans);
        rootToLeafNodePath_helper(root.right,set,ans);
        set.remove(set.size()-1);
    }

    public static ArrayList<ArrayList<Integer>> rootToLeafNodePath(TreeNode root){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> set = new ArrayList<>();
            rootToLeafNodePath_helper(root,set,ans);
            return ans;
    }

    public static void singleChild(TreeNode root, ArrayList<Integer> ans){
        if(root == null || (root.left == null && root.right == null))
            return;
        if(root.left == null || root.right == null){
            ans.add(root.val);
            return;
        }
        singleChild(root.left,ans);
        singleChild(root.right,ans);
    }

    public static int countSingleCount(TreeNode root){
        if(root == null || (root.left == null && root.right == null))
            return;
        int left = countSingleCount(root.left);
        int right = countSingleCount(root.right);

        int ans = left + right;
        if(root.left == null || root.right == null)
            ans++;
        return ans;
    }

    //========== k nodes away======================
        public ArrayList<TreeNode> nodePath(TreeNode root , TreeNode target){
        if(root == null ){
            ArrayList<TreeNode> base = new ArrayList<>();
            return base; 
        }
        if(root == target){
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }
        ArrayList<TreeNode> left = nodePath(root.left, target);
        if(left.size() != 0){
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right = nodePath(root.right, target);
        if(right.size() != 0){
            right.add(root);
            return right;
        }
        return new ArrayList<>();

    }

    public void kdown(TreeNode root, TreeNode blockedNode, int k,List<Integer> ans){
        if(root == null || root == blockedNode || k < 0 )
            return;
        if(k==0){
            ans.add(root.val);
            return;
        }
        kdown(root.left,blockedNode,k-1,ans);
        kdown(root.right,blockedNode,k-1,ans);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        if(root == null)
            return new ArrayList<>();
        int num = k;
        List<Integer> ans = new ArrayList<>();
        ArrayList<TreeNode> path = nodePath(root,target);

        kdown(path.get(0),null,k,ans);
        
        for(int i=1;i<path.size();i++){
            if(k-i < 0)
                break;
            kdown(path.get(i),path.get(i-1),k-i,ans);
        }

        return ans;
    }

    // same problem different way=================
    public void kdown(TreeNode root, TreeNode blockedNode, int k, List<Integer> ans){
        if(root == null || root == blockedNode || k<0)
            return;
        if(k == 0){
            ans.add(root.val);
            return;
        }
        kdown(root.left,blockedNode,k,ans);
        kdown(root.right,blockedNode,k,ans);
    }

    public int distanceK1_helper(TreeNode root, TreeNode target, int k, List<Integer> ans){
        if(root == null)
            return 0;
        if(root == target){
            kdown(root,null,k,ans);
            return 1;
        }
        int ld = distanceK1_helper(root.left,target,k,ans);             // here we make a call to the node it node is found then
        if(ld != 0){                                                    // hath ki hath kdown call krdiya or peeche aae toh k-ld krke kdown kr diya 
            kdown(root,root.left,k-ld,ans);                               //basically k-1 hi ho raha h but pichle call mey 1 subtract hua ya nahi pta nhi toh ld 
            return ld+1;                                                    // mey jitni bar -1 hua vo stored h
        }
        int rd = distanceK1_helper(root.right,target,k,ans);
        if(rd != 0){
            kdown(root,root.right,k-rd,ans);
            return rd+1;
        }
        return 0;
    }

    public List<Integer> distanceK1(TreeNode root, TreeNode target, int k){
        List<Integer> ans = new ArrayList<>();
        distanceK1_helper(root, target, k,ans);
        return ans;
    }

    //====== burning tree =========================

    public static void kdown(TreeNode root, int time, TreeNode BlockNode, ArrayList<ArrayList<Integer>> ans){
        if(root == null || root == blockedNode)
            return;
        if(time == arr.size())
            ans.add(new ArrayList<>());
        ans.get(time).add(root.val);
        kdown(root.left,time+1,blockedNode,ans);
        kdown(root.right,time+1,blockedNode,ans);
    }

    public static int burningTree(TreeNode root, int target, ArrayList<ArrayList<Integer>> ans){
        if(root == null){
            return -1;
        }
        if(root.val == target){
            kdown(root,0,null,ans);
            return 1;
        }
        int left = burningTree(root.left,target,ans);
        if(left != -1){
            kdown(root,left,root.left,ans);
            return left+1;
        }
        int right = burningTree(root.right,target,ans);
        if(right != -1){
            kdown(root,right,root.right,ans);
            return right+1;
        }
        return -1;
    }


    public static void kdown(TreeNode root, int time, TreeNode blockedNode, ArrayList<ArrayList<Integer>> ans){
        if(root == null || root == blockedNode){
            return;
        }
        if(time == ans.size())
            ans.add(new ArrayList<>());

        ans.get(time).add(root.val);

        kdown(root.left,time+1,blockedNode,ans);
        kdown(root.right,time+1,blockedNode,ans);
    }

    public static int burningTree(TreeNode root, int target, ArrayList<ArrayList<Integer>> ans){
        if(root == null)
            return -1;
        if(root.val == target){
            kdown(root,0,null,ans);
            return 1;
        }

        int ld = burningTree(root.left,target,ans);
        if(ld != -1 ){
            kdown(root,ld,root.left,ans);
            return ld+1;
        }
        int rd = burningTree(root.right,target,ans);
        if(rd != -1 ){
            kdown(root,rd,root.right,ans);
            return rd+1;
        }
        return -1;
    }
    //============== burning tree with water==============
        public static void kdown(TreeNode root, int time, TreeNode blockedNode, ArrayList<ArrayList<Integer>> ans, HashSet<Integer> water){
        if(root == null || root == blockedNode || water.contains(root.val)){
            return;
        }
        if(time == ans.size())
            ans.add(new ArrayList<>());

        ans.get(time).add(root.val);

        kdown(root.left,time+1,blockedNode,ans);
        kdown(root.right,time+1,blockedNode,ans);
    }

    // so how are we handling case of water in above node mean agr fire node jb uper ja rahi h toh water se felegi nahi 
    // toh ld == x,y,z ko number h pr root.val == contains water then it vo loop mey jaega hi nahi or right side koi number h hi nahi 
    // return -1 hoga

    public static int burningTreewithwater(TreeNode root, int target,ArrayList<ArrayList<Integer>> ans,HashSet<Integer> water){
        if(root == null)
            return -1;
        if(root.val == target){
            if(!water.contains(root.val)){
                kdown(root,0,null,ans);
                return 1;
            }
            else 
                return -2;                // so that it wont be treated as not found the node because -1 is treated as node not found and right call will happen which is waste call 
        }
        int ld = burningTree(root.left,target,ans);
        if(ld == -2) return -2;
        if(ld != -1 && !water.contains(root.val)){
            kdown(root,ld,root.left,ans);
            return ld+1;
        }
        int rd = burningTree(root.right,target,ans);
        if(rd == -2) return -2;
        if(rd != -1 && !water.contains(root.val) ){
            kdown(root,rd,root.right,ans);
            return rd+1;
        }
        return -1;
    }

    public static void main(String[] args){

    }
}