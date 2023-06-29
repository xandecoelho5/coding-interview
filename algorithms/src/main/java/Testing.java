import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Testing {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String s = read.readLine().trim();

            Solution ob = new Solution();
            String ans = ob.rearrange(s, N);

            System.out.println(ans);
        }
    }


}

class Solution {
    public String rearrange(String S, int N) {
        var first = sort(S.replaceAll("[^aeiou]", ""));
        var second = sort(S.replaceAll("[aeiou]", ""));

        if (first.length() - second.length() < -1 || first.length() - second.length() > 1) return "-1";

        if (second.length() > first.length() || (second.charAt(0) < first.charAt(0))) {
            String aux = first;
            first = second;
            second = aux;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0, j = 0, k = 0; i < N; i++) {
            if (i % 2 == 0) {
                res.append(first.charAt(j++));
            } else {
                res.append(second.charAt(k++));
            }
        }
        return res.toString();
    }

    private static String sort(String inputString) {
        char[] tempArray = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
