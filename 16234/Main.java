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

    static int n, l, r;
    static int ans;
    static int[][] a = new int[55][55];
    static int[][] b = new int[55][55];
    static boolean[][] vis = new boolean[55][55];
    static Queue<Pair> Q = new ArrayDeque<>();
    static Queue<Pair> u = new ArrayDeque<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    static void bfs(int x, int y) {
        int cnt = 1;
        int sum = a[x][y];
        vis[x][y] = true;
        Q.offer(new Pair(x, y));
        u.offer(new Pair(x, y));
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (vis[nx][ny]) continue;
                int dif = Math.abs(a[cur.x][cur.y] - a[nx][ny]);
                if (dif < l || r < dif) continue;
                cnt++;
                sum += a[nx][ny];
                vis[nx][ny] = true;
                Q.offer(new Pair(nx, ny));
                u.offer(new Pair(nx, ny));
            }
        }
        int num = sum / cnt;
        while (!u.isEmpty()) {
            Pair cur = u.peek(); u.poll();
            b[cur.x][cur.y] = num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    vis[i][j] = false;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!vis[i][j]) bfs(i, j);
                }
            }
            if (check()) break;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = b[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = 0;
                }
            }
            ans++;
        }
        System.out.println(ans);
    }
}
