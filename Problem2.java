import java.util.*;

// Problem 2: Array Transformation Cost Minimization
// Key insight: all A[i] % K must be equal (feasibility).
// Minimum ops = sum of |A[i] - median| / K (median minimizes absolute deviation)
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());
        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(sc.nextLine().trim());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        long K = Long.parseLong(sc.nextLine().trim());

        if (K == 0) {
            boolean allEqual = true;
            for (int i = 1; i < N; i++) {
                if (A[i] != A[0]) { allEqual = false; break; }
            }
            System.out.println(allEqual ? 0 : -1);
            return;
        }

        // Feasibility: all remainders must be equal
        long rem = A[0] % K;
        for (int i = 1; i < N; i++) {
            if (A[i] % K != rem) {
                System.out.println(-1);
                return;
            }
        }

        // Convert to steps and find median
        long[] steps = new long[N];
        for (int i = 0; i < N; i++) {
            steps[i] = A[i] / K;
        }
        Arrays.sort(steps);
        long median = steps[N / 2];

        long totalOps = 0;
        for (long s : steps) {
            totalOps += Math.abs(s - median);
        }

        System.out.println(totalOps);
    }
}
