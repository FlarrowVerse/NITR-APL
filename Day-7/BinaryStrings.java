import java.util.Scanner;

class StringTree {

    // instance members
    private int size;
    private boolean[] tree;

    /**
     * Parameterized constructor
     * @param size
     */
    public StringTree(int size) {
        this.size = size;
        this.tree = new boolean[this.size];
    }

    /**
     * inserts a new binary string into the tree
     * @param s
     * @return
     */
    public boolean insertString(String s) {
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') { // go to left child
                idx = 2 * idx + 1;
            } else if (c == '1') { // go to right child
                idx = 2 * idx + 2;
            }
        }
        if (idx >= this.size || this.tree[idx]) return false; // not inserting new string
        else {
            this.tree[idx] = true; // mark the end of the string
            return true;
        }
    }

    /**
     * Get a string if it exists which ends a given index
     * @param idx
     * @return
     */
    public String getString(int idx) {
        if (idx >= 0 && idx < this.size && this.tree[idx]) {
            String s = "";
            int start = idx;
            while (start != 0) {
                if (start % 2 == 0) { // right child
                    s = "1" + s;
                    start = start / 2 - 1; // get parent
                } else { // left child
                    s = "0" + s;
                    start = start / 2; // get parent
                }
            }
            return s;
        }
        return "";
    }

    /**
     * Prints all the strings stored currently in the tree
     */
    public void printAllStrings() {
        String[] s = new String[this.size];
        s[0] = "";
        for (int i = 1; i < this.size; i++) {
            if (i % 2 == 0) { // right child
                s[i] = s[i / 2 - 1] + "1";
            } else {
                s[i] = s[i / 2] + "0";
            }
        }

        for (int i = 0; i < s.length; i++) {
            if (this.tree[i]) {
                // string exists, print
                System.out.println(s[i]);
            }            
        }
    }

}

public class BinaryStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum number of nodes: ");
        int n = sc.nextInt(); sc.nextLine();

        StringTree tree = new StringTree(n);

        while (true) {
            System.out.print("Enter a binary string to store in the tree: ");
            tree.insertString(sc.nextLine());

            System.out.print("Do you want to enter another string(Y/N): ");
            if ("yY".indexOf(sc.nextLine().charAt(0)) == -1) {
                break;
            }
        }

        System.out.println("All the strings currently stored: ");
        tree.printAllStrings(); // print all the strings
        sc.close();
    }
}
