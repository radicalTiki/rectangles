import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * Points will be in order from bottom left, top left, bottom right, top right
 */
public class RectanglesServiceTest {

    @Test
    public void testGetIntersectionFor2Points() {
        //  xxxxxxxxxxx
        //  x         x
        //  x   xxxxx x
        //  xxxxxxxxxxx
        //      xxxxx
        RectanglesService.Rectangle rect1 = new RectanglesService.Rectangle(0, 1, 10, 5);
        RectanglesService.Rectangle rect2 = new RectanglesService.Rectangle(4, 0, 5, 2);

        RectanglesService service = new RectanglesService();
        RectanglesService.Point[] points = rect1.getIntersectionPoints(rect2);

        System.out.println("IntersectionPoints: " + points[0] + " " + points[1]);
        Assert.assertEquals(points[0].x, 4);
        Assert.assertEquals(points[0].y, 1);
        Assert.assertEquals(points[1].x, 9);
        Assert.assertEquals(points[1].y, 1);
    }

//    private boolean containsPoint(RectanglesService.PlotPoint[] plotPoints, double xAxisPoint, double yAxisPoint) {
//        for (RectanglesService.PlotPoint point: plotPoints) {
//            if (point.getX_AXIS_POINT() == xAxisPoint && point.getY_AXIS_POINT() == yAxisPoint)
//                return true;
//        }
//        return false;
//    }
}
