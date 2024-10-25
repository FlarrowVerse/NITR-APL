import java.util.Scanner;

/**
 * Image class
 */
class Image {
    /**
     * Member variables
     */
    private int width, height;
    private int[][] image;

    /**
     * parameterized constructor
     * @param height
     * @param width
     */
    public Image(int height, int width) {
        this.height = height;
        this.width = width;

        image = new int[this.height][this.width];
    }

    /**
     * Taking input for the image
     * @param sc
     */
    public void setImage(Scanner sc) {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.image[i][j] = sc.nextInt();
                if (this.image[i][j] != 0 && this.image[i][j] != 1) {
                    System.err.println("Wrong input! enter only 0 or 1");
                    j--;
                }
            }
        }        
    }

    /**
     * Flips the image horizontally in place
     */
    public void flipImageHorizontal() {
        for (int i = 0, j = this.width-1; i <= j; i++, j--) {
            for (int row = 0; row < this.height; row++) {
                int pixel = this.image[row][i];
                this.image[row][i] = this.image[row][j];
                this.image[row][j] = pixel;
            }
        }
    }

    /**
     * For easily displaying an image
     */
    @Override
    public String toString() {
        String image = String.format("Dimensions: %d x %d\n", this.height, this.width);
        for (int[] row : this.image) {
            for (int pixel : row) {
                image += (pixel == 1)?"*":" ";
            }
            image +="\n";
        }
        return image;
    }
}

public class FlipImage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Width: ");
        int width = sc.nextInt();
        System.out.print("Height: ");
        int height = sc.nextInt();

        Image i = new Image(height, width);
        i.setImage(sc);
        System.out.println(i);
        System.out.println("Flipping image horizontally.....");
        i.flipImageHorizontal();
        System.out.println(i);

        sc.close();
    }    
}
