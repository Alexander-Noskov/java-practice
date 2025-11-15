package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.topLeft = leftTop;
        this.bottomRight = rightBottom;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        topLeft = new Point(xLeft, yTop);
        bottomRight = new Point(xRight, yBottom);
    }

    public Rectangle(int length, int width) {
        topLeft = new Point(0, -width);
        bottomRight = new Point(length, 0);
    }

    public Rectangle() {
        topLeft = new Point(0, -1);
        bottomRight = new Point(1, 0);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    public int getWidth() {
        return bottomRight.getY() - topLeft.getY();
    }

    public void moveTo(int x, int y) {
        bottomRight.moveTo(x + getLength(),y + getWidth());
        topLeft.moveTo(x, y);

    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        moveTo(topLeft.getX() + dx, topLeft.getY() + dy);
    }

    public void resize(double ratio) {
        bottomRight.setX(topLeft.getX() + (int) (getLength() * ratio));
        bottomRight.setY(topLeft.getY() + (int) (getWidth() * ratio));
    }

    public void stretch(double xRatio, double yRatio) {
        bottomRight.setX(topLeft.getX() + (int) (getLength() * xRatio));
        bottomRight.setY(topLeft.getY() + (int) (getWidth() * yRatio));
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= bottomRight.getX() && y >= topLeft.getY() && y <= bottomRight.getY();
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Rectangle rectangle) {
        int left1 = this.topLeft.getX();
        int right1 = this.bottomRight.getX();
        int top1 = this.topLeft.getY();
        int bottom1 = this.bottomRight.getY();

        int left2 = rectangle.topLeft.getX();
        int right2 = rectangle.bottomRight.getX();
        int top2 = rectangle.topLeft.getY();
        int bottom2 = rectangle.bottomRight.getY();

        return !(right1 < left2 || left1 > right2 || bottom1 < top2 || top1 > bottom2);
    }

    public boolean isInside(Rectangle rectangle) {
        return rectangle.topLeft.getX() >= topLeft.getX() && rectangle.bottomRight.getX() <= bottomRight.getX() &&
                rectangle.topLeft.getY() >= topLeft.getY() && rectangle.bottomRight.getY() <= bottomRight.getY();

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(topLeft, rectangle.topLeft) && Objects.equals(bottomRight, rectangle.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}
