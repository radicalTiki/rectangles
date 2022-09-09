package challenge;

import org.junit.Assert;
import org.junit.Test;

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
        //  x         x
        //  x   xxxxxxx
        //  xxxxxxxxxxx
        //      xxxxxxx
        Rectangle rect1 = new Rectangle(0, 1, 10, 5);
        Rectangle rect2 = new Rectangle(4, 0, 6, 2);

        Assert.assertTrue(rect2.isContained(rect1));
    }

    @Test
    public void testIsAdjacentSubLine() {
        //  xxxxxxxxxxx
        //  x         x
        //  x   xxxxxxx
        //  xxxxxxxxxxx
        Rectangle rect1 = new Rectangle(0, 1, 10, 5);
        Rectangle rect2 = new Rectangle(4, 1, 6, 2);

        Assert.assertTrue(rect2.isContained(rect1));
    }

    @Test
    public void testIsAdjacentFalse() {
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
    public void testGetIntersectionFor2Points() {
        //  xxxxxxxxxxx
        //  x         x
        //  x   xxxxx x
        //  xxxxxxxxxxx
        //      xxxxx
        Rectangle rect1 = new Rectangle(0, 1, 10, 5);
        Rectangle rect2 = new Rectangle(4, 0, 5, 2);

        Point[] points = rect1.getIntersectionPoints(rect2);

        System.out.println("IntersectionPoints: " + points[0] + " " + points[1]);
        Assert.assertEquals(points[0].x, 4);
        Assert.assertEquals(points[0].y, 1);
        Assert.assertEquals(points[1].x, 9);
        Assert.assertEquals(points[1].y, 1);
    }
}
