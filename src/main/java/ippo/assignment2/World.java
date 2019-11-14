package ippo.assignment2;

import java.awt.event.ItemEvent;
import java.util.HashMap;

public class World {
    private String name;
    private Player player;
    private Directions directions;
    private HashMap<String, Location> locations;

    public World(String name) {
        this.name = name;
        this.directions = new Directions();
        this.locations = new HashMap<String, Location>();
    }

    public void createWorld() {

        player = new Player("Adam");
        System.out.println("player");

        // create array to loop through locations
        String[] roomNames = {"mahuella00", "mahuella01", "mahuella02"};
        for (String roomName: roomNames) {
            Location location = new Location(roomName);
            // create array to loop through directions
            String[] directions = {"north", "east", "south", "west"};
            for (String direction : directions) {
                location.addScene(direction, roomName + "_" + direction + ".jpg");
            }

            if (roomName == "mahuella00") {
                location.setSceneExit("east","mahuella01");
                Item item = new Item("apple");
                item.setImagePath("apple.png");
                System.out.println(item.getImagePath());
                location.addItemToScene("north", item);
            } else if (roomName == "mahuella01") {
                location.setSceneExit("west", "mahuella00");
                location.setSceneExit("east", "mahuella02");
            } else if (roomName == "mahuella02") {
                location.setSceneExit("west", "mahuella01");
                Item item = new Item("lemon");
                item.setImagePath("lemon.png");
                System.out.println(item.getImagePath());
                location.addItemToScene("east", item);
            }

            this.locations.put(roomName, location);
            System.out.println(roomName);
        }
    }

    // location | scene

    public String getImageLookingDirection() {
        return this.locations.get(player.getCurrentLocation()).getSceneImage(player.getLookingDirection());
    }

    public void turnLeft() {
        player.setLookingDirection(directions.getNextDirectionLeft(player.getLookingDirection()));
    }

    public void turnRight() {
        player.setLookingDirection(directions.getNextDirectionRight(player.getLookingDirection()));
    }

    public String getExit() {
        return locations.get(player.getCurrentLocation()).getSceneExit(player.getLookingDirection());
    }

    public void setCurrentLocation(String location) {
        player.setCurrentLocation(location);
    }

    // item

    public String getImageItem() {
        return this.locations.get(player.getCurrentLocation()).getItemFormScene(player.getLookingDirection()).getImagePath();
    }

    public boolean checkIfSceneHasItem() {
        return this.locations.get(player.getCurrentLocation()).checkIfSceneHasItem(player.getLookingDirection());
    }

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

    public void dropItem(String itemName) {
        Item item = player.getItem(itemName);
        player.removeItem(itemName);
        locations.get(player.getCurrentLocation()).addItemToScene(player.getLookingDirection(), item);
    }

    public HashMap<String,Item> getPlayerItems() {
        return player.getItems();
    }
}
