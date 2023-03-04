import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, k;
    static int ans;
    static int[] a = new int[10005];
    static int[] b = new int[10005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a, 0, n);
        for (int i = 1; i < n; i++) {
            b[i] = a[i] - a[i - 1];
        }
        Arrays.sort(b, 0, n);
        for (int i = 0; i <= n - k; i++) {
            ans += b[i];
        }
        System.out.println(ans);
    }
}
