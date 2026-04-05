package classEx;

public class EqualsEx {

    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        Point p1Copy = new Point(10, 20);
        Point p2 = new Point(10, 20);
        Point p3 = new Point(10, 20);

        System.out.println("=== 1. 재귀성 (Reflexive): x.equals(x) == true ===");
        System.out.println("p1.equals(p1) : " + p1.equals(p1));

        System.out.println("\n=== 2. 대칭성 (Symmetric): x.equals(y) == y.equals(x) ===");
        System.out.println("p1.equals(p1Copy) : " + p1.equals(p1Copy));
        System.out.println("p1Copy.equals(p1) : " + p1Copy.equals(p1));

        System.out.println("\n=== 3. 전이성 (Transitive): x==y, y==z → x==z ===");
        System.out.println("p1.equals(p2) : " + p1.equals(p2));
        System.out.println("p2.equals(p3) : " + p2.equals(p3));
        System.out.println("p1.equals(p3) : " + p1.equals(p3));

        System.out.println("\n=== 4. null 비교: x.equals(null) == false ===");
        System.out.println("p1.equals(null) : " + p1.equals(null));

        System.out.println("\n=== 5. instanceof 테스트: 다른 타입과 비교 ===");
        String notAPoint = "not a point";
        System.out.println("p1.equals(\"not a point\") : " + p1.equals(notAPoint));

        Point different = new Point(99, 99);
        System.out.println("\n=== 값이 다른 경우 ===");
        System.out.println("p1.equals(Point(99,99)) : " + p1.equals(different));
    }

    private static class Point{
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point p)) return false;
            return p.x == x && p.y == y;
        }
    }

}
