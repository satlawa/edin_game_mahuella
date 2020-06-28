package ippo.assignment2;

import java.util.HashMap;

/**
 * A simple class to represent the compass directions.
 * It holds the information of the compass directions order.
 * If the user wants to turn right it returns the next logical compass direction.
 */
public class Directions {

    private HashMap<String, String> changingDirectionLeft;
    private HashMap<String, String> changingDirectionRight;

    /**
     * The constructor calls the method createChangingDirections and sets the directions order
     */
    public Directions() {
        this.changingDirectionLeft = new HashMap<String, String>();
        this.changingDirectionRight = new HashMap<String, String>();
        this.createChangingDirections();
    }

    /**
     * add logical order of the directions for changing direction to the left and to the right
     */
    private void createChangingDirections() {
        // add logical order for changing direction to the left
        this.changingDirectionLeft.put("north", "west");
        this.changingDirectionLeft.put("west", "south");
        this.changingDirectionLeft.put("south", "east");
        this.changingDirectionLeft.put("east", "north");
        // add logical order for changing direction to the right
        this.changingDirectionRight.put("north", "east");
        this.changingDirectionRight.put("east", "south");
        this.changingDirectionRight.put("south", "west");
        this.changingDirectionRight.put("west", "north");
    }

    public String getNextDirectionLeft(String currentDirection) {
        return this.changingDirectionLeft.get(currentDirection);
    }

    public String getNextDirectionRight(String currentDirection) {
        return this.changingDirectionRight.get(currentDirection);
    }
}
