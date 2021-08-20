import java.util.Scanner;

public class rough{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int n = scn.nextInt();

            int [] input = new int[n]; 
            for(int i=0;i<n;i++)
                input[i] = scn.nextInt();
            int [] LeftMultiple = new int[n+1];
            LeftMultiple[0]=1;
            LeftMultiple[1]=input[0];
            for(int i=1;i<n;i++){
                LeftMultiple[i+1] = LeftMultiple[i]*input[i];
            }
            for(int i=0;i<=n;i++)
                System.out.print(LeftMultiple[i]);
        }

}