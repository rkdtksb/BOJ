import java.util.Scanner;

public class Main {
    static int N, X;
    static int ans1, ans2, sum;
    static int[] a = new int[250005];
    static final String NO_VISITORS = "SAD";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        X = sc.nextInt();
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < X; i++) {
            sum += a[i];
        }
        for (int i = X; i <= N; i++) {
            if (ans1 < sum) {
                ans1 = sum;
                ans2 = 0;
            }
            if (ans1 == sum) ans2++;
            sum -= a[i - X];
            sum += a[i];
        }
        if (ans1 == 0) System.out.println(NO_VISITORS);
        else System.out.printf("%d%n%d%n", ans1, ans2);
    }
}
