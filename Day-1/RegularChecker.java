import java.util.Scanner;

/**
 * Handles coordinate related stuff
 */
class Point {
    private int x, y;
    
    /**
     * Parameterized constructor
     * @param x
     * @param y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Given two points in the Cartesian plane returns its distance
     * @param p1
     * @param p2
     * @return cartesian distance
     */
    public static long getDistance(Point p1, Point p2) {
        return Math.round(Math.sqrt((Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2))));
    }
}

public class RegularChecker {

    /**
     * Main driver code
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the vertices of the quadrilateral in clockwise order: ");
        Point a = new Point(sc.nextInt(), sc.nextInt());
        Point b = new Point(sc.nextInt(), sc.nextInt());
        Point c = new Point(sc.nextInt(), sc.nextInt());
        Point d = new Point(sc.nextInt(), sc.nextInt());

        boolean isRegular = ((Point.getDistance(a, b) ^ Point.getDistance(b, c)) == 0) 
                            && ((Point.getDistance(c, d) ^ Point.getDistance(d, a)) == 0) 
                            && ((Point.getDistance(d, a) ^ Point.getDistance(a, b)) == 0);

        System.out.println(Math.abs((isRegular+"").indexOf('f')));


        sc.close();
    }
    
}
