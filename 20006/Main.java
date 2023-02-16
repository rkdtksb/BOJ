import java.util.*;

public class Main {
    static class Pair {
        int l;
        String n;

        public Pair(int l, String n) {
            this.l = l;
            this.n = n;
        }
    }

    static int p, m;
    static Queue<Pair> Q = new ArrayDeque<>();
    static PriorityQueue<Pair> PQ = new PriorityQueue<>(
            (a, b) -> a.n.compareTo(b.n));
    static final String WAIT = "Waiting!", START = "Started!";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        p = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < p; i++) {
            int l = sc.nextInt();
            String n = sc.next();
            Q.offer(new Pair(l, n));
        }
        while (!Q.isEmpty()) {
            Pair cur = Q.peek(); Q.poll();
            int sz = Q.size();
            int mn = cur.l - 10;
            int mx = cur.l + 10;
            PQ.offer(cur);
            for (int i = 0; i < sz; i++) {
                Pair nxt = Q.peek(); Q.poll();
                if (mn <= nxt.l && nxt.l <= mx && PQ.size() < m) PQ.offer(nxt);
                else Q.offer(nxt);
            }
            if (PQ.size() == m) System.out.println(START);
            if (PQ.size() < m) System.out.println(WAIT);
            while (!PQ.isEmpty()) {
                Pair nxt = PQ.peek(); PQ.poll();
                System.out.printf("%d %s%n", nxt.l, nxt.n);
            }
        }
    }
}
