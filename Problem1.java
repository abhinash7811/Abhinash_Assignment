import java.util.*;

public class Problem1 {
    public static int maxCyclicSum(String s) {
        int n = s.length();
        String t = s + s;

        Set<Character> set = new HashSet<>();
        int left = 0, sum = 0, ans = 0;

        for (int right = 0; right < 2 * n; right++) {
            char ch = t.charAt(right);

            while (set.contains(ch) || right - left + 1 > n) {
                char remove = t.charAt(left);
                set.remove(remove);
                sum -= (remove - 'a' + 1);
                left++;
            }

            set.add(ch);
            sum += (ch - 'a' + 1);
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(maxCyclicSum(s));
    }
}
