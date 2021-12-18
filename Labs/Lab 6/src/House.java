interface Rooms {
    //Create the default number of rooms if not changed in constructor
    int DEFAULT_NUM_ROOMS = 4;

    //Getter & Setter methods
    int getNumRooms();

    void setNumRooms(int i);
}

public class House extends Building implements Rooms {
    private int numRooms;

    //House constructor using default values
    public House() {
        this.numRooms = DEFAULT_NUM_ROOMS;
    }

    //Getter and setter methods
    @Override
    public int getNumRooms() {
        return this.numRooms;
    }

    @Override
    public void setNumRooms(int i) {
        this.numRooms = i;
    }

    public static void main(String[] args) {
        //Instantiate two new houses for comparison
        House firstHouse = new House();
        House secondHouse = new House();

        //Set attributes of second house
        secondHouse.setArea(50);
        secondHouse.setWalls(16);
        secondHouse.setNumRooms(6);

        //Compare the two
        System.out.println("FIRST HOUSE");
        System.out.println("House roof area: " + firstHouse.getArea() + " M^2");
        System.out.println("Number of walls: " + firstHouse.getWalls() + " walls.");
        System.out.println("Number of rooms: " + firstHouse.getNumRooms() + " rooms.");

        System.out.println("\n------------------------------\nSECOND HOUSE");

        System.out.println("House roof area: " + secondHouse.getArea() + " M^2");
        System.out.println("Number of walls: " + secondHouse.getWalls() + " walls.");
        System.out.println("Number of rooms: " + secondHouse.getNumRooms() + " rooms.");

    }
}
