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

    static int N, M;
    static int[][] dist = new int[200][200];
    static Queue<Pair> Q = new ArrayDeque<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                if (ch == '0') dist[i][j] = -1;
                if (ch == '1') Q.offer(new Pair(i, j));
            }
        }
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                Q.offer(new Pair(nx, ny));
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
