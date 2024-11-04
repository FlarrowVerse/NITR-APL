import java.util.Scanner;

/**
 * Shape interface to be implemented and methods to be overriden
 */
interface Shape {
    
    // method overloading - same name, different parameter lists
    public double getArea(double a, double b); // method to be overridden
    public double getArea(double a); // method to be overriden
}

class TriangleAndSquare implements Shape {

    /**
     * Overriding for triangle
     */
    @Override
    public double getArea(double base, double height) {
        return 0.5 * base * height;
    }

    /**
     * Overriding for square
     */
    @Override
    public double getArea(double side) {
        return Math.pow(side, 2);
    }
}

class RectangleAndCircle implements Shape {

    /**
     * Overriding for rectangle
     */
    @Override
    public double getArea(double length, double breadth) {
        return length * breadth;
    }

    /**
     * Overriding for circle
     */
    @Override
    public double getArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }
}

public class AreaCalculator {

    /**
     * Main driver code
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TriangleAndSquare tsq = new TriangleAndSquare();
        RectangleAndCircle rac = new RectangleAndCircle();
        while (true) {
            
            System.out.println("AREA CALCULATOR MENU:");
            System.out.println("\t1. Triangle");
            System.out.println("\t2. Rectangle");
            System.out.println("\t3. Square");
            System.out.println("\t4. Circle");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            double arg1 = 0.0, arg2 = 0.0, area = 0.0; // required vars

            switch (choice) {
                case 1: System.out.print("Enter the base and height of the triangle: ");
                    arg1 = sc.nextDouble(); arg2 = sc.nextDouble();
                    area = tsq.getArea(arg1, arg2);
                    System.out.printf("Area of triangle with base %.2f and height %.2f = %.2f\n", arg1, arg2, area);
                    break;
                case 2: System.out.print("Enter the length and breadth of the rectangle: ");
                    arg1 = sc.nextDouble(); arg2 = sc.nextDouble();
                    area = rac.getArea(arg1, arg2);
                    System.out.printf("Area of rectangle with length %.2f and breadth %.2f = %.2f\n", arg1, arg2, area);
                    break;

                case 3: System.out.print("Enter the side length of the square: ");
                    arg1 = sc.nextDouble();
                    area = tsq.getArea(arg1);
                    System.out.printf("Area of square with side length %.2f = %.2f\n", arg1, area);
                    break;

                case 4: System.out.print("Enter the radius of the circle: ");
                    arg1 = sc.nextDouble();
                    area = rac.getArea(arg1);
                    System.out.printf("Area of circle with radius %.2f = %.2f\n", arg1, area);
                    break;
            
                default: System.err.println("Invalid choice! Try Again.");
                    break;
            }
            sc.nextLine();

            System.out.print("Do you want to continue? (Y/N): ");
            if ("yY".indexOf(sc.nextLine().charAt(0)) == -1) {
                System.out.println("Exiting...");
                break;
            }
        }
        sc.close();
    }
    
}