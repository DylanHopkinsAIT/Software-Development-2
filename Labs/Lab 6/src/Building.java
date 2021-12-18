interface Walls {
    //Create the default number of walls for a building if not changed in constructor
    int DEFAULT_NUM_WALLS = 4;

    //Getter & Setter methods
    int getWalls();

    void setWalls(int i);
}

interface Roof {
    //Create the default roof area for a building if not changed in constructor
    int DEFAULT_AREA = 25;

    //Getter & Setter methods
    int getArea();

    void setArea(int i);
}

public class Building implements Walls, Roof {
    private int numWalls;
    private int roofArea;

    //Building constructor using default values
    public Building() {
        this.numWalls = DEFAULT_NUM_WALLS;
        this.roofArea = DEFAULT_AREA;
    }

    //Getter and setter methods
    @Override
    public int getWalls() {
        return this.numWalls;
    }

    @Override
    public void setWalls(int i) {
        this.numWalls = i;
    }

    @Override
    public int getArea() {
        return this.roofArea;
    }

    @Override
    public void setArea(int i) {
        this.roofArea = i;
    }

    public static void main(String[] args) {
        //Instantiate two new buildings for comparison
        Building firstBuilding = new Building();
        Building secondBuilding = new Building();

        //Set attributes of second building
        secondBuilding.setArea(55);
        secondBuilding.setWalls(256);

        //Compare the two
        System.out.println("FIRST BUILDING");
        System.out.println("First Building roof area: " + firstBuilding.getArea() + " M^2");
        System.out.println("First Building has: " + firstBuilding.getWalls() + " walls.");

        System.out.println("\n-------------------------------------\nSECOND BUILDING");

        System.out.println("Second Building roof area: " + secondBuilding.getArea() + " M^2");
        System.out.println("Second Building has: " + secondBuilding.getWalls() + " walls.");

    }

}

