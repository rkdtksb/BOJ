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
    static int[][] dist = new int[105][105];
    static Queue<Pair> Q = new ArrayDeque<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            String str = sc.next();
            for (int j = 1; j <= m; j++) {
                char ch = str.charAt(j - 1);
                if (ch == '1') dist[i][j] = -1;
            }
        }
        dist[1][1] = 1;
        Q.offer(new Pair(1, 1));
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx <= 0 || ny <= 0 || nx > n || ny > m) continue;
                if (dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                Q.offer(new Pair(nx, ny));
            }
        }
        System.out.println(dist[n][m]);
    }
}
