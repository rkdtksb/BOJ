import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int[][] A = new int[101][101];
    static int[][] B = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        M = sc.nextInt();
        K = sc.nextInt();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < K; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum += A[i][k] * B[k][j];
                }
                System.out.printf("%d ", sum);
            }
            System.out.println();
        }
    }
}
