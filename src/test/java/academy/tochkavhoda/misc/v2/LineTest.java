package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineTest {
    Point p1;
    Point p2;
    Line line;

    @BeforeEach
    void setUp() throws Exception {
        p1 = new Point(1,1);
        p2 = new Point(2,2);
        line = new Line(p1, p2);
    }

    @Test
    void testLine1() {
        assertEquals(1, line.getStart().getX());
        assertEquals(1, line.getStart().getY());
        assertEquals(2, line.getEnd().getX());
        assertEquals(2, line.getEnd().getY());
    }

    @Test
    void testLine2() {
        line.setStart(2, 2);
        line.setEnd(3, 3);

        assertEquals(2, line.getStart().getX());
        assertEquals(2, line.getStart().getY());
        assertEquals(3, line.getEnd().getX());
        assertEquals(3, line.getEnd().getY());
    }

    @Test
    void testLine3() {
        line.moveTo(0, 0);

        assertEquals(0, line.getStart().getX());
        assertEquals(0, line.getStart().getY());
        assertEquals(1, line.getEnd().getX());
        assertEquals(1, line.getEnd().getY());
    }

    @Test
    void testLine4() {
        line.moveRel(10, 10);
        assertEquals(11, line.getStart().getX());
        assertEquals(11, line.getStart().getY());
        assertEquals(12, line.getEnd().getX());
        assertEquals(12, line.getEnd().getY());
    }

}