import java.util.Scanner;
public class geek1{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
            int n = scn.nextInt();
            int m = scn.nextInt();
            int k = scn.nextInt();
            int[][] blocked_cells = new int [n][m];
            for(int i=0;i<k;i++)
            {
                    for(int j=0;j<2;j++)
                        blocked_cells[i][j] = scn.nextInt();
            }
            System.out.print(FindWays(1,1,n,m,blocked_cells));
    }
    public static int FindWays(int sr,int sc, int dr, int dc, int[][] blocked_cells){
        // Code here
        int count = 0;
        for(int i=0;i<blocked_cells.length;i++){
                        if(blocked_cells[i][0] == dr && blocked_cells[i][1] == dc)
                            return 0;
            }
        if(sc==dc && sr==sr)
            return 1;
            
        boolean flag1 = true;
        boolean flag2 = true;
        for(int i=0;i<blocked_cells.length;i++) {
                        if(blocked_cells[i][1] == sc+1&&blocked_cells[i][0] == sr)
                            flag1=false;
                        if(blocked_cells[i][0]==sr+1&&blocked_cells[i][1] == sc)
                            flag2=false;
            }    
            
        if(sc+1<=dc&&flag1)
            count +=FindWays(sr,sc+1,dr,dc,blocked_cells);
        if(sr+1<=dr&&flag2)
            count +=FindWays(sr+1,sc,dr,dc,blocked_cells);
        return count;
    }
}