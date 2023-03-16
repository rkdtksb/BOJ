import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int ans;
    static int[] a = new int[1005];
    static int[] d1 = new int[1005];
    static int[] d2 = new int[1005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.fill(d1, 1);
        Arrays.fill(d2, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    d1[i] = Math.max(d1[i], d1[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (a[i] > a[j]) {
                    d2[i] = Math.max(d2[i], d2[j] + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, d1[i] + d2[i] - 1);
        }
        System.out.println(ans);
    }
}
