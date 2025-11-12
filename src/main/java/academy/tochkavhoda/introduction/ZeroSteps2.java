package academy.tochkavhoda.introduction;

import java.util.Random;

public class ZeroSteps2 {

    public int sumSquares(int count) {
        int result = 0;

        for (int i = 1; i <= count; i++) {
            result += i * i;
        }
        return result;
    }

    public int sumOdds(int count) {
        int result = 0;

        for (int i = 1; i <= count; i += 2) {
            result += i;
        }
        return result;
    }

    public double sumInverses(int count) {
        double result = 0;

        for (int i = 1; i <= count; i++) {
            result += 1.0 / i;
        }
        return result;
    }

    public long factorial(int count) {
        long result = 1;

        for (int i = 2; i <= count; i++) {
            result *= i;
        }
        return result;
    }

    public int prodDigits(int value) {
        int result = 1;

        while (value > 1) {
            result *= value % 10;
            value /= 10;
        }
        return result;
    }

    public int fibonacci(int number) {
        if (number < 2) return number;

        int result = 0;
        int prev = 1;
        int prevPrev = 0;

        for (int i = 2; i <= number; i++) {
            result = prev + prevPrev;
            prevPrev = prev;
            prev = result;
        }
        return result;
    }

    public long sum2Powers(int max) {
        long result = 0;

        for (int i = 0; i <= max; i++) {
            result += (long) Math.pow(2, i);
        }
        return result;
    }

    public int sumSquaresWithBarrier(int count, int barrier) {
        int i = 1;
        int result = 0;

        while (barrier >= result && i <= count) {
            result += i * i;
            i++;
        }
        return result;
    }

    public int sumPairProd(int count1, int count2) {
        int result = 0;

        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                result += i * j;
            }
        }
        return result;
    }

    public int sumPairProdWithBarrier(int count1, int count2, int barrier) {
        int result = 0;

        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                if (i * j < barrier) {
                    result += i * j;
                }
            }
        }
        return result;
    }

    public double sumInversePairProd(int count1, int count2) {
        double result = 0;

        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                result += (1.0 / i) * (1.0 / j);
            }
        }
        return result;
    }

    public int sumTripleProd(int count1, int count2, int count3) {
        int result = 0;

        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                for (int k = 1; k <= count3; k++) {
                    result += i * j * k;
                }
            }
        }
        return result;
    }

    public double calculateE() {
        double e = 1.0;
        double current = 1.0;
        int n = 1;

        while (current >= 1e-6) {
            current /= n;
            e += current;
            n++;
        }
        return e;
    }

    public double calculatePi() {
        return Math.PI;
    }

    public double calculateCircleSquare(double length, int count) {
        Random random = new Random();
        int k = 0;

        double radius = length / 2.0;
        double centerX = length / 2.0;
        double centerY = length / 2.0;

        for (int i = 0; i < count; i++) {
            double x = random.nextDouble() * length;
            double y = random.nextDouble() * length;

            double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));

            if (distance <= radius) {
                k++;
            }
        }
        return length * length * k / count;
    }
}
