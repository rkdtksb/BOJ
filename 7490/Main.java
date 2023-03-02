import java.util.Scanner;

public class Main {
    static int t, n;

    static void dfs(int cur, int num, int sum, int sign, String ans) {
        if (cur == n) {
            sum += num * sign;
            if (sum == 0) System.out.println(ans);
            return;
        }
        int nxt = cur + 1;
        dfs(nxt, num * 10 + nxt, sum, sign, ans + " " + nxt);
        dfs(nxt, nxt, sum + num * sign, 1, ans + "+" + nxt);
        dfs(nxt, nxt, sum + num * sign, -1, ans + "-" + nxt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            dfs(1, 1, 0, 1, "1");
            System.out.println();
        }
    }
}
