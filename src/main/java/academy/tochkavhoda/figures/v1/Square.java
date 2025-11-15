package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Square {
    private Point topLeft;
    private int size;

    public Square(Point leftTop, int size) {
        this.topLeft = leftTop;
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        topLeft = new Point(xLeft, yTop);
        this.size = size;
    }

    public Square(int size) {
        topLeft = new Point(0, -size);
        this.size = size;
    }

    public Square() {
        this(1);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return new Point(topLeft.getX() + size, topLeft.getY() + size);
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getLength() {
        return size;
    }

    public void moveTo(int x, int y) {
        topLeft.moveTo(x, y);
    }

    public void moveTo(Point point) {
        topLeft.moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        size = (int) (size * ratio);
    }

    public double getArea() {
        return size * size;
    }

    public double getPerimeter() {
        return 4 * size;
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= topLeft.getX() + size &&
                y >= topLeft.getY() && y <= topLeft.getY() + size;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Square square) {
        int left1 = topLeft.getX();
        int right1 = topLeft.getX() + size;
        int top1 = topLeft.getY();
        int bottom1 = topLeft.getY() + size;

        int left2 = square.topLeft.getX();
        int right2 = square.topLeft.getX() + square.size;
        int top2 = square.topLeft.getY();
        int bottom2 = square.topLeft.getY() + square.size;

        return !(right1 < left2 || left1 > right2 || bottom1 < top2 || top1 > bottom2);
    }

    public boolean isInside(Square square) {
        return square.topLeft.getX() >= topLeft.getX() && square.topLeft.getX() + square.size <= topLeft.getX() + size &&
                square.topLeft.getY() >= topLeft.getY() && square.topLeft.getY() + square.size <= topLeft.getY() + size;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return size == square.size && Objects.equals(topLeft, square.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, size);
    }
}
