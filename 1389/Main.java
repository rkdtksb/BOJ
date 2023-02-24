import java.util.*;

public class Main {
    static int n, m;
    static int ans, mn;
    static int[] dist = new int[105];
    static Queue<Integer> Q = new ArrayDeque<>();
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static final int INF = 0x7fffffff;

    static int bfs(int st) {
        int sum = 0;
        dist[st] = 0;
        Q.offer(st);
        while (!Q.isEmpty()) {
            int cur = Q.peek(); Q.poll();
            for (int nxt : adj.get(cur)) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    sum += dist[nxt];
                    Q.offer(nxt);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        while (m-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        mn = INF;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist, -1);
            int sum = bfs(i);
            if (sum < mn) {
                ans = i;
                mn = sum;
            }
        }
        System.out.println(ans);
    }
}
