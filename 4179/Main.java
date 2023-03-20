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

    static int r, c;
    static int[][] dist1 = new int[1005][1005];
    static int[][] dist2 = new int[1005][1005];
    static char[][] a = new char[1005][1005];
    static Queue<Pair> Q1 = new ArrayDeque<>();
    static Queue<Pair> Q2 = new ArrayDeque<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        for (int i = 0; i < r; i++) {
            Arrays.fill(dist1[i], -1);
            Arrays.fill(dist2[i], -1);
        }
        for (int i = 0; i < r; i++) {
            String str = sc.next();
            for (int j = 0; j < c; j++) {
                a[i][j] = str.charAt(j);
                if (a[i][j] == 'F') {
                    Q1.offer(new Pair(i, j));
                    dist1[i][j] = 0;
                }
                if (a[i][j] == 'J') {
                    Q2.offer(new Pair(i, j));
                    dist2[i][j] = 0;
                }
            }
        }
        while (!Q1.isEmpty()) {
            Pair cur = Q1.peek(); Q1.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (dist1[nx][ny] >= 0 || a[nx][ny] == '#') continue;
                dist1[nx][ny] = dist1[cur.x][cur.y] + 1;
                Q1.offer(new Pair(nx, ny));
            }
        }
        while (!Q2.isEmpty()) {
            Pair cur = Q2.peek(); Q2.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    System.out.println(dist2[cur.x][cur.y] + 1);
                    return;
                }
                if (dist2[nx][ny] >= 0 || a[nx][ny] == '#') continue;
                if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.x][cur.y] + 1) continue;
                dist2[nx][ny] = dist2[cur.x][cur.y] + 1;
                Q2.offer(new Pair(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
