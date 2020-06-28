package ippo.assignment2;

import java.awt.event.ItemEvent;
import java.util.HashMap;

/**
 * This class contains the whole model of the world.
 * One world contains Locations and one Player.
 * It is responsible for creating the world with one player, several locations, and some Items
 * It is a intermediary between the WorldController class and the Location Player class
 */

public class World {
    private String name;
    private Player player;
    private Directions directions;
    private HashMap<String, Location> locations;

    /**
     * The constructor sets the name of the world
     *
     * @param name is the name of the player
     */
    public World(String name) {
        this.name = name;
        this.directions = new Directions();
        this.locations = new HashMap<String, Location>();
    }

    /**
     * Create the world with one player, several locations, and some Items
     */
    public void createWorld() {

        player = new Player("Adam");
        System.out.println("player");

        // create array to loop through locations
        String[] roomNames = {"mahuella00", "mahuella01", "mahuella02", "mahuella10", "mahuella11", "mahuella21", "mahuella22"};
        for (String roomName: roomNames) {
            Location location = new Location(roomName);
            // create array to loop through directions
            String[] directions = {"north", "east", "south", "west"};
            for (String direction : directions) {
                location.addScene(direction, roomName + "_" + direction + ".jpg");
            }
            // set exits and items in the Scenes
            if (roomName == "mahuella00") {
                location.setSceneExit("east","mahuella01");
                location.setSceneExit("south","mahuella10");
                Item item = new Item("apple");
                item.setImagePath("apple.png");
                location.addItemToScene("north", item);
            } else if (roomName == "mahuella01") {
                location.setSceneExit("west", "mahuella00");
                location.setSceneExit("south", "mahuella11");
                location.setSceneExit("east", "mahuella02");
            } else if (roomName == "mahuella02") {
                location.setSceneExit("south", "mahuella22");
                location.setSceneExit("west", "mahuella01");
                Item item = new Item("lemon");
                item.setImagePath("lemon.png");
                location.addItemToScene("east", item);
            } else if (roomName == "mahuella10") {
                location.setSceneExit("north", "mahuella00");
                location.setSceneExit("east", "mahuella11");
            } else if (roomName == "mahuella11") {
                location.setSceneExit("north", "mahuella01");
                location.setSceneExit("south", "mahuella21");
                location.setSceneExit("west", "mahuella10");
                Item item = new Item("mandarin");
                item.setImagePath("mandarin.png");
                location.addItemToScene("east", item);
            } else if (roomName == "mahuella21") {
                location.setSceneExit("north", "mahuella11");
                location.setSceneExit("east", "mahuella22");
                Item item = new Item("persimmon");
                item.setImagePath("persimmon.png");
                location.addItemToScene("west", item);
            } else if (roomName == "mahuella22") {
                location.setSceneExit("north", "mahuella02");
                location.setSceneExit("west", "mahuella21");
                Item item = new Item("green olive");
                item.setImagePath("olive_green.png");
                location.addItemToScene("east", item);
                Item item2 = new Item("black olive");
                item2.setImagePath("olive_black.png");
                location.addItemToScene("south", item2);
            }
            // add location to HashMap
            this.locations.put(roomName, location);
            System.out.println(roomName);
        }
    }


    /**
     * Retrieves the image name from the current Scene
     */
    public String getImageLookingDirection() {
        return this.locations.get(player.getCurrentLocation()).getSceneImage(player.getLookingDirection());
    }

    /**
     * Sets the looking direction to the next logical orderin Player class when turning left
     */
    public void turnLeft() {
        player.setLookingDirection(directions.getNextDirectionLeft(player.getLookingDirection()));
    }

    /**
     * Sets the looking direction to the next logical orderin Player class when turning right
     */
    public void turnRight() {
        player.setLookingDirection(directions.getNextDirectionRight(player.getLookingDirection()));
    }

    /**
     * Retrieves the exit name from the current Scene
     * if there is no exit "noExit" is returned
     */
    public String getExit() {
        return locations.get(player.getCurrentLocation()).getSceneExit(player.getLookingDirection());
    }

    /**
     * Sets the new location in Player class
     *
     * @param location name of the Location to be set
     */
    public void setCurrentLocation(String location) {
        player.setCurrentLocation(location);
    }

    /**
     * Retrieves the file name of the image
     */
    public String getImageItem() {
        return this.locations.get(player.getCurrentLocation()).getItemFormScene(player.getLookingDirection()).getImagePath();
    }

    /**
     * Checks if there is an item at the Scene
     */
    public boolean checkIfSceneHasItem() {
        return this.locations.get(player.getCurrentLocation()).checkIfSceneHasItem(player.getLookingDirection());
    }

    /**
     * Checks if there is an item at the Scene
     *      if yes then it removes it from the scene and adds it to the players basket
     *      if no then nothing happens
     */
    public String pickupItem() {
        // check if scene has Item
        if (this.checkIfSceneHasItem()){
            // get item from scene
            Item item = locations.get(player.getCurrentLocation()).getItemFormScene(player.getLookingDirection());
            // remove Item
            locations.get(player.getCurrentLocation()).removeItemFromScene(player.getLookingDirection());
            // add item to player
            player.addItem(item.getName(), item);
            return item.getName();
        } else {
            System.out.println("no item avalible");
            return null;
        }
    }

    /**
     * Checks if there is an item at the Scene
     *      if yes then nothing happens, because the spot for the item is already occupied
     *      if no then it removes it from the players basket and adds it to the scene
     */
    public void dropItem(String itemName) {
        // check if scene has Item
        if (this.checkIfSceneHasItem()){
            System.out.println("there is already an item on this scene");
        } else {
            Item item = player.getItem(itemName);
            player.removeItem(itemName);
            locations.get(player.getCurrentLocation()).addItemToScene(player.getLookingDirection(), item);
        }
    }

    /**
     * Retrieves a HashMap with all the items the player currently has in his basket
     */
    public HashMap<String,Item> getPlayerItems() {
        return player.getItems();
    }
}
