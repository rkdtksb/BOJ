import java.util.Scanner;

public class Main {
    static int n, m, k;
    static int[][] a = new int[105][105];
    static int[][] b = new int[105][105];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        m = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int sum = 0;
                for (int l = 0; l < m; l++) {
                    sum += a[i][l] * b[l][j];
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
