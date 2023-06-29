package recursion;

// To find all possible subsequences for a given sequence (String).
// Subsequence - must be in same sequence that they appear in word

// Complexity
// Time: O(2^n)
// Space: O(n)
public class FindingSubsequences {
    public static void main(String[] args) {
        var word = "abc";
        System.out.println(getSubsequence(word));
    }

    private static String getSubsequence(String word) {
        if (word.isEmpty()) return "";

        var first = word.charAt(0);
        var rest = getSubsequence(word.substring(1));

        StringBuilder result = new StringBuilder();
        for (String subseq : rest.split(",", -1)) {
            result.append(",").append(first).append(subseq);
            result.append(",").append(subseq);
        }

        return result.substring(1);
    }
}
