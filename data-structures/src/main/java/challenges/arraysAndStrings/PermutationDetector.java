package challenges.arraysAndStrings;

import java.util.Arrays;

public class PermutationDetector {

    public boolean isPermutation(String text, String perm) {
        if (perm.length() != text.length()) return false;

        return sort(text).equals(sort(perm));
    }

    private String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    // My solution
    public boolean isPermutation2(String a, String b) {
        if (a.length() != b.length()) return false;

        Arrays.sort(a.toCharArray());

        char[] tempArray = a.toCharArray();
        Arrays.sort(tempArray);
        a = new String(tempArray);

        char[] tempArrayB = b.toCharArray();
        Arrays.sort(tempArrayB);
        b = new String(tempArrayB);

        return a.equals(b);
    }
}
