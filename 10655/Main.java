import java.util.Scanner;

public class Main {
    static int n;
    static int ans;
    static int[] x = new int[100005];
    static int[] y = new int[100005];

    static int dist(int a, int b) {
        return Math.abs(x[b] - x[a]) + Math.abs(y[b] - y[a]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int tot = 0;
        for (int i = 1; i < n; i++) {
            tot += dist(i - 1, i);
        }
        ans = tot;
        for (int i = 1; i < n - 1; i++) {
            ans = Math.min(ans, tot - dist(i - 1, i) - dist(i, i + 1) + dist(i - 1, i + 1));
        }
        System.out.println(ans);
    }
}
