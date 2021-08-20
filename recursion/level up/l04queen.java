public class l04queen{

    //what we are basically doing is travelling in 8 directions and checking if theres a queen if there is then we can not place the queen bcoz it get kill
    public static boolean issafetoplace(boolean[][] boxes, int r, int c){
        int[][] dir = {{0,-1},{-1,-1},{-1,0},{-1,1}};
        int n = boxes.length,m = boxes[0].length;
        for(int d = 0;d<dir.length;d++){   
            for(int rad = 1; rad<n;rad++){        // here we are increasing the reach and till it hits the end 1,2,3,4,5
                int row = r + rad * dir[d][0];
                int col = c+ rad * dir[d][1];

                if(row>=0 && row<n &&col>=0 &&col<m){
                    if(boxes[row][col])
                        return false;
                }else 
                        break;
            }
        }
        return true;
    }

    
    public static int nqueencombination(boolean[][] boxes, int idx, int tqe, String ans){
        if(tqe == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        int n = boxes.length, m = boxes[0].length;
        for(int i=idx;i<n*m;i++){
            int r = i/m;                            // we can convertion 1d array to 2d array rows will be number / columns
            int c  = i%m;
            if(!boxes[r][c]&&issafetoplace(boxes,r,c)){
                boxes[r][c] = true;                           // so that we can mark the place where queen in sitting so that will wont place another in her direction
                count += nqueencombination(boxes,i+1,tqe-1,ans+"("+r+", "+c+") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }
    public static boolean issafetoplace(boolean[][] boxes, int r, int c){
       // int[][] dir = {{0,-1},{-1,-1},{-1,0},{-1,1}};
               int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

        int n = boxes.length,m = boxes[0].length;
        for(int d = 0;d<dir.length;d++){   
            for(int rad = 1; rad<n;rad++){        // here we are increasing the reach and till it hits the end 1,2,3,4,5
                int row = r + rad * dir[d][0];
                int col = c+ rad * dir[d][1];

                if(row>=0 && row<n &&col>=0 &&col<m){
                    if(boxes[row][col])
                        return false;
                }else 
                        break;
            }
        }
        return true;
    }

    public static int nqueenpermutation(boolean[][] boxes, int idx, int tqe, String ans){
        if(tqe == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        int n = boxes.length, m = boxes[0].length;
        for(int i=idx;i<n*m;i++){
            int r = i/m;                            // we can convertion 1d array to 2d array rows will be number / columns
            int c  = i%m;
            if(!boxes[r][c]&&issafetoplace(boxes,r,c)){
                boxes[r][c] = true;                           // so that we can mark the place where queen in sitting so that will wont place another in her direction
                count += nqueenpermutation(boxes,0,tqe-1,ans+"("+r+", "+c+") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }

    //============ OPTIMISED===========================================

    static boolean[] row;
    static boolean[] col;
    static boolean[] diagonal;
    static boolean[] antidiagonal;

    // public static int nqueencombination(int n, int m,int idx, int tqe, String ans){
    //     if(tqe == 0){
    //         System.out.println(ans);
    //         return 1;
    //     }
    //     int count = 0;
    //     for(int i = idx; i<n*m;i++){
    //         int r = i/m;
    //         int c = i%m; 
    //         if(!row[r] && !col[c] &&!diagonal[r+c] && !antidiagonal[r-c +m-1]){
    //             row[r] = col[c] = diagonal[r+c] = antidiagonal[r-c +m-1] = true;
    //             count += nqueencombination(n,m,i+1,tqe-1,ans + "(" + r + ", " + c + ") ");
    //             row[r] = col[c] = diagonal[r+c] = antidiagonal[r-c +m-1] = false;
    //         }
    //     }
    //     return count;
    // }
    public static int nqueenpermute(int n, int m,int idx, int tqe, String ans){
        if(tqe == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = idx; i<n*m;i++){
            int r = i/m;
            int c = i%m; 
            if(!row[r] && !col[c] &&!diagonal[r+c] && !antidiagonal[r-c +m-1]){
                row[r] = col[c] = diagonal[r+c] = antidiagonal[r-c +m-1] = true;
                count += nqueenpermute(n,m,0,tqe-1,ans + "(" + r + ", " + c + ") ");
                row[r] = col[c] = diagonal[r+c] = antidiagonal[r-c +m-1] = false;
            }
        }
        return count;
    }


    public static void main(String[] args){
        int n=4,m=4,q=4;
        //boolean[][] boxes = new boolean[n][m];
        row  = new boolean[n];
        col = new boolean[m];
        diagonal = new boolean[n+m-1];
        antidiagonal = new boolean[n+m-1];
        System.out.println(nqueenpermute(n,m,0,q,""));
    }
}