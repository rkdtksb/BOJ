import java.util.Scanner;

public class Main {
    static int n;
    static int[] d = new int[1000005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d[1] = 0;
        d[2] = 1;
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
            if (i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
        }
        System.out.println(d[n]);
    }
}
