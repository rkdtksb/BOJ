import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] a = new int[105];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        m = sc.nextInt();
        while (m-- > 0) {
            int k = sc.nextInt();
            int x = sc.nextInt();
            if (k == 1) {
                for (int i = x; i <= n; i += x) {
                    a[i] ^= 1;
                }
            } else {
                int l = x - 1;
                int r = x + 1;
                while (0 < l && r <= n && a[l] == a[r]) {
                    a[l] ^= 1;
                    a[r] ^= 1;
                    l--;
                    r++;
                }
                a[x] ^= 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }
}
