import java.util.Scanner;

public class Main {
    static int t;
    static long[] a = new long[1000005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long ans = 0;
            long cur = 0;
            for (int j = 1; j <= n; j++) {
                a[j] = sc.nextLong();
            }
            cur = a[n];
            for (int j = n - 1; j > 0; j--) {
                cur = Math.max(cur, a[j]);
                ans += cur - a[j];
            }
            System.out.println(ans);
        }
    }
}
