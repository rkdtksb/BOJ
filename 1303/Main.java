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

    static int n, m;
    static int ans1, ans2;
    static int[][] a = new int[105][105];
    static Queue<Pair> Q = new ArrayDeque<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int bfs(int x, int y, int k) {
        int cnt = 1;
        a[x][y] = -1;
        Q.offer(new Pair(x, y));
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (a[nx][ny] != k) continue;
                cnt++;
                a[nx][ny] = -1;
                Q.offer(new Pair(nx, ny));
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                char ch = str.charAt(j);
                if (ch == 'W') a[i][j] = 0;
                if (ch == 'B') a[i][j] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    int p = bfs(i, j, 0);
                    ans1 += p * p;
                }
                if (a[i][j] == 1) {
                    int p = bfs(i, j, 1);
                    ans2 += p * p;
                }
            }
        }
        System.out.printf("%d %d", ans1, ans2);
    }
}
