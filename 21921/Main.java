import java.util.Scanner;

public class Main {
    static int n, x;
    static int ans1, ans2, sum;
    static int[] a = new int[250005];
    static final String NO_VISITORS = "SAD";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < x; i++) {
            sum += a[i];
        }
        ans1 = sum;
        ans2 = 1;
        for (int i = x; i < n; i++) {
            sum -= a[i - x];
            sum += a[i];
            if (ans1 < sum) {
                ans1 = sum;
                ans2 = 1;
            }
            else if (ans1 == sum) {
                ans2++;
            }
        }
        if (ans1 == 0) System.out.println(NO_VISITORS);
        else System.out.printf("%d%n%d", ans1, ans2);
    }
}
