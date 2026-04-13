package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.figures.v3.Ellipse;
import academy.tochkavhoda.figures.v3.Point;
import academy.tochkavhoda.iface.v3.Colored;

import java.util.Objects;

public class ColoredEllipse extends Ellipse implements Colored {
    private Color color;

    public ColoredEllipse(Point center, int xAxis, int yAxis, Color color) throws ColorException {
        super(center, xAxis, yAxis);
        setColor(color);
    }

    public ColoredEllipse(Point center, int xAxis, int yAxis, String color) throws ColorException {
        super(center, xAxis, yAxis);
        setColor(color);
    }

    public ColoredEllipse(Point center, int xAxis, int yAxis) {
        super(center, xAxis, yAxis);
        this.color = Color.RED;
    }

    public ColoredEllipse(int xCenter, int yCenter, int xAxis, int yAxis, Color color) throws ColorException {
        this(new Point(xCenter, yCenter), xAxis, yAxis, color);
    }


    public ColoredEllipse(int xCenter, int yCenter, int xAxis, int yAxis, String color) throws ColorException {
        this(new Point(xCenter, yCenter), xAxis, yAxis, color);
    }

    public ColoredEllipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this(new Point(xCenter, yCenter), xAxis, yAxis);
    }

    public ColoredEllipse(int xAxis, int yAxis, Color color) throws ColorException {
        super(0, 0, xAxis, yAxis);
        setColor(color);
    }

    public ColoredEllipse(int xAxis, int yAxis, String color) throws ColorException {
        super(0, 0, xAxis, yAxis);
        setColor(color);
    }

    public ColoredEllipse(int xAxis, int yAxis) {
        super(0, 0, xAxis, yAxis);
        this.color = Color.RED;
    }

    public ColoredEllipse() {
        this(1, 1);
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        if (colorString == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = Color.colorFromString(colorString);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredEllipse that = (ColoredEllipse) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
