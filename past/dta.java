import java.util.Scanner;

public class dta {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }

    public static int getValueInBase(int n, int b) {
        int res = 0, pwr = 1;
        while (n != 0) {
            int rem = n % b;
            n = n / b;
            res += rem * pwr;
            pwr *= 10;
        }
        return res;
        // write code here
    }
}