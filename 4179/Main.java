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

    static int r, c;
    static int[][] a = new int[1000][1000];
    static Queue<Pair> Q1 = new ArrayDeque<>();
    static Queue<Pair> Q2 = new ArrayDeque<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        for (int i = 0; i < r; i++) {
            String str = sc.next();
            for (int j = 0; j < c; j++) {
                char ch = str.charAt(j);
                if (ch == '#') a[i][j] = -2;
                if (ch == '.') a[i][j] = -1;
                if (ch == 'F') Q1.offer(new Pair(i, j));
                if (ch == 'J') Q2.offer(new Pair(i, j));
            }
        }
        while (!Q1.isEmpty()) {
            Pair cur = Q1.peek();
            Q1.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (a[nx][ny] != -1) continue;
                a[nx][ny] = a[cur.x][cur.y] + 1;
                Q1.offer(new Pair(nx, ny));
            }
        }
        Pair J = Q2.peek();
        a[J.x][J.y] = 0;
        while (!Q2.isEmpty()) {
            Pair cur = Q2.peek();
            Q2.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    System.out.println(a[cur.x][cur.y] + 1);
                    return;
                }
                if (a[nx][ny] != -1 && a[nx][ny] <= a[cur.x][cur.y] + 1) continue;
                a[nx][ny] = a[cur.x][cur.y] + 1;
                Q2.offer(new Pair(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
