import java.util.Scanner;

public class Main {
    static int T;
    static

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int cnt = 0;
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == '(') cnt++;
                if (ch == ')') cnt--;
                if (cnt < 0) break;
            }
            System.out.println(cnt == 0 ? "YES" : "NO");
        }
    }
}
