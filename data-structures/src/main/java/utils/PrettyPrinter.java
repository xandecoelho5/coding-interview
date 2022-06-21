package utils;

public class PrettyPrinter {

    public static void printMatrix(int[][] matrix) {

        int rowCount = matrix.length; // y
        int columnCount = matrix[0].length; // x

        for (int[] ints : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < columnCount; col++) {
                sb.append(ints[col]).append(" ");
            }
            System.out.println(sb);
        }
        System.out.println("");
    }
}
