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
            int t = sc.nextInt();
            int x = sc.nextInt();
            if (t == 1) {
                for (int j = x; j <= n; j += x) {
                    a[j] ^= 1;
                }
            } else {
                a[x] ^= 1;
                int l = x - 1;
                int r = x + 1;
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
