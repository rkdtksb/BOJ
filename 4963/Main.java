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

    static int w, h;
    static int[][] a = new int[55][55];
    static Queue<Pair> Q = new ArrayDeque<>();

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static void bfs(int x, int y) {
        a[x][y] = 0;
        Q.offer(new Pair(x, y));
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.poll();
            for (int dir = 0; dir < 8; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (a[nx][ny] == 0) continue;
                a[nx][ny] = 0;
                Q.offer(new Pair(nx, ny));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) break;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int ans = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (a[i][j] == 1) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
