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

    static int n, m, k;
    static int ans;
    static int[][] a = new int[105][105];
    static boolean[][] vis = new boolean[105][105];
    static Queue<Pair> Q = new ArrayDeque<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int bfs(int x, int y) {
        int cnt = 1;
        vis[x][y] = true;
        Q.offer(new Pair(x, y));
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx <= 0 || ny <= 0 || nx > n || ny > m) continue;
                if (a[nx][ny] == 0 || vis[nx][ny]) continue;
                cnt++;
                vis[nx][ny] = true;
                Q.offer(new Pair(nx, ny));
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            a[r][c] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == 1 && !vis[i][j]) {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }
        System.out.println(ans);
    }
}
