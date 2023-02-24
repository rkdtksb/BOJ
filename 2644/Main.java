import java.util.*;

public class Main {
    static int n, m, u, v;
    static int[] dist = new int[105];
    static Queue<Integer> Q = new ArrayDeque<>();
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    static void bfs(int st) {
        dist[st] = 0;
        Q.offer(st);
        while (!Q.isEmpty()) {
            int cur = Q.peek(); Q.poll();
            for (int nxt : adj.get(cur)) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    Q.offer(nxt);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        u = sc.nextInt();
        v = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(dist, -1);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        bfs(u);
        System.out.println(dist[v]);
    }
}
