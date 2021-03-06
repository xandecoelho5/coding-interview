package challenges.arraysAndStrings;

public class OneAwayDetector {

    public boolean oneAway(String first, String second) {

        // Let's break this down.
        // If the strings differ by > 1 length, they are not one replacement away
        // If the strings are the same length,  they are one replacement away
        // If the strings differ by one,        they may be one edit or insert away
        // If the strings differ by one less,   they may be one edit or insert away

        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        } else if (first.length() == second.length()) {
            return OneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return OneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return OneEditInsert(second, first);
        }

        return true;
    }

    // Check if you can insert a character into s1 to make s2
    // Do this by comparing characters and pointers.
    //
    // For example:
    //      pale
    //      i
    //      pble
    //      j
    //
    // As soon as you detect that one of the characters doesn't match,
    // compare the indexes. If they are the same, that's OK. That means
    // this is your first check that doesn't match. Increment the other pointer.
    // If the characters don't match again, and the pointers don't match,
    // you know they are more than one away.
    private boolean OneEditInsert(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (j < s2.length() && i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (i != j) {
                    return false;
                }
            } else {
                i++;
            }
            j++;
        }
        return true;
    }

    private boolean OneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }
}
