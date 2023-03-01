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
        ans = 0;
        dis = 0x7f7f7f7f;
        for (int i = 0; i < n - 1; i++) {
            dis = Math.min(dis, b[i]);
            ans += a[i] * dis;
        }
        System.out.println(ans);
    }
}
