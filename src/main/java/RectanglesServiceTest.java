import org.junit.Test;

import java.awt.*;

/**
 * Points will be in order from bottom left, top left, bottom right, top right
 */
public class RectanglesServiceTest {

    @Test
    public void testGetIntersection() {
        RectanglesService.Rectangle rect1 = new RectanglesService.Rectangle(0, 1, 10, 5);
        RectanglesService.Rectangle rect2 = new RectanglesService.Rectangle(4, 0, 5, 2);

        RectanglesService service = new RectanglesService();
        RectanglesService.Point[] points = rect1.getIntersectionPoints(rect2);

        System.out.println("IntersectionPoints: " + points[0] + " " + points[1]);
    }

//    private boolean containsPoint(RectanglesService.PlotPoint[] plotPoints, double xAxisPoint, double yAxisPoint) {
//        for (RectanglesService.PlotPoint point: plotPoints) {
//            if (point.getX_AXIS_POINT() == xAxisPoint && point.getY_AXIS_POINT() == yAxisPoint)
//                return true;
//        }
//        return false;
//    }
}
