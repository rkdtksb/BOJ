import java.util.Scanner;

public class Main {
    static int h, w;
    static int ans;
    static int[] a = new int[505];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        for (int i = 0; i < w; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < w; i++) {
            int l = 0;
            int r = 0;
            for (int j = i; j >= 0; j--) {
                l = Math.max(l, a[j]);
            }
            for (int j = i; j < w; j++) {
                r = Math.max(r, a[j]);
            }
            ans += Math.min(l, r) - a[i];
        }
        System.out.println(ans);
    }
}
