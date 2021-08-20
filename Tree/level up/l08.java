public class l08{
    public static class leafToLeafPair {
        int LTLMaxSum = -(int) 1e9;
        int NTLMaxSum = -(int) 1e9; 
    }

    public static leafToLeafPair maxLeafSum(Node root) {
        if (root == null) {
            return new leafToLeafPair();
        }

        if (root.left == null && root.right == null) {
            leafToLeafPair base = new leafToLeafPair();
            base.NTLMaxSum = root.data;
            return base;
        }

        leafToLeafPair lRes = maxLeafSum(root.left);
        leafToLeafPair rRes = maxLeafSum(root.right);

        leafToLeafPair myRes = new leafToLeafPair();
        myRes.LTLMaxSum = Math.max(lRes.LTLMaxSum, rRes.LTLMaxSum);

        if (root.left != null && root.right != null) {
            myRes.LTLMaxSum = Math.max(myRes.LTLMaxSum, lRes.NTLMaxSum + root.data + rRes.NTLMaxSum);
        }

        myRes.NTLMaxSum = Math.max(lRes.NTLMaxSum, rRes.NTLMaxSum) + root.data;
        return myRes;
    }

    int maxPathSum(Node root) {
        int ans = maxLeafSum(root).LTLMaxSum;
        int ans2 = maxLeafSum(root).NTLMaxSum;

        return ans != -(int) 1e9 ? ans : Math.max(ans, ans2);
    }
    public class NTNPair{
        int maxPossibleAns = -(int)1e9;
        int NTNMaxSum = 0;
    }

    public int getMax(int... arr){
        int maxEle = arr[0];
        for(int ele : arr){
            maxEle = Math.max(maxEle, ele);
        }
        return maxEle;
    }

    public NTNPair maxPathSum_(TreeNode root){
        NTNPair myAns = new NTNPair();
        if(root == null)
            return myAns;

        NTNPair left = maxPathSum_(root.left);
        NTNPair right = maxPathSum_(root.right);

        int oneSidedMax = Math.max(left.NTNMaxSum, right.NTNMaxSum) + root.val;
        myAns.maxPossibleAns = getMax(left.maxPossibleAns, right.maxPossibleAns, root.val, oneSidedMax, left.NTNMaxSum + root.val + right.NTNMaxSum);

        myAns.NTNMaxSum = Math.max(oneSidedMax, root.val);
        return myAns;
    }
    
     // -1 : Camera Reqd. , 0 : Already Covered, 1 : I'm a camera
    public int maxPathSum(TreeNode root) {
        return maxPathSum_(root).maxPossibleAns;
    }
        public int minCameraCover(TreeNode root, int[] countOfCamera){
        if(root == null)
            return 0;

        int lr = minCameraCover(root.left, countOfCamera);
        int rr = minCameraCover(root.right, countOfCamera);

        if(lr == -1 || rr == -1){
            countOfCamera[0]++;
            return 1;
        }

        if(lr == 1 || rr == 1){
            return 0;
        }

        return -1;

    }
    public int minCameraCover(TreeNode root) {
        int[] countOfCamera = new int[1];
        int ans = minCameraCover(root, countOfCamera);
        if(ans == -1)
            countOfCamera[0]++;
        return countOfCamera[0];
    }

    public static void main(String[] args){

    }
}