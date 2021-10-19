import java.util.Scanner;

public class Box {

    private String boxName;
    private int w, h, d;
    private String isFull;

    /*
    Object 'Box' containing name, dimensions, isFull boolean
     */
    public Box() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the box type: ");
        this.boxName = sc.next();

        System.out.println("Is the box full true/false?");
        //If there is input
        if (sc.hasNext()) {
            boolean full = sc.nextBoolean();
            if (full) {
                this.isFull = "Full";
            } else {
                this.isFull = "Empty";
            }
        }

        System.out.println("Please enter the box width:");
        this.w = sc.nextInt();

        System.out.println("Please enter the box depth");
        this.d = sc.nextInt();

        System.out.println("Please enter the box height");
        this.h = sc.nextInt();
    }

    /*
    Method to calculate the area of object box taking the dimensions from the object.
     */
    public int getArea() {
        return this.w * this.h * this.d;
    }


    public String toString() {
        return
                "\nBox type is: " + this.boxName +
                "\nBox area is: " + this.getArea() + "cm^2" +
                "\nBox status is: " + this.isFull;
    }

    public static void main(String[] args) {
        Box b = new Box();
        Box c = new Box();
        System.out.println(b);
        System.out.println(c);
    }

}
