interface Cubicles {
    //Create the default cubicle size if not changed in constructor
    int DEFAULT_CUBICLE_SIZE = 3;

    //Getter & Setter methods
    int getSize();

    void setSize(int i);
}

public class OfficeBlock extends Building implements Cubicles {
    private int size;

    //House constructor using default values
    public OfficeBlock() {
        this.size = DEFAULT_CUBICLE_SIZE;
    }

    //Getter and setter methods
    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setSize(int i) {
        this.size = i;
    }

    public static void main(String[] args) {
        //Instantiate two new office blocks for comparison
        OfficeBlock firstOfficeBlock = new OfficeBlock();
        OfficeBlock secondOfficeBlock = new OfficeBlock();

        //Set attributes of second office block
        secondOfficeBlock.setArea(706);
        secondOfficeBlock.setWalls(44);
        secondOfficeBlock.setSize(1);

        //Compare the two
        System.out.println("FIRST OFFICE BLOCK");
        System.out.println("Office Block Roof size: " + firstOfficeBlock.getArea() + " M^2");
        System.out.println("Office Block number of walls: " + firstOfficeBlock.getWalls() + " walls.");
        System.out.println("Office Block cubicle size: " + firstOfficeBlock.getSize() + " M^2");

        System.out.println("\n-----------------------------\nSECOND OFFICE BLOCK");

        System.out.println("Office Block Roof size: " + secondOfficeBlock.getArea() + " M^2");
        System.out.println("Office Block number of walls: " + secondOfficeBlock.getWalls() + " walls.");
        System.out.println("Office Block cubicle size: " + secondOfficeBlock.getSize() + " M^2");
    }
}
