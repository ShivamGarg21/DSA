public class lect01{
    public static class pathpair{
        int length = 0;
        String path = "";
        int count  = 0;
        // int shortestpathlength = 0;
        // String shortestpath = "";
        pathpair(int lpath, String lstring){
            String path = lstring;
            int length = lpath;
        }
    }
    public static pathpair printpath(int sr, int sc, int dr, int dc, int[][] dir, String[] dirc, boolean[][] vis){
        if(sr==dr && sc == dc){
            return new pathpair(0,"",1); 
        }
        vis[sr][sc] = true;
        pathpair myAns - new pathpair((int) 1e9,"",0);
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r>=0 && r<=dr && c >=0 && c<=dr && !vis[r][c] ){
                pathpair recAns += printpath(r,c,dr,dc,dir,dirc,vis,path+dirc[d],p);
                if(resAns.length +1 <myAns.length){
                    my
                }
            }
        }
        vis[sr][sc] = false;
        return count;
    }


    // public static int printpath(int sr, int sc, int dr, int dc, int[][] dir, String[] dirc, boolean[][] vis, String path,pair p){
    //     if(sr==dr && sc == dc){
    //         System.out.println(path + " ");
    //         if(path.length() > p.longestpathlength){
    //             p.longestpathlength = path.length();
    //             p.longestpath = path;
    //         }
    //         if(path.length() < p.shortestpathlength){
    //             p.shortestpath = path;
    //             p.shortestpathlength = path.length();
    //         }

    //         return 1; 
    //     }
    //     vis[sr][sc] = true;
    //     int count =0; 
    //     for(int d = 0; d < dir.length; d++){
    //         int r = sr + dir[d][0];
    //         int c = sc + dir[d][1];

    //         if(r>=0 && r<=dr && c >=0 && c<=dr && !vis[r][c] )
    //             count += printpath(r,c,dr,dc,dir,dirc,vis,path+dirc[d],p);
    //     }
    //     vis[sr][sc] = false;
    //     return count;
    // }

    public static void main(String[] args){
        int[][] dir = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        String[] dirc = {"right ","s ","d ","w ","left ","n ","t ","e "};
        int longestpathlength = 0;
        boolean[][] vis = new boolean[3][3];
        //pair  p = new pair();
        System.out.println(printpath(0,0,2,2,dir,dirc,vis,""));
        // System.out.println(p.longestpathlength + " " + p.longestpath);
    }
}