package academy.tochkavhoda.introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroSteps4 {

    public int min(int[][] matrix) {
        int minValue = Integer.MAX_VALUE;
        for (int[] i : matrix) {
            for (int j : i) {
                if (j < minValue) {
                    minValue = j;
                }
            }
        }
        return minValue;
    }

    public int max(int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;
        for (int[] i : matrix) {
            for (int j : i) {
                if (j > maxValue) {
                    maxValue = j;
                }
            }
        }
        return maxValue;
    }

    public boolean find(int[][] matrix, int value) {
        for (int[] i : matrix) {
            for (int j : i) {
                if (j == value) return true;
            }
        }
        return false;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] >= arr[i - 1]) return false;
            }
        }
        return true;
    }

    public int hasNoZeroRows(int[][] matrix) {
        int count = 0;
        for (int[] arr : matrix) {
            boolean hasZero = false;
            for (int i : arr) {
                if (i == 0) {
                    hasZero = true;
                    break;
                }
            }
            if (!hasZero) count++;
        }
        return count;
    }

    public boolean hasFullZeroRow(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    break;
                }
                if (i == arr.length - 1) return true;
            }
        }
        return false;
    }

    public boolean isSymmetric(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i]) return false;
            }
        }
        return true;
    }

    public int mainDiagonalMax(int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[i][i] > maxValue) {
                maxValue = matrix[i][i];
            }
        }
        return maxValue;
    }

    public int mainDiagonalPositivesSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[i][i] > 0) {
                sum += matrix[i][i];
            }
        }
        return sum;
    }

    public int secondaryDiagonalMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[matrix.length - 1 - i][i] > max) {
                max = matrix[matrix.length - 1 - i][i];
            }
        }
        return max;
    }

    public int secondaryDiagonalPositivesSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[matrix.length - 1 - i][i] > 0) {
                sum += matrix[matrix.length - 1 - i][i];
            }
        }
        return sum;
    }

    public int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int[][] sum = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int cols = matrix1[i].length;
            sum[i] = new int[cols];
            for (int j = 0; j < cols; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return sum;
    }

    public void transpose(int[][] matrix) {
        int len = matrix[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public void interchange(int[][] matrix) {
        int len = matrix[0].length;

        for (int i = 0; i < len; i += 2) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[i + 1];
            matrix[i + 1] = tmp;
        }
    }

    public int[] toLinearByRow(int[][] matrix) {
        int len = Arrays.stream(matrix)
                .map(m -> m.length)
                .reduce(0, Integer::sum);
        int[] result = new int[len];
        int i = 0;
        for (int[] r : matrix) {
            for (int v : r) {
                result[i] = v;
                i++;
            }
        }
        return result;
    }

    public int[] toLinearByColumn(int[][] matrix) {
        int len = matrix[0].length;
        int[] result = new int[len * len];
        int i = 0;

        for (int j = 0; j < len; j++) {
            for (int k = 0; k < len; k++) {
                result[i] = matrix[k][j];
                i++;
            }
        }
        return result;
    }

    public int[] toLinearByRowUpperTriangle(int[][] matrix) {
        int len = matrix[0].length;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                nums.add(matrix[i][j]);
            }
        }
        return nums.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int sumUntilNotFoundInRow(int[][] matrix, int barrier) {
        int sum = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == barrier) break;
                sum += anInt;
            }
        }
        return sum;
    }

    public int sumUntilNotFound(int[][] matrix, int barrier) {
        int sum = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == barrier) return sum;
                sum += anInt;
            }
        }
        return sum;
    }
}
