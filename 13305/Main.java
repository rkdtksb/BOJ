import java.util.Scanner;

public class Main {
    static int n;
    static long ans;
    static long[] a = new long[100005];
    static long[] b = new long[100005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextLong();
        }
        int mn = 0x7f7f7f7f;
        for (int i = 0; i < n - 1; i++) {
            mn = Math.min(mn, b[i]);
            ans += a[i] * mn;
        }
        System.out.println(ans);
    }
}
