package ippo.assignment2;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private String name;
    private String lookingDirection;
    private String currentLocation;
    private HashMap<String,Item> items;

    public Player (String name) {
        this.name = name;
        this.lookingDirection = "north";
        this.currentLocation = "mahuella02";
        this.items = new HashMap<String,Item>();
    }

    public void setLookingDirection(String direction) {
        this.lookingDirection = direction;
    }

    public void setCurrentLocation(String location) {
        this.currentLocation = location;
    }

    public void addItem(String name, Item item) {
        this.items.put(name, item);
    }

    public Item removeItem(String name) {
        return this.items.remove(name);
    }

    public String getLookingDirection() {
        return this.lookingDirection;
    }

    public String getCurrentLocation() {
        return this.currentLocation;
    }

    public Item getItem(String name) {
        return this.items.get(name);
    }

    public HashMap<String,Item> getItems() {
        return this.items;
    }
}
