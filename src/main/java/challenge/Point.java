package challenge;

import lombok.Data;

import java.util.Objects;

@Data
public class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object check) {
        if (check.getClass() == Point.class) {
            Point point = (Point)check;
            return x == point.x && y == point.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}