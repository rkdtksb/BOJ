import java.util.Scanner;

public class Main {
    static int t;
    static long[] a = new long[1000005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long ans = 0;
            long cur = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            for (int i = n - 1; i >= 0; i--) {
                cur = Math.max(cur, a[i]);
                ans += cur - a[i];
            }
            System.out.println(ans);
        }
    }
}
