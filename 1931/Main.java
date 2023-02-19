import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int ans, cur;
    static int[][] a = new int[100005][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        Arrays.sort(a, 0, n, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        ans = 0;
        cur = 0;
        for (int i = 0; i < n; i++) {
            if (a[i][0] >= cur) {
                ans++;
                cur = a[i][1];
            }
        }
        System.out.println(ans);
    }
}
