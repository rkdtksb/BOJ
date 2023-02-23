import java.util.Scanner;

public class Main {
    static int r, c, k;
    static int ans;
    static int[][] a = new int[10][10];
    static boolean[][] vis = new boolean[10][10];

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y, int dist) {
        if (x == 1 && y == c) {
            if (dist == k) ans++;
            return;
        }
        vis[x][y] = true;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx <= 0 || ny <= 0 || nx > r || ny > c) continue;
            if (a[nx][ny] == -1 || vis[nx][ny]) continue;
            vis[nx][ny] = true;
            dfs(nx, ny, dist + 1);
            vis[nx][ny] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();
        for (int i = 1; i <= r; i++) {
            String str = sc.next();
            for (int j = 1; j <= c; j++) {
                char ch = str.charAt(j - 1);
                if (ch == 'T') a[i][j] = -1;
            }
        }
        dfs(r, 1, 1);
        System.out.println(ans);
    }
}
