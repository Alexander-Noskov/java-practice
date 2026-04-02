package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColoredLineTest {
    Point p1;
    Point p2;
    ColoredLine line;

    @BeforeEach
    void setUp() throws Exception {
        p1 = new Point(1,1);
        p2 = new Point(2,2);
        line = new ColoredLine(p1, p2, 0);
    }

    @Test
    void testColoredLine() {
        assertEquals(0, line.getColor());
    }

    @Test
    void testColoredLine2() {
        line.setColor(1);
        assertEquals(1, line.getColor());
    }

}