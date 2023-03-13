import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] d = new int[205];
    static final int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        d[0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                d[j] = (d[j - 1] + d[j]) % MOD;
            }
        }
        System.out.println(d[n]);
    }
}
