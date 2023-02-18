import java.util.Scanner;

public class Main {
    static int n;
    static int[] r = new int[1005];
    static int[] g = new int[1005];
    static int[] b = new int[1005];

    static int min(int a, int b) {
        if (a < b) return a;
        else return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            r[i] = sc.nextInt();
            g[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            r[i] += min(g[i - 1], b[i - 1]);
            g[i] += min(r[i - 1], b[i - 1]);
            b[i] += min(r[i - 1], g[i - 1]);
        }
        System.out.println(min(r[n], min(g[n], b[n])));
    }
}
