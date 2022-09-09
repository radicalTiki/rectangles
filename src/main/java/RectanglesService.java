import lombok.Data;

import java.util.Arrays;

class RectanglesService {

    @Data
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Data
    static class Rectangle {
        int x;
        int y;
        int width;
        int height;

        Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        /**
         * Determine the points of intersection given two rectangles
         */
        Point[] getIntersectionPoints(Rectangle r) {
            //check if an intersection is possible with the two triangles
            //first check to see if rectangles are completely left or right of each other
            //next check to see if rectangles are completely above or below each other
            if ((Math.min(this.x + this.width, r.x + r.width) - Math.max(this.x, r.x)) < 0 ||
                    Math.min(this.y + this.height, r.y + r.height) - Math.max(this.y, r.y) < 0) {
                return null;
            }

            int[] x_axis_points = {this.x, this.x + this.width, r.x, r.x + r.width};
            int[] y_axis_points = {this.y, this.y + this.height, r.y, r.y + r.height};

            Arrays.sort(x_axis_points);
            Arrays.sort(y_axis_points);

            Point[] points = new Point[2];
            
            //check if this rectangle shares a edge with the check rectangle
            if (this.x == r.x || this.y == r.y || this.x + this.width == r.x + r.width ||
                    this.y + this.height == r.y + r.height) {
                //shared edge logic, no more than 1 point
            }
            else {
                //2 point intersection
                int maxDifference = Math.max(this.x + this.width, r.x + r.width) -
                        Math.min(this.x + this.width, r.x + r.width);
                int minDifference = Math.max(this.x, r.x) - Math.min(this.x, r.x);

                if (this.x < r.x && this.y + this.height < r.y + r.height) {
                    points[0] = new Point(x_axis_points[1], y_axis_points[1]);
                    points[1] = new Point(x_axis_points[2], y_axis_points[1]);
                }
            }

            //this rectangle is to the right of the check rectangle and height is above check triangle
            //points are on the same
            else if (this.x > r.x && this.y + this.height < r.y + r.height) {

            }
            else if (this.x > r.x && this.y + this.height < r.y + r.height) {

            }


            return points;
        }
    }
}
