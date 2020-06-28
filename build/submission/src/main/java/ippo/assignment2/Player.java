package ippo.assignment2;

import java.util.HashMap;

/**
 * A simple player class that represents the player in the application.
 * It holds all necessary information about the player:
 *      name, location, looking direction, currently holding items
 */
public class Player {
    private String name;
    private String lookingDirection;
    private String currentLocation;
    private HashMap<String,Item> items;

    /**
     * The constructor sets the name, the location and the current looking direction
     *
     * @param name is the name of the player
     */
    public Player (String name) {
        this.name = name;
        this.lookingDirection = "north";
        this.currentLocation = "mahuella02";
        this.items = new HashMap<String,Item>();
    }

    public void setLookingDirection(String direction) {
        this.lookingDirection = direction;
    }

    public String getLookingDirection() {
        return this.lookingDirection;
    }


    public void setCurrentLocation(String location) {
        this.currentLocation = location;
    }

    public String getCurrentLocation() {
        return this.currentLocation;
    }


    public void addItem(String name, Item item) {
        this.items.put(name, item);
    }

    public Item removeItem(String name) {
        return this.items.remove(name);
    }

    public Item getItem(String name) {
        return this.items.get(name);
    }

    public HashMap<String,Item> getItems() {
        return this.items;
    }
}
