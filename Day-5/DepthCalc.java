import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DepthCalc {

    /**
     * Calculates the maximum depth of given parenthesized expression
     * @param expr
     * @return
     */
    public static int getDepth(String expr) {
        int maxDepth = 0, depth = 0;

        List<Character> stack = new ArrayList<Character>();

        boolean cleared = true;

        for (char p : expr.toCharArray()) {
            switch (p) {
                case '(': 
                    if (cleared) {
                        stack.add('(');
                        maxDepth = Math.max(maxDepth, depth);
                        depth = 0;
                    }
                    cleared = true;                    
                    break;
                case ')': cleared = false;
                    if (stack.size() > 0) {
                        stack.remove(stack.size() - 1);
                        depth++;
                    }
                    break;
            }
        }

        return Math.max(maxDepth, depth);
    }

    /**
     * Main driver code
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Expression: ");
        String expr = sc.nextLine();

        System.out.printf("Maximum depth of %s is %d\n", expr, getDepth(expr));

        sc.close();
    }    
}
