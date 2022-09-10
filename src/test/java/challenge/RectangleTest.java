package challenge;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Points will be in order from bottom left, top left, bottom right, top right
 */
public class RectangleTest {

    @Test
    public void testIsRectangleContained() {
        //  xxxxxxxxxxx
        //  x   xxxxx x
        //  x   xxxxx x
        //  xxxxxxxxxxx
        Rectangle rect1 = new Rectangle(0, 1, 10, 5);
        Rectangle rect2 = new Rectangle(4, 2, 5, 2);

        Assert.assertTrue(rect2.isContained(rect1));
    }

    @Test
    public void testIsRectangleContainedFalse() {
        //  xxxxxxxxxxx
        //  x         x
        //  x   xxxxx x
        //  xxxxxxxxxxx
        //      xxxxx
        Rectangle rect1 = new Rectangle(0, 1, 10, 5);
        Rectangle rect2 = new Rectangle(4, 0, 5, 2);

        Assert.assertFalse(rect2.isContained(rect1));
    }

    @Test
    public void testIsAdjacentPartial() {
        //  xxxxxxxxxxx
        //  x   xxxxxxx
        //  x   x     x
        //  xxxxxxxxxxx
        //      xxxxxxx
        Rectangle rect1 = new Rectangle(0, 1, 10, 5);
        Rectangle rect2 = new Rectangle(4, 0, 6, 3);

        Assert.assertTrue(rect2.isAdjacent(rect1));
    }

    @Test
    public void testIsAdjacentSubLine() {
        //  xxxxxxxxxxx
        //  x         x
        //  x   xxxxxxx
        //  xxxxxxxxxxx
        Rectangle rect1 = new Rectangle(0, 1, 10, 5);
        Rectangle rect2 = new Rectangle(4, 1, 6, 2);

        Assert.assertTrue(rect2.isAdjacent(rect1));
    }

    @Test
    public void testIsAdjacentFalse() {
        //  xxxxxxxxxxx
        //  x         x
        //  x         x
        //  x   xxxxx x
        //  xxxxxxxxxxx
        //      xxxxx
        Rectangle rect1 = new Rectangle(0, 1, 10, 5);
        Rectangle rect2 = new Rectangle(4, 0, 5, 2);

        Assert.assertFalse(rect2.isAdjacent(rect1));
    }

    @Test
    public void hasIntersectingLinesTrue() {
        //  xxxxxxxxxxx
        //  x         x
        //  x   xxxxx x
        //  xxxxxxxxxxx
        //      xxxxx
        Rectangle rect1 = new Rectangle(0, 1, 10, 5);
        Rectangle rect2 = new Rectangle(4, 0, 5, 3);

        Assert.assertTrue(rect1.hasIntersectingLines(rect2));
    }

    @Test
    public void hasIntersectingLinesFalse() {
        //  xxxxxxxxxxx
        //  x         x
        //  x         x xxxxxx
        //  xxxxxxxxxxx xxxxxx
        Rectangle rect1 = new Rectangle(0, 1, 10, 5);
        Rectangle rect2 = new Rectangle(12, 1, 5, 2);

        Assert.assertFalse(rect1.hasIntersectingLines(rect2));
    }

    @Test
    public void testGetIntersectionFor2Points() {
        //  xxxxxxxxxxx
        //  x         x
        //  x   xxxxx x
        //  xxxxxxxxxxx
        //      xxxxx
        Rectangle rect1 = new Rectangle(0, 1, 10, 5);
        Rectangle rect2 = new Rectangle(4, 0, 5, 2);

        List<Point> points = rect1.getIntersectionPoints(rect2);

        Assert.assertTrue(points.contains(new Point(4, 1)));
        Assert.assertTrue(points.contains(new Point(9, 1)));
    }
}
