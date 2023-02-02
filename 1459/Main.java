import java.util.Scanner;

public class Main {
    static long X, Y, W, S;
    static long ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextLong();
        Y = sc.nextLong();
        W = sc.nextLong();
        S = sc.nextLong();

        if (W * 2 <= S) {
            ans = W * (X + Y);
        }
        if (W * 2 > S && W <= S) {
            ans = S * Math.min(X, Y) + W * Math.abs(X - Y);
        }
        if (W * 2 > S && W > S) {
            ans = S * Math.max(X, Y);
            if (Math.abs(X - Y) % 2 != 0) {
                ans -= S;
                ans += W;
            }
        }
        System.out.println(ans);
    }
}
