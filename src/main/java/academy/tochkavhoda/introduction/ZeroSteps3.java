package academy.tochkavhoda.introduction;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ZeroSteps3 {

    public int sum(int[] array) {
        return Arrays.stream(array)
                .sum();
    }

    public int mul(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        return Arrays.stream(array)
                .reduce(1, (a, b) -> a * b);
    }

    public int min(int[] array) {
        return Arrays.stream(array)
                .min()
                .orElse(Integer.MAX_VALUE);
    }

    public int max(int[] array) {
        return Arrays.stream(array)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    public double average(int[] array) {
        return Arrays.stream(array)
                .average()
                .orElse(0.0);
    }

    public boolean isSortedDescendant(int[] array) {
        if (array.length == 0) return true;
        return IntStream.range(1, array.length)
                .allMatch(i -> array[i] < array[i - 1]);
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {
        return Arrays.stream(array)
                .anyMatch(n -> n == value);
    }

    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int j = array.length - 1 - i;
            int tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
    }

    public boolean isPalindrome(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) return false;
        }
        return true;
    }

    public void replaceBySquare(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) return;
            array[i] *= array[i];
        }
    }

    public int mulNonZero(int[] array) {
        if (array.length == 0) return 0;
        return Arrays.stream(array)
                .filter(n -> n != 0)
                .reduce(1, (a, b) -> a * b);
    }

    public boolean allPositive(int[] array) {
        if (array.length == 0) return false;
        for (int n : array) {
            if (n <= 0) return false;
        }
        return true;
    }

    public boolean allEqual(int[] array) {
        for (int n : array) {
            if (n != array[0]) return false;
        }
        return true;
    }

    public int greaterThanNeighbours(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) return i;
        }
        return -1;
    }

    public boolean neighboursAverage(double[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] == (array[i - 1] + array[i + 1]) / 2) return true;
        }
        return false;
    }

    public int sumBetween2Zeros(int[] array) {
        int result = 0;
        int ind = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 0) {
                ind = i;
                break;
            }
        }
        for (int i = ind + 1; i < array.length; i++) {
            if (array[i] == 0) return result;
            result += array[i];
        }
        return result;
    }

    public int sameAtPosition(int[] array1, int[] array2) {
        int count = 0;
        for (int i = 0; i < Math.min(array1.length, array2.length); i++) {
            if (array1[i] == array2[i]) {
                count++;
            }
        }
        return count;
    }

    public boolean bothZeroAtPosition(int[] array1, int[] array2) {
        for (int i = 0; i < Math.min(array1.length, array2.length); i++) {
            if (array1[i] == array2[i] && array1[i] == 0) return true;
        }
        return false;
    }

    public void accumulatedSum(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
    }

    public int[] mergeArrays(int[] array1, int[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;

        int[] result = new int[len1 + len2];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < len1 && j < len2) {
            if (array1[i] <= array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }

        while (i < len1) {
            result[k++] = array1[i++];
        }

        while (j < len2) {
            result[k++] = array2[j++];
        }

        return result;
    }

    public int insideCircle(int[] x, int[] y, int radius) {
        if (x == null || y == null || x.length != y.length) {
            return 0;
        }

        int count = 0;
        int radiusSquared = radius * radius;

        for (int i = 0; i < x.length; i++) {
            int xi = x[i];
            int yi = y[i];

            int distanceSquared = xi * xi + yi * yi;

            if (distanceSquared <= radiusSquared) {
                count++;
            }
        }

        return count;
    }

    public double scalarProduct(double[] array1, double[] array2) {
        double result = 0;
        for (int i = 0; i < array1.length; i++) {
            result += array1[i] * array2[i];
        }
        return result;
    }
}
