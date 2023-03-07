import java.util.Scanner;

public class Main {
    static int h, w;
    static int ans;
    static int[] a = new int[505];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        int mxh = 0;
        int mxi = 0;
        for (int i = 0; i < w; i++) {
            a[i] = sc.nextInt();
            if (a[i] > mxh) {
                mxh = a[i];
                mxi = i;
            }
        }
        int st = a[0];
        int en = a[w];
        for (int i = 0; i < mxi; i++) {
            st = Math.max(st, a[i]);
            ans += st - a[i];
        }
        for (int i = w - 1; i > mxi; i--) {
            en = Math.max(en, a[i]);
            ans += en - a[i];
        }
        System.out.println(ans);
    }
}
