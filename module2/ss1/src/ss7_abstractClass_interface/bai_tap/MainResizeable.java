package ss7_abstractClass_interface.bai_tap;

import ss6_inheritance.thuc_hanh.Circle;
import ss6_inheritance.thuc_hanh.Geometric;
import ss6_inheritance.thuc_hanh.Rectangle;
import ss6_inheritance.thuc_hanh.SquareResize;

public class MainResizeable {
    public static void main(String[] args) {
        Geometric[] geometrics = new Geometric[3];
        geometrics[0] = new Circle();
        geometrics[1] = new Rectangle();
        geometrics[2] = new SquareResize();

        for (Geometric geometric : geometrics) {
            if (geometric instanceof Circle || geometric instanceof Rectangle || geometric instanceof SquareResize) {
                Resizeable resizeable = (Resizeable) geometric;
                resizeable.resize(30);
            }
        }
    }
}
