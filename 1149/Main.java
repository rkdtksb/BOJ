import java.util.Scanner;

public class Main {
    static int N;
    static int[][] d = new int[1005][3];

    static int min(int a, int b) {
        if (a < b) return a;
        else return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            d[i][0] = sc.nextInt();
            d[i][1] = sc.nextInt();
            d[i][2] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            d[i][0] += min(d[i - 1][1], d[i - 1][2]);
            d[i][1] += min(d[i - 1][0], d[i - 1][2]);
            d[i][2] += min(d[i - 1][0], d[i - 1][1]);
        }
        System.out.println(min(d[N][0], min(d[N][1], d[N][2])));
    }
}
