import java.util.Scanner;

public class Main {
    static String str;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '0') n++;
            if (ch == '1') m++;
        }
        n /= 2;
        m /= 2;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '0' && n > 0) {
                System.out.print(0);
                n--;
            }
            else if (ch == '1' && m > 0) {
                m--;
            }
            else if (ch == '1' && m == 0) {
                System.out.print(1);
            }
        }
    }
}
