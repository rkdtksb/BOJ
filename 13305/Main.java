import java.util.Scanner;

public class Main {
    static int n;
    static long ans, dis;
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
        ans = a[0] * b[0];
        dis = b[0];
        for (int i = 1; i < n - 1; i++) {
            dis = Math.min(dis, b[i]);
            ans += a[i] * dis;
        }
        System.out.println(ans);
    }
}
