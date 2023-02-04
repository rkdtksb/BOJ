import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int ans;
    static int[] a = new int[105];
    static int[][] b = new int[105][105];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            for (int j = 0; j < p; j++) {
                b[i][j] = sc.nextInt();
            }
            Arrays.sort(b[i], 0, p);
            if (p < l) a[i] = 1;
            if (p > l) a[i] = b[i][p - l];
            if (p == l) a[i] = b[i][0];
        }
        Arrays.sort(a, 0, n);
        for (int i = 0; i < n; i++) {
            m -= a[i];
            if (m >= 0) ans++;
        }
        System.out.println(ans);
    }
}
