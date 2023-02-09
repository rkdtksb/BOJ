import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int ans;
    static int[] a = new int[105];
    static int[] b = new int[105];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            Arrays.fill(b, 0);
            for (int j = 0; j < p; j++) {
                b[j] = sc.nextInt();
            }
            Arrays.sort(b, 0, p);
            if (p < l) a[i] = 1;
            else a[i] = b[p - l];
        }
        Arrays.sort(a, 0, n);
        for (int i = 0; i < n; i++) {
            m -= a[i];
            if (m >= 0) ans++;
        }
        System.out.println(ans);
    }
}