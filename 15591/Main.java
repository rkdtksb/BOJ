import java.util.*;

public class Main {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, q;
    static boolean[] vis = new boolean[5005];
    static Queue<Integer> Q = new ArrayDeque<>();
    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    static int bfs(int k, int st) {
        int cnt = 0;
        vis[st] = true;
        Q.offer(st);
        while (!Q.isEmpty()) {
            int cur = Q.peek(); Q.poll();
            for (Pair nxt : adj.get(cur)) {
                int nx = nxt.x;
                int ny = nxt.y;
                if (!vis[nx] && ny >= k) {
                    cnt++;
                    vis[nx] = true;
                    Q.offer(nx);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int r = sc.nextInt();
            adj.get(p).add(new Pair(q, r));
            adj.get(q).add(new Pair(p, r));
        }
        for (int i = 0; i < q; i++) {
            int k = sc.nextInt();
            int v = sc.nextInt();
            Arrays.fill(vis, 0, n + 1, false);
            System.out.println(bfs(k, v));
        }
    }
}
