import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tree {

    // instance variable
    private int size, root;
    private List<Integer> keys, left, right;

    /**
     * Parameterized constructor
     * @param size
     * @param root
     */
    public Tree(int size, int root) {
        this.size = size;
        this.root = root;
        // initialise tree
        this.keys = new ArrayList<>();
        this.left = new ArrayList<>();
        this.right = new ArrayList<>();

    }

    /**
     * Initialise tree by taking correct inputs
     * @param sc
     */
    public void initTree(Scanner sc) {
        // key values
        System.out.print("Enter key values:");
        for (int i = 0; i < this.size; i++) {
            this.keys.add(sc.nextInt());
        }

        // corresponding left child
        System.out.print("Enter left child indices:");
        for (int i = 0; i < this.size; i++) {
            this.left.add(sc.nextInt());
        }

        // corresponding right child
        System.out.print("Enter right child indices:");
        for (int i = 0; i < this.size; i++) {
            this.right.add(sc.nextInt());
        }
    }

    /**
     * Inserts a new key into the tree
     * @param key
     */
    public void insertKey(int key) {
        this.keys.add(key); // add the key
        this.left.add(-1); // add the left child
        this.right.add(-1); // add the right child

        int index = this.keys.size() - 1; // get the index of the newly inserted key

        // find where to insert the key
        int startIdx = this.root;
        while (this.left.get(startIdx) != -1 && this.right.get(startIdx) != -1) {
            if (key > this.keys.get(startIdx)) { // go to right child
                startIdx = this.right.get(startIdx);
            } else { // go to the left child
                startIdx = this.left.get(startIdx);
            }
        }

        // add the key's index to the appropriate
        if (key > this.keys.get(startIdx)) { // go to right child
            this.right.set(startIdx, index);
        } else { // go to the left child
            this.left.set(startIdx, index);
        }
    }

    /**
     * Returns the index of the parent of the inorder predecessor
     * @param index
     * @return
     */
    public int getInorderPredecessor(int index) {
        int startIdx = this.left.get(index); // start index of current node's left subtree

        // till  you get the right most node
        while (this.right.get(startIdx) != -1 && this.right.get(this.right.get(startIdx)) != -1) {
            startIdx = this.right.get(startIdx);
        }
        return startIdx; // returns maximum element of left sub-tree
    }

    /**
     * Returns the index of the parent of the inorder successor
     * @param index
     * @return
     */
    public int getInorderSuccessor(int index) {
        int startIdx = this.right.get(index); // start index of current node's right subtree

        // till  you get the left most node
        while (this.left.get(startIdx) != -1 && this.left.get(this.left.get(startIdx)) != -1) {
            startIdx = this.left.get(startIdx);
        }
        return startIdx; // returns maximum element of left sub-tree
    }

    /**
     * Delete a key from the tree
     * @param key
     */
    public boolean deleteKey(int key) {
        // find where to insert the key
        int startIdx = this.root;
        int parentIdx = -1;
        while (this.keys.get(startIdx) != key && (startIdx >= 0 && startIdx < this.keys.size())) {
            parentIdx = startIdx;
            if (key > this.keys.get(startIdx)) { // go to right child                
                startIdx = this.right.get(startIdx);
            } else { // go to the left child
                startIdx = this.left.get(startIdx);
            }
        }

        if (this.keys.get(startIdx) != key) {
            return false; // key not found, so not deleted
        }

        if (this.left.get(startIdx) != -1) { // if node has left child
            // find in-order predecessor
            int predParent = getInorderPredecessor(startIdx);
            int value = this.keys.get(this.right.get(predParent));
            int leftIdx = this.left.get(this.right.get(predParent)); // left child if present of predecessor
            
            this.keys.remove(this.right.get(predParent)); // remove the key
            this.right.remove(this.right.get(predParent)); // remove the left child
            this.left.remove(this.right.get(predParent)); // remove the right child

            if (leftIdx != -1) {
                // left child present
                this.right.set(predParent, leftIdx);
            }           

            this.keys.set(startIdx, value); // replace with in order predecessor

        } else if (this.right.get(startIdx) != -1) {  // if node has no left child but a right child
            int succParent = getInorderSuccessor(startIdx);
            int value = this.keys.get(this.right.get(succParent));
            int rightIdx = this.right.get(this.left.get(succParent)); // right child if present of successor
            
            this.keys.remove(this.left.get(succParent)); // remove the key
            this.right.remove(this.left.get(succParent)); // remove the key
            this.left.remove(this.left.get(succParent)); // remove the key

            if (rightIdx != -1) {
                // right child present
                this.left.set(succParent, rightIdx);
            }           

            this.keys.set(startIdx, value); // replace with in order successor
        } else {
            // if no children present
            if (this.keys.get(this.right.get(parentIdx)) == key) {
                this.right.set(parentIdx, -1);
            } else {
                this.left.set(parentIdx, -1);
            }
            // remove the node and its connections
            this.keys.remove(startIdx);
            this.left.remove(startIdx);
            this.right.remove(startIdx);
        }
        return true;
    }

    /**
     * Overriden toString method to print the tree
     */
    @Override
    public String toString() {
        String str = "";

        // print each node
        for (int i = 0; i < this.keys.size(); i++) {
            str += i + ":::::> " + this.toString(i) + "\n";
        }

        return str;
    }

    /**
     * Print a single node
     * @param index
     * @return
     */
    public String toString(int index) {
        return this.left.get(index) + "<---" + this.keys.get(index) + ((index == root)?"(Root)":"") + "--->" + this.right.get(index);
    }

}

public class RandomTree {

    /**
     * Main driver code
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of tree: ");
        int size = sc.nextInt();
        System.out.print("Enter root index of tree: ");
        int root = sc.nextInt();

        Tree tree = new Tree(size, root); // create a new tree

        tree.initTree(sc);

        while (true) {
            System.out.println("MENU:");
            System.out.println("\t1. Insert");
            System.out.println("\t2. Delete");
            System.out.println("\t3. Display");
            System.out.println("\t0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            int key = -1;

            switch (choice) {
                case 1: System.out.print("Enter a key: ");
                    key = sc.nextInt();
                    tree.insertKey(key);
                    break;
                case 2: System.out.print("Enter a key: ");
                    key = sc.nextInt();
                    if (tree.deleteKey(key)) {
                        System.out.println("Deleted successfully!");
                    } else {
                        System.out.println("Could not delete key");
                    }
                    break;
                case 3: System.out.println(tree);
                    break;
                case 0: System.out.println("Exiting...."); sc.close(); return;
                default: System.err.println("Invalid choice. Try again.");
                    break;
            }
        }        
    }
}
