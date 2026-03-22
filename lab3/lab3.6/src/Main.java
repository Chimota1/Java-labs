import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();
        rectangle.setArea(20);
        circle.setArea(50);
        List<Shape> list = Arrays.asList(rectangle,circle);
        System.out.println(Shape.calculateTotalArea(list));
    }
}