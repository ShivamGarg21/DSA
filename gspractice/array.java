import java.util.Scanner;

public class array{
    public Scanner scn = new Scanner(System.in);
    public static void main (String[] args){
            int n = scn.nextInt();

            int [] input = new int[n]; 
            for(int ele : input)
                input[ele] = scn.nextInt();
            int [] LeftMultiple = new int[n+2];
            int [] RightMultiple = new int[n+2];  
            int LeftMultiple[0] = 1;
            int RightMultiple[n] = 1;
            for(int i=0;i<n;i++){
                LeftMultiple[i] = LeftMultiple[i-1]*input[i];
            }
            for(int i=n-1;i>=0;i--){
                RightMultiple[i] = RightMultiple[i+1]*input[i];
            }
    }
}