import java.util.Scanner;

public class Main {
    static int ans;
    static int[] a = new int[10];
    static int[] b = new int[10];

    static void dfs(int k) {
        if (k == 10) {
            for (int i = 2; i < 10; i++) {
                if (b[i - 2] == b[i] && b[i - 1] == b[i]) return;
            }
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                if (a[i] == b[i]) cnt++;
            }
            if (cnt >= 5) ans++;
            return;
        }
        for (int i = 1; i <= 5; i++) {
            b[k] = i;
            dfs(k + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        dfs(0);
        System.out.println(ans);
    }
}
