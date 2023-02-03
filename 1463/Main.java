import java.util.Scanner;

public class Main {
    static int N;
    static int[] d = new int[1000005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        d[2] = 1;
        d[3] = 1;
        for (int i = 4; i <= N; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
            if (i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
        }
        System.out.println(d[N]);
    }
}