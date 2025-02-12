package src;
import java.awt.Rectangle;
import java.util.ArrayList;

class BigRectangleFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle r = (Rectangle) x;
            double perimeter = 2 * (r.getWidth() + r.getHeight());
            return perimeter > 10;
        }
        return false;
    }
}

public class BigRectLister {

    public static ArrayList collectAll(ArrayList rectangles, Filter filter) {
        ArrayList filteredRectangles = new ArrayList<>();
        for (Object rectangle : rectangles) {
            if (filter.accept(rectangle)) {
                filteredRectangles.add(rectangle);
            }
        }
        return filteredRectangles;
    }

    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(1, 1)); // Perimeter 4
        rectangles.add(new Rectangle(2, 2)); // Perimeter 8
        rectangles.add(new Rectangle(3, 3)); // Perimeter 12
        rectangles.add(new Rectangle(4, 4)); // Perimeter 16
        rectangles.add(new Rectangle(1, 5)); // Perimeter 12
        rectangles.add(new Rectangle(5, 1)); // Perimeter 12
        rectangles.add(new Rectangle(2, 3)); // Perimeter 10
        rectangles.add(new Rectangle(6, 6)); // Perimeter 24
        rectangles.add(new Rectangle(7, 1)); // Perimeter 16
        rectangles.add(new Rectangle(1, 8)); // Perimeter 18


        BigRectangleFilter bigRectangleFilter = new BigRectangleFilter();
        ArrayList bigRectangles = collectAll(rectangles, bigRectangleFilter);

        System.out.println("Rectangles with perimeter greater than 10:");
        for (Object rectangle : bigRectangles) {
            System.out.println(rectangle);
        }
    }
}