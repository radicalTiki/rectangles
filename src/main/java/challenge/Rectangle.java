package challenge;

import lombok.Data;

import java.util.Arrays;

@Data
class Rectangle {
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
     * Determine whether this rectangle is wholly contained within
     * another rectangle
     */
    boolean isContained(Rectangle r) {
        // check opposite corners of this rectangle are within the bounds of the opposite corners of
        // the check rectangle
        // bottom left corner
        return (this.x > r.x && this.x < r.x + r.width && this.y > r.y && this.y < r.y + height)
                // top right corner
                && (this.x + this.width > r.x && this.x + this.width < r.x + r.width && this.y +
                this.height > r.y && this.y + this.height < r.y + r.height);
    }

    /**
     * Detect whether two rectangles are adjacent. Adjacency is
     * defined as the sharing of at least one side. Side sharing may be proper, sub-line or partial. A
     * sub-line share is a share where one side of rectangle A is a line that exists as a set of points
     * wholly contained on some other side of rectangle B, where partial is one where some line
     * segment on a side of rectangle A exists as a set of points on some side of Rectangle B
     */
    boolean isAdjacent(Rectangle r) {
        return (this.x > r.x && this.x < r.x + r.width && this.y > r.y && this.y < r.y + height)
                // top right corner
                && (this.x + this.width > r.x && this.x + this.width < r.x + r.width && this.y +
                this.height > r.y && this.y + this.height < r.y + r.height);
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
//            else if (this.x > r.x && this.y + this.height < r.y + r.height) {
//
//            }
//            else if (this.x > r.x && this.y + this.height < r.y + r.height) {
//
//            }


        return points;
    }
}