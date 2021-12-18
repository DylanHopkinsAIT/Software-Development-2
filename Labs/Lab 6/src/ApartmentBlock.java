interface Units {
    //Create the default area of apartment unit if not changed in constructor
    int DEFAULT_UNIT_SIZE = 100;

    //Getter & Setter methods
    int getSize();

    void setSize(int i);
}

public class ApartmentBlock extends Building implements Units {
    private int size;

    //Apartment block constructor using default values
    public ApartmentBlock() {
        this.size = DEFAULT_UNIT_SIZE;
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
        //Instantiate two new apartments for comparison
        ApartmentBlock firstApartment = new ApartmentBlock();
        ApartmentBlock secondApartment = new ApartmentBlock();

        //Set attributes of second apartment
        secondApartment.setArea(333);
        secondApartment.setWalls(3);
        secondApartment.setSize(77);

        //Compare the two
        System.out.println("FIRST APARTMENT");
        System.out.println("First Apartment Block roof area: " + firstApartment.getArea() + " M^2");
        System.out.println("First Apartment number of walls: " + firstApartment.getWalls() + " walls");
        System.out.println("First Apartment block unit size: " + firstApartment.getSize() + " M^2");

        System.out.println("\n-----------------------------\nSECOND APARTMENT");

        System.out.println("Second Apartment Block roof area: " + secondApartment.getArea() + " M^2");
        System.out.println("Second Apartment number of walls: " + secondApartment.getWalls() + " walls");
        System.out.println("Second Apartment block unit size: " + secondApartment.getSize() + " M^2");
    }
}
