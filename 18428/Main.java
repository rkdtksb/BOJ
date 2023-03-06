import java.util.Scanner;

public class Main {
    static int n;
    static String[][] a = new String[10][10];

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean check(int x, int y) {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            while (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (a[nx][ny].equals("O")) break;
                if (a[nx][ny].equals("S")) return false;
                nx += dx[dir];
                ny += dy[dir];
            }
        }
        return true;
    }

    static boolean dfs(int cnt) {
        if (cnt == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j].equals("T")) {
                        return check(i, j);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j].equals("X")) {
                    a[i][j] = "O";
                    if (dfs(cnt + 1)) return true;
                    a[i][j] = "X";
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String str = sc.next();
                a[i][j] = str;
            }
        }
        if (dfs(0)) System.out.println("YES");
        else System.out.println("NO");
    }
}
