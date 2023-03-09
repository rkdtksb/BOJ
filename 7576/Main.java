import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int m, n;
    static int ans;
    static int[][] a = new int[1005][1005];
    static int[][] dist = new int[1005][1005];
    static Queue<Pair> Q = new ArrayDeque<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 0) dist[i][j] = -1;
                if (a[i][j] == 1) Q.offer(new Pair(i, j));
            }
        }
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                Q.offer(new Pair(nx, ny));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dist[i][j]);
                if (dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(ans);
    }
}
