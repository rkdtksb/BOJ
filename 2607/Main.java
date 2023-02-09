import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int ans;
    static String tstr;
    static int[] a = new int[26];
    static int[] b = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tstr = sc.next();
        for (int i = 0; i < tstr.length(); i++) {
            a[tstr.charAt(i) - 'A']++;
        }
        for (int i = 0; i < n - 1; i++) {
            int x = 0;
            int y = 0;
            String cstr = sc.next();
            Arrays.fill(b, 0);
            for (int j = 0; j < cstr.length(); j++) {
                b[cstr.charAt(j) - 'A']++;
            }
            for (int j = 0; j < 26; j++) {
                if (a[j] > b[j]) x += a[j] - b[j];
                if (a[j] < b[j]) y += b[j] - a[j];
            }
            if (x < 2 && y < 2) ans++;
        }
        System.out.println(ans);
    }
}
