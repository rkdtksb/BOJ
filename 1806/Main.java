import java.util.Scanner;

public class Main {
    static int n, s;
    static int ans;
    static int[] a = new int[100005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        ans = 0x7f7f7f7f;
        int en = 0;
        int sum = a[en];
        for (int st = 0; st < n; st++) {
            while (en + 1 < n && sum < s) {
                en++;
                sum += a[en];
            }
            if (sum >= s) ans = Math.min(ans, en - st + 1);
            sum -= a[st];
        }
        if (ans == 0x7f7f7f7f) System.out.println(0);
        else System.out.println(ans);
    }
}
