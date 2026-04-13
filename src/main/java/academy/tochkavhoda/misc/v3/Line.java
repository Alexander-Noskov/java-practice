package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.figures.v3.Point;
import academy.tochkavhoda.iface.v3.Movable;

import java.util.Objects;

public class Line implements Movable {
    private Point start;

    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public Line() {
        this.start = new Point();
        this.end = new Point(1, 1);
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.setStart(start.getX(), start.getY());
    }

    public void setStart(int x, int y) {
        this.start.setX(x);
        this.start.setY(y);
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.setEnd(end.getX(), end.getY());
    }

    public void setEnd(int x, int y) {
        this.end.setX(x);
        this.end.setY(y);
    }

    @Override
    public void moveTo(int x, int y) {
        this.setEnd(x + this.end.getX() - this.start.getX(), y + this.end.getY() - this.start.getY());
        this.setStart(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.setStart(this.getStart().getX() + dx, this.getStart().getY() + dy);
        this.setEnd(this.getEnd().getX() + dx, this.getEnd().getY() + dy);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(start, line.start) && Objects.equals(end, line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
