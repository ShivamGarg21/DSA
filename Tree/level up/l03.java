import java.util.LinkedList;
public class l03{
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    // public static bfsTree(TreeNode root){
    //     LinkedList<TreeNode> que = new LinkedList<>();
    //     ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    //     que.add(root);
    //     while(que.size() != 0){
    //         int size = que.size();
    //         ArrayList<Integer> smallAns = new ArrayList<>();
    //         while(size-- > 0){
    //             TreeNode rnode = que.removeFirst();
    //             smallAns.add(rnode.val);
    //             if(rnode.left != null)
    //                 que.addLast(rnode.left);
    //             if(rnode.right != null)
    //                 que.addLast(rnode.right);
    //         }
    //         ans.add(smallAns);
    //     }
    // }

    public static void bfsTree(TreeNode root){
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while(que.size() != 0){
            int size = que.size();
            ArrayList<Integer> smallans = new ArrayList<>();
            while(size-- > 0 ){
                TreeNode rnode = que.removeFirst();
                smallans.add(rnode.val);
                if(rnode.left != null)
                    que.addLast(rnode.left);
                if(rnode.right != null)
                    que.addLast(rnode.right);
            }
            ans.add(smallans);
        }
    }
    public static ArrayList<Integer> leftview(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        while(que.size() != 0){
            int size = que.size();
            ans.add(que.getFirst().val);
            while(size-- > 0 ){
                TreeNode rnode = que.removeFirst();
                
                if(rnode.left != null)
                    que.addLast(rnode.left);
                if(rnode.right != null)
                    que.addLast(rnode.right);
            }
        }
        return ans;
    }
    public static class vPair{
        TreeNode node = null;
        int vl = 0;
        vPair(TreeNode node, int vl){
            this.node = node;
            this.vl = vl;
        }
    }
    public static void widthofshadow(TreeNode root, int vl, int[] minmax){
        if(vl > minmax[1]){
            minmax[1] = vl;
        }
        if(vl < minmax[0]){
            minmax[0] = vl;
        }
        
        if(root.left != null)
            widthofshadow(root.left, vl - 1, minmax);
        if(root.right != null)
            widthofshadow(root.right ,vl+1, minmax);
        
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root){
        LinkedList<vPair> que = new LinkedList<>();
        
        int[] minmax = new int[2];
        
        widthofshadow(root,0,minmax);
        int len = minmax[1] - minmax[0] + 1;

        que.addLast(new vPair(root,Math.abs(minmax[0])));

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < len;i++)
            ans.add(new ArrayList<>());

        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                vPair rnode = que.removeFirst();
                
                int vl = rnode.vl;
                TreeNode node = rnode.node;
                
                ans.get(vl).add(node.val);
                if(node.left != null)
                    que.addLast(new vPair(node.left,vl-1));
                if(node.right != null)
                    que.addLast(new vPair(node.right,vl+1));
            }
        }            
        return ans;
    }

    //================= bottom view =================================
    public static class vPair{
        TreeNode node = null;
        int vl = 0;
        vPair(TreeNode node, int vl){
            this.node = node;
            this.vl = vl;
        }
    }
    
    public static void widthofshadow(TreeNode root, int vl, int[] minmax){
        if(vl < minmax[0])
            minmax[0] = vl;
        if(vl > minmax[1])
            minmax[1] = vl;
        if(root.left != null)
            widthofshadow(root.left,vl-1,minmax);
        if(root.right != null)
            widthofshadow(root.right,vl+1,minmax);
    }

    public static ArrayList<Integer> bottomview(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        LinkedList<vPair> que = new LinkedList<>();

        int[] minmax = new int[2];

        widthofshadow(root,0,minmax);
        
        que.addLast(new vPair(root,Math.abs(minmax[0])));
        int len = minmax[1] - minmax[0] + 1;
        
        for(int i = 0;i < len;i++)
            ans.add(null);

        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                vPair rnode = que.removeFirst();

                TreeNode node = rnode.node;
                int vl = rnode.vl;
                ans.set(vl,node.val);
                if(node.left != null)
                    que.addLast(new vPair(node,vl-1));
                if(node.right != null)
                    que.addLast(new vPair(node,vl+1));
            }
        }
        return ans;

    }
    //========top view ============================================
        public static class vPair{
        TreeNode node = null;
        int vl = 0;
        vPair(TreeNode node, int vl){
            this.node = node;
            this.vl = vl;
        }
    }
    
    public static void widthofshadow(TreeNode root, int vl, int[] minmax){
        if(vl < minmax[0])
            minmax[0] = vl;
        if(vl > minmax[1])
            minmax[1] = vl;
        if(root.left != null)
            widthofshadow(root.left,vl-1,minmax);
        if(root.right != null)
            widthofshadow(root.right,vl+1,minmax);
    }

    public static ArrayList<Integer> topview(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        LinkedList<vPair> que = new LinkedList<>();

        int[] minmax = new int[2];

        widthofshadow(root,0,minmax);
        
        que.addLast(new vPair(root,Math.abs(minmax[0])));
        int len = minmax[1] - minmax[0] + 1;
        for(int i = 0;i < len;i++)
            ans.add(null);
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                vPair rnode = que.removeFirst();

                TreeNode node = rnode.node;
                int vl = rnode.vl;
                if(ans.get(vl) == null)
                    ans.set(vl,node.val);
                if(node.left != null)
                    que.addLast(new vPair(node.left,vl-1));
                if(node.right != null)
                    que.addLast(new vPair(node.right,vl+1));
            }
        }
        return ans;

    }

    //====== Diagonal order=============================
    public static class vPair{
        TreeNode node = null;
        int vl = 0;
        vPair(TreeNode node, int vl){
            this.node = node;
            this.vl = vl;
        }
    }
    
    public static void widthofshadow(TreeNode root, int vl, int[] minmax){
        if(vl < minmax[0])
            minmax[0] = vl;
        if(vl > minmax[1])
            minmax[1] = vl;
        if(root.left != null)
            widthofshadow(root.left,vl-1,minmax);
        if(root.right != null)
            widthofshadow(root.right,vl+1,minmax);
    }

    public static ArrayList<ArrayList<Integer>> diagonalView(TreeNode root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        LinkedList<vPair> que = new LinkedList<>();
        
        que.addLast(new vPair(root,0));        
        while(que.size() != 0){
            int size = que.size();
            //ArrayList<Integer> myans = new ArrayList<>();
            while(size-- > 0){
                vPair rnode = que.removeFirst();
                TreeNode node = rnode.node;
                int vl = rnode.vl;
                if(ans.size() == vl)
                    ans.add(new ArrayList<>());
                
                ans.get(vl).add(node.val);
                if(node.left != null)
                    que.addLast(new vPair(node.left,vl+1));
                if(node.right != null)
                    que.addLast(new vPair(node.right,vl));
            }
        }
        return ans;

    }

    public static ArrayList<ArrayList<Integer>> diagonalView(TreeNode root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        while(que.size() != 0){
            int size = que.size();
            ArrayList<Integer> smallAns = new ArrayList<>();
            while(size-- > 0){
                TreeNode rnode = que.removeFirst();
                while(rnode != null){
                    smallAns.add(rnode.val);
                    if(rnode.left != null)
                        que.addLast(rnode.left);
                    rnode = rnode.right;
                }
            }
            ans.add(smallAns);
        }
        return ans;
    }

    public static void main(String[] args){

    }
}