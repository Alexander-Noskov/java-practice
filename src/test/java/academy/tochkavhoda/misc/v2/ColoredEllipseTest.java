package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColoredEllipseTest {
    Point center;
    ColoredEllipse ellipse;

    @BeforeEach
    void setUp() {
        center = new Point(10, 20);
        ellipse = new ColoredEllipse(center, 10, 20);
    }

    @Test
    void testColoredEllipse1() {
        assertEquals(1, ellipse.getColor());
    }

    @Test
    void testColoredEllipse2() {
        ellipse.setColor(2);
        assertEquals(2, ellipse.getColor());
    }

}