import java.util.Scanner;

public class Main {
    static int N;
    static int[][] d = new int[1005][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            d[i][0] = sc.nextInt();
            d[i][1] = sc.nextInt();
            d[i][2] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            d[i][0] += Math.min(d[i - 1][1], d[i - 1][2]);
            d[i][1] += Math.min(d[i - 1][0], d[i - 1][2]);
            d[i][2] += Math.min(d[i - 1][0], d[i - 1][1]);
        }
        System.out.println(Math.min(d[N][0], Math.min(d[N][1], d[N][2])));
    }
}
