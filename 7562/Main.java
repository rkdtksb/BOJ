import java.util.ArrayDeque;
import java.util.Arrays;
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
    static int[][] dist = new int[305][305];
    static Queue<Pair> Q = new ArrayDeque<>();

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = 0; j < l; j++) {
                Arrays.fill(dist[j], -1);
            }
            dist[n][m] = 0;
            Q.offer(new Pair(n, m));
            while (!Q.isEmpty()) {
                Pair cur = Q.peek(); Q.poll();
                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
                    if (dist[nx][ny] >= 0) continue;
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    Q.offer(new Pair(nx, ny));
                }
            }
            System.out.println(dist[x][y]);
        }
    }
}