import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

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
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        Arrays.fill(dist, -1);
        bfs(u);
        System.out.println(dist[v]);
    }
}
