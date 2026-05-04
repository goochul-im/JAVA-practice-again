package genericEx;

import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ExtendsEx {

    private interface Shape {

        void draw();

    }

    private static class Rectangle implements Shape, Comparable<Rectangle> {

        @Override
        public void draw() {
            System.out.println("Rectangle");
        }

        @Override
        public int compareTo(Rectangle o) {
            return 0;
        }
    }

    private static class Circle implements Shape{

        @Override
        public void draw() {
            System.out.println("Circle");
        }
    }

    private static void addItem(List<? super Circle> list, Circle item) {
        list.add(item);
    }

    private static void run(List<? extends Shape> list) {

        for (Shape shape : list) {
            shape.draw();
        }

//        list.add(new Circle());

    }

    private static <T extends Shape & Comparable<T>> void addItem(List<T> list, T item) {
        list.add(item);

        for (Shape t : list) {
            t.draw();
        }
    }

    @SafeVarargs
    private static void mergeList(List<String > ...lists) {
        Object[] objectArray = lists;
        objectArray[0] = List.of(42);
        String s = lists[0].get(0);
    }

    static void main() {

        List<Circle> circles = new LinkedList<>();
        LinkedList<Rectangle> rectangles = new LinkedList<>();

        run(circles);

        addItem(circles, new Circle());
        addItem(rectangles, new Rectangle());

        Shape[] circleList = new Circle[5];




        mergeList(new ArrayList<>(3));

    }

}
