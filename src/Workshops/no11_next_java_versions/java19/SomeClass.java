package Workshops.no11_next_java_versions.java19;

public class SomeClass {

    private void print1(Object object) {
        if (object instanceof Point point) {
            System.out.printf("Object is a point, x = %s, y = %s", point.x(), point.y());
        }
            // else ...
    }

    // czyli że można zrobić objekt Point w locie
/*    private void print2(Object object) {
        if (object instanceof Point(int x, int y)) {
            System.out.printf("object is a point, x = %s, y = %s", x, y);
        }
// else ...
    }*/
}
