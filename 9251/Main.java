import java.util.Scanner;

public class Main {
    static String a, b;
    static int n, m;
    static int[][] d = new int[1005][1005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.next();
        b = sc.next();
        n = a.length();
        m = b.length();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                }
                else {
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                }
            }
        }
        System.out.println(d[n][m]);
    }
}
