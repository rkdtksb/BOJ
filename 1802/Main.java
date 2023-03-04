import java.util.Scanner;

public class Main {
    static int t;

    static boolean dfs(String str) {
        if (str.length() == 1) return true;
        int mid = str.length() / 2;
        String l = str.substring(0, mid);
        String r = str.substring(mid + 1);
        for (int i = 0; i < l.length(); i++) {
            char lc = l.charAt(i);
            char rc = r.charAt(r.length() - 1 - i);
            if (lc == rc) return false;
        }
        return dfs(l);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();
            System.out.println(dfs(str) ? "YES" : "NO");
        }
    }
}
