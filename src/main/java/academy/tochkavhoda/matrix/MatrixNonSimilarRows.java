package academy.tochkavhoda.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MatrixNonSimilarRows {
    private final int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        this.matrix = matrix;
    }

    public Set<int[]> getNonSimilarRows() {
        if (matrix.length == 0) {
            return new LinkedHashSet<>();
        }

        Set<Set<Integer>> seenSets = new HashSet<>();
        Set<int[]> result = new LinkedHashSet<>();

        Arrays.stream(matrix)
                .forEach(row -> {
                    Set<Integer> rowSet = getUniqueNumbers(row);
                    if (!seenSets.contains(rowSet)) {
                        result.add(row);
                        seenSets.add(rowSet);
                    }
                });

        return result;
    }

    private Set<Integer> getUniqueNumbers(int[] row) {
        Set<Integer> uniqueSet = new HashSet<>();

        if (row != null) {
            for (int num : row) {
                uniqueSet.add(num);
            }
        }

        return uniqueSet;
    }
}
