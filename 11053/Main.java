import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int ans;
    static int[] a = new int[1005];
    static int[] d = new int[1005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.fill(d, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) d[i] = Math.max(d[i], d[j] + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, d[i]);
        }
        System.out.println(ans);
    }
}
