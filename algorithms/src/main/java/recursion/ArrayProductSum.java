package recursion;

import java.util.ArrayList;
import java.util.List;

// Complexity
// Time: O(n)
// Space: O(d) -> depth size
public class ArrayProductSum {

    public static void main(String[] args) {
        var list = new ArrayList<Object>(List.of(1, 2, new ArrayList<>(List.of(3, 2)), 6, new ArrayList<>(List.of(new ArrayList<>(List.of(2, 4)), 1)), 7));
        System.out.println(list); // 3 + 10 + 6 + 38 + 7 => 64
        System.out.println(productSum(list, 1));
    }

    private static int productSum(List<Object> list, int depth) {
        var sum = 0;
        for (Object obj : list) {
            if (obj instanceof List) sum += productSum((List) obj, depth + 1);
            else sum += (Integer) obj;
        }
        return sum * depth;
    }
}
