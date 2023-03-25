import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int ans;
    static boolean[] vis = new boolean[1005];
    static Queue<Integer> Q = new ArrayDeque<>();
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static void bfs(int k) {
        ans++;
        vis[k] = true;
        Q.offer(k);
        while (!Q.isEmpty()) {
            int cur = Q.peek(); Q.poll();
            for (int nxt : adj.get(cur)) {
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    Q.offer(nxt);
                }
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
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) bfs(i);
        }
        System.out.println(ans);
    }
}
