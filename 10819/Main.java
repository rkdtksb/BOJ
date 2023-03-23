import java.util.Scanner;

public class Main {
    static int n;
    static int ans;
    static int[] a = new int[10];
    static int[] b = new int[10];
    static boolean[] vis = new boolean[10];

    static void dfs(int k) {
        if (k == n) {
            int sum = 0;
            for (int i = 0; i < k - 1; i++) {
                sum += Math.abs(b[i] - b[i + 1]);
            }
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                b[k] = a[i];
                vis[i] = true;
                dfs(k + 1);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        dfs(0);
        System.out.println(ans);
    }
}
