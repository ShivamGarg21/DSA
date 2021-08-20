import java.util.Scanner;
public class backtrecking01{
        public static Scanner scn = new Scanner(System.in);
        public static int floodfill(int sr ,int sc,int dr,int dc,boolean[][] vis,int[][] dir,String[] dirs,String ans)
        {
                int count = 0;
                if(sc==dc && sr == dr){
                    System.out.println(ans);
                    return 1;
                }
                vis[sr][sc]=true;
                int n=vis.length;
                int m=vis[0].length;
                for(int d=0;d<dir.length;d++)
                {
                        int r = sr + dir[d][0];
                        int c = sc + dir[d][1];

                        if(r>=0&&r<n && c>=0&& c<m && !vis[r][c])
                            count+=floodfill(r,c,dr,dc,vis,dir,dirs,ans+dirs[d]);
                }
                vis[sr][sc]=false;
                return count;
        }
        public static void main(String[] args){
                int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
                String[] dirs = {"R","D","L","U"};
                int n=3,m=3;
                boolean[][] vis = new boolean[n][m];
                System.out.println(floodfill(0,0,n-1,m-1,vis,dir,dirs,""));
        }
}