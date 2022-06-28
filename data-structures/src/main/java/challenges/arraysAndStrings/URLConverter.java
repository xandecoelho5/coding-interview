package challenges.arraysAndStrings;

public class URLConverter {

    public String urlify(String url, int length) {
        // Create a bucket to hold our final result
        char[] result = new char[length];

        // Strip off any space at beginning or end
        url = url.trim();

        // Loop through url, and insert an ASCII space '%20' whenever we hit a space
        char[] urlChars = url.toCharArray();

        // Also create a pointer to keep track of where we are in our results array
        int pointer = 0;

        for (char urlChar : urlChars) {
            if (urlChar != ' ') {
                result[pointer] = urlChar;
                pointer++;
            } else {
                result[pointer] = '%';
                result[pointer + 1] = '2';
                result[pointer + 2] = '0';
                pointer = pointer + 3;
            }
            System.out.println("...");
        }

        return String.valueOf(result);
    }

    private void prettyPrint(char[] chars) {
        for (char aChar : chars) {
            System.out.println("c[" + aChar + "]");
        }
    }

    // My solution
    public String urlify2(String url) {
        return url.trim().replaceAll(" ", "%20");
    }
}
