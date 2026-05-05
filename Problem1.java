import java.util.*;

// Problem 1: Cyclic Substring Maximum Sum
// Key insight: max sum = sum of values of all DISTINCT characters in S
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine().trim();

        Set<Character> unique = new HashSet<>();
        for (char c : S.toCharArray()) {
            unique.add(c);
        }

        int maxSum = 0;
        for (char c : unique) {
            maxSum += (c - 'a' + 1);
        }

        System.out.println(maxSum);
    }
}
