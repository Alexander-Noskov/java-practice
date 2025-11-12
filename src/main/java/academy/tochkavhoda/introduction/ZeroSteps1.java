package academy.tochkavhoda.introduction;

public class ZeroSteps1 {
    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public double calculateTriangleSquare(int side1, int side2) {
        return side1 * side2 / 2.0;
    }

    public double calculateTrianglePerimeter(int side1, int side2) {
        return side1 + side2 + Math.sqrt(side1 * side1 + side2 * side2);
    }

    public int reverseNumber(int number) {
        int first = number % 10 * 100;
        int second = number / 10 % 10 * 10;
        int third = number / 100 % 10;
        return first + second + third;
    }

    public long calculate15Degree(int number) {
        return (long) Math.pow(number, 15);
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public double sqrtAbs(int number) {
        return Math.sqrt(Math.abs(number));
    }

    public boolean isTriangleExist(int side1, int side2, int side3) {
        return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }

    public int getDigitsProduction(int number) {
        int num1 = number % 10;
        int num2 = number / 10 % 10;
        int num3 = number / 100 % 10;
        int num4 = number / 1000 % 10;
        return num1 * num2 * num3 * num4;
    }

    public boolean isCircleInsideSquare(int radius, int side) {
        return radius * 2 < side;
    }

    public char getCharByCode(short code) {
        return (char) code;
    }

    public short getCodeByChar(char character) {
        return (short) character;
    }

    public char getCharByCodeAndOffset(char ch, short offset) {
        return (char) ((short) ch + offset);
    }

    public boolean isGreaterOrEqual(char ch1, char ch2) {
        return (short) ch1 >= (short) ch2;
    }

    public char getAverageChar(char ch1, char ch2) {
        return (char) (((short) ch1 + (short) ch2) / 2);
    }
}
