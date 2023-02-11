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
            Arrays.fill(a, 0);
            for (int j = 0; j < p; j++) {
                a[j] = sc.nextInt();
            }
            Arrays.sort(a, 0, p);
            if (p < l) b[i] = 1;
            else b[i] = a[p - l];
        }
        Arrays.sort(b, 0, n);
        for (int i = 0; i < n; i++) {
            m -= b[i];
            if (m >= 0) ans++;
        }
        System.out.println(ans);
    }
}
