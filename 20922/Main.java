import java.util.Scanner;

public class Main {
    static int n, k;
    static int ans;
    static int[] a = new int[200005];
    static int[] b = new int[100005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int en = 0;
        b[a[en]]++;
        for (int st = 0; st < n; st++) {
            while (en + 1 < n && b[a[en + 1]] < k) {
                en++;
                b[a[en]]++;
            }
            ans = Math.max(ans, en - st + 1);
            b[a[st]]--;
        }
        System.out.println(ans);
    }
}
