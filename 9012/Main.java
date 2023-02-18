import java.util.Scanner;

public class Main {
    static int t;
    static final String VALID = "YES", INVALID = "NO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int cnt = 0;
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == '(') cnt++;
                if (ch == ')') cnt--;
                if (cnt < 0) break;
            }
            if (cnt == 0) System.out.println(VALID);
            else System.out.println(INVALID);
        }
    }
}
