import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Stack {
    private List<Integer> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void initStack() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements in sequence for stack (-99999999 to exit): ");
        int n = sc.nextInt();
        while (n != -99999999) {
            this.push(n);
            n = sc.nextInt();
        }
        sc.close();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    /**
     * Adds an element to the stack
     * @param x
     */
    public void push(int x) {
        this.stack.add(x);
    }

    /**
     * Pops an element from the stack and returns it
     * @return
     */
    public int pop() {
        if (this.stack.isEmpty()) return Integer.MIN_VALUE;
        else {
            int x = this.stack.get(this.stack.size() - 1);
            this.stack.remove(this.stack.size() - 1);
            return x;
        }
    }

    /**
     * Returns (peeks) the top most element
     * @return
     */
    public int top() {
        if (this.stack.isEmpty()) return Integer.MIN_VALUE;
        else return this.stack.get(this.stack.size() - 1);
    }
}

public class StackSort {

    public static void sortStack(Stack stack) {
        if (stack.isEmpty()) return; // if empty stack
        else {
            int top = stack.pop(); // get the top element out
            sortStack(stack); // sort the rest of the stack

            Stack buffer = new Stack(); // buffer to help push top in correct place
            while (!stack.isEmpty() && stack.top() > top) {
                buffer.push(stack.pop()); // take the elements bigger than top out
            }
            stack.push(top); // push top in correct place
            while (!buffer.isEmpty()) {
                stack.push(buffer.pop()); // push elements bigger than top in place
            }
        }
    }

    /**
     * Main driver code
     * @param args
     */
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.initStack(); // input

        System.out.println("Sorted stack (top to bottom): ");
        sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }    
}
