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

    static int t;
    static int h, w;
    static char[][] a = new char[105][105];
    static Queue<Pair> Q = new ArrayDeque<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int x, int y) {
        a[x][y] = '.';
        Q.offer(new Pair(x, y));
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (a[nx][ny] == '.') continue;
                a[nx][ny] = '.';
                Q.offer(new Pair(nx, ny));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            h = sc.nextInt();
            w = sc.nextInt();
            for (int i = 0; i < h; i++) {
                String str = sc.next();
                for (int j = 0; j < w; j++) {
                    a[i][j] = str.charAt(j);
                }
            }
            int ans = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (a[i][j] == '#') {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
