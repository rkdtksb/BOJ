import java.util.Scanner;

public class Main {
    static int t;

    static boolean dfs(String str) {
        if (str.length() == 1) return true;
        int mid = str.length() / 2;
        String l = str.substring(0, mid);
        String r = str.substring(mid + 1);
        for (int i = 0; i < mid; i++) {
            char lc = l.charAt(i);
            char rc = r.charAt(mid - 1 - i);
            if (lc == rc) return false;
        }
        return dfs(l);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();
            if (dfs(str)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
