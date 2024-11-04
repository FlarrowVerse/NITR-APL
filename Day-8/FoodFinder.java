import java.util.Scanner;

enum Move {
    NORTH,
    SOUTH,
    EAST,
    WEST;
    
    /**
     * Returns the next move depending on current move
     * @param move
     * @return
     */
    public static Move getNextMove(Move move) {
        switch (move) {
            case NORTH: return EAST;
            case SOUTH: return WEST;
            case EAST: return SOUTH;
            case WEST: return NORTH;
            default: throw new IllegalArgumentException("Invalid move value: " + move);
        }
    }

    public static void move(Mouse mouse) {
        switch (mouse.move) {
            case NORTH: mouse.currY += mouse.strength; break;
            case SOUTH: mouse.currY -= mouse.strength; break;
            case EAST: mouse.currX += mouse.strength; break;
            case WEST: mouse.currX -= mouse.strength; break;
            default: throw new IllegalArgumentException("Invalid move value: " + mouse.move);
        }
        mouse.strength = 0.9 * mouse.strength; // reduce the strength
    }
}

class Mouse {
    double currX, currY, strength;
    Move move;

    public Mouse(int x, int y, int strength) {
        this.currX = x; this.currY = y; this.move = Move.NORTH;
        this.strength = strength;
    }
}

class Field {
    double length, breadth, foodX, foodY;
    Mouse mouse;

    /**
     * Parameterized constructor
     * @param length length of field
     * @param breadth length of breadth
     */
    public Field(int length, int breadth) {
        this.length = length; this.breadth = breadth; // setting field size
        this.foodX = this.breadth / 2; this.foodY = this.length / 2; // placing the food source
        this.mouse = new Mouse(0, 0, length); // initializing the mouse
    }

    /**
     * Returns the distance between food and mouse
     * @return euclidean distance
     */
    public double getDistance() {
        return Math.sqrt(Math.pow((this.foodX - mouse.currX), 2) + Math.pow((this.foodY - mouse.currY), 2));
    }
}


public class FoodFinder {

    public static int findFood(Field field) {
        double prevStrength = Double.MIN_VALUE;
        int moves = 0;
        boolean found = false;

        while (!found && prevStrength != field.mouse.strength) {
            moves++; // increase move count
            prevStrength = field.mouse.strength; // current strength
            Move.move(field.mouse); // move the mouse in the current direction and change strength
            field.mouse.move = Move.getNextMove(field.mouse.move); // change the move direction
            if (field.getDistance() < 1) {
                // if food is within 1 meter of mouse
                found = true;                
            }
        }

        return (!found)? -moves: moves;
    }

    /**
     * main driver code
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of the field: ");
        int n = sc.nextInt();

        Field field = new Field(n, n); // initializing field

        int moves = findFood(field);
        System.out.printf("%s food after %d moves\n", (moves < 0)? "Could not find": "Found", Math.abs(moves));

        sc.close();
    }
}