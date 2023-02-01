import java.util.Scanner;

public class Main {
    static int n;
    static int[] d = new int[1005];
    static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 2] + d[i - 1]) % MOD;
        }

        System.out.println(d[n]);
    }
}