package ippo.assignment2;

import java.util.HashMap;

public class Directions {

    private HashMap<String, String> changingDirectionLeft;
    private HashMap<String, String> changingDirectionRight;

    public Directions() {
        this.changingDirectionLeft = new HashMap<String, String>();
        this.changingDirectionRight = new HashMap<String, String>();
        this.createChangingDirections();
    }

    /**
     * add logical order of the directions for changing direction to the left and to the right
     */
    private void createChangingDirections() {
        // add String pairs of logical order left
        this.changingDirectionLeft.put("north", "west");
        this.changingDirectionLeft.put("west", "south");
        this.changingDirectionLeft.put("south", "east");
        this.changingDirectionLeft.put("east", "north");
        // add String pairs of logical order right
        this.changingDirectionRight.put("north", "east");
        this.changingDirectionRight.put("east", "south");
        this.changingDirectionRight.put("south", "west");
        this.changingDirectionRight.put("west", "north");
    }

    public Boolean checkIfDirectionExists(String direction) {
        return this.changingDirectionLeft.containsKey(direction);
    }

    public String getNextDirectionLeft(String currentDirection) {
        return this.changingDirectionLeft.get(currentDirection);
    }

    public String getNextDirectionRight(String currentDirection) {
        return this.changingDirectionRight.get(currentDirection);
    }
}
