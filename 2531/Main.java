import java.util.Scanner;

public class Main {
    static int n, d, k, c;
    static int ans;
    static int[] a = new int[30005];
    static int[] b = new int[3005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int cnt = 1;
        b[c]++;
        for (int i = 0; i < k; i++) {
            if (b[a[i]] == 0) cnt++;
            b[a[i]]++;
        }
        for (int i = k; i < k + n; i++) {
            if (b[a[i - k]] == 1) cnt--;
            b[a[i - k]]--;
            if (b[a[i % n]] == 0) cnt++;
            b[a[i % n]]++;
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}
