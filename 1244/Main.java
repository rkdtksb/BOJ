import java.util.Scanner;

public class Main {
    static int n, q;
    static int[] a = new int[105];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int m = sc.nextInt();
            int p = sc.nextInt();
            if (m == 1) {
                for (int j = p; j <= n; j += p) {
                    a[j] ^= 1;
                }
            } else {
                a[p] ^= 1;
                int l = p - 1;
                int r = p + 1;
                while (l > 0 && r <= n && a[l] == a[r]) {
                    a[l] ^= 1;
                    a[r] ^= 1;
                    l--;
                    r++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", a[i]);
            if (i % 20 == 0) System.out.println();
        }
    }
}
