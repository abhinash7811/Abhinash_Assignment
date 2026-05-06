import java.util.*;

public class Problem2 {
    public static long minOperations(int[] arr, int k) {
        int n = arr.length;

        int rem = arr[0] % k;
        for (int x : arr) {
            if (x % k != rem) return -1;
        }

        Arrays.sort(arr);
        int target = arr[n / 2];

        long ops = 0;
        for (int x : arr) {
            ops += Math.abs(x - target) / k;
        }

        return ops;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(minOperations(arr, k));
    }
}
