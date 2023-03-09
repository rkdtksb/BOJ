import java.util.Scanner;

public class Main {
    static int t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '(') cnt++;
                if (ch == ')') cnt--;
                if (cnt < 0) break;
            }
            if (cnt == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
