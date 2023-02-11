import java.util.Scanner;

public class Main {
    static int A, B;
    static int ans;
    static final int IMMUTABLE = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        ans = 1;
        while (A < B) {
            if (B % 2 == 0) {
                B /= 2;
                ans++;
            }
            else {
                if (B % 10 == 1) {
                    B -= 1;
                    B /= 10;
                    ans++;
                }
                else {
                    ans = -1;
                    break;
                }
            }
        }
        if (B < A) System.out.println(IMMUTABLE);
        else System.out.println(ans);
    }
}
