package challenge;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return this.getIntersectionPoints(r).size() > 2;
    }

    /**
     * Determine whether two rectangles have one or more intersecting lines,
     * the lines must cross each-other.
     */
    boolean hasIntersectingLines(Rectangle r) {
        //check if an intersection is possible with the two triangles
        //first check to see if rectangles are completely left or right of each other
        //next check to see if rectangles are completely above or below each other
        return !((Math.min(this.x + this.width, r.x + r.width) - Math.max(this.x, r.x)) < 0 ||
                Math.min(this.y + this.height, r.y + r.height) - Math.max(this.y, r.y) < 0);
    }

    /**
     * Produce a result identifying the points of intersection
     */
    List<Point> getIntersectionPoints(Rectangle r) {
        Map<Point, Integer> pointMap = new HashMap<>();

        //Add all this rectangle x,y points to map
        IntStream.rangeClosed(this.x, this.x + this.width).forEach(e -> {
            pointMap.merge(new Point(e, this.y), 1, Integer::sum);
            pointMap.merge(new Point(e, this.y + this.height), 1, Integer::sum);
        });

        IntStream.rangeClosed(this.y + 1, this.y + this.height - 1).forEach(e -> {
            pointMap.merge(new Point(this.x, e), 1, Integer::sum);
            pointMap.merge(new Point(this.x + this.width, e), 1, Integer::sum);
        });

        //Add all check rectangle x,y points to map
        IntStream.rangeClosed(r.x, r.x + r.width).forEach(e -> {
            pointMap.merge(new Point(e, r.y), 1, Integer::sum);
            pointMap.merge(new Point(e, r.y + r.height), 1, Integer::sum);
        });

        IntStream.rangeClosed(r.y + 1, r.y + r.height - 1).forEach(e -> {
            pointMap.merge(new Point(r.x, e), 1, Integer::sum);
            pointMap.merge(new Point(r.x + r.width, e), 1, Integer::sum);
        });

        return pointMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}