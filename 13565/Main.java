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
    static char[][] a = new char[1005][1005];
    static Queue<Pair> Q = new ArrayDeque<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                a[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[0][i] == '0') {
                a[0][i] = '1';
                Q.offer(new Pair(0, i));
            }
        }
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (a[nx][ny] == '1') continue;
                if (nx == m - 1) {
                    System.out.println("YES");
                    return;
                }
                a[nx][ny] = '1';
                Q.offer(new Pair(nx, ny));
            }
        }
        System.out.println("NO");
    }
}
