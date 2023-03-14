import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int t;
    static int[] a = new int[10005];
    static int[] d = new int[10005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Arrays.fill(d, 0);
            d[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = a[i]; j <= m; j++) {
                    d[j] += d[j - a[i]];
                }
            }
            System.out.println(d[m]);
        }
    }
}
