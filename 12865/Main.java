import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] w = new int[105];
    static int[] v = new int[105];
    static int[] d = new int[100005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= w[i]; j--) {
                d[j] = Math.max(d[j], v[i] + d[j - w[i]]);
            }
        }
        System.out.println(d[k]);
    }
}
