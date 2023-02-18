import java.util.Scanner;

public class Main {
    static int h, w, x, y;
    static int[][] b = new int[605][605];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        for (int i = 0; i < h + x; i++) {
            for (int j = 0; j < w + y; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        for (int i = x; i < h; i++) {
            for (int j = y; j < w; j++) {
                b[i][j] -= b[i - x][j - y];
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
