import java.util.Scanner;

public class Main {
    static int H, W, X, Y;
    static int[][] B = new int[605][605];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();
        for (int i = 0; i < H + X; i++) {
            for (int j = 0; j < W + Y; j++) {
                B[i][j] = sc.nextInt();
            }
        }
        for (int i = X; i < H; i++) {
            for (int j = Y; j < W; j++) {
                B[i][j] -= B[i - X][j - Y];
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
    }
}
