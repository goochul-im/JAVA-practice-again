package classEx;

import java.util.HashMap;
import java.util.Objects;

public class HashCodeEx {

    public static void main(String[] args) {

        HashMap<Point, String> map = new HashMap<>();

        Point p1 = new Point(10, 20);
        map.put(p1, "this is 10 and 20");
        System.out.println(map.get(p1));
        System.out.println(map.get(new Point(10, 20)));

        p1.x = 30;
        System.out.println(map.get(new Point(10, 20)));

    }

    private static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y; // x와 y가 같으면 같은 객체다!
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
