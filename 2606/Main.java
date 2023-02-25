import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int ans;
    static boolean[] vis = new boolean[105];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static void dfs(int cur) {
        vis[cur] = true;
        for (int nxt : adj.get(cur)) {
            if (!vis[nxt]) {
                ans++;
                dfs(nxt);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(1);
        System.out.println(ans);
    }
}
